package empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

class Empresa {
  private String nombre;
  private int cuil;
  private ArrayList<Empleado> empleados = new  ArrayList<Empleado>();

    public Empresa(String nombre, int cuil, ArrayList<Empleado> empleados) {
        this.nombre = nombre;
        this.cuil = cuil;
        this.empleados = empleados;
    }

    public int montoTotalDeSueldoNeto(){
        int montoTotal = 0;
        for(int i=0; i < empleados.size() ;i++){
            montoTotal = montoTotal + empleados.get(i).sueldoNeto();
        }
        return montoTotal;
    }

    public int montoTotalDeSueldoBrutp(){
        int montoTotal = 0;
        for(int i=0; i < empleados.size() ;i++){
            montoTotal = montoTotal + empleados.get(i).sueldoBruto();
        }
        return montoTotal;
    }

    public int montoTotalRetencion(){
        var retencion = 0;
        for(int i=0; i < empleados.size() ;i++){
            retencion = retencion + empleados.get(i).retenciones();
        }
        return retencion;
    }

    public void liquiedacionDeSueldo(){
        for(int i=0; i < empleados.size() ;i++){
           empleados.get(i).hacerReciboDeHberes(LocalDate.now());
        }
    }

}









