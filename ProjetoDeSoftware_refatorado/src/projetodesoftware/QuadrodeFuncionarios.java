/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class QuadrodeFuncionarios implements Quadrofuncionario{
    
    public ArrayList<Funcionario> f = new ArrayList();
    public AgendaPagamento ap = new AgendaPagamento();
    public LocalDate diaAtual = LocalDate.now();
    public Invoker invoker = new Invoker();
    Scanner input =  new Scanner(System.in);
    
    public String rodarAgenda(String grupo){
        String s ="";
                for (Funcionario funcionario : f) {
                    s += invoker.invoker(grupo, diaAtual,funcionario);
                }
        return s;
    }
    
    public int AlterarAgandaFuncionario(String cpf, String Method, String timeMethod, String timeMethodWeekDay){
        int i = getIndex(cpf);
        String confereAgenda=Method;
        if(!timeMethod.equals("") && timeMethod != null){
            confereAgenda += " "+timeMethod;
        } else{
            timeMethod = "";
        }
        if(!timeMethodWeekDay.equals("")&& timeMethodWeekDay!=null){
            confereAgenda += " "+timeMethodWeekDay;
        }else{
            timeMethodWeekDay = "";
        }
        if(!ap.existAgenda(confereAgenda)){
            return -1;
        }
        f.get(i).setPaymentMethod(Method, timeMethod, timeMethodWeekDay); // atualizo os valores diretamente
        ///////////// atualizo o dia de pagamento ///////////////
        if(Method.equals("mensal") ||  Method.equals("mensalmente")){
            LocalDate l2 = this.getDiaAtual().with(TemporalAdjusters.lastDayOfMonth());
            if(timeMethod.equals("$") || timeMethod.equals("") || timeMethod== null){
                //LocalDate l1 = f.get(i).getPaymentDay().with(TemporalAdjusters.lastDayOfMonth());
                //DayOfWeek d = f.get(i).getPaymentDay().withDayOfMonth(l2.getDayOfMonth()).getDayOfWeek();
                DayOfWeek d = this.getDiaAtual().withDayOfMonth(l2.getDayOfMonth()).getDayOfWeek();
                if(d == DayOfWeek.SUNDAY){ /////somente o ultimo dia util(no maximo sabado)
                    //f.get(i).setPaymentDay(f.get(i).getPaymentDay().with(TemporalAdjusters.lastDayOfMonth()).minusDays(1));
                    f.get(i).setPaymentDay(l2.minusDays(1));
                }else{
                    //f.get(i).setPaymentDay(f.get(i).getPaymentDay().with(TemporalAdjusters.lastDayOfMonth()));
                    f.get(i).setPaymentDay(l2.with(TemporalAdjusters.lastDayOfMonth()));
                } 
            }else { // timeMethod sera o dia do pagamento
                if(l2.withDayOfMonth(Integer.parseInt(timeMethod)).isBefore(this.getDiaAtual())){
                    f.get(i).setPaymentDay(l2.withDayOfMonth(Integer.parseInt(timeMethod)).plusMonths(1));
                }else{
                    f.get(i).setPaymentDay(l2.withDayOfMonth(Integer.parseInt(timeMethod)));
                }
            }
        } else if(Method.equals("semanal") || Method.equals("semanalmente")){     
            if(timeMethodWeekDay.equals("") || timeMethodWeekDay == null){  //// pago por semana nas sextas
                if(timeMethod.equals("2")){
                    f.get(i).setPaymentMethod("bi- semanalmente", "","");
                    f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).plusDays(7));
                } else if(timeMethod.equals("1")|| timeMethod.equals("")){
                    f.get(i).setPaymentMethod("semanalmente", "","");
                    f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
                }
            }else{
                if(timeMethodWeekDay.equals("segunda")){ //// pago por semana nas segundas
                    if(timeMethod.equals("2")){
                        f.get(i).setPaymentMethod("bi- semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).plusDays(7));
                    } else if(timeMethod.equals("1") || timeMethod.equals("")){
                        f.get(i).setPaymentMethod("semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
                    }
                } else if(timeMethodWeekDay.equals("terca")){
                  if(timeMethod.equals("2")){
                        f.get(i).setPaymentMethod("bi- semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).plusDays(7));
                    } else if(timeMethod.equals("1")){
                        f.get(i).setPaymentMethod("semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
                    }  
                } else if(timeMethodWeekDay.equals("quarta")){
                    if(timeMethod.equals("2")){
                        f.get(i).setPaymentMethod("bi- semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)).plusDays(7));
                    } else if(timeMethod.equals("1") || timeMethod.equals("")){
                        f.get(i).setPaymentMethod("semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)));
                    } 
                } else if(timeMethodWeekDay.equals("quinta")){
                    if(timeMethod.equals("2")){
                        f.get(i).setPaymentMethod("bi- semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).plusDays(7));
                    } else if(timeMethod.equals("1") || timeMethod.equals("")){
                        f.get(i).setPaymentMethod("semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)));
                    } 
                } else if(timeMethodWeekDay.equals("sexta")){
                    if(timeMethod.equals("2")){
                        f.get(i).setPaymentMethod("bi- semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).plusDays(7));
                    } else if(timeMethod.equals("1") || timeMethod.equals("")){
                        f.get(i).setPaymentMethod("semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
                    } 
                } else if(timeMethodWeekDay.equals("sabado")){
                    if(timeMethod.equals("2")){
                        f.get(i).setPaymentMethod("bi- semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).plusDays(7));
                    } else if(timeMethod.equals("1") || timeMethod.equals("")){
                        f.get(i).setPaymentMethod("semanalmente", "",timeMethodWeekDay);
                        f.get(i).setPaymentDay(diaAtual.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));
                    } 
                }
            }
        }
        return 1;
    }

    public LocalDate getDiaAtual() {
        return diaAtual;
        
    }

    public void setDiaAtual(LocalDate diaAtual) {
        this.diaAtual = diaAtual;
    }
  
    
    
    @Override
    public void add(Funcionario p) {
        
        f.add(p);
    }

    @Override
    public int remover(String cpf) {
        for(int i = 0; i< f.size(); i++ ){
            if (f.get(i).getEmployeeID().equals(cpf)){   
                f.remove(i); 
                return i;
                } 
            }
        return -1;
        }

    @Override
    public String list() {
        String list= "";
        if (f.isEmpty()){
            return ("Não possui nenhum funcionario contratado");
        }else{
            for(int i = 0; i< f.size(); i++ ){
                    list += f.get(i).toString() + "\n************\n";
                }
            }
            return list;
        }

    @Override
    public String pesquisar(String cpf) {  
        for(int i = 0; i< f.size(); i++ ){
            if (f.get(i).getEmployeeID().equals(cpf)){
                return f.get(i).toString();
            }
        }
        return("Funcionario nao encontrado");
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
