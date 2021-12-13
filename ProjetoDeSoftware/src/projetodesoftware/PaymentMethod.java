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
public class PaymentMethod {
    public String method;
    public String timeMethod;
    public String timeMethodWeekDay;
    
    
    public String getDetails(){
        return method+" "+timeMethod+" "+timeMethodWeekDay;
    }
}
