package parcial1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservacion {
    private Cliente cliente;
    private Habitacion habitacion;
    private Paquete paquete;
    private double totalNoche;
    private int dias;
    private double total;
    private Date diaReservacion;
    private String estado;

    public Reservacion(Cliente cliente, Habitacion habitacion, Paquete paquete, int dias, double total, Date diaReservacion, String estado, double totalNoche) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.paquete = paquete;
        this.totalNoche = totalNoche;
        this.dias = dias;
        this.total = total;
        this.diaReservacion = diaReservacion;
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public double getTotalNoche() {
        return totalNoche;
    }

    public void setTotalNoche(double totalNoche) {
        this.totalNoche = totalNoche;
    }

    
    
    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDiaReservacion() {
        return diaReservacion;
    }

    public void setDiaReservacion(Date diaReservacion) {
        this.diaReservacion = diaReservacion;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String datosReservacion(){
        String nombrePaquete = "Ninguno", estadoReservacion = "FINALIZADA";
        
        if (this.estado.equals("A")) estadoReservacion = "ACTIVA";
        else if (this.estado.equals("C")) estadoReservacion = "CANCELADA";
        
        if (this.paquete != null) nombrePaquete = this.paquete.getNombre();
        
        return  " - Cliente: " + this.cliente.getnombres() + " " + this.cliente.getapellidos() + "\n" +
                " - Tipo Documento: " + this.cliente.getTipoDoc() + " No. " + this.cliente.getNumDoc() + "\n" +
                " - Habitacion: " + this.habitacion.value() + "\n" +
                " - Paquete: " + nombrePaquete + "\n" +
                " - Total Noche (Precio Habitacion + Paquete): " + this.totalNoche + "\n" +
                " - Total Dias: " + this.dias + "\n" +
                " - Total a Cancelar: " + this.total+ "\n" +
                " - Dia de Reservación: " + new SimpleDateFormat("dd/MM/yyyy").format(this.diaReservacion) + "\n" +
                " - Estado Reservación: " + estadoReservacion;
    }
}
