package com.sparta.udonunit.employeefactory;

import java.time.LocalDate;

/**
 * @param dob Date of Birth
 */
public record Employee(Integer empId, String title, String firstName, Character middleInitial, String lastName, Character gender,
                       String email, LocalDate dob, LocalDate hireDate, Integer salary) {

    @Override
    public String toString() {
        return
                "Employee: " + title + " " + firstName + " " + lastName + '\n' +
                ". Employee Id => " + empId + '\n' +
                ". Employee Title => " + title + '\n' +
                ". Employee First Name => " + firstName + '\n' +
                ". Employee Middle Initial => " + middleInitial + '\n' +
                ". Employee Last Name => " + lastName + '\n' +
                ". Employee Gender => " + gender + '\n' +
                ". Employee Email Address => " + email + '\n' +
                ". Employee Date of Birth (YYYY-MM-DD) => " + dob + '\n' +
                ". Employee Hire Date (YYYY-MM-DD) => " + hireDate +'\n' +
                ". Employee Salary => " + "£" + salary + '\n' +
                "-------------------------------------------------"
                ;
    }
}
