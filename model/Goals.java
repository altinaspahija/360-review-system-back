package com.employeessystem.backend.model;

import lombok.Data;

import java.util.Date;

@Data
public class Goals {

    Date createdDate;
    Integer createdTo;
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

    public Goals(Date createdDate, Integer createdTo, String categoryDescription, Double answer) {
        this.createdDate = createdDate;
        this.createdTo = createdTo;
        this.categoryDescription = categoryDescription;
        this.answer = answer;
    }

}
