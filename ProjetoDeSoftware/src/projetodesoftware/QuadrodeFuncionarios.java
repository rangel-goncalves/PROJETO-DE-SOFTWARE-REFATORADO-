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

    @Override
    public void changeDetails() {
        int k =-1;
        String cpf;
        System.out.println("Digite o id do funcionario(CPF) que deseja fazer alteracoes");
        cpf = input.nextLine();
        for(int i = 0; i< f.size(); i++ ){
            if (f.get(i).getEmployeeID().equals(cpf)){
                k = i;
                break;
            }
        } 
        if(k == -1){
            System.out.println("Funcionario nao encontrado");
            return;
        }
        System.out.println("Qual informção do funcionario alterar? ");
        String ans = input.next();
        input.nextLine();
        switch (ans) {
            case "nome", "Nome" -> {
                System.out.println("Digite o novo nome: ");
                ans = input.nextLine();
                f.get(k).setName(ans);
            }
            case "endereco", "Endereco" -> {
                System.out.println("Digite o novo endereco: ");
                ans = input.nextLine();
                f.get(k).setAddress(ans);
            }
            case "tipo", "Tipo" -> {
                System.out.println("Digite o novo tipo: ");
                ans = input.next();
                f.get(k).setType(ans);
            }
            case "metodo de pagamento", "Metodo de pagamento" -> {
                System.out.println("digite o novo metodo de pagamento");
                ans = input.nextLine();
                f.get(k).setPaymentMethod(ans);
            }
            case "sindicato", "Sindicato" -> {
                System.out.println("Digite a nova relação com o sindicato: ");
                ans = input.next();
                f.get(k).setSyndicate(Boolean.parseBoolean(ans));
            }
            case "sindicatoID", "SindicatoID" -> {
                System.out.println("Digite o nodo ID do sindicato");
                ans = input.next();
                f.get(k).setSyndicateID(ans);
            }
            case "taxa do sindicato", "Taxa do sindicato" -> {
                System.out.println("Digite o calor da nova taxa");
                ans = input.next();
                f.get(k).setUnionFee(Float.parseFloat(ans));
            }
            default -> {
            }
        }
    }
}
