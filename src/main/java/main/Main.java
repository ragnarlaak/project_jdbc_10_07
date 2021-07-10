package main;

import model.Employee;
import persistence.RepositoryEmployee;

public class Main {
    public static void main(String[] args) {

        RepositoryEmployee repository = new RepositoryEmployee();
        Employee employee = new Employee();
        employee.setFirstName("Ragnar");
        employee.setLastName("Laak");
        employee.setEmail("ragnar@gmail.com");
        employee.setPhoneNumber("9498-7345");
        employee.setDateOfBirth("1996-07-15");
        employee.setSalary(7500);

        repository.saveEmployee(employee);
    }
}
