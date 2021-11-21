/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

/**
 *
 * @author Rangel
 */
public class Commissioned extends Funcionario {
    
    private float commission;
    private float sales;

    public Commissioned() {
    }

    public Commissioned(String name, String employeeID) {
        super(name, employeeID, "", "Commissioned", "bi- semanalmente",0.0f);
    }

    public Commissioned(String name, String employeeID, float salary) {
        super(name, employeeID, "", "Commissioned", "bi- semanalmente",salary);
    }

    public Commissioned(String name, String employeeID, String address) {
        super(name, employeeID, address, "Commissioned", "bi- semanalmente");
    }

    public Commissioned(String name, String employeeID, String address, float salary) {
        super(name, employeeID, address, "Commissioned", "bi- semanalmente",salary);
    }

    public Commissioned(String name, String employeeID, String address,  String paymentMethod) {
        super(name, employeeID, address, "Commissioned", paymentMethod);
    }

    public Commissioned(String name, String employeeID, String address, String paymentMethod, float salary) {
        super(name, employeeID, address, "Commissioned", paymentMethod, salary);
    }

    public Commissioned(String name, String employeeID, String address, boolean Syndicate, String paymentMethod, float salary) {
        super(name, employeeID, address, "Commissioned", Syndicate, paymentMethod, salary);
    }
///////////////////////////////com comissao///////////////////////////
    public Commissioned(float commission, String name, String employeeID) {
        super(name, employeeID, "", "Commissioned", "bi- semanalmente",0.0f);
        this.commission = commission;
    }

    public Commissioned(float commission, String name, String employeeID, float salary) {
        super(name, employeeID, "", "Commissioned", "bi- semanalmente",salary);
        this.commission = commission;
    }

    public Commissioned(float commission, String name, String employeeID, String address) {
        super(name, employeeID, address, "Commissioned", "bi- semanalmente");
        this.commission = commission;
    }

    public Commissioned(float commission, String name, String employeeID, String address, float salary) {
        super(name, employeeID, address, "Commissioned", "bi- semanalmente",salary);
        this.commission = commission;
    }

    public Commissioned(float commission, String name, String employeeID, String address, String paymentMethod) {
        super(name, employeeID, address, "Commissioned", paymentMethod);
        this.commission = commission;
    }

    public Commissioned(float commission, String name, String employeeID, String address, String paymentMethod, float salary) {
        super(name, employeeID, address, "Commissioned", paymentMethod, salary);
        this.commission = commission;
    }

    public Commissioned(float commission, String name, String employeeID, String address, boolean Syndicate, String paymentMethod, float salary) {
        super(name, employeeID, address, "Commissioned", Syndicate, paymentMethod, salary);
        this.commission = commission;
    }



    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSales() {
        return sales;
    }

    public void setSales(float sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return super.toString() + "Commissioned{" + "commission: " + commission + ", sales: " + sales + '}';
    }

}
