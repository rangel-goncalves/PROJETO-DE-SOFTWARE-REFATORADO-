/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import java.util.ArrayList;

/**
 *
 * @author Rangel
 */
public class UndoRedo {
    
  /* public QuadrodeFuncionarios qpass;
   public QuadrodeFuncionarios qat;
   public QuadrodeFuncionarios qfut;

    public UndoRedo(QuadrodeFuncionarios qat) {
        this.qat = qat;
    }
    
    public QuadrodeFuncionarios redo(){
        if(qpass != null){
            qfut = qat;
            System.out.println("entreiredo");
            try{
            Funcionario p = new Funcionario();
        for (int i = 0 ; i< qpass.f.size();i++) {

               p = (Funcionario) qpass.f.get(i).clone();
            qat.f.add(p);
        }
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
            return qpass;
            
        }else{
            System.out.println("!traz");
            return qat;
        }
    }
    
    public QuadrodeFuncionarios undo(){
        if(qfut != null){
            qpass = qat;
            return qfut;
        }else{
            System.out.println("!frente");
            return qat;
        }
    }
    public void att(QuadrodeFuncionarios Nqat){
        qpass = new QuadrodeFuncionarios(); //qat = Nqat;
        
        try{
            Funcionario p = new Funcionario();
        for (int i = 0 ; i< qat.f.size();i++) {
               p = (Funcionario) qat.f.get(i).clone();
               if (p instanceof Hourly){
                   ((Hourly) p).startWorkedhours();
                   for(int j = 0; j<30; j++){
                       ((Hourly) p).workedhours[j] = ((Hourly)qat.f.get(i)).workedhours[j];
                   }
               }
            qpass.f.add(p);
        }
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        System.out.println(((Hourly)qpass.f.get(2)).getWorkedhours());
        System.out.println(((Hourly)qat.f.get(2)).getWorkedhours());
    }*/
}
