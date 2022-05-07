package com.employeessystem.backend.controller;


import com.employeessystem.backend.dto.RatingScaleDto;
import com.employeessystem.backend.exception.RatingScaleNotFoundException;
import com.employeessystem.backend.model.RatingReview;
import com.employeessystem.backend.model.RatingScale;
import com.employeessystem.backend.service.RatingReviewService;
import com.employeessystem.backend.service.RatingScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RatingScaleController {

   @Autowired
    RatingScaleService ratingScaleService;

    //http://localhost:9090/ratingScales GET
    @GetMapping("ratingScales")
    public List<RatingScale> getRatingScale() throws RatingScaleNotFoundException {
        return ratingScaleService.getRatingScales();
    }

}
