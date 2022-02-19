/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.time.LocalDate;

/**
 *
 * @author Rangel
 */
public class AgendaGeral implements Command{
    
    

    @Override
    public String execute(Funcionario p, LocalDate cur) {
        return contrachequeGeral(p,cur);
    }

    private String contrachequeGeral(Funcionario p, LocalDate cur) {
        String s="";
        Invoker i = new Invoker();
        s += i.invoker("A", cur, p);
        s += i.invoker("C", cur, p);
        s += i.invoker("H", cur, p);
        return s;   
    }
    
    
    
}
