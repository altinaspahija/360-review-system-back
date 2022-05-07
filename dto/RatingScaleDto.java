package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.RatingScale;
import lombok.Data;

@Data
public class RatingScaleDto {

    private Integer ratingScaleId;
    private String range;
    private String definition;
    private String description;

    public static RatingScale getRatingScale(RatingScaleDto ratingScaleDto){
        if (ratingScaleDto ==null) return null;
        RatingScale ratingScale = new RatingScale();
        ratingScale.setRatingScaleId(ratingScaleDto.getRatingScaleId());
        ratingScale.setRange(ratingScaleDto.getRange());
        ratingScale.setDefinition(ratingScaleDto.getDefinition());
        ratingScale.setDescription(ratingScaleDto.getDescription());
        return ratingScale;
    }

    public static RatingScaleDto getRatingScaleDto(RatingScale ratingScale){
        if (ratingScale==null) return null;
        RatingScaleDto ratingScaleDto = new RatingScaleDto();
        ratingScaleDto.setRatingScaleId(ratingScale.getRatingScaleId());
        ratingScaleDto.setRange(ratingScale.getRange());
        ratingScaleDto.setDefinition(ratingScaleDto.getDefinition());
        ratingScaleDto.setDescription(ratingScaleDto.getDescription());
        return ratingScaleDto;
    }

}
