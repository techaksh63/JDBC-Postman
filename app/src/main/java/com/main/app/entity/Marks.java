package com.main.app.entity;

public class Marks {
    private int registerNumber;
    private int rollNumber;
    private int marks;
    private String resultStatus;

    public Marks() {
    }
    public Marks(int registerNumber, int rollNumber, int marks, String resultStatus) {
        this.registerNumber = registerNumber;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.resultStatus = resultStatus;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }
}
