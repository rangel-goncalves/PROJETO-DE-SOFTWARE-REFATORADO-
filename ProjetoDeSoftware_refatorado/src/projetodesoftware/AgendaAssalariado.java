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
public class AgendaAssalariado implements Command{
        
    private float total;
    private LocalDate diaDePagamento;
    Funcionario p;

    public String calcularBiSemanal(Funcionario p, LocalDate cur){
        String taxasSind_Vendas="";
        this.total =  p.getSalary()/2 - p.getUnionFee()/2;
        p.setPaymentDay(p.getPaymentDay().plusDays(14));
        setDiaDePagamento(p.getPaymentDay().plusDays(14));
        if(p.getUnionFee()>0){
            taxasSind_Vendas += "-"+p.getUnionFee()/2+" Taxa Sindical\n";
        }
        if(p.getIsTaxaLancada()){
            this.total -= p.getTaxaServicoSindicato();
            taxasSind_Vendas += "-"+p.getTaxaServicoSindicato()+" por Serviços sindicais\n";
            p.newTaxaServicoSindicato(-1*p.getTaxaServicoSindicato(), cur);
            p.setIsTaxaLancada(false);
        }
        if(p.getPaymentDay().isAfter(cur.with(TemporalAdjusters.lastDayOfMonth()))){
            p.setIsTaxaLancada(true);
        }
        return (p.getName()+":("+p.getEmployeeID()+")->"+this.total+" "+ p.getPaymentTransfer()+"\n"+taxasSind_Vendas)+"\n";
    }
    
    public String calcularSamanal(Funcionario p, LocalDate cur){
        String taxasSind_Vendas="";
        this.total =  p.getSalary()/4 - p.getUnionFee()/4;
        p.setPaymentDay(p.getPaymentDay().plusDays(7));
        setDiaDePagamento(p.getPaymentDay().plusDays(7));
        if(p.getUnionFee()>0){
            taxasSind_Vendas += "-"+p.getUnionFee()/4+" Taxa Sindical\n";
        }
        if(p.getIsTaxaLancada()){
            this.total -= p.getTaxaServicoSindicato();
            taxasSind_Vendas += "-"+p.getTaxaServicoSindicato()+" por Serviços sindicais\n";
            p.newTaxaServicoSindicato(-1*p.getTaxaServicoSindicato(), cur);
            p.setIsTaxaLancada(false);
        }
        if(p.getPaymentDay().isAfter(cur.with(TemporalAdjusters.lastDayOfMonth()))){
            p.setIsTaxaLancada(true);
        }
        return (p.getName()+":("+p.getEmployeeID()+")->"+this.total+" "+ p.getPaymentTransfer()+"\n"+taxasSind_Vendas)+"\n";           
    }
    
    public String  calcularMensal(Funcionario p, LocalDate cur){
        String taxasSind_Vendas="";
        this.total =  p.getSalary()- p.getUnionFee() /*- p.getTaxaServicoSindicato()*/;
        p.setPaymentDay(p.getPaymentDay().plusMonths(1));
        setDiaDePagamento(p.getPaymentDay().plusMonths(1));
        if(p.getUnionFee()>0){
            taxasSind_Vendas += "-"+p.getUnionFee()+" Taxa Sindical\n";
        }
        if(p.getIsTaxaLancada()){
            this.total -= p.getTaxaServicoSindicato();
            taxasSind_Vendas += "-"+p.getTaxaServicoSindicato()+" por Serviços sindicais\n";
            p.newTaxaServicoSindicato(-1*p.getTaxaServicoSindicato(), cur);
            p.setIsTaxaLancada(false);
        }
        if(p.getPaymentDay().isAfter(cur.with(TemporalAdjusters.lastDayOfMonth()))){
            p.setIsTaxaLancada(true);
        }
        return (p.getName()+":("+p.getEmployeeID()+")->"+this.total+" "+ p.getPaymentTransfer()+"\n"+taxasSind_Vendas)+"\n";
    }

    public String gerarContraCheque(Funcionario p, LocalDate cur){
        if(p instanceof Salaried){
            if(cur.equals(p.getPaymentDay())){
                if(p.getPaymentMethod().equals("bi- semanalmente")){
                    return this.calcularBiSemanal(p, cur);
                } else if(p.getPaymentMethod().equals("semanalmente")){
                    return this.calcularSamanal(p, cur);
                } else if(p.getPaymentMethod().equals("mensalmente")|| p.getPaymentMethod().equals("mensal")){
                    return this.calcularMensal(p, cur);
                }
            }
        }
        return "";
    }
    
    @Override
    public String execute(Funcionario p, LocalDate cur) {
        return this.gerarContraCheque(p, cur);
    }
    public float getTotal() {
        return total;
    }
    
    

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getDiaDePagamento() {
        return diaDePagamento;
    }

    public void setDiaDePagamento(LocalDate diaDePagamento) {
        this.diaDePagamento = diaDePagamento;
    }

}
