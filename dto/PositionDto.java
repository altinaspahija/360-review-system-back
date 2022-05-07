package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.Position;
import lombok.Data;

@Data
public class PositionDto {

  private int positionId;
  private String positionTitle;
  private int departmentId;

  public static Position getPosition(PositionDto positionDto){
    if (positionDto==null) return null;
    Position position = new Position();
    position.setPositionId(positionDto.getPositionId());
    position.setPositionTitle(positionDto.getPositionTitle());
    position.setDepartmentId(positionDto.getDepartmentId());
    return position;
  }

  public static PositionDto getPositionDto(Position position){
    if (position==null) return null;
    PositionDto positionDto = new PositionDto();
    positionDto.setPositionId(position.getPositionId());
    positionDto.setPositionTitle(position.getPositionTitle());
    positionDto.setDepartmentId(position.getDepartmentId());
    return positionDto;
  }

}
