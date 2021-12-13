/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class ProjetoDeSoftware {
    /*
    ***(feitoeu acho TESTE DENOVO)verificar se a agenda existe antes(quase feito, dando proplema no existeagenda com "mensal" e "mensalmente")
    ***concertar a undo
    *** (TA VERIFICADO MAS REFORÇA)ver se estar trocando a agenda direito(não esta funcionando a parte de verificar existencia)
    *** interfasse agenda de pagamento(ja me parece boa)
    *** undo undo undo carai
                      ***TEEEEEEEEEEESTARRRRRRRRRR ***
    
    */
    /*                      ARRUMADOS MAS SOB VIGILANCIA
    ***arrumar a cobrança das taxas de serviços pra gem não recebe mensalmente (ideia: por um bool taxalançada, se true cobra 
    na agenda de pagamento se false cobra 0(tentei arrumar com o local date em  pagamentoComissionado tem o comentario)
    ***criar uma função de lançar taxas no quadro de funcionarios
    *** na interface em edtemployee falta arrumar os metodos de pagamento
    */
    
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        Scanner inputdetails =  new Scanner(System.in);
        QuadrodeFuncionarios qf = new QuadrodeFuncionarios();
        Hourly h = new Hourly("rangel", "123", 20);
        Salaried s = new Salaried("felipe", "147", 1000);
        Commissioned c = new Commissioned(10, "bel", "159", 1000);
        qf.add(c);
        qf.add(h);
        qf.add(s);
        c.setSyndicate(true);
        c.setUnionFee(40);
        c.newTaxaServicoSindicato(100,LocalDate.now());
        h.setWorkedhours(8, 16, 1);
        c.setSales(1000);
        
        c.setPaymentDay(LocalDate.of(2021,12,10));
        h.setPaymentDay(LocalDate.of(2021,12,11));
        s.setPaymentDay(LocalDate.of(2021,12,12));
        System.out.println(qf.list());
        qf.setDiaAtual(LocalDate.of(2021,12,10));
        System.out.println(c.getPaymentDay());
        System.out.println(h.getPaymentDay());
        qf.rodarAgenda(0);
        System.out.println(c.getPaymentDay());
        System.out.println(h.getPaymentDay());
        qf.setDiaAtual(c.getPaymentDay());
        qf.rodarAgenda(0);
        System.out.println(c.getPaymentDay());
        System.out.println(qf.getDiaAtual());
        LocalDate l = LocalDate.parse("2000-01-01")
                ;
        LocalDateTime l1 = LocalDateTime.of(l, LocalTime.now());
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("Post-Truncate: " + l1.truncatedTo(ChronoUnit.SECONDS).format(dtf));
        
        System.out.println(l1);
        Vendas v = new Vendas(qf);
        String a = l.toString();
        System.out.println(c.getDetailsPayment());
        System.out.println(c.getPaymentDay());
        String o = "$";
        qf.AlterarAgandaFuncionario("159", "mensalmente", o, "");
        System.out.println(c.getDetailsPayment());
        System.out.println(c.getPaymentDay());
        LocalDate d1 = LocalDate.now().plusDays(1);
        LocalDate d2 = LocalDate.now().plusDays(2);
        LocalDate d3 = LocalDate.now().plusDays(3);
        ArrayList<Funcionario> al = new ArrayList();
        al.add(c);
        al.add(s);
        al.add(h);
        System.out.println(qf.f.toString());
        
        System.out.println(al.toString());
        /* String k = "2 segunda";
        System.out.println(k.length());
        Funcionario p2 = new Hourly("bel", "147", 20);
        LocalDate l = LocalDate.of(2021, 12, 10);
        LocalDate j = l;
        System.out.println(j);
        //j = j.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        j = j.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(j+ " aqui");
        //LocalDate l2 = l.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate l2 = l.withDayOfMonth(2); ////////// metodo bom para agenda
        for (int i = 1; i < 33; i++) {
            if(i<=l.lengthOfMonth())
            {
                LocalDate l3 = LocalDate.of(2021, 12, i);
                //System.out.println(l3);
            } else {
                //System.out.println("valor ultrapaca o limite de dias deste mes");
            }
        }
        System.out.println(l+ " " + l2);
        //p2.setPaymentMethod("Mensal", "7");
        //System.out.println(p2.getPaymentMethod());
        QuadrodeFuncionarios qf = new QuadrodeFuncionarios();
        System.out.println(qf.ap.ListAgendas());
        qf.ap.AddAgenda("semanal 2 segunda");
        System.out.println(qf.ap.ListAgendas());
        LocalDate l01 = LocalDate.of(2022, 1, 1);
        LocalDate l02 = LocalDate.of(2021, 12, 1);*///////////////////////////////////////////
        /*
                              codigoLIXO e codigoTESTE
        nem sempre o codigoTeste são lixo mas todos os coligoLixos foram testes
        */////////////////////////////////////
        /*LocalDate u = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(u);
        LocalDate l = LocalDate.of(2021, 12, 1);
        LocalDate l2 = LocalDate.of(2021, 12, 1);
        LocalDate l3 = LocalDate.of(2021, 12, 1);
        QuadrodeFuncionarios qf = new QuadrodeFuncionarios();
        //UndoRedo ur = new UndoRedo(qf); 
        Funcionario p = new Salaried("rangel", "123", 1000);
        p.setPaymentDay(l);
        Funcionario p1 = new Commissioned(10, "felipe", "159", 1000);
        p1.setPaymentDay(l2);
        Funcionario p2 = new Hourly("bel", "147", 20);
        p2.setPaymentDay(l3);
        ((Hourly)p2).setWorkedhours(7,15,1);
        ((Hourly)p2).setWorkedhours(7,15,2);
        ((Hourly)p2).setWorkedhours(7,15,3);
        ((Hourly)p2).setWorkedhours(7,15,4);
        ((Hourly)p2).setWorkedhours(7,15,5);
        qf.add(p);
        qf.add(p1);
        qf.add(p2);
        UndoRedo ur = new UndoRedo(qf);
        System.out.println(((Hourly)qf.f.get(2)).getWorkedhours());
        ur.att(qf);
        //System.out.println("pass: "+ur.qpass.list());
        //qf.f.get(2).setName("bezinha");
        qf.rodarAgenda(0);
        p2.setName("belzinha");
        //System.out.println(((Hourly)ur.qpass.f.get(2)).getWorkedhours());
        System.out.println(qf.list());
        System.out.println(ur.qpass.list());
        qf = ur.redo();
        //System.out.println(ur.qat.list());
        System.out.println("list" + qf.list());*/ //////////////////////////////////////
        /*LocalDate l = LocalDate.of(2021, 11, 27);
        LocalTime l1 = LocalTime.now();
        LocalTime l2 = LocalTime.of(1, 20);
       
        System.out.println(l1);
        System.out.println(l1.minusSeconds(l2.toSecondOfDay()));
        System.out.println(l1.minusSeconds(l2.toSecondOfDay()).plusSeconds(l2.toSecondOfDay()));
        l = l.plusDays(4);
        System.out.println(l);*/
        /////////////////////////////////////////////////////////////
       /* QuadrodeFuncionarios qf = new QuadrodeFuncionarios();
        LocalDate l = LocalDate.of(2021, 11, 29);
        LocalDate l2 = LocalDate.of(2021, 11, 29);
        LocalDate l3 = LocalDate.of(2021, 11, 29);
        Funcionario p = new Salaried("rangel", "123", 1000);
        p.setPaymentDay(l);
        Funcionario p1 = new Commissioned(10, "felipe", "159", 1000);
        p1.setPaymentDay(l2);
        Funcionario p2 = new Hourly("bel", "147", 20);
        p2.setPaymentDay(l3);*/
/////////////////////////////////////////////////////////////
        //(p2).workedhours[0].chegada = 1;
        /*((Hourly)p2).setWorkedhours(7,15,1);
        ((Hourly)p2).setWorkedhours(7,15,2);
        ((Hourly)p2).setWorkedhours(7,15,3);
        ((Hourly)p2).setWorkedhours(7,15,4);
        ((Hourly)p2).setWorkedhours(7,15,5);*/
        //////////////////////////////////
        /*System.out.println(((Hourly)p2).getWorkedhours());
        qf.add(p);
        qf.add(p1);
        qf.add(p2);
        Vendas v = new Vendas(qf);
        v.lancarVenda("159", 1100);
        qf.rodarAgenda(0);
        qf.setDiaAtual(l.plusDays(7));
        qf.setDiaAtual(l.plusDays(14));
        qf.rodarAgenda(0);
        
        LocalDateTime hora = LocalDateTime.now();
        System.out.println(hora.getHour());
        
        CartaoDePonto cp = new CartaoDePonto(qf);
        cp.lancarCartao("147", 7, 15,30);
        System.out.println(((Hourly)qf.f.get(2)).getWorkedhours());
        System.out.println(((Hourly)qf.f.get(2)).workedhours[29].Total());
        QuadrodeFuncionarios[] qar = new QuadrodeFuncionarios[2];
           qar[0]= new QuadrodeFuncionarios();
           qar[1]= new QuadrodeFuncionarios();*/
           //////////////////////////////////////////////////////
        //System.out.println(((Commissioned)qf.f.get(1)).getSales());
        //System.out.println(((Commissioned)p1).getSales());
        //System.out.println(((Commissioned)p1).getPaymentDay());
        //qf.rodarAgenda(0);
        //qf.setDiaAtual(l.plusDays(7));
        //qf.rodarAgenda(0);
        
        
        
        
        //v.lancarVenda("123", 1100);
        //System.out.println(((Commissioned)qf.f.get(0)).getSales());
       /*((Commissioned)p).getCommission();
       ((Commissioned)p).setCommission(10);
        System.out.println(p.getEmployeeID());
        p = p1;
        System.out.println(p.getEmployeeID());
        p = p2;
        System.out.println(((Commissioned)p).getCommission());
       ((Commissioned)k.f.get(0)).getCommission();*/
        
      /* ArrayList<ArrayList> k = new ArrayList<ArrayList>();
       k.add(new ArrayList<Salaried>());
       k.add(new ArrayList<Hourly>());
        
        //QuadrodeFuncionarios qf = new QuadrodeFuncionarios();
        ArrayList<Funcionario> p = new ArrayList();
        p.add(new Commissioned(1000, "felipe", "123"));
        p.add(new Funcionario("rangel","forene", "123", "comi"));
        System.out.println("*********************");
        System.out.println(p.get(0).toString()+"\n"+p.get(0).getClass());
        //System.out.println("*********************");
        //System.out.println(p.get(1).toString());
        if(p.get(0) instanceof Salaried){
                System.out.println(((Salaried) p.get(0)).getSalary());
            }
        p.set(0, p.get(1));
        System.out.println("*********************");
        System.out.println(p.get(0).toString()+"\n"+p.get(0).getClass());*/
        //System.out.println(p.get(0).getClass());   
        /*Funcionario t = new Salaried(1000, "felipe", "123");
        ArrayList<Funcionario> g = new ArrayList<Funcionario>();
        g.add(new Salaried(1000, "felipe", "123")); */
        /*while(true){
            System.out.println("""
                               MENU:
                               Adicionar funcionario(1)
                               Remover funcionario(2)
                               Lista de funcionario(3)
                               Pesquisar Funcionario(4)
                               Fechar programa(0)""");
            int opcao =  input.nextInt();
            switch(opcao){
                case 1 -> qf.add();
                case 2 -> qf.remover();
                case 3 -> qf.list();
                case 4 -> qf.pesquisar();
                case 5 -> qf.changeDetails();
                default -> {
                }
            }
            if (opcao == 0){
                break;
            }
            
        }*/
    }
    
}
