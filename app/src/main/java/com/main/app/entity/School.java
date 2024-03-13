package com.main.app.entity;

public class School {
    private int registerNumber;
    private String name;
    private String address;
    private int totalStudent;
    private int totalTeacher;

    public School() {

    }
    public School(int registerNumber, String name, String address, int totalStudent, int totalTeacher) {
        this.registerNumber = registerNumber;
        this.name = name;
        this.address = address;
        this.totalStudent = totalStudent;
        this.totalTeacher = totalTeacher;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }

    public int getTotalTeacher() {
        return totalTeacher;
    }

    public void setTotalTeacher(int totalTeacher) {
        this.totalTeacher = totalTeacher;
    }

}
