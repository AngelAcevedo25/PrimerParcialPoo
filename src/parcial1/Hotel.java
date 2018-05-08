/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author user
 */
public class Hotel {
    private String nombre;
    private Habitacion habitaciones[][];
    private double precio;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Paquete> paquetes = new ArrayList<>();
    private ArrayList<Reservacion> reservaciones = new ArrayList<>();
    
    
    public Hotel(String nombre,int numHabitaciones, int pisos,double precio) {
        this.nombre = nombre;
        this.habitaciones = new Habitacion[pisos][numHabitaciones];
        this.precio = precio;
        creaHabitaciones();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Habitacion[][] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitacion[][] habitaciones) {
        this.habitaciones = habitaciones;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    private void creaHabitaciones() {

        int pisos = habitaciones.length;
        int cont = 1; 
        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[0].length; j++) {
                double precioFinal = this.precio;
                if(cont == pisos || cont == (pisos - 1)) precioFinal = precio + (precio*0.10);
                //Recordar que los char se pueden sumar
                habitaciones[i][j] = new Habitacion(j+1,(char) ('A' + i),precioFinal,true);
            }
            cont++; 
        }

    }
    
    public Habitacion getHabitaciones(int nivel, int habitacion) {
        if (habitacion < 0 || habitacion > habitaciones[0].length-1 || nivel < 0 || nivel < habitaciones.length-1) return null;
        return this.habitaciones[(habitaciones.length-1)-(nivel-1)][habitacion-1];
    }
    
    public int getFilas() {
        return habitaciones.length;
    }
    
    public int getColumnas() {
        return habitaciones[0].length;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public ArrayList<Reservacion> getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(ArrayList<Reservacion> reservaciones) {
        this.reservaciones = reservaciones;
    }
    
    
    
    public String mostrarMenu(){
        String rslt;
        rslt = "Buen Dia. \nEscoja el número de la acción que desee realizar:\n";
        rslt += " 1) Mantenimiento Clientes\n";
        rslt += " 2) Mantenimiento Habitaciones\n";
        rslt += " 3) Mantenimiento Paquetes\n";
        rslt += " 4) Mantenimiento Reservacion\n";
        rslt += " 5) Reportes\n";
        rslt += " 6) Salir";
        return rslt;
    }
    
    public String mostrarSubMenu(int menu){
        String rslt = "";
        switch(menu){
            case 1:
                rslt = "\n--Escoja el número de la acción que desee realizar:\n";
                rslt += " 1) Agregar Cliente\n";
                rslt += " 2) Modificar Cliente\n";
                rslt += " 3) Regresar al menu";
                break;
            case 2:
                rslt = "\n--Escoja el número de la acción que desee realizar:\n";
                rslt += " 1) Modificar Precio Base\n";
                rslt += " 2) Inhabilitar Habitacion\n";
                rslt += " 3) Habilitar Habitacion\n";
                rslt += " 4) Inhabilitar Piso\n";
                rslt += " 5) Habilitar Piso\n";
                rslt += " 6) Regresar al menu";
                break;
            case 3:
                rslt = "\n--Escoja el número de la acción que desee realizar:\n";
                rslt += " 1) Agregar Paquete\n";
                rslt += " 2) Modificar Paquete\n";
                rslt += " 3) Regresar al menu";
                break;
            case 4:
                rslt = "\n--Escoja el número de la acción que desee realizar:\n";
                rslt += " 1) Agregar Reservacion\n";
                rslt += " 2) Cancelar Reservación\n";
                rslt += " 3) Facturar Reservación\n";
                rslt += " 4) Modificar Reservacion\n";
                rslt += " 5) Regresar al menu";
                break;
            case 5:
                rslt = "\n--Escoja el número de la acción que desee realizar:\n";
                rslt += " 1) Reporte de Clientes\n";
                rslt += " 2) Reporte Habitaciones\n";
                rslt += " 3) Reporte Paquetes\n";
                rslt += " 4) Reporte Reservaciones\n";
                rslt += " 5) Regresar al menu";
                break;
        }
        return rslt;
    }
    
    
    
    public String addCliente(String nombres, String apellidos,String sexo,String tipoDoc,String numDoc ,int edad, String nacionalidad,String numTarjeta){
        String rslt =  "";
        //Se valida los datos que vienen
        if (nombres.trim().isEmpty())rslt += "[ Nombre Vacios ]";
        if (apellidos.trim().isEmpty())rslt += "[ Apellidos Vacios ]";
        if (sexo.trim().isEmpty() || (!sexo.toUpperCase().equals("M") && !sexo.toUpperCase().equals("F")))rslt += "[ Sexo vacio o no Existe ]";
        if (tipoDoc.trim().isEmpty())rslt += "[ Tipo Documento vacio ]";
        if (numDoc.trim().isEmpty())rslt += "[ Número Documento vacio]";
        if (edad < 18)rslt += "[ Edad vacia o menor a 18 años ]";
        //Si rslt sigue vacio se agrega al cliente
        //System.out.println(nombres+" "+  apellidos +" "+sexo.toUpperCase() +" "+tipoDoc.toLowerCase()+" "+ numDoc +" "+ edad +" "+ nacionalidad+" "+ numTarjeta);
        if (rslt.equals("")) clientes.add(new Cliente( nombres,  apellidos, sexo.toUpperCase() , tipoDoc.toLowerCase(), numDoc , edad,  nacionalidad, numTarjeta));
        
        return rslt;
    }
    
    public String addPaquete(String nombre, boolean buffet, boolean piscina, boolean ilimiPiscina, boolean serviceHabitacion, boolean minibar, boolean ilimiMiniBar, boolean ilimiInternet, double precio){
        String rslt = "";
        if(nombre.trim().isEmpty()) rslt += "[ Nombre de paquete vacio ] ";
        if(precio < 0) rslt += "[ Precio no valido ]";
        
        if(rslt.equals("")) paquetes.add(new Paquete(nombre, buffet, piscina, ilimiPiscina, serviceHabitacion, minibar, ilimiMiniBar, ilimiInternet, precio));
        return rslt;
    }
    
    public String addReservacion(int cliente, int piso,int habitacion, Integer paquete, int dias){
        String rslt = "";
        if(cliente < 1 || clientes.size() < cliente) rslt += "[ Escoja un Cliente ] ";
        else if(reservaCliente(clientes.get(cliente - 1))) rslt += "[ Este Cliente ya posee Reservación ]";
        if(habitacion < 1  || habitacion > habitaciones[0].length || piso < 0 || piso > habitaciones.length) rslt += "[Escoja Habitacion Valida]";
        if(dias < 1 || dias > 7) rslt += "[ Cantidad de Dias minimo 1 y maximo 7 ] ";
        
        if(rslt.equals("")) {
            Paquete paqueteF;
            Date date = new Date();
            double paque = 0;
            if (paquete == -1 ){
                paquete = null;
                paqueteF = null;
            } 
            else {
                paqueteF = paquetes.get(paquete-1);
            }
            if (paquete != null) paque = paquetes.get(paquete-1).getPrecio();
            double precioHabitacion = habitaciones[piso][(habitacion-1)].getPrecio();
            double total = totalPagar(paque,precioHabitacion,dias);
            reservaciones.add(new Reservacion(clientes.get((cliente-1)), habitaciones[piso][(habitacion - 1)], paqueteF, dias, total, date, "A", (precioHabitacion + paque )));
            habitaciones[piso][(habitacion-1)].setCliente(clientes.get((cliente-1)));
        }
        return rslt;
    }
    
    
    public void todosClientes(int accion){
        if(accion == 1){
            if(clientes.isEmpty()) System.out.println("--\n---------- NO HAY CLIENTES INGRESADOS ----------\n--");
            for(int i = 0; i < clientes.size() ; i++) {
                System.out.println("----------- CLIENTES AGREGADOS ----------\n"+(i+1)+") \n"+clientes.get(i).clienteDatos()+"\n--");
            }
        }
        else {
            if(clientes.isEmpty()) System.out.println("--\n---------- NO HAY CLIENTES INGRESADOS ----------\n--");
            for(int i = 0; i < clientes.size() ; i++) {
                System.out.println((i+1)+") "+clientes.get(i).clienteDatos().replace("\n"," ")+"\n");
            }
        }
    }
    
    public void todasHabitaciones(int accion){
        if(accion == 1){
            System.out.println("----------- HABITACIONES ----------\n");
            int pisos = habitaciones.length;
            for(int i = 0; i < habitaciones.length; i++) {
                for (int j = 0; j < habitaciones[0].length; j++) {
                    double precioFinal = this.precio;
                    if(pisos == habitaciones.length || pisos == habitaciones.length-1) precioFinal = precio + (precio*0.10);
                    System.out.println("\n"+habitaciones[i][j].datosHabitacion()+"\n--");
                }
                pisos--; //Decremento la fila para actualizar la fila
            }
        }
        else{
            int ini = 0;
            int pisos = habitaciones.length;
            for (int i = 0; i < habitaciones.length; i++) {
                for (int j = 0; j < habitaciones[0].length; j++) {
                    if(ini == 1 && habitaciones[i][j].isEstado() && habitaciones[i][j].getCliente() == null){
                        System.out.println("\n"+habitaciones[i][j].datosHabitacion().replace("\n", "") +" ****");
                        //System.out.println("\n"+habitaciones[i][j].value()+"*** ");
                        ini = 0;
                    }
                    else if(ini == 0 && habitaciones[i][j].isEstado() && habitaciones[i][j].getCliente() == null){
                        System.out.println(habitaciones[i][j].datosHabitacion().replace("\n", "") +" ****");
                        //System.out.println(habitaciones[i][j].value()+" *** ");
                    }
                }
                pisos--;
                ini = 1;
            }
        }
    }
    
    public void todosPaquetes(){
        System.out.println("----------- PAQUETES AGREGADOS ----------\n");
        if(paquetes.isEmpty()) System.out.println("--\n---------- NO HAY PAQUETES AGREGADOS----------\n--");
        for(int i = 0; i < paquetes.size() ; i++) {
            System.out.println((i+1)+") \n"+paquetes.get(i).datosPaquete().replace("true", "Sí").replace("false", "No")+"\n--");
        }
    }
    
    public void todasReservaciones(int accion){
        if (accion == 1)
        {
            System.out.println("----------- TODAS LAS RESERVACIONES ----------\n");
            if( this.reservaciones.isEmpty()) System.out.println("--\n---------- NO HAY RESERVACIONES AGREGADOS----------\n--");
            for(int i = 0; i < reservaciones.size() ; i++) {
                System.out.println((i+1)+") \n" + reservaciones.get(i).datosReservacion() + "\n--");
            }
        }
        else if(accion == 0)
        {
            System.out.println("----------- TODAS LAS RESERVACIONES (Solo dar Ente en caso que no hayan reservaciones) ----------\n");
            if(this.reservaciones.isEmpty()) System.out.println("--\n---------- NO HAY RESERVACIONES AGREGADAS ----------\n--");
            for(int i = 0; i < reservaciones.size() ; i++) {
                if(reservaciones.get(i).getEstado().equals("A")) System.out.println((i+1)+") \n" + reservaciones.get(i).datosReservacion().replace("\n"," ") + "\n--");
            }
        }
    }
    
    
    public void updPreciobaseH(double precio){
        if(precio == -1) return;
        int pisos = habitaciones.length;
        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[0].length; j++) {
                double precioFinal = precio;
                if(pisos == habitaciones.length || pisos == habitaciones.length-1) precioFinal = precio + (precio*0.10);
                //Recuerda que los char se pueden sumar
                habitaciones[i][j].setPrecio(precioFinal);
            }
            pisos--; //Decremento la fila para actualizar la fila
        }
        System.out.println("--\n ---------- REGISTRO MODIFICADO ----------\n--");
    }
    
    public void updEstadoHabitacion(int nivel, int num, boolean estado){
        int val = nivel-1;
        if( val > habitaciones.length) System.out.println("No existe este nivel");
        else{
            habitaciones[(habitaciones.length-1)-(nivel-1)][num-1].setEstado(estado);
            System.out.println("--\n ---------- REGISTRO MODIFICADO ----------\n--");
        } 
    }
    
    public void updEstadoNivel(int nivel, boolean estado){
        int val = nivel-1;
        if(val > habitaciones.length) System.out.println("No existe este nivel");
        else{
            for(int i = 0; i < habitaciones[0].length;i++){
                habitaciones[(habitaciones.length-1)-(nivel-1)][i].setEstado(estado);
            }
            System.out.println("--\n ---------- REGISTRO MODIFICADO ----------\n--");
        } 
    }
    
    public void updEstadoReservacion(int reservacion,String estado){
        if(reservacion < 1 || reservacion > reservaciones.size()) System.out.println("No existe esta número de reservación");
        else
        {
            reservaciones.get(reservacion - 1).setEstado(estado);
            System.out.println("--\n ---------- REGISTRO MODIFICADO ----------\n--");
        }
    }
    
    
    
    private double totalPagar(double paquete, double habitacion, int dias){
        return Double.valueOf( new DecimalFormat("#.00").format(( paquete + habitacion ) * dias));
    }
    
    private boolean reservaCliente(Cliente cliente){
        for(int i = 0; i < reservaciones.size(); i++)
        {
            if(reservaciones.get(i).getCliente() == cliente && reservaciones.get(i).getEstado().equals("A")) return true;
        }
        return false;
    }
    
    public String updReservacion(int numReservacion,int cliente, int piso,int habitacion, Integer paquete, int dias){
        String rslt = "";
        if(numReservacion < 1 || numReservacion > reservaciones.size()) rslt += " [ RESERVACION NO VALIDA ] ";
        if(clientes.size() < cliente) rslt += "[ Escoja un Cliente ] ";
        else if(cliente > 1) if(reservaCliente(clientes.get(cliente - 1))) rslt += "[ Este Cliente ya posee Reservación ]";
        if(habitacion > habitaciones[0].length || piso > habitaciones.length) rslt += "[Escoja Habitacion Valida]";
        if(dias == 0 || dias > 7) rslt += "[ Cantidad de Dias minimo 1 y maximo 7 ] ";
        
        if(rslt.equals("")) {
            double paque;
            
            //Modificación Cliente
            if(cliente > 0)
            {
                reservaciones.get(numReservacion -1).setCliente(clientes.get(cliente - 1));
                habitaciones[reservaciones.get(numReservacion -1).getHabitacion().getNivel() - 'A'][reservaciones.get(numReservacion -1).getHabitacion().getNumHabitacion()].setCliente(clientes.get((cliente-1)));
            }
            
            //Modificación Habitacion
            if(piso > -1 && habitacion > 0)
            {
                reservaciones.get(numReservacion -1).setHabitacion(habitaciones[piso][habitacion - 1]);
            }
            else
            {
                if(piso > -1)
                {
                    Habitacion habitacionNueva = habitaciones[piso][reservaciones.get(numReservacion - 1).getHabitacion().getNumHabitacion()];
                    reservaciones.get(numReservacion -1).setHabitacion(habitacionNueva);
                }
                else if (habitacion > 0)
                {
                    Habitacion habitacionNueva = habitaciones[reservaciones.get(numReservacion - 1).getHabitacion().getNivel() - 'A'][habitacion - 1];
                    reservaciones.get(numReservacion -1).setHabitacion(habitacionNueva);
                }
            }
            
            //Modificacion de Paquete.            
            if(paquete == -2)
            {
                reservaciones.get(numReservacion - 1).setPaquete(null);
            }
            else if (paquete > - 1)
            {
                if(paquete <= paquetes.size())
                {
                    reservaciones.get(numReservacion -1).setPaquete(paquetes.get(paquete - 1));
                }
            }
            
            //Modificacion Dias.
            if(dias > 0)
            {
                reservaciones.get(numReservacion -1).setDias(dias);
            }
            paque = 0;
            if(reservaciones.get(numReservacion - 1).getPaquete() != null) paque = reservaciones.get(numReservacion - 1).getPaquete().getPrecio();
            double precioHabitacion = reservaciones.get(numReservacion - 1).getHabitacion().getPrecio();
            double total = totalPagar(paque,precioHabitacion,dias);
            
            reservaciones.get(numReservacion - 1).setTotal(total);
            reservaciones.get(numReservacion - 1).setTotalNoche(precioHabitacion + paque);
            
        }
        return rslt;
    }
}
