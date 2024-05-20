package com.ArtCompany.ArtCompany;

import Exceptions.EmployeeAlreadyAddedException;
import Exceptions.EmployeeNotFoundException;
import Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private static final int arrayEmployees = 5;
    private final Map<String, Employee> employees = new HashMap<>();

    //добавить сотрудника в базу
    public Employee addPersonal(String lastName, String firstName) {
        String fill = lastName + firstName;
        if (employees.containsKey(fill)) {
            throw new EmployeeAlreadyAddedException("Уже есть такой сотрудник");
        } else if (employees.size() > arrayEmployees) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирмет");
        }
        Employee employee = new Employee(lastName, firstName);
        employees.put(fill, employee);
        return employee;

    }

    // удалить сотрудника из базы
    public Employee delPersonal(String lastName, String firstName) {
        String fill = lastName + firstName;
        if (employees.containsKey(fill)) {
            employees.remove(fill);
            return employees.get(fill);
        }
        throw new EmployeeNotFoundException("Сотрудник отсутствует в базе данных, удаление невозможно");
    }

    // найти сотрудника в базе
    public Employee findPersonal(String lastName, String firstName) {
        String fill = lastName + firstName;
        if (employees.containsKey(fill)) {
            return employees.get(fill);
        }
        throw new EmployeeNotFoundException("Сотрудник отсутствует в базе данных");
    }

    public Collection<Employee> printAllEmployee() {
        return employees.values();
    }
}
