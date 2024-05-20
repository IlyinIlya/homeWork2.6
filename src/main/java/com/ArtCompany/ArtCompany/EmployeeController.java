package com.ArtCompany.ArtCompany;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;


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
        return employeeService.addPersonal(lastName, firstName);
    }

    @RequestMapping(path = "/remove")
    public Employee delPersonal(@RequestParam("lastName") String lastName,
                                @RequestParam("firstName") String firstName) {
        return employeeService.delPersonal(lastName, firstName);
    }

    @RequestMapping(path = "/find")
    public Employee findPersonal(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName) {
        return employeeService.findPersonal(lastName, firstName);
    }

    @GetMapping
    public Collection<Employee> printEmployee() {
        return employeeService.printAllEmployee();
    }
}
