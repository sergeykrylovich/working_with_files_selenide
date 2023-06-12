package org.example;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFilesWithSelenide {

    //private final String pathZip = "src/test/resources/examples/files.zip";
    @Test
    void zipExtractFiles() throws Exception {
        try (
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("src/test/resources/examples/files.zip"));
        ) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                //System.out.println(zipEntry.getName());
                String nameOfFile = zipEntry.getName();
                if (nameOfFile.endsWith(".csv")) {
                    CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(zipInputStream))
                            .withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
                    List<String[]> content = csvReader.readAll();
                    assertThat(content.get(1)[1]).contains("1");
                } else if (nameOfFile.endsWith(".pdf")) {
                    PDF pdfContent = new PDF(zipInputStream);
                    assertThat(pdfContent.text).contains("Минск");
                } else if (nameOfFile.endsWith(".xlsx")){
                    XLS xlsContent = new XLS(zipInputStream);
                    assertThat(xlsContent.excel.getSheetAt(0).getRow(3).getCell(0).getStringCellValue()).contains("Проверка");
                }
                System.out.println("File name - " + nameOfFile);

                try (
                    FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/unzipfiles/ext_" + nameOfFile);
                ) {
                    for (int i = zipInputStream.read(); i != -1; i = zipInputStream.read()) {
                        fileOutputStream.write(i);
                    }
                }
            }
        }


    }


}
