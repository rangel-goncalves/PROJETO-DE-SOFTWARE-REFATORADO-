/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 *
 * @author Rangel
 */
public class Hourly extends Funcionario{
    
    public Workedhours[] workedhours = new Workedhours[31];

    public Hourly() {
        startWorkedhours();
    }

    public Hourly(String name, String employeeID) {
        super(name, employeeID, "", "Hourly", "semanalmente");
        startWorkedhours();
    }

    public Hourly(String name, String employeeID, float salary) {
        super(name, employeeID, "", "Hourly", "semanalmente", salary);
        //workedhours[0].chegada = 0;
        startWorkedhours();
    }

    public Hourly(String name, String employeeID, String address) {
        super(name, employeeID, address, "Hourly", "semanalmente");
        startWorkedhours();
    }

    public Hourly(String name, String employeeID, String address, float salary) {
        super(name, employeeID, address, "Hourly", "semanalmente", salary);
        startWorkedhours();
    }

    public Hourly(String name, String employeeID, String address, String paymentMethod) {
        super(name, employeeID, address, "Hourly", paymentMethod);
        startWorkedhours();
    }

    public Hourly(String name, String employeeID, String address, String paymentMethod, float salary) {
        super(name, employeeID, address, "Hourly", paymentMethod, salary);
        startWorkedhours();
    }

    public Hourly(String name, String employeeID, String address, boolean Syndicate, String paymentMethod, float salary) {
        super(name, employeeID, address, "Hourly", Syndicate, paymentMethod, salary);
        startWorkedhours();
    }

    public float getWorkedhours() {
        int total=0;
        for (Workedhours workedhour : workedhours) {
            total += workedhour.Total();
        }
        return total;
    }
    public float getExtraHours() {
        int total=0;
        for (Workedhours workedhour : workedhours) {
            total += workedhour.getExtra();
        }
        return total;
    }

    public void setWorkedhours(int chegada,int saida, int dia ) {
        this.workedhours[dia-1].setChegada(chegada);
        this.workedhours[dia-1].setSaida(saida);
        if((saida - chegada)>8){
            this.workedhours[dia-1].setExtra((saida - chegada)- 8);
        }
 
    }
    
    public void setWorkedhours(LocalDateTime chegada,LocalDateTime saida ) {
        this.workedhours[chegada.getDayOfMonth()-1].setChegada(chegada.getHour());
        this.workedhours[chegada.getDayOfMonth()-1].setSaida(saida.getHour());    
    }
    public void FillWorkedhours(){
        
        for(int i = 0; i <31; i++){
            this.workedhours[i].setChegada(0);
            this.workedhours[i].setSaida(0);
            this.workedhours[i].setExtra(0);
        }
        
    }
    
    public void startWorkedhours(){
        for (int i = 0 ; i < 31 ; i++){
            this.workedhours[i] = new Workedhours();
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nHourly{" + "workedhours: " + this.getWorkedhours() +" +Horas extras:" +this.getExtraHours()
                +  '}';
    }

   
}
