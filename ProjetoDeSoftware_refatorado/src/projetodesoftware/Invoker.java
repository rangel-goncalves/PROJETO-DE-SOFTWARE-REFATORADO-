/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rangel
 */
public class Invoker {
    
    public Map<String, Command> comandos = new HashMap<String, Command>();

    public Invoker() {
        comandos.put("A", new AgendaAssalariado());
        comandos.put("C", new AgendaComissionado());
        comandos.put("H", new AgendaHorista());
        comandos.put("G", new AgendaGeral());
    }
    
    public String invoker(String comando,LocalDate cur, Funcionario p){
        if(comandos.get(comando)!=null)
        {
            return comandos.get(comando).execute(p,cur);
        }
        return("!!!Comando desconhecido!!!\n"
                + "Comandos possiveis: \n"
                + "Rodar agenda de todos assalariados(A)\n"
                + "Rodar agenda de todos Comissionados(C)\n"
                + "Rodar agenda de todos Horistas(H)\n"
                + "Rodar agenda Geral(G)");
    }
}
