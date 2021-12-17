/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

/**
 *
 * @author Rangel
 */
public class Workedhours {
    private int chegada=0;
    private int saida=0;
    private int extra=0;

    public int getChegada() {
        return chegada;
    }

    public void setChegada(int chegada) {
        this.chegada = chegada;
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }
 
    public int Total(){
        /*if((this.saida - this.chegada)>8){
            this.extra = (this.saida - this.chegada) - 8;
        }*/
        return this.saida - this.chegada - this.extra;
    }
}
