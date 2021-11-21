/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.util.Scanner;
/**
 *
 * @author Rangel
 */
public class Funcionario {
    
    private String name ;
    private String employeeID;
    private String address;
    private String type;
    private boolean Syndicate;
    private float salary;
    private String paymentMethod;
  
    public Funcionario() {
    }
    
    public Funcionario(String name, String employeeID, String type) {
        this.name = name;
        this.employeeID = employeeID;
        this.type = type;

    }

    public Funcionario(String name, String employeeID, String type, float salary) {
        this.name = name;
        this.employeeID = employeeID;
        this.type = type;
        this.salary = salary;
    }

    public Funcionario(String name, String employeeID, String address, String type) {
        this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        
    }
    
    public Funcionario(String name, String employeeID, String address, String type, float salary) {
        this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        this.salary = salary;
    }
    
    public Funcionario(String name, String employeeID, String address, String type, String paymentMethod) {
        this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        this.paymentMethod = paymentMethod;
    }
    
    public Funcionario(String name, String employeeID, String address, String type, String paymentMethod, float salary) {
        this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        this.paymentMethod = paymentMethod;
        this.salary = salary;
    }

    public Funcionario(String name, String employeeID, String address, String type, boolean Syndicate, String paymentMethod, float salary) {
        this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        this.Syndicate = Syndicate;
        this.paymentMethod = paymentMethod;
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isSyndicate() {
        return Syndicate;
    }

    public void setSyndicate(boolean Syndicate) {
        this.Syndicate = Syndicate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "name: " + name + ", employeeID: " 
                + employeeID + ", address: " + address + ", type: " + type + ", Syndicate: " +
                Syndicate + ", salary: " + salary + ", paymentMethod: " + paymentMethod + '}';
    }

}
