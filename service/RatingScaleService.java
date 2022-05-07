package com.employeessystem.backend.service;

import com.employeessystem.backend.dto.RatingScaleDto;
import com.employeessystem.backend.exception.RatingScaleNotFoundException;
import com.employeessystem.backend.model.RatingScale;

import java.util.List;

public interface RatingScaleService {

    List<RatingScale> getRatingScales() throws RatingScaleNotFoundException;

}
