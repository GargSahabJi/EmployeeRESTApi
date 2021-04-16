package com.nagarro.employeeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.lang.reflect.GenericSignatureFormatError;

@Entity(name = "Employees")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_code")
    private long employeeCode;
    @Column(name = "Name")
    private String employeeName;
    @Column(name = "Location")
    private String location;
    @Column(name = "Email")
    private String email;
    @Column(name = "Date_of_Birth")
    private String dateOfBirth;

    Employee(){

    }

    public long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
