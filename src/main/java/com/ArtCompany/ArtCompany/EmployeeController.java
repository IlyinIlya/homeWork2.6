package com.ArtCompany.ArtCompany;

import Exceptions.EmployeeAlreadyAddedException;
import Exceptions.EmployeeNotFoundException;
import Exceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/add")
    public Employee addPersonal(@RequestParam("lastName") String lastName,
                                @RequestParam("firstName") String firstName) {
        try {
            return employeeService.addPersonal(lastName, firstName);
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Достигнут предел сотрудников");
            throw e;
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Сотрудник уже существует");
            throw e;
        }
    }

    @RequestMapping(path = "/remove")
    public Employee delPersonal(@RequestParam("lastName") String lastName,
                                @RequestParam("firstName") String firstName) {
        try {
            return employeeService.delPersonal(lastName, firstName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден");
            throw e;
        }
    }

    @RequestMapping(path = "/find")
    public Employee findPersonal(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName) {
        try {
            return employeeService.findPersonal(lastName, firstName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден");
            throw e;
        }
    }

    @GetMapping
    public Collection<Employee> printEmployee() {
        return employeeService.printAllEmployee();
    }
}
