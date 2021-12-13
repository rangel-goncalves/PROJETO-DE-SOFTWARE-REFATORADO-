/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Rangel
 */
public class CartaoDePonto {
    
    QuadrodeFuncionarios qf;

    public CartaoDePonto(QuadrodeFuncionarios qf) {
        this.qf = qf;
    }
  
    public void lancarCartao(String cpf, LocalDateTime Chegada,LocalDateTime saida){
        
        int i = qf.getIndex(cpf);
        if(qf.f.get(i) instanceof Hourly){
            ((Hourly)qf.f.get(i)).setWorkedhours(Chegada, saida);
        }
        
    }
    
    public void lancarCartao(String cpf, int Chegada, int saida, int dia){
        
        int i = qf.getIndex(cpf);
        if(qf.f.get(i) instanceof Hourly){
            ((Hourly)qf.f.get(i)).setWorkedhours(Chegada, saida, dia);
        }
        
    }
    
}
