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
public class AgendaHorista implements Command{
    
    
    private float total;
    private LocalDate diaDePagamento;
    Funcionario p;

    @Override
    public String execute(Funcionario p, LocalDate cur) {
        if(p instanceof Hourly){
                String taxasSind_Vendas="";
                if(cur.equals(p.getPaymentDay()))
                {
                    if(p.getPaymentMethod().equals("bi- semanalmente")){
                    this.total =  (((Hourly) p).getWorkedhours() * p.getSalary()) + ((((Hourly) p).getExtraHours()) * p.getSalary()*1.5f)
                            - (p.getUnionFee()/2);
                    ((Hourly) p).FillWorkedhours();
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
                        //this.total -= p.getTaxaServicoSindicato();
                        //p.newTaxaServicoSindicato(-1*p.getTaxaServicoSindicato(), cur);
                        p.setIsTaxaLancada(true);
                    }
                    
                } else if(p.getPaymentMethod().equals("semanalmente")){
                    this.total =  (((Hourly) p).getWorkedhours() * p.getSalary()) + ((((Hourly) p).getExtraHours()) * (p.getSalary()*1.5f))
                            - (p.getUnionFee()/4);
                    ((Hourly) p).FillWorkedhours();
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
                        //this.total -= p.getTaxaServicoSindicato();
                        //p.newTaxaServicoSindicato(-1*p.getTaxaServicoSindicato(), cur);
                        p.setIsTaxaLancada(true);
                    }
                    
                } else if(p.getPaymentMethod().equals("mensalmente")|| p.getPaymentMethod().equals("mensal")){
                    this.total =  ((Hourly) p).getWorkedhours() * p.getSalary() + (((Hourly) p).getExtraHours()) * p.getSalary()*1.5f
                            - p.getUnionFee() /*- p.getTaxaServicoSindicato()*/;
                    ((Hourly) p).FillWorkedhours();
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
                        //this.total -= p.getTaxaServicoSindicato();
                        //p.newTaxaServicoSindicato(-1*p.getTaxaServicoSindicato(), cur);
                        p.setIsTaxaLancada(true);
                    }
                }
                    return (p.getName()+":("+p.getEmployeeID()+")->"+this.total+" "+ p.getPaymentTransfer()+"\n"+taxasSind_Vendas)+"\n";
                }
                
                
        }
        return "";
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