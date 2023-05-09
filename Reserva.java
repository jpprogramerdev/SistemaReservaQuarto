package sistemahotel;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import java.util.ArrayList;

class Reserva {
    LocalDate localDate = LocalDate.now();
    String nome;
    String CPF;
    String data_nascimento;
    String dataEntrada;
    String dataSaida;
    //manipulando os dias om o localDate
    String dataReserva = localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear();

    static int quartoId;
    void efetuarReserva(){
        
        int opcao = 0;
        do{
            quartoId = Quartos.exibirQuartos(Reserva.class);
            if(Quartos.podeAddHospede(Reserva.class) == false){
                JOptionPane.showMessageDialog(null, "Limite de hospedes atingido", "[ERROR]", 0);
            }else{
                opcao = JOptionPane.showConfirmDialog(null, "O quarto escolhido foi o " + quartoId + "\n\n Está correto?");
                    
                if (opcao == JOptionPane.YES_OPTION) {
                    Hospede novoHospede = new Hospede();
                    nome = JOptionPane.showInputDialog(null, "Digite o nome completo");
                    CPF = JOptionPane.showInputDialog(null, "Digite o CPF");
                    data_nascimento = JOptionPane.showInputDialog(null, "Digite a data de nascimento (dd/mm/ano)");
                    dataEntrada = JOptionPane.showInputDialog(null, "Digite a data de entrada (dd/mm/ano)");
                    dataSaida = JOptionPane.showInputDialog(null, "Digite a data de saida (dd/mm/ano)");
                    novoHospede.setReserva(nome, data_nascimento, CPF, dataReserva, dataEntrada, dataSaida);
                } else if (opcao == JOptionPane.NO_OPTION) {
                        quartoId = 0;
                } else if (opcao == JOptionPane.CANCEL_OPTION || opcao == JOptionPane.CLOSED_OPTION) {
                    Menu.exebirMenu();
                }
            }
        }while(opcao == JOptionPane.NO_OPTION) ;
    }
        
}
