package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.dto.PositionDto;
import com.employeessystem.backend.dto.RoleDto;
import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.exception.PositionNotFoundException;
import com.employeessystem.backend.exception.RoleNotFoundException;
import com.employeessystem.backend.model.Position;
import com.employeessystem.backend.model.PositionByTitle;
import com.employeessystem.backend.model.Role;
import com.employeessystem.backend.repository.PositionRepository;
import com.employeessystem.backend.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionServiceImplementation implements PositionService {

    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<PositionDto> getAllPositions() throws PositionNotFoundException {
        List<Position> allPositions = positionRepository.findAll();
        List<PositionDto> positionDtos = new ArrayList<>();
        if(allPositions.isEmpty()) throw new PositionNotFoundException();

        allPositions.forEach(position-> positionDtos.add(PositionDto.getPositionDto(position)));
        return positionDtos;
    }

    @Override
    public List<PositionByTitle> getPositionsTitles(Integer departmentId) throws DepartmentNotFoundException {
        return positionRepository.getPositionsTitles(departmentId);
    }

}
