package com.carrental.mapper;

import com.carrental.dto.WorkerFindListDto;
import com.carrental.model.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkerFindListMapper {

    WorkerFindListMapper INSTANCE = Mappers.getMapper(WorkerFindListMapper.class);

    Worker toEntity(WorkerFindListDto workerDto);

    WorkerFindListDto toDto(Worker worker);
}
