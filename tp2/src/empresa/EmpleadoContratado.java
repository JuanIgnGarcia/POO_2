package empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

class EmpleadoContratado extends Empleado {
    private int numeroDeContrato;
    private MedioDePago medioDePago;

    public EmpleadoContratado(String nombre, int dirrecion, EstadoCivil estadoCivil, LocalDate fechaDeNacimiento, ReciboDeHaberes recivoDeHaberes, int sueldoBase, int numeroDeContrato, MedioDePago medioDePago) {
        super(nombre, dirrecion, estadoCivil, fechaDeNacimiento, recivoDeHaberes, sueldoBase);
        this.numeroDeContrato = numeroDeContrato;
        this.medioDePago = medioDePago;
    }

    @Override
    public int sueldoNeto() {
        return this.sueldoBruto() - this.retenciones();
    }

    @Override
    public int retenciones() {
        return this.gastosAdmistrativos();
    }

    public int gastosAdmistrativos() {
        return 50;
    }

    @Override
    public ArrayList<DetalleSueldo> modificacionesAlBruto() {
        var modificanciones = new ArrayList<DetalleSueldo>();

        var gastosAdmistrativos = new DetalleSueldo("gastosAdmistrativos", this.gastosAdmistrativos());

        modificanciones.add(gastosAdmistrativos);

        return modificanciones;
    }

    public int getNumeroDeContrato() {
        return numeroDeContrato;
    }

    public void setNumeroDeContrato(int numeroDeContrato) {
        this.numeroDeContrato = numeroDeContrato;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }
}