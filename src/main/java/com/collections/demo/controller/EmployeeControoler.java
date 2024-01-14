package com.collections.demo.controller;

import com.collections.demo.model.Employee;
import com.collections.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping ("/employee")
public class EmployeeControoler {
    private EmployeeService service;

    public void EmployeeService(EmployeeService service) {
        this.service = service;
    }

    public EmployeeControoler(EmployeeService service) {
        this.service = service;
    }

    @GetMapping ("/add")
    public void add(@RequestParam String firstName, @RequestParam String lastName){
        service.add(firstName, lastName);
    }
    @GetMapping ("/remove")
    public void remove(@RequestParam String firstName,@RequestParam String lastName){
service.remove(firstName, lastName);
    }
    @GetMapping ("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName){
        return service.find(firstName, lastName);

    }
    @GetMapping ("/all")
    public Collection<Employee> all(){
        return service.getAll();

    }
}
