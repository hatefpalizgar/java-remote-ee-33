package com.sda.p27_streams.no1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example01 {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 40);
        Employee jack = new Employee("Jack Hill", 39);
        Employee snow = new Employee("Snow White", 35);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = List.of(hr, accounting);

        // use Streams API to print the employees name in each department
        departments
                .stream() // make a stream out of departments
                .map(dep -> dep.getEmployees()) // convert/transform each department to its list of employees
                .forEach(list -> // for each list of employees do below
                        list.forEach(emp -> System.out.println(emp.getName()))
                );

        System.out.println("==================== second solution =======================");
        // second solution:
        departments
                .stream()
                .flatMap(d -> d.getEmployees().stream())
                .forEach(e -> System.out.println(e.getName()));
        /**
         * For a better example of FlatMap()
         * @see FlatMapExample1
         * */

        // use Streams API to create a Map<Integer,List<Employee>> that groups employees by their age e.g: [30, {e1,e2,e3}]
        Map<Integer, List<Employee>> employeesGroupedByAge = departments
                .stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.groupingBy(e -> e.getAge()));
        // TODO: Try to do this without Stream API (Hello to Hell!)



        // TODO: Homework
        // What is the goal of below code?
        departments
                .stream()
                .flatMap(d -> d.getEmployees().stream())
                .reduce((e1,e2) -> e1.getAge() > e2.getAge() ? e1 : e2)
                .ifPresent(e -> System.out.println(e.getName()));

    }

    /**
     *
     * @see com.sda.p27_streams.no2.Example02
     * */
}
