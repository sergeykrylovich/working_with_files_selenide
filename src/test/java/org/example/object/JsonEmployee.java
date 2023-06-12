package org.example.object;

import java.util.List;

public class JsonEmployee {
    public JsonEmployee() {}

    private String firstName;


    private List<Computer> computer;


    public JsonEmployee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Computer> getComputer() {
        return computer;
    }

    public static class Computer {
        public String getCpu() {
            return cpu;
        }

        public String getRam() {
            return ram;
        }

        public boolean isHdd() {
            return hdd;
        }

        public boolean isSsd() {
            return ssd;
        }

        public String cpu;
        public String ram;
        public boolean hdd;
        public boolean ssd;

    }

}
