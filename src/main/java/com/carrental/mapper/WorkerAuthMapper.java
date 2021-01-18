package com.carrental.mapper;

import com.carrental.dto.AuthDto;
import com.carrental.model.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkerAuthMapper {

    WorkerAuthMapper INSTANCE = Mappers.getMapper(WorkerAuthMapper.class);

    Worker toEntity(AuthDto workerDto);

    AuthDto toDto(Worker worker);
}
