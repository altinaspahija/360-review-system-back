package com.employeessystem.backend.service;

import com.employeessystem.backend.dto.PositionDto;
import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.exception.PositionNotFoundException;
import com.employeessystem.backend.model.PositionByTitle;

import javax.swing.text.Position;
import java.util.List;

public interface PositionService {

    List<PositionDto> getAllPositions() throws PositionNotFoundException;
    List<PositionByTitle> getPositionsTitles(Integer departmentId) throws DepartmentNotFoundException;

}
