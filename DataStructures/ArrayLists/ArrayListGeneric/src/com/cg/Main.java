package com.cg;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("cc", "d", 123));
        employeeList.add(new Employee("dd", "l", 126));
        employeeList.add(new Employee("eee", "lll", 125));

        employeeList.forEach(employee -> System.out.println(employee));

    }
}
