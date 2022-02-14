/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

/**
 *
 * @author Rangel
 */
public class AgendaPagamento{
    
    private ArrayList<String> agendas = new ArrayList();
    
    public AgendaPagamento() {
        agendas.add("semanalmente");
        agendas.add("mensalmente");
        agendas.add("bi- semanalmente");
        agendas.add("semanal 2 sexta");
    }
    
    public void AddAgenda(String add){
        agendas.add(add);
    }
      
    public String ListAgendas(){
        String s = "";
        for (int i = 0; i < agendas.size(); i++) {
            s +="("+ i+") "+agendas.get(i)+"\n";
        }
        return s;
    }
    
    public boolean existAgenda(String agenda){
        for (int i = 0; i < agendas.size(); i++) {
            if(agendas.get(i).equals(agenda)){
                return true;
            }
        }
        return false;
    }
    
}
