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
public class Salaried extends Funcionario{

    public Salaried() {
        
    }

    public Salaried(String name, String employeeID) {
        super(name, employeeID, "", "Salaried", "mensalmente", 0.0f);
    }

    public Salaried(String name, String employeeID, float salary) {
        super(name, employeeID, "", "Salaried", "mensalmente", salary);
    }

    public Salaried(String name, String employeeID, String address) {
        super(name, employeeID, address, "Salaried", "mensalmente");
    }

    public Salaried(String name, String employeeID, String address, float salary) {
        super(name, employeeID, address, "Salaried", "mensalmente");
    }

    public Salaried(String name, String employeeID, String address, String paymentMethod) {
        super(name, employeeID, address, "Salaried", paymentMethod);
    }

    public Salaried(String name, String employeeID, String address, String paymentMethod, float salary) {
        super(name, employeeID, address, "Salaried", paymentMethod, salary);
    }

    public Salaried(String name, String employeeID, String address, boolean Syndicate, String paymentMethod, float salary) {
        super(name, employeeID, address, "Salaried", Syndicate, paymentMethod, salary);
    }


}
