package sistemahotel;

import javax.swing.JOptionPane;

class Menu {
    static int opcao;
    
    static void exebirMenu() {

        opcao = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Digite a opção\n\n1 - Mostrar quartos\n2 - Fazer reserva\n3 - Exibir reservas\n4 - Exibir hospedes\n5 - Sair"));
    
        switch (opcao) {
            case 1:
                Quartos.exibirQuartos(Menu.class);
                break;
            case 2:
                Reserva newReserva = new Reserva();
                newReserva.efetuarReserva();
                break;
            case 3:
                Quartos.exibirHospede();
                break;
            case 4:
                Hospede.exibirHospedes();
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Saindo do sistema", "Sistema de reserva", 1);break;
            default:
                JOptionPane.showMessageDialog(null, "Opção invalida, digite uma nova opção", "[ERROR]", 0);

        }
    }
}
