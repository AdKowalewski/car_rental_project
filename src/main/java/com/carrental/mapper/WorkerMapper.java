package com.carrental.mapper;

import com.carrental.dto.WorkerDto;
import com.carrental.model.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkerMapper {

    WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);

    Worker toEntity(WorkerDto workerDto);

    WorkerDto toDto(Worker worker);

}
