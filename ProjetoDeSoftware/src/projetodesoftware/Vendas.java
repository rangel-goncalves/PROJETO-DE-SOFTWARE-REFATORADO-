/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Rangel
 */
public class Vendas {
    /*
    lamçar(empregado, valor);
    
    */
    private QuadrodeFuncionarios qf;

    public Vendas(QuadrodeFuncionarios qf) {
        this.qf = qf;
    }
    
    public void lancarVenda(String cpf, float preco){
        int i = qf.getIndex(cpf);
        if(qf.f.get(i) instanceof Commissioned){
            ((Commissioned)qf.f.get(i)).setSales(preco*((Commissioned)qf.f.get(i)).getCommission()/100);
            LocalDateTime l1 = LocalDateTime.of(qf.getDiaAtual(), LocalTime.now()); // retirando nos mili/nano segundos
            DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
            ((Commissioned)qf.f.get(i)).setSalesHistory(Float.toString(preco)+" Horario: "
                    +l1.truncatedTo(ChronoUnit.SECONDS).format(dtf));
        }
    }
}
