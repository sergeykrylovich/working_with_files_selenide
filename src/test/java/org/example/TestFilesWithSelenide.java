package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
                System.out.println("File name - " + nameOfFile);

                FileOutputStream fileOutputStream = new FileOutputStream("ext_" + nameOfFile);
                fileOutputStream.flush();
            }
        }


    }
}
