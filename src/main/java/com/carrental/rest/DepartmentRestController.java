package com.carrental.rest;

import com.carrental.dto.DepartmentDto;
import com.carrental.dto.DepartmentFindListDto;
import com.carrental.mapper.DepartmentFindListMapper;
import com.carrental.mapper.DepartmentMapper;
import com.carrental.model.Department;
import com.carrental.service.DepartmentService;
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
@RequestMapping("/api/departments")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentFindListDto addDepartment(@RequestBody DepartmentFindListDto dto) {
       Department department = departmentService.save(DepartmentFindListMapper.INSTANCE.toEntity(dto));
       return DepartmentFindListMapper.INSTANCE.toDto(department);
    }

    @GetMapping(path = "{departmentId}")
    public @ResponseBody
    DepartmentDto getDepartmentById(@PathVariable("departmentId") Long id) {
        return DepartmentMapper.INSTANCE.toDto(departmentService.find(id));
    }

    @GetMapping
    public List<DepartmentFindListDto> getAllDepartmentsOrByCity(@RequestParam(value = "city", required = false) Optional<String> city) {
        return city.map(s -> departmentService.findByCity(s).stream().map(DepartmentFindListMapper.INSTANCE::toDto).collect(Collectors.toList())).orElseGet(() -> departmentService.findAll().stream().map(DepartmentFindListMapper.INSTANCE::toDto).collect(Collectors.toList()));
    }

    @DeleteMapping("/{deptId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDepartmentById(@PathVariable("deptId") Long id) {
        departmentService.delete(id);
    }

}
