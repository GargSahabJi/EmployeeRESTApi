package com.nagarro.employeeapi.controller;

import com.nagarro.employeeapi.dao.EmployeeDao;
import com.nagarro.employeeapi.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/employee-api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeDao.getOne(id);
    }

    @PostMapping
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeDao.saveAndFlush(employee);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable long id) {
        employeeDao.deleteById(id);
    }

    @PUT
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeDao.getOne(id);
        BeanUtils.copyProperties(employee, existingEmployee, "employeeCode");
        return employeeDao.saveAndFlush(existingEmployee);
    }
}
