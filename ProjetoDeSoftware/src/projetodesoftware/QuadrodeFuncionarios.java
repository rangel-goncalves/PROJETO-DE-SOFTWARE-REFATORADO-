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
public class QuadrodeFuncionarios implements Quadrofuncionario {
    
    ArrayList<Funcionario> f = new ArrayList();
    Scanner input =  new Scanner(System.in);
  
  
    @Override
    public void add() {
        Funcionario p = new Funcionario();
        System.out.println("Adicionar Funcionario%n");
        System.out.print("Nome: ");
        p.setName(input.nextLine());
        System.out.print("Endereço: ");
        p.setAddress(input.nextLine());
        System.out.print("CPF: ");
        p.setEmployeeID(input.nextLine());
        //input.nextLine();
        System.out.print("Tipo:(hourly, salaried, commissioned) ");
        p.setType(input.next());
        System.out.print("Salario: ");
        p.setSalary(input.nextFloat());
        System.out.print("Sindicato: ");
        p.setSyndicate(input.nextBoolean());
        input.nextLine();
        f.add(p);
    }

    @Override
    public void remover() {
        String cpf;
        System.out.println("Digite o id do funcionario(CPF)");
        cpf = input.nextLine();
        for(int i = 0; i< f.size(); i++ ){
            if (f.get(i).getEmployeeID().equals(cpf)){
                System.out.println("Fazer desligamento do funcionario: "+f.get(i).getName()+"\n ID: "+f.get(i).getEmployeeID()
                                    +"da Empresa(S/N)");
                String ans;
                ans = input.next();
                switch(ans){
                    case "S" -> f.remove(i);
                    case "N" -> System.out.println("Operação cancelada!");
                    default -> System.out.println("!INVALIDO! OPERAÇÃO CANCELADA.");
                    
                }
                return;
            }
        }
        System.out.println("Funcionario nao encontrado");
    }

    @Override
    public void list() {
        if (f.isEmpty()){
            System.out.println("Nao possui nenhum funcionario contratado");
        }else{
            System.out.println("************");
            for(int i = 0; i< f.size(); i++ ){
                    f.get(i).ficha();
                    System.out.println("************");
                }
            }
        }

    @Override
    public void pesquisar() {
        String cpf;
        System.out.println("Digite o id do funcionario(CPF)");
        cpf = input.nextLine();
        for(int i = 0; i< f.size(); i++ ){
            if (f.get(i).getEmployeeID().equals(cpf)){
                f.get(i).ficha();
                return;
            }
        }
        System.out.println("Funcionario nao encontrado");
    }
}
