package com.collections.demo.service;

import com.collections.demo.exceptions.EmployeeAlreadyAddedException;
import com.collections.demo.exceptions.EmployeeNotFoundException;
import com.collections.demo.exceptions.EmployeeStorageIsFullException;
import com.collections.demo.model.Employee;
import org.junit.jupiter.api.Test;

import java.lang.invoke.WrongMethodTypeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();
    @Test
    void testAdd() {
        employeeService.add("test", "testtest", 1_000, 1);
        employeeService.add("TEsTTEST", "TeSteStTest", 2_000, 3);

            var actual1 = employeeService.find("test", "TESTTEST");
        assertThat(actual1).isNotNull();
        assertThat(actual1.getFirstName()).isEqualTo("test");
        assertThat(actual1.getLastName()).isEqualTo("testtest");
        assertThat(actual1.getDepartment()).isEqualTo(1);
        assertThat(actual1.getSalary()).isEqualTo(1_000);

            var actual2 = employeeService.find("TEsTTEST", "TeSteStTest");
        assertThat(actual2).isNotNull();
        assertThat(actual2.getFirstName()).isEqualTo("TEsTTEST");
        assertThat(actual2.getLastName()).isEqualTo("TeSteStTest");
        assertThat(actual2.getDepartment()).isEqualTo(3);
        assertThat(actual2.getSalary()).isEqualTo(2_000);
    }

    @Test
    void testAddDuplicate() {
        employeeService.add("test", "testtest", 1_000, 1);
        employeeService.add("TEsTTEST", "TeSteStTest", 2_000, 2);
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add("test",
                "testtest", 2_000, 2));
    }

    @Test
    void testFull() {
        employeeService.add("testus", "testtest", 1_000, 1);
        employeeService.add("testis", "testtest", 1_000, 1);
        employeeService.add("testas", "testtest", 1_000, 1);
        employeeService.add("testes", "testtest", 1_000, 1);
        employeeService.add("testae", "testtest", 1_000, 1);
        employeeService.add("testsix", "testtest", 1_000, 1);
        employeeService.add("testqs", "testtest", 1_000, 1);
        employeeService.add("testttt", "testtest", 1_000, 1);
        employeeService.add("testttttt", "testtest", 1_000, 1);
        employeeService.add("testtttttt", "testtest", 1_000, 1);
        assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.add("testtest",
                "testtest", 1_000, 1));
    }

    @Test
    void testGetAll() {
        employeeService.add("testus", "testtest", 1_000, 1);
        employeeService.add("testis", "testtest", 2_000, 2);

        var actual = employeeService.getAll();
        assertThat(actual).containsExactlyInAnyOrder(
                new Employee("testus", "testtest", 1_000, 1),
                new Employee("testis", "testtest", 2_000, 2));
    }

    @Test
    void testNotFound() {

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("Foo", "Bar"));
    }

    @Test
    void testRemove() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove("Foo", "Far", 1_000, 1));
        employeeService.add("testus", "testtest", 1_000, 1);
        employeeService.add("testis", "testtest", 2_000, 2);
        var actual = employeeService.find("testus", "testtest");
        assertThat(actual).isNotNull();
        employeeService.remove("testus", "testtest", 2_000, 2);
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("testus", "testtest"));

    }

}