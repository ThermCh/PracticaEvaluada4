package practicaevaluada4;

import javax.swing.JOptionPane;

public class PracticaEvaluada4 {

    public static void main(String[] args) {
        Participante parti = new Participante();
        boolean ciclo = true;

        while (ciclo) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Que desea hacer\n" + "1.Registrar participante\n" + "2.Buscar Participante\n" + "3.Buscar por categoria\n"
                    + "4.Eliminar participante\n" + "5.Mostar todos los participantes\n6.Salir"));

            switch (opcion) {
                case 1:
                    parti.RegistrarMaraton();
                    parti.mostrarParticipantes();
                    break;
                case 2:
                    parti.buscarCorredor();
                    break;
                case 3:
                    parti.buscarCategoria();
                    break;
                case 4:
                    parti.eliminarCorredor();
                    break;
                case 5:
                    parti.mostrarParticipantes();
                    break;
                case 6:
                    ciclo = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
            }

        }
    }
}
