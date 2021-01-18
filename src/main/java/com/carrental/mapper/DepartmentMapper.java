package com.carrental.mapper;

import com.carrental.dto.DepartmentDto;
import com.carrental.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    Department toEntity(DepartmentDto departmentDto);

    DepartmentDto toDto(Department department);

}
