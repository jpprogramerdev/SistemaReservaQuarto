package sistemahotel;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Hospede {
    String nomeHospede;
    String dtNascimento;
    String CPF;
    String dtReserva;
    String dtEntrada;
    String dtSaida;
    private static ArrayList <Hospede> listHospedeResgister = new ArrayList<>();

    static void exibirHospedes(){
        int i = 1;
        if(Hospede.listHospedeResgister.size() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum hospede cadastrado", "SEM HOSPEDES", 0);
        }else{
            String mensagem = "Lista de hospedes\n\n";
            for (Hospede hospede : listHospedeResgister) {
                mensagem +=  i + ": " + "Nome: " + hospede.nomeHospede + "\nData de nascimento: " + hospede.dtNascimento + "\nCPF: " + hospede.CPF +"\n\n";
                i++;
            }
            JOptionPane.showMessageDialog(null, mensagem);
        }
    }
    void addHospede(String nomeHospede, String dtNascimento, String CPF){
        Hospede novoHospede = new Hospede();
        novoHospede.nomeHospede = nomeHospede;
        novoHospede.CPF = CPF;
        novoHospede .dtNascimento = dtNascimento;
        listHospedeResgister.add(novoHospede);
    }

    void setReserva(String nomeHospede, String dtNascimento, String CPF, String dtReserva, String dtEntrada, String dtSaida){
        this.nomeHospede = nomeHospede;
        this.dtNascimento = dtNascimento;
        this.CPF = CPF;
        this.dtReserva = dtReserva;
        this.dtEntrada = dtEntrada;
        this.dtSaida = dtSaida;
        Quartos.addHospede(this);
        addHospede(nomeHospede, dtNascimento, CPF);
    }
}