package com.employeessystem.backend.model;

import lombok.Data;

@Data
public class PositionByTitle {

    private String positionTitle;
    private Integer positionId;

    public PositionByTitle(Integer positionId, String positionTitle) {
        this.positionId = positionId;
        this.positionTitle = positionTitle;
    }

}
