package empresa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

class EmpresaTest {

    Empresa empre;
    ArrayList<Empleado> empleados;

    EmpleadoPlantaPermanente pedro;
    EmpleadoPlantaTemporaria marcos;

    Casado casado;
    Soltero soltero;

    MedioDePago medioDePago;

    ReciboDeHaberes reciboPedro;
    ReciboDeHaberes reciboMarcos;
    EmpleadoContratado fernando;


        @BeforeEach
    public void setUp(){

        casado = new Casado();
        soltero = new Soltero();

        medioDePago = new Cheque();

        reciboPedro = new ReciboDeHaberes();
        reciboMarcos = new ReciboDeHaberes();

        LocalDate fechaPedro = LocalDate.of(2002,10,10);
        LocalDate fechaMarcos = LocalDate.of(1990,10,10);
        LocalDate fechaAsig  = LocalDate.of(2025,10,10);

        pedro = new EmpleadoPlantaPermanente("Pedro",852,casado,fechaPedro,reciboPedro,5000,0,10);
        marcos = new EmpleadoPlantaTemporaria("Marcos",741,soltero,fechaMarcos,reciboMarcos,2500,10,fechaAsig);
        fernando = new EmpleadoContratado("Fernando",852,casado,fechaPedro,reciboPedro,5000,123,medioDePago);


        empleados = new ArrayList<>();
        empleados.add(pedro);
        empleados.add(marcos);

        empre = new Empresa("Empresa_Robert",454784,empleados);
    }


    @Test
    void testMontoSueldoBrutoPedro() {
        assertEquals(5600,pedro.sueldoBruto());
    }

    @Test
    void testMontoSueldoRetencionPedro() {
        assertEquals(1400,pedro.retenciones());
    }

    @Test
    void testMontoSueldoNetoPedro() {
        assertEquals(4200,pedro.sueldoNeto());
    }

/// Test Marcos
    @Test
    void testMontoSueldoBrutoMarcos() {
        assertEquals(2900,marcos.sueldoBruto());
    }

    @Test
    void testMontoSueldoRetencionMarcos() {
        assertEquals(630,marcos.retenciones());
    }

    @Test
    void testMontoSueldoNetoMarcos() {
        assertEquals(2270,marcos.sueldoNeto());
    }

/// Test fernando

    @Test
    void testMontoSueldoBrutoFernando() {
        assertEquals(5000,fernando.sueldoBruto());
    }

    @Test
    void testMontoSueldoRetencionFernando() {
        assertEquals(50,fernando.retenciones());
    }

    @Test
    void testMontoSueldoNetoFernando() {
        assertEquals(4950, fernando.sueldoNeto());
    }

        ///Empresa
    @Test
    void testMontoTotalDeSueldoNeto() {
       assertEquals(6470,empre.montoTotalDeSueldoNeto());  // marcos + pedro = 6470    y   marcos + pedro + fernando = 11420
    }

    @Test
    void liquiedacionDeSueldo() {
        assertEquals(reciboPedro,pedro.reciboDeHaberes()); //Antes del cambio
        empre.liquiedacionDeSueldo();                      //cambio
        assertEquals(reciboPedro.sueldoBruto(),pedro.reciboDeHaberes().sueldoBruto()); //Despues del cambio
        assertEquals(6,pedro.reciboDeHaberes().desgloceDeConseptos().size());
    }
}