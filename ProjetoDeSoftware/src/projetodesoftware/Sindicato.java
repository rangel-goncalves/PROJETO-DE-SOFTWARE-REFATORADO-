/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.time.LocalDate;

/**
 *
 * @author Rangel
 */
public class Sindicato {
    
    private boolean Syndicate=false;
    private String syndicateId="";
    private float feeServices=0;
    private float unionFee=0;
    private String historico = "";
    public void NewFeeServices(float value, LocalDate l){
        //this.feeServices += value;
        if(this.Syndicate == true){
          this.feeServices += value;
          if(value<0){
              this.historico +="pagamento de taxas: "+value + " Dia: " + l+"\n";
          }else{
              this.historico +=value + " Dia: " + l+"\n";
          }
          
        }
    }
    
    public float TotalFeeServices(){
        return this.feeServices;
    }

    public String getHistorico(){
        return this.historico;
    }
    
    public String getSyndicateId() {
        return this.syndicateId;
    }

    public void setSyndicateId(String syndicateId) {
        this.syndicateId = syndicateId;
    }

    public float getUnionFee() {
        return this.unionFee;
    }

    public void setUnionFee(float unionFee) {
        this.unionFee = unionFee;
        if(this.Syndicate == false){
            this.unionFee = 0;
        }
    }

    public boolean isSyndicate() {
        return this.Syndicate;
    }

    public void setSyndicate(boolean Syndicate) {
        this.Syndicate = Syndicate;
    }
    
    
    
}
