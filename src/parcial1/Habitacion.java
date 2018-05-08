package parcial1;

public class Habitacion {
    private int NumHabitacion;
    private char nivel;
    private double precio;
    private Cliente cliente;
    private boolean estado;

    public Habitacion(int NumHabitacion, char nivel,double precio, boolean estado) {
        this.NumHabitacion = NumHabitacion;
        this.nivel = nivel;
        this.precio = precio;
        this.cliente = null;
        this.estado = estado;
        
    }

    public int getNumHabitacion() {
        return NumHabitacion;
    }

    public void setNumHabitacion(int NumHabitacion) {
        this.NumHabitacion = NumHabitacion;
    }

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel) {
        this.nivel = nivel;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public boolean ocupado() {
        return cliente != null;
    }

    @Override
    public String toString() {
        if (ocupado()) {
            return "Habitación: " + nivel + this.NumHabitacion;
        }

        return "Habitación: " + nivel + this.NumHabitacion + " y este asiento está vacio ";
    }
    
    public String value(){
        return String.valueOf(this.nivel) + this.NumHabitacion;
    }
    
    public String datosHabitacion(){
        String reserva = "LIBRE",estadoF = "HABILIDATA",tipo = "SENCILLA";
        if (this.cliente != null) reserva = "RESERVADA";
        if (!this.estado) estadoF = "INHABILITADA";
        if (this.NumHabitacion%2 == 0) tipo = "DOBLE";
        return " -Habitación: " + this.nivel +this.NumHabitacion+ "\n -Precio: " + this.precio + "\n -Estado Reserva: " + reserva + "\n -Estado: " + estadoF + "\n -Tipo :"+tipo;
    }
}
