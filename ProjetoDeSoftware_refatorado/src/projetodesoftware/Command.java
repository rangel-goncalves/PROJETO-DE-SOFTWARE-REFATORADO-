package projetodesoftware;

import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Rangel
 */
public interface Command {
    
    public String execute(Funcionario p, LocalDate cur);
}
