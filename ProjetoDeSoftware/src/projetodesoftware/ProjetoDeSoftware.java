/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class ProjetoDeSoftware {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input =  new Scanner(System.in);
        ArrayList<Funcionario> f = new ArrayList();
        String name ;
        String address;
        int employeeID;
        String type;
    
        float salary;
        float commission = 0.0f;
        boolean syndicate;
        
        System.out.println("Adicionar Funcionario");
        System.out.println("Dados do Funcionario:");
        System.out.println("Nome: ");
        name= input.nextLine();
        System.out.println("Endereço: ");
        address = input.nextLine();
        input.nextLine();
        System.out.println("CPF: ");
        employeeID = input.nextInt();
        input.nextLine();
        System.out.println("Tipo:(hourly, salaried, commissioned)");
        type = input.nextLine();
        if(type.equals("commissioned")){
            System.out.println("Percentual de comissão: ");
            commission = input.nextFloat();
        }
        System.out.println("Salário: ");
        salary = input.nextFloat();
        System.out.println("É afiliado ao sindicato?(1 para S/0 para N)");
        syndicate = input.nextBoolean();
        f.add(new Funcionario(name,address,employeeID,type,salary,commission,syndicate));
        f.get(0).ficha();
        
    }
    
}
