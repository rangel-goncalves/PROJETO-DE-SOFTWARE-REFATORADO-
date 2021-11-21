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

    
    public static void main(String[] args) {
        
        Scanner input =  new Scanner(System.in);
       
        //QuadrodeFuncionarios qf = new QuadrodeFuncionarios();
        ArrayList<Funcionario> p = new ArrayList();
        p.add(new Commissioned(1000, "felipe", "123"));
        p.add(new Funcionario("rangel","forene", "123", "comi"));
        System.out.println("*********************");
        System.out.println(p.get(0).toString()+"\n"+p.get(0).getClass());
        //System.out.println("*********************");
        //System.out.println(p.get(1).toString());
        if(p.get(0) instanceof Salaried){
                System.out.println(((Salaried) p.get(0)).getSalary());
            }
        p.set(0, p.get(1));
        System.out.println("*********************");
        System.out.println(p.get(0).toString()+"\n"+p.get(0).getClass());
        //System.out.println(p.get(0).getClass());   
        /*Funcionario t = new Salaried(1000, "felipe", "123");
        ArrayList<Funcionario> g = new ArrayList<Funcionario>();
        g.add(new Salaried(1000, "felipe", "123")); */
        /*while(true){
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
            
        }*/
    }
    
}
