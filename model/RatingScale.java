package com.employeessystem.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="rating_scale")
public class RatingScale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rating_scale_id", insertable = true)
    private Integer ratingScaleId;

    @Column(name="range")
    private String range;

    @Column(name="definition")
    private String definition;

    @Column(name="description")
    private String description;

}
