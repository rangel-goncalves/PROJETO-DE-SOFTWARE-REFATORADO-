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
public interface Quadrofuncionario {
    public abstract void add(Funcionario p);
    public abstract void remover(String cpf);
    public abstract void list();
    public abstract String pesquisar(String cpf);
    public abstract void changeDetails(String cpf, Funcionario p);
    public abstract int getIndex(String cpf);
    
}
