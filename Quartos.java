package sistemahotel;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Quartos {
    int numMaxHospede;
    int[] qtdCama;
    boolean frigobar;
    boolean tv;
    boolean sacada;
    boolean banheiro;
    double valorQuarto;
    ArrayList<Hospede> listHospedes;

    // atributos statico
    static int idQuarto = 0;
    static ArrayList<Quartos> quartosList = new ArrayList<Quartos>();

    public Quartos(int maxHospede, int[] cama, boolean frigobar, boolean tv, boolean sacada, boolean banheiro,
            double valor) {
        this.numMaxHospede = maxHospede;
        this.qtdCama = cama;
        this.frigobar = frigobar;
        this.tv = tv;
        this.sacada = sacada;
        this.banheiro = banheiro;
        this.valorQuarto = valor;
        listHospedes = new ArrayList<Hospede>();
        quartosList.add(this);
    }

    static int exibirQuartos(Class chamada) {
        String mensagem = "";
        if (quartosList.size() == 0) {
            Quartos qrt1 = new Quartos(5, new int[] { 2, 1, 0, 0 }, true, false, false, true, 150.00);
            Quartos qrt2 = new Quartos(4, new int[] { 1, 1, 1, 0 }, true, true, true, true, 200.00);
            Quartos qrt3 = new Quartos(3, new int[] { 0, 0, 1, 1 }, false, true, false, true, 100.00);
        }
        if (chamada == Reserva.class) {
            mensagem = "Digite o numero do quarto que deseja alugar\n\n";
            idQuarto = Integer.parseInt(JOptionPane.showInputDialog(null, gerarMsg(mensagem)));
            do {
                if (idQuarto >= quartosList.size()) {
                    if (podeAddHospede(Quartos.class) == false) {
                        JOptionPane.showMessageDialog(null, "Limite de hospedes atingido", "[ERRO]", 0);
                    } else {
                        mensagem = "Quarto invalido, digite novamento o quarto";
                        idQuarto = Integer.parseInt(JOptionPane.showInputDialog(null, gerarMsg(mensagem)));
                    }
                }
            } while (idQuarto >= quartosList.size());
        } else if (chamada == Menu.class) {
            mensagem = "Quartos disponiveis\n\n";
            JOptionPane.showMessageDialog(null, gerarMsg(mensagem));
        }
        return idQuarto;
    }

    static boolean podeAddHospede(Class chamada) {
        if(chamada == Quartos.class){
            Quartos quarto = quartosList.get(idQuarto - 1);
            if (quarto.listHospedes.size() == quarto.numMaxHospede) {
                return false;
            }
        }else if(chamada == Reserva.class){
            Quartos quarto = quartosList.get(Reserva.quartoId - 1);
            if (quarto.listHospedes.size() == quarto.numMaxHospede) {
                return false;
            }
        }
        return true;
    }

    static String gerarMsg(String mensagem) {
        int i = 1;
        for (Quartos q : quartosList) {
            mensagem += i + ":\n" + "Numero maximo de hospede: " + q.numMaxHospede
                    + "\nQuantidade de camas de solteiro: " + q.qtdCama[0] + "\nQuantidade de camas de casal: "
                    + q.qtdCama[1] + "\nQuantidade de camas queen: " + q.qtdCama[2] + "\nQuantidade camas king: "
                    + q.qtdCama[3] + "\nTem frigobar: " + (q.frigobar ? "Sim\n" : "Não\n") + "Numero de hospede: " + q.listHospedes.size() + "\n\n";
            i++;
        }
        return mensagem;
    }

    static void addHospede(Hospede hospede) {
        Quartos quarto = quartosList.get(idQuarto - 1);
        quarto.listHospedes.add(hospede);
    }

    static void exibirHospede() {
        String mensagem = "Digite o número do quarto que deseja verificar os hóspedes registrados\n\n";
        idQuarto = Integer.parseInt(JOptionPane.showInputDialog(null, gerarMsg(mensagem)));
        Quartos quarto = quartosList.get(idQuarto - 1);
        String listaHospedes = "Hóspedes registrados no quarto " + idQuarto + ":\n\n";
        int i = 1;
        for (Hospede hospede : quarto.listHospedes) {
            listaHospedes += i + ": " + "Nome: " + hospede.nomeHospede + "\nData de nascimento: " + hospede.dtNascimento
                    + "\nCPF: " + hospede.CPF + "\nData da reserva:" + hospede.dtReserva + "\nData de entrada"
                    + hospede.dtEntrada + "\nData de saida:" + hospede.dtSaida +"\n\n";
            i++;
        }
        JOptionPane.showMessageDialog(null, listaHospedes);
    }

}