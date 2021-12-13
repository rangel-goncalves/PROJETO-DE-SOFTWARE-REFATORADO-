/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
/**
 *
 * @author Rangel
 */
public class Funcionario implements  Cloneable  {
    
    private String name ;
    private String employeeID;
    private String address;
    private String type;
    private Sindicato Syndicate = new Sindicato();
    private float salary;
    private PaymentMethod paymentMethod = new PaymentMethod();
    private LocalDate paymentDay;
    private String paymentTransfer;
    private float payment;
  
    public Funcionario() {
        setDefault();
    }
    
    public Funcionario(String name, String employeeID, String type) {
        this.name = name;
        this.employeeID = employeeID;
        this.type = type;
        setDefault();
    }

    public Funcionario(String name, String employeeID, String type, float salary) {
        this.name = name;
        this.employeeID = employeeID;
        this.type = type;
        this.salary = salary;
        setDefault();
    }

    public Funcionario(String name, String employeeID, String address, String type) {
        this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        setDefault();
    }
    
    public Funcionario(String name, String employeeID, String address, String type, float salary) {
        this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        this.salary = salary;
        setDefault();
    }
    
    public Funcionario(String name, String employeeID, String address, String type, String paymentMethod) {
        this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        this.paymentMethod.method = paymentMethod;
        setDefault();
    }
    
    public Funcionario(String name, String employeeID, String address, String type, String paymentMethod, float salary) {
        this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        this.paymentMethod.method = paymentMethod;
        this.salary = salary;
        setDefault();
    }

    public Funcionario(String name, String employeeID, String address, String type, boolean Syndicate, String paymentMethod, float salary) {
        this.name = name;
        this.address = address;
        this.employeeID = employeeID;
        this.type = type;
        this.Syndicate.setSyndicate(Syndicate);
        this.paymentMethod.method = paymentMethod;
        this.salary = salary;
        setDefault();
    }

    public LocalDate getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(LocalDate paymentDay) {
        this.paymentDay = paymentDay;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isSyndicate() {
        return this.Syndicate.isSyndicate();
    }

    public void setSyndicate(boolean Syndicate) {
        this.Syndicate.setSyndicate(Syndicate);
    }
    
    public void setUnionFee(float value){
        this.Syndicate.setUnionFee(value);
    }
    
    public float getUnionFee(){
        return this.Syndicate.getUnionFee();
    }
    
    public void newTaxaServicoSindicato(float value, LocalDate l ){
        this.Syndicate.NewFeeServices(value,l);
    }
    
    public float getTaxaServicoSindicato(){
        return this.Syndicate.TotalFeeServices();
    }
    
    public String getHistoricoSindicato(){
        return this.Syndicate.getHistorico();
    }
    
    public void setSyndicateId(String syndicateId){
        if(syndicateId.equals("") || syndicateId == (null)){
            syndicateId = this.type +"-"+ this.employeeID;
        }
        this.Syndicate.setSyndicateId(syndicateId);
    }
    
    public String getSyndicateId(){
        return this.Syndicate.getSyndicateId();
    }
    
    public String getPaymentMethod() {
        return this.paymentMethod.method;
    }

    public String getDetailsPayment(){
        return this.paymentMethod.getDetails();
    }
    
    public String getTimePaymentMethod() {
        return this.paymentMethod.timeMethod;
    }
    
    public String getTimeMethodWeekDay(){
        return this.paymentMethod.timeMethodWeekDay;
    }

    public void setPaymentMethod(String paymentMethod, String timePaymentMethod, String timeMethodWeekDay) {
        this.paymentMethod.method = paymentMethod;
        this.paymentMethod.timeMethod = timePaymentMethod;
        this.paymentMethod.timeMethodWeekDay = timeMethodWeekDay;
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
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

    public String getPaymentTransfer() {
        if(paymentTransfer == null){
            setPaymentTransfer("Deposito Bancario");
        }
        return paymentTransfer;
    }

    public void setPaymentTransfer(String paymentTransfer) {
        this.paymentTransfer = paymentTransfer;
    }
    
    public void setDefault(){
        if(paymentTransfer == null){
            this.setPaymentTransfer("Deposito Bancario");
        }
        if(paymentDay == null){
            LocalDate l = LocalDate.now();
            LocalDate j = l;
            if(this instanceof Salaried){
                //j = j.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).plusMonths(1);
                j = j.with(TemporalAdjusters.lastDayOfMonth());
            } else if (this instanceof Commissioned){
                j = j.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).plusWeeks(1);
            }else{
               j = j.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)); 
            }
            this.paymentDay = j; 
        }
    }
    
    @Override
    public String toString() {
        System.out.println(this.getSyndicateId());
        return "Funcionario{" + "name: " + name + ", employeeID: " 
                + employeeID + ", address: " + address + ", type: " + type + ", Syndicate: " +
                Syndicate.isSyndicate()+ ", salary: " + salary + ", paymentMethod: " + getPaymentMethod() + " " 
                +getTimePaymentMethod()+" "+ getTimeMethodWeekDay()+" " + getPaymentTransfer() +" "+ getPaymentDay()+ "}\n";
    }
  
}
