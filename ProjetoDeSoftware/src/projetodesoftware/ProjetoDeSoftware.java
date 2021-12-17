/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodesoftware;

import View.AdminMain;
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
        AdminMain mainMenu =  new AdminMain();
        mainMenu.setVisible(true);
    }
    
}
