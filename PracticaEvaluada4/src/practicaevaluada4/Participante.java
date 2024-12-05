package practicaevaluada4;

import java.util.Random;
import javax.swing.JOptionPane;

public class Participante {

    private String nombre;
    private int edad;
    private int numCorredor = 0;
    private double tiempoEst;
    private int tiempoReal;
    private String categoria;
    private Participante maraton[] = new Participante[30];

    //Contador que usamos para la cantidad de participantes que vamos a registrar
    private int contador;

    public Participante() {
    }

    public Participante(String nombre, int edad, double tiempoEst, int tiempoReal, String categoria, int NumeroCorredor) {
        this.nombre = nombre;
        this.edad = edad;
        this.tiempoEst = tiempoEst;
        this.tiempoReal = tiempoReal;
        this.categoria = categoria;
        this.numCorredor = NumeroCorredor;
    }

    public void buscarCorredor() {
        String mensaje = "";
        int num = Integer.parseInt(JOptionPane.showInputDialog("Cual el numero que desea buscar"));
        for (int i = 0; i < contador; i++) {
            if (num == maraton[i].getNumCorredor()) {
                mensaje = "El corredor " + maraton[i].getNombre() + " Fue encontrado";
                break;
            } else {
                mensaje = "El corredor no fue encontrado";

            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    //Registrar participante
    public Participante RegistrarParticipantes() {
        setNombre(JOptionPane.showInputDialog("Cual es el nombre del participante:"));
        setEdad(Integer.parseInt(JOptionPane.showInputDialog("Cual es la edad del participante: ")));
        setTiempoEst(Double.parseDouble(JOptionPane.showInputDialog("Cual es el tiempo estimando para completar")));
        setCategoria();
        setTiempoReal();
        setNumCorredor(1);
        Participante participante = new Participante(nombre, edad, tiempoEst, tiempoReal, categoria, numCorredor);

        return participante;
    }

    public void buscarCategoria() {
        String mensaje = "";
        String categoria = JOptionPane.showInputDialog("Cual es la categoria a buscar" + "\nJuvenil o Adulto o Master");
        for (int i = 0; i < contador; i++) {
            if (maraton[i].getCategoria().toUpperCase().equals(categoria.toUpperCase())) {
                mensaje += "Corrador: " + maraton[i].getNombre() + "Numero de corredor: " + maraton[i].getNumCorredor();
            }
            JOptionPane.showMessageDialog(null, mensaje);

        }
    }

    public void eliminarCorredor() {
        String mensaje = "";
        int posicionEncont = 0;
        int numeroBorrar = Integer.parseInt(JOptionPane.showInputDialog("Cual es el numero del participante que quiere borrar"));
        for (int i = 0; i < contador; i++) {
            if (numeroBorrar == maraton[i].getNumCorredor()) {
                maraton[i] = null;
                mensaje = "Borrado";
                posicionEncont = i;
                break;
            } else {
                mensaje = "No encontrado";
            }
            JOptionPane.showMessageDialog(null, mensaje);

        }
        //Movemos las reservaciones a la izquerda movemos la null al final
        for (int i = posicionEncont; i < contador - 1; i++) {
            maraton[i] = maraton[i + 1];
        }
        //Borramos la reservacion y tmb reducimos cantidad de reservaciones 
        maraton[contador - 1] = null;
        contador--;
    }

    public void RegistrarMaraton() {
        boolean bandera = true;
        this.contador += Integer.parseInt(JOptionPane.showInputDialog("Cuantos participantes va a registrar"));
        for (int i = 0; i < contador; i++) {
            maraton[i] = RegistrarParticipantes();

        }
    }

    public void mostrarParticipantes() {
        String mensaje = "";
        for (int i = 0; i < contador; i++) {
            mensaje += "El participante: " + maraton[i].getNombre() + " Con el numero " + maraton[i].getNumCorredor() + " En la categoria de " + maraton[i].getCategoria() + ""+" El tiempo estimaod a completar es de "
                    + maraton[i].getTiempoEst()+"\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCategoria() {

        return categoria;
    }

    public void setCategoria() {
        if (this.edad <= 18) {
            this.categoria = "Juvenil";
        }
        if (this.edad > 18 && this.edad < 40) {
            this.categoria = "Adulto";
        }
        if (this.edad >= 40) {
            this.categoria = "Master";
        }

    }

    public int getTiempoReal() {
        return tiempoReal;
    }

    //Agregar para que sean minutos random
    public void setTiempoReal() {
        String hour = "";
        Random aleatorio = new Random();
        int min = aleatorio.nextInt(2, 20);
        this.tiempoReal = min;

    }

    public int getNumCorredor() {
        return numCorredor;
    }

    public void setNumCorredor(int numCorredor) {

        this.numCorredor +=1+numCorredor;
    }

    public double getTiempoEst() {
        return tiempoEst;
    }

    public void setTiempoEst(double tiempoEst) {
        this.tiempoEst = tiempoEst;
    }

}
