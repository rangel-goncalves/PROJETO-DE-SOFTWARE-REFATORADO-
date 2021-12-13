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
    public int chegada ;
    public int saida;
    public boolean trabalhei=true;

    public int Total(){
        return saida - chegada;
    }
}
