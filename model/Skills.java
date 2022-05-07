package com.employeessystem.backend.model;

import lombok.Data;

import java.util.Date;

@Data
public class Skills {

    String reviewName;
    Integer createdTo;
    String name;
    String surname;
    Date createdDate;
    String categoryDescription;
    Double answer;

    public static Double round(Double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public Double getAnswer() {
        return round(answer,1);
    }

    public Skills(String reviewName,Integer createdTo, String name, String surname, Date createdDate, String categoryDescription, Double answer) {
        this.reviewName = reviewName;
        this.createdTo = createdTo;
        this.name = name;
        this.surname = surname;
        this.createdDate = createdDate;
        this.categoryDescription = categoryDescription;
        this.answer = answer;
    }

}
