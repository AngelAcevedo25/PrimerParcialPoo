package parcial1;

public class Paquete {
    private String nombre;
    private boolean buffet;
    private boolean piscina;
    private boolean ilimiPiscina;
    private boolean serviceHabitacion;
    private boolean minibar;
    private boolean ilimiMiniBar;
    private boolean ilimiInternet;
    private double precio;

    public Paquete(String nombre, boolean buffet, boolean piscina, boolean ilimiPiscina, boolean serviceHabitacion, boolean minibar, boolean ilimiMiniBar, boolean ilimiInternet, double precio) {
        this.nombre = nombre;
        this.buffet = buffet;
        this.piscina = piscina;
        this.ilimiPiscina = ilimiPiscina;
        this.serviceHabitacion = serviceHabitacion;
        this.minibar = minibar;
        this.ilimiMiniBar = ilimiMiniBar;
        this.ilimiInternet = ilimiInternet;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isBuffet() {
        return buffet;
    }

    public void setBuffet(boolean buffet) {
        this.buffet = buffet;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public boolean isIlimiPiscina() {
        return ilimiPiscina;
    }

    public void setIlimiPiscina(boolean ilimiPiscina) {
        this.ilimiPiscina = ilimiPiscina;
    }

    public boolean isServiceHabitacion() {
        return serviceHabitacion;
    }

    public void setServiceHabitacion(boolean serviceHabitacion) {
        this.serviceHabitacion = serviceHabitacion;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isIlimiMiniBar() {
        return ilimiMiniBar;
    }

    public void setIlimiMiniBar(boolean ilimiMiniBar) {
        this.ilimiMiniBar = ilimiMiniBar;
    }

    public boolean isIlimiInternet() {
        return ilimiInternet;
    }

    public void setIlimiInternet(boolean ilimiInternet) {
        this.ilimiInternet = ilimiInternet;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public String datosPaquete(){
        //nombre
        //buffet, piscina, ilimiPiscina, serviceHabitacion, minibar, ilimiMiniBar, ilimiInternet, precio
        return  " -Nombre: " + this.nombre +
                "\n -Buffet: " + this.buffet + 
                "\n -Piscina : " + this.piscina + 
                "\n -Piscina Ilimitada: " + ilimiPiscina + 
                "\n -Servicio a la Habitacion: " + this.serviceHabitacion + 
                "\n -Mini Bar: " + this.minibar + 
                "\n -Mini Bar Ilimitado: " + this.ilimiMiniBar + 
                "\n -Internet Ilimitado: " + this.ilimiInternet +
                "\n -Precio Extra por Dia: $" + this.precio + " Dolares";
    }
}
