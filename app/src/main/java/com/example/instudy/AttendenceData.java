package com.example.instudy;

public class AttendenceData {
    String name;
    int leaves_left;
    int absent;
    int percentage;
    AttendenceData(String name,int leaves_left,int absent,int percentage) {
        this.name = name;
        this.leaves_left = leaves_left;
        this.absent = absent;
        this.percentage = percentage;
    }
}
