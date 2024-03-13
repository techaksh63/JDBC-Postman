package com.main.app.entity;

public class Student {
    private int rollNumber;
    private String name;
    private String address;
    private String standard;

    public Student() {

    }
    public Student(int rollNumber, String name, String standard, String address) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.standard = standard;
        this.address = address;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
