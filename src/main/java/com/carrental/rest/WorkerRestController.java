package com.carrental.rest;

import com.carrental.dto.WorkerDto;
import com.carrental.dto.WorkerFindListDto;
import com.carrental.mapper.WorkerFindListMapper;
import com.carrental.mapper.WorkerMapper;
import com.carrental.model.Worker;
import com.carrental.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/workers")
public class WorkerRestController {

    private final WorkerService workerService;

    public WorkerRestController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping
    public WorkerFindListDto addWorker(@RequestBody WorkerFindListDto dto) {
        Worker worker = workerService.save(WorkerFindListMapper.INSTANCE.toEntity(dto));
        return WorkerFindListMapper.INSTANCE.toDto(worker);
    }

    @GetMapping(path = "{workerId}")
    public @ResponseBody
    WorkerDto getWorkerById(@PathVariable("workerId") Long id) {
        return WorkerMapper.INSTANCE.toDto(workerService.find(id));
    }

    @GetMapping
    public List<WorkerFindListDto> getAllWorkersOrByFirstNameAndLastName(
            @RequestParam(value = "firstName", required = false) Optional<String> firstName,
            @RequestParam(value = "lastName", required = false) Optional<String> lastName) {
        if(firstName.isPresent() && lastName.isPresent()){
            return workerService.findAllByFirstNameAndLastName(firstName.get(), lastName.get()).stream()
                    .map(WorkerFindListMapper.INSTANCE::toDto)
                    .collect(Collectors.toList());
        } else {
            return workerService.findAll().stream()
                    .map(WorkerFindListMapper.INSTANCE::toDto)
                    .collect(Collectors.toList());
        }
    }

    @DeleteMapping("/{workerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteWorkerById(@PathVariable("workerId") Long id) {
        workerService.delete(id);
    }
}
