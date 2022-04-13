package empresa;

import java.time.LocalDate;
import java.util.ArrayList;

class EmpleadoPlantaPermanente extends  Empleado {
    private int cantidadDeHijos;
    private int antiguedad;


    public EmpleadoPlantaPermanente(String nombre, int dirrecion, EstadoCivil estadoCivil, LocalDate fechaDeNacimiento, ReciboDeHaberes recivoDeHaberes, int sueldoBase, int cantidadDeHijos, int antiguedad) {
        super(nombre, dirrecion, estadoCivil, fechaDeNacimiento, recivoDeHaberes, sueldoBase);
        this.cantidadDeHijos = cantidadDeHijos;
        this.antiguedad = antiguedad;
    }

    @Override
    public int sueldoBruto(){
        return  super.sueldoBruto()                +
                this.asignacionPorHijo()           +
                this.estadoCivil().asignacionPorConyuge() +
                this.bonoAntiguedad() ;
    }

    public int asignacionPorHijo(){
        return cantidadDeHijos * 150;
    }

    public int bonoAntiguedad(){
        return 50 * antiguedad;
    }

    @Override
    public int retenciones(){
        return  super.retenciones()      +
                this.rentPorHijo()       +
                this.rentPorJubilacion();
    }

    public int rentPorHijo(){
        return 50 * cantidadDeHijos;
    }


    public int rentPorJubilacion(){
        return  (this.sueldoBruto() * 15 )/ 100;
    }
    @Override
    public ArrayList<DetalleSueldo> modificacionesAlBruto(){
        var modificanciones = new ArrayList<DetalleSueldo>() ;

        var detAsignacion = new DetalleSueldo("asignacionPorHijo",this.asignacionPorHijo());
        var asignacionPorConyuge = new DetalleSueldo("asignacionPorConyuge",this.estadoCivil().asignacionPorConyuge());
        var bonoAntiguedad = new DetalleSueldo("bonoAntiguedad",this.bonoAntiguedad());

        var rentPorHijo = new DetalleSueldo("rentPorHijo",-this.rentPorHijo());
        var rentPorJubilacion = new DetalleSueldo("rentPorJubilacion" ,-this.rentPorJubilacion());
        var rentPorObraSocial = new DetalleSueldo("rentPorObraSocial",- this.rentPorObraSocial());


        modificanciones.add(detAsignacion);
        modificanciones.add(asignacionPorConyuge);
        modificanciones.add(bonoAntiguedad);
        modificanciones.add(rentPorHijo);
        modificanciones.add(rentPorJubilacion);
        modificanciones.add(rentPorObraSocial);

        return modificanciones;
    }
}