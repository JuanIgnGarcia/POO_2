package empresa;

import java.time.LocalDate;
import java.util.ArrayList;


abstract class Empleado {
    private String nombre;
    private int dirrecion;
    private EstadoCivil estadoCivil;
    private LocalDate fechaDeNacimiento;
    private ReciboDeHaberes recivoDeHaberes;
    private int sueldoBase;

    public Empleado(String nombre, int dirrecion, EstadoCivil estadoCivil, LocalDate fechaDeNacimiento, ReciboDeHaberes recivoDeHaberes, int sueldoBase) {
        this.nombre = nombre;
        this.dirrecion = dirrecion;
        this.estadoCivil = estadoCivil;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.recivoDeHaberes = recivoDeHaberes;
        this.sueldoBase = sueldoBase;
    }

    public int edad(){
        return  LocalDate.now().getYear() - fechaDeNacimiento.getYear();
    }

    public int sueldoBruto(){
        return sueldoBase;
    }

    public int retenciones(){
        return this.rentPorObraSocial();
    }

    public int sueldoNeto(){
        return this.sueldoBruto() - this.retenciones();
    }

    public int rentPorObraSocial(){
        return  this.sueldoBruto() / 10;
    }

    public void hacerReciboDeHberes(LocalDate fechaDeEmision){
        recivoDeHaberes.llenar(nombre,dirrecion,fechaDeEmision,this.sueldoBruto(),this.sueldoNeto(),this.modificacionesAlBruto());
    }

    public EstadoCivil estadoCivil(){
        return estadoCivil;
    }

    public ReciboDeHaberes reciboDeHaberes(){return  recivoDeHaberes;}

    public abstract ArrayList<DetalleSueldo> modificacionesAlBruto();
}






