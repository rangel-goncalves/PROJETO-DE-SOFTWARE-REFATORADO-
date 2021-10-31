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
    private String address;
    private String employeeID;
    private String type;
    private String paymentMethod;
    private String SyndicateID;
    
    private float salary;
    private float commission;
    private boolean syndicate;
    
    private float frequency;
    private float sales;
    private float unionFee;

    public Funcionario(/*String name, String address, int employeeID, String type, float salary, float commission , boolean syndicate*/) {
        /*this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        this.salary = salary;
        this.commission = commission;
        this.syndicate = syndicate;*/
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
        if(this.type.equals("commissioned")){
            Scanner input = new Scanner(System.in);
            System.out.println("Percentual de comissão: ");
            this.commission = input.nextFloat();
        }
    }

    public boolean isSyndicate() {
        return syndicate;
    }

    public void setSyndicate(boolean syndicate) {
        this.syndicate = syndicate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }
    
    public void ficha(){
        System.out.println(this.getName()+"\n"+this.getAddress()+"\n"+this.getEmployeeID()+"\n"+this.getType()+"\n"+this.getCommission()+"%\n"+
                this.getSalary()+"\n"+this.isSyndicate());
    }


    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public float getSales() {
        return sales;
    }

    public void setSales(float sales) {
        this.sales = sales;
    }

    public float getUnionFee() {
        return unionFee;
    }

    public void setUnionFee(float unionFee) {
        this.unionFee = unionFee;
    }
    
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getSyndicateID() {
        return SyndicateID;
    }

    public void setSyndicateID(String SyndicateID) {
        this.SyndicateID = SyndicateID;
    }
 
}
