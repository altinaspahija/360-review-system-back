package com.employeessystem.backend.model;


import lombok.Data;

import java.util.Date;


@Data
public class ReviewsRatings {

    private Integer reviewId;
    private String reviewName;
    private String name;
    private String surname;
    private Double answer;
    private Date createdDate;

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

    public ReviewsRatings(Integer reviewId, String reviewName, String name, String surname, Date createdDate, Double answer) {
        this.reviewId = reviewId;
        this.reviewName = reviewName;
        this.name = name;
        this.surname = surname;
        this.createdDate = createdDate;
        this.answer = answer;
    }

    public ReviewsRatings(Date createdDate, Double answer) {
        this.createdDate = createdDate;
        this.answer = answer;
    }

    public ReviewsRatings() {
    }

}
