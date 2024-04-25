package com.sparta.udonunit.employeefactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.sparta.udonunit.logger.Log;

public class EmployeeDataHandler {
    private static List<Employee> employeeList;


    // Constructor populates employeeList by calling EmployeeFactory.
    public EmployeeDataHandler() throws IOException {
        Log.setClassName(EmployeeDataHandler.class.getSimpleName());
        Log.info("Creating employee data handler...");
        Log.config("Populating employee data from employee factory");
        String[] employeeData = EmployeeFactory.getEmployees(1000);

        Log.config("Creating employee object list from employee data");
        employeeList = new ArrayList<>(convertEmployeeDataListIntoObjects(employeeData));
        Log.config("Employee list populated");
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    private List<Employee> convertEmployeeDataListIntoObjects(String[] employeeData) {
        Log.config("Converting employee data list into objects...");

        List<Employee> employees = new ArrayList<>();

        for (String data : employeeData) {
            String[] values = data.split(",");

            int empId = Integer.parseInt(values[0]);
            String prefix = values[1];
            String firstName = values[2];
            char middleInitial = values[3].charAt(0);
            String lastName = values[4];
            char gender = values[5].charAt(0);
            String email = values[6];
            LocalDate dob = LocalDate.parse(values[7], DateTimeFormatter.ofPattern("M/d/y"));
            LocalDate hireDate = LocalDate.parse(values[8], DateTimeFormatter.ofPattern("M/d/y"));
            int salary = Integer.parseInt(values[9]);

            Employee employee = new Employee(empId, prefix, firstName, middleInitial, lastName,
                    gender, email, dob, hireDate, salary);
            employees.add(employee);
        }
        Log.config("Employee total: " + employees.size());

        return employees;
    }

}
