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
    
    public ArrayList<Funcionario> f = new ArrayList();
    Scanner input =  new Scanner(System.in);
  
  
    @Override
    public void add(Funcionario p) {
        f.add(p);
    }

    @Override
    public void remover(String cpf) {
        for(int i = 0; i< f.size(); i++ ){
            if (f.get(i).getEmployeeID().equals(cpf)){   
                f.remove(i); 
                }
                return;
            }
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
    public String pesquisar(String cpf) {  
        for(int i = 0; i< f.size(); i++ ){
            if (f.get(i).getEmployeeID().equals(cpf)){
                return f.get(i).ficha();
            }
        }
        return("funcionario nao encontrado");
    }

    @Override
    public void changeDetails(String cpf, Funcionario p) {
        
        for(int i = 0; i< f.size(); i++ ){
            if (f.get(i).getEmployeeID().equals(cpf)){
                 f.set(i, p);
                break;
            }
        } 
    }

    @Override
    public int getIndex(String cpf) {
        for(int i = 0; i< f.size(); i++ ){
            if (f.get(i).getEmployeeID().equals(cpf)){
                return i;
            }
        }
        return -1;
    }
}
