package empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

class EmpleadoPlantaTemporaria extends Empleado {
    private int  cantHorasExtras;
    private LocalDate fechaDeFinDeAsignacion;

    public EmpleadoPlantaTemporaria(String nombre, int dirrecion, EstadoCivil estadoCivil, LocalDate fechaDeNacimiento, ReciboDeHaberes recivoDeHaberes, int sueldoBase, int cantHorasExtras, LocalDate fechaDeFinDeAsignacion) {
        super(nombre, dirrecion, estadoCivil, fechaDeNacimiento, recivoDeHaberes, sueldoBase);
        this.cantHorasExtras = cantHorasExtras;
        this.fechaDeFinDeAsignacion = fechaDeFinDeAsignacion;
    }

    @Override
    public int sueldoBruto(){
        return super.sueldoBruto() +
                this.bonificacionPorHora() * cantHorasExtras;
    }

    public int bonificacionPorHora(){
        return 40;
    }

    public int  retenciones(){
        return  super.retenciones()      +
                this.rentPorEdad()       +
                this.rentPorJubilacion() +
                this.rentPorHora();
    }

    public int rentPorHora(){
        return cantHorasExtras * 5;
    }

    public int rentPorEdad(){
        if(this.edad() > 50){
            return 25;
        }else{
            return 0;
        }
    }

    public int rentPorJubilacion(){
        return this.sueldoBruto() / 10;
    }

    @Override
    public ArrayList<DetalleSueldo> modificacionesAlBruto(){
        var modificanciones = new ArrayList<DetalleSueldo>();

        var bonificacionPorHorasExtras = new DetalleSueldo("bonificacionPorHorasExtras",this.bonificacionPorHora() * cantHorasExtras);
        var rentPorEdad = new DetalleSueldo("rentPorEdad",this.rentPorEdad() );
        var rentPorJubilacion = new DetalleSueldo("rentPorJubilacion",this.rentPorJubilacion());

        modificanciones.add(bonificacionPorHorasExtras);
        modificanciones.add(rentPorEdad);
        modificanciones.add(rentPorJubilacion);

        return modificanciones;
    }
}