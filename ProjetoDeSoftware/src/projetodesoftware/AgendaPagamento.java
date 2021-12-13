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
public class AgendaPagamento implements  Cloneable{
    
    private ArrayList<String> agendas = new ArrayList();
    private float total;
    private LocalDate diaDePagamento;
    Funcionario p;

    public AgendaPagamento() {
        agendas.add("semanalmente");
        agendas.add("mensalmente");
        agendas.add("bi- semanalmente");
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
    
    public String pagamentoGeral(Funcionario p, LocalDate cur){
        String s ="";
        s+=pagamentoComissionado(p,cur);
        s+=pagamentoSalariado(p,cur);
        s+=pagamentoHorista(p,cur);
        return s;
    }
    
    public String pagamentoComissionado(Funcionario p, LocalDate cur){
        
        if(p instanceof Commissioned){
            if(cur.equals(p.getPaymentDay())){
                float comissao = ((Commissioned) p).getSales();
                if(p.getPaymentMethod().equals("bi- semanalmente")){
                    total =  p.getSalary()/2 + ((Commissioned) p).getSales()/**((Commissioned) p).getCommission()/100*/ - p.getUnionFee()/2;
                    ((Commissioned) p).setSales(((Commissioned)p).getSales()*-1);
                    p.setPaymentDay(p.getPaymentDay().plusDays(14));
                    setDiaDePagamento(p.getPaymentDay().plusDays(14));
                    ////arrumar taxa de serivços sindicato
                    if(p.getPaymentDay().isAfter(cur.with(TemporalAdjusters.lastDayOfMonth()))){
                        System.out.println("discontei "+p.getTaxaServicoSindicato() );
                        this.total -= p.getTaxaServicoSindicato();
                    }
                } else if(p.getPaymentMethod().equals("semanalmente")){
                    total =  p.getSalary()/4 + ((Commissioned) p).getSales()/**((Commissioned) p).getCommission()/100*/- p.getUnionFee()/4;
                    ((Commissioned) p).setSales(((Commissioned)p).getSales()*-1);
                    p.setPaymentDay(p.getPaymentDay().plusDays(7));
                    setDiaDePagamento(p.getPaymentDay().plusDays(7));
                    if(p.getPaymentDay().isAfter(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()))){
                        this.total -= p.getTaxaServicoSindicato();
                    }
                } else if(p.getPaymentMethod().equals("mensalmente") || p.getPaymentMethod().equals("mensal")){
                    total =  p.getSalary() + ((Commissioned) p).getSales()/**((Commissioned) p).getCommission()/100*/- p.getUnionFee() - p.getTaxaServicoSindicato();
                    ((Commissioned) p).setSales(((Commissioned)p).getSales()*-1);
                    p.setPaymentDay(p.getPaymentDay().plusMonths(1));
                    setDiaDePagamento(p.getPaymentDay().plusMonths(1));
                }
                ((Commissioned) p).setSalesHistory("Comissão ja recebida: "+comissao);
                return(p.getName()+":("+p.getEmployeeID()+")->"+this.total +" "+ p.getPaymentTransfer());
                
            }
        }
        return "";
    }
    
    public String pagamentoSalariado(Funcionario p, LocalDate cur){
        
         if(p instanceof Salaried){
            if(cur.equals(p.getPaymentDay())){
                if(p.getPaymentMethod().equals("bi- semanalmente")){
                    this.total =  p.getSalary()/2 - p.getUnionFee()/2;
                    p.setPaymentDay(p.getPaymentDay().plusDays(14));
                    setDiaDePagamento(p.getPaymentDay().plusDays(14));
                    if(p.getPaymentDay().isAfter(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()))){
                        this.total -= p.getTaxaServicoSindicato();
                    }
                } else if(p.getPaymentMethod().equals("semanalmente")){
                    this.total =  p.getSalary()/4 - p.getUnionFee()/4;
                    p.setPaymentDay(p.getPaymentDay().plusDays(7));
                    setDiaDePagamento(p.getPaymentDay().plusDays(7));
                    if(p.getPaymentDay().isAfter(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()))){
                        this.total -= p.getTaxaServicoSindicato();
                    }
                    
                } else if(p.getPaymentMethod().equals("mensalmente")|| p.getPaymentMethod().equals("mensal")){
                    this.total =  p.getSalary()- p.getUnionFee() - p.getTaxaServicoSindicato();
                    p.setPaymentDay(p.getPaymentDay().plusMonths(1));
                    setDiaDePagamento(p.getPaymentDay().plusMonths(1));
                } /*else if(p.getPaymentMethod().equals("semanal 1 segunda")){
                    this.total =  p.getSalary()/4;
                    p.setPaymentDay(p.getPaymentDay().plusDays(7));
                    setDiaDePagamento(p.getPaymentDay().plusDays(7));
                }*/
                return (p.getName()+":("+p.getEmployeeID()+")->"+this.total+" "+ p.getPaymentTransfer())+"\n";
            }
        }
        return "";
    }
    
    public String pagamentoHorista(Funcionario p, LocalDate cur){
        
         if(p instanceof Hourly){
                if(cur.equals(p.getPaymentDay()))
                {
                    if(p.getPaymentMethod().equals("bi- semanalmente")){
                    this.total =  ((Hourly) p).getWorkedhours() * p.getSalary() + (((Hourly) p).getWorkedhours()%8) * p.getSalary()*1.5f
                            - p.getUnionFee()/2;
                    ((Hourly) p).FillWorkedhours();
                    p.setPaymentDay(p.getPaymentDay().plusDays(14));
                    setDiaDePagamento(p.getPaymentDay().plusDays(14));
                    if(p.getPaymentDay().isAfter(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()))){
                        this.total -= p.getTaxaServicoSindicato();
                    }
                    
                } else if(p.getPaymentMethod().equals("semanalmente")){
                    this.total =  ((Hourly) p).getWorkedhours() * p.getSalary() + (((Hourly) p).getWorkedhours()%8) * p.getSalary()*1.5f
                            - p.getUnionFee()/4;
                    ((Hourly) p).FillWorkedhours();
                    p.setPaymentDay(p.getPaymentDay().plusDays(7));
                    setDiaDePagamento(p.getPaymentDay().plusDays(7));
                    if(p.getPaymentDay().isAfter(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()))){
                        this.total -= p.getTaxaServicoSindicato();
                    }
                    
                } else if(p.getPaymentMethod().equals("mensalmente")|| p.getPaymentMethod().equals("mensal")){
                    this.total =  ((Hourly) p).getWorkedhours() * p.getSalary() + (((Hourly) p).getWorkedhours()%8) * p.getSalary()*1.5f
                            - p.getUnionFee() - p.getTaxaServicoSindicato();
                    ((Hourly) p).FillWorkedhours();
                    p.setPaymentDay(p.getPaymentDay().plusMonths(1));
                    setDiaDePagamento(p.getPaymentDay().plusMonths(1));
                }
                    /*total =  ((Hourly) p).getWorkedhours() * p.getSalary() + (((Hourly) p).getWorkedhours()%8) * p.getSalary()*1.5f;
                    ((Hourly) p).FillWorkedhours();
                    p.setPaymentDay(p.getPaymentDay().plusDays(7));
                    setDiaDePagamento(p.getPaymentDay().plusDays(7));*/
                    return (p.getName()+":("+p.getEmployeeID()+")->"+this.total+" "+ p.getPaymentTransfer())+"\n";
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
