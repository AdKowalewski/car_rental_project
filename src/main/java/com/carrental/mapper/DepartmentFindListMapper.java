package com.carrental.mapper;

import com.carrental.dto.DepartmentFindListDto;
import com.carrental.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentFindListMapper {

    DepartmentFindListMapper INSTANCE = Mappers.getMapper(DepartmentFindListMapper.class);

    Department toEntity(DepartmentFindListDto departmentForCarDto);

    DepartmentFindListDto toDto(Department department);
}
