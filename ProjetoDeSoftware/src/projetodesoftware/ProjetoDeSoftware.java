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
       
        QuadrodeFuncionarios qf = new QuadrodeFuncionarios();
        
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
