package com.collections.demo.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();
    @Test
    void testAdd() {
        employeeService.add("test", "testtest", 1_000, 1);
        employeeService.add("tEsTTEST", "teSteStTest", 2_000, 3);

            var actual1 = employeeService.find("test", "TESTTEST");

        assertThat(actual1).isNotNull();
        assertThat(actual1.getFirstName()).isEqualTo("test");
        assertThat(actual1.getLastName()).isEqualTo("testtest");
        assertThat(actual1.getDepartment()).isEqualTo(1);
        assertThat(actual1.getSalary()).isEqualTo(1_000);

            var actual2 = employeeService.find("TEST", "TESTTESTtest");
        assertThat(actual2).isNotNull();
        assertThat(actual2.getFirstName()).isEqualTo("tEsTTEST");
        assertThat(actual2.getLastName()).isEqualTo("teSteStTest");
        assertThat(actual2.getDepartment()).isEqualTo(3);
        assertThat(actual2.getSalary()).isEqualTo(2_000);
    }
}