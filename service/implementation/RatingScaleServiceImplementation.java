package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.exception.RatingScaleNotFoundException;
import com.employeessystem.backend.model.RatingScale;
import com.employeessystem.backend.repository.RatingScaleRepository;
import com.employeessystem.backend.service.RatingScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingScaleServiceImplementation implements RatingScaleService {

    @Autowired
    RatingScaleRepository ratingScaleRepository;


    @Override
    public List<RatingScale> getRatingScales() throws RatingScaleNotFoundException {
        return ratingScaleRepository.getRatingScales();
    }

}
