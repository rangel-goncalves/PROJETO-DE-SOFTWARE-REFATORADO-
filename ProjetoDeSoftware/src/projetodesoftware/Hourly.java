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
public class Hourly extends Funcionario{
    
    private float workedhours;

    public Hourly() {
    }

    public Hourly(String name, String employeeID) {
        super(name, employeeID, "", "Hourly", "semanalmente");
    }

    public Hourly(String name, String employeeID, float salary) {
        super(name, employeeID, "", "Hourly", "semanalmente", salary);
    }

    public Hourly(String name, String employeeID, String address) {
        super(name, employeeID, address, "Hourly", "semanalmente");
    }

    public Hourly(String name, String employeeID, String address, float salary) {
        super(name, employeeID, address, "Hourly", "semanalmente", salary);
    }

    public Hourly(String name, String employeeID, String address, String paymentMethod) {
        super(name, employeeID, address, "Hourly", paymentMethod);
    }

    public Hourly(String name, String employeeID, String address, String paymentMethod, float salary) {
        super(name, employeeID, address, "Hourly", paymentMethod, salary);
    }

    public Hourly(String name, String employeeID, String address, boolean Syndicate, String paymentMethod, float salary) {
        super(name, employeeID, address, "Hourly", Syndicate, paymentMethod, salary);
    }

    public float getWorkedhours() {
        return workedhours;
    }

    public void setWorkedhours(float workedhours) {
        this.workedhours = workedhours;
    }

    @Override
    public String toString() {
        return "Hourly{" + "workedhours: " + workedhours + '}';
    }

   
}
