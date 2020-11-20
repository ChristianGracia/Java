package com.cg;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {

    //synchronized, can be used on different threads without worrying about doing the handling for that
    //cause overhead so array list used when this isn't concern

    // thread safe

    public static void main(String[] args) {

        List<Employee> employeeList = new Vector<>();

        employeeList.add(new Employee("cc", "d", 123));
        employeeList.add(new Employee("dd", "l", 126));
        employeeList.add(new Employee("eee", "lll", 125));

        employeeList.forEach(employee -> System.out.println(employee));

    }
}
