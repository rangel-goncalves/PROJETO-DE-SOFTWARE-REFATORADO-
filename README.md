# PROJETO-DE-SOFTWARE-REFATORADO-
Implementação dos seguintes Command e  Move Accumulation to Collecting Parameter.
O padrão Command foi implementado para atualizar as antiga classe QuadrodeFuncionarios, que tinha como função identificar a qual classe filha o Funcionário pertencia e após isso invocava os métodos da classe AgendaPagamanto, que por sua vez possuia métodos  para calcular os contracheques de cada tipo de funcionário. No refatoramento a classe  AgendaPagamanto teve seus métodos  para calcular os contracheques remanejados para 4 outras novas classes (AgendaAssalariado,  AgendaComissionado, AgendaHorista e AgendaGeral) que separadamente geram os contracheques do seu respectivo grupo. Assim, no projeto atual essas 4 novas classes são invocadas fazendo o uso do polimorfismo no padrão command através de uma classe Invoker.

Método antigo da classe QuadrodeFuncionarios:

```java
    public String rodarAgenda(int grupo){
        String s ="";
        switch (grupo) {
            case 1 -> {
                for (Funcionario funcionario : f) {
                    s += ap.pagamentoSalariado(funcionario, diaAtual);
                }
            }
            case 2 -> {
                for (Funcionario funcionario : f) {
                    s += ap.pagamentoComissionado(funcionario, diaAtual);
                }
            }
            case 3 -> {
                for (Funcionario funcionario : f) {
                    s += ap.pagamentoHorista(funcionario, diaAtual);
                }
            }
            case 0 -> {
                for (Funcionario funcionario : f) {
                    s += ap.pagamentoGeral(funcionario, diaAtual);
                }
            }
            default -> {
            }
        }
        return s;
    }
  ```
Novo método refatorado:
```java
    public String rodarAgenda(String grupo){
        String s ="";
                for (Funcionario funcionario : f) {
                    s += invoker.invoker(grupo, diaAtual,funcionario);
                }
        return s;
    }
```
Classes enolvidas no projeto antes do refatoramento: 

[QuadrodeFuncionarios](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE/blob/main/ProjetoDeSoftware/src/projetodesoftware/QuadrodeFuncionarios.java)

[AgendaPagamento](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE/blob/main/ProjetoDeSoftware/src/projetodesoftware/AgendaPagamento.java)

Classes envolvidas após o refatoramento:

[QuadrodeFuncionarios](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/QuadrodeFuncionarios.java)

[AgendaPagamento](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/AgendaPagamento.java)

[AgendaAssalarioado](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/AgendaAssalariado.java)

[AgandaComissionado](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/AgendaComissionado.java)

[AgendaHorista](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/AgendaHorista.java)

[AgendaGeral](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/AgendaGeral.java)

[Command](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/Command.java)

[Invoker](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/Invoker.java)


 O padrão Move Accumulation to Collecting Parameter foi aplicado nas novas classes AgendaAssalariado,  AgendaComissionado, AgendaHorista e AgendaGeral, uma vez que as mesmas que possuíam o método GerarContraCheque, que também estava calculando os valores do contracheque dependendo da agenda do funcionário, então foi criado 3 novos métodos (calcularBiSemanal, calcularSemanal, calcularMensal) nas classes AgendaAssalariado, AgendaComissionado e AgendaHriosta que se encarregaram de calcular os valores do contracheque e as futuras datas dos próximos pagamentos, dependendo da agenda escolhida pelo funcionário.
 
 Classes envolvidas:
 
 [AgendaAssalarioado](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/AgendaAssalariado.java)

[AgandaComissionado](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/AgendaComissionado.java)

[AgendaHorista](https://github.com/rangel-goncalves/PROJETO-DE-SOFTWARE-REFATORADO-/blob/main/ProjetoDeSoftware_refatorado/src/projetodesoftware/AgendaHorista.java)
