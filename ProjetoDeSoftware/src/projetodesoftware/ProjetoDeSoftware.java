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
        /*ArrayList<Funcionario> f = new ArrayList();
        String name ;
        String address;
        int employeeID;
        String type;
    
        float salary;
        float commission = 0.0f;
        boolean syndicate;
        
        /*System.out.println("Adicionar Funcionario");
        System.out.println("Dados do Funcionario:");
        System.out.println("Nome: ");
        name= input.nextLine();
        System.out.println("Endereço: ");
        address = input.nextLine();
        //input.nextLine();
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
        f.add(new Funcionario(name,address,employeeID,type,salary,commission,syndicate));*/
        QuadrodeFuncionarios qf = new QuadrodeFuncionarios();
        
        //qf.add();
        //qf.add();
        //qf.add();
        //qf.pesquisar();
        while(true){
            System.out.println("""
                               MENU:
                               Adicionar funcionario(1)
                               Remover funcionario(2)
                               Lista de funcionario(3)
                               Pesquisar Funcionario(4)
                               Fechar programa(0)""");
            int opcao =  input.nextInt();
            switch(opcao){
                case 1 -> qf.add();
                case 2 -> qf.remover();
                case 3 -> qf.list();
                case 4 -> qf.pesquisar();
                case 5 -> qf.changeDetails();
                default -> {
                }
            }
            if (opcao == 0){
                break;
            }
        }
    }
    
}
