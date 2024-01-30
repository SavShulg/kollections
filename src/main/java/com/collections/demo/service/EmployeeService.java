package com.collections.demo.service;



import com.collections.demo.exceptions.EmployeeAlreadyAddedException;
import com.collections.demo.exceptions.EmployeeNotFoundException;
import com.collections.demo.exceptions.EmployeeStorageIsFullException;
import com.collections.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private static final int MAX_COUNT = 10;

    private final Map<String, Employee> employees = new HashMap<>(MAX_COUNT);

    public void add(String firstName, String lastName, int salary, int department) throws EmployeeAlreadyAddedException {
        if (employees.size() >= MAX_COUNT) {
            throw new EmployeeStorageIsFullException();
        }

        Employee employee = new Employee(firstName, lastName, salary, department);
        var key = makeKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(key, employee);
    }

    public void remove(String firstName, String lastName, int salary, int department) {
        var employee = new Employee(firstName, lastName,salary,department);
        var key = makeKey(firstName, lastName);
        var removed = employees.remove(key);
        if (removed != null) {
            throw new EmployeeAlreadyAddedException();
        }
    }


    public Employee find (String firstName, String lastName){
        var key = makeKey(firstName, lastName);
        var employee = employees.get(key);
        if (employee != null) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    public Collection<Employee> getAll () {
        return Collections.unmodifiableCollection(employees.values());
    }
    private static String makeKey(String firstName, String lastName) {
        return (firstName + "-" + lastName).toLowerCase();
    }
}


