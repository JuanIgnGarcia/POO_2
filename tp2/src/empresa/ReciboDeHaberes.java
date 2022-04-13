package empresa;

//------ ReciboDeHaberes

import java.time.LocalDate;
import java.util.ArrayList;

class ReciboDeHaberes {

    private String  nombreDeEmpleado;
    private int dir;
    private LocalDate fechaDeEmision;
    private int sueldoBruto;
    private int sueldoNeto;
    private ArrayList<DetalleSueldo> desgloceDeConseptos;


    public void llenar(String nom, int dirr, LocalDate fecha, int bruto, int neto, ArrayList<DetalleSueldo> conspetos){
        this.nombreDeEmpleado(nom);
        this.dir(dirr);
        this.fechaDeEmision(fecha);
        this.sueldoBruto(bruto);
        this.sueldoNeto(neto);
        this.desgloceDeConseptos(conspetos);
    }

    public String getNombreDeEmpleado() {
        return nombreDeEmpleado;
    }

    public int getDir() {
        return dir;
    }

    public LocalDate fechaDeEmision() {
        return fechaDeEmision;
    }

    public int sueldoBruto() {
        return sueldoBruto;
    }

    public int sueldoNeto() {
        return sueldoNeto;
    }

    public ArrayList<DetalleSueldo> desgloceDeConseptos() {
        return desgloceDeConseptos;
    }

    public void nombreDeEmpleado(String nom){
        nombreDeEmpleado = nom;
    }

    public void dir(int dirr){
        dir = dirr;
    }

    public void fechaDeEmision(LocalDate fecha){
        fechaDeEmision = fecha;
    }

    public void sueldoBruto(int bruto){
        sueldoBruto = bruto;
    }

    public void sueldoNeto(int neto){
        sueldoNeto = neto;
    }

    public void desgloceDeConseptos(ArrayList<DetalleSueldo> conspetos){
        desgloceDeConseptos = conspetos;
    }
}