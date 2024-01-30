package com.collections.demo.controller;

import com.collections.demo.model.Employee;
import com.collections.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee max(@RequestParam int department) {
        return service.findMaxSalary(department);
    }
    @GetMapping("/min-salary")
    public Employee min(@RequestParam int department) {
        return service.findMinSalary(department);
    }
    @GetMapping(value = "/all", params = "departmentId")
    public Collection<Employee> findAllByDepartment(@RequestParam int department) {
        return service.findByDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> groupBy(@RequestParam int department) {
        return service.groupByDepartment();
    }
}
