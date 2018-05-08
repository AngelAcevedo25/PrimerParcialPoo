package parcial1;
import java.util.Scanner;

public class Parcial1 {

    public static void main(String[] args) {
        Hotel hotel = new Hotel("Viña Rafinha", 10, 6,10.50 );
              //         nombre   , buffet, piscina, ilimiPiscina, serviceHabitacion, minibar, ilimiMiniBar, ilimiInternet, precio
        hotel.addPaquete("PREMIUM", true  , true   , true        , true             , true   , true ,        true         ,150.00);
        hotel.addPaquete("BASICO" , false , true   , false       , false            , false  , false,        true         ,10.00);
        hotel.addCliente("ANGEL MAURICIO", "ACEVEDO GURDADO", "M", "dui", "00232187", 23, "SALVADOREÑO", "00232819");
        hotel.addReservacion(1, 5, 9, 1, 7);
        
        int accion;
        boolean flgMenu = true;
        Scanner sn = new Scanner(System.in);
        Validate validate = new Validate();
        
        while(flgMenu){
            System.out.println(hotel.mostrarMenu());
            accion = validate.ValidateInt(sn.nextLine());
            switch(accion){
                case 1:
                    System.out.println(hotel.mostrarSubMenu(accion));
                    int subMenu = validate.ValidateInt(sn.nextLine());
                    switch(subMenu){
                        case 1:
                            String nombres, apellidos, sexo, tipoDoc, numDoc,nacionalidad,numTarjeta;
                            Integer edad;
        //                    System.out.println("");
        //                    nombres = sn.nextLine();
                            System.out.println("Ingrese nombre(s):");
                            nombres = sn.nextLine();
                            System.out.println("Ingrese apellido(s):");
                            apellidos = sn.nextLine();
                            System.out.println("Ingrese edad:");
                            edad = validate.ValidateInt(sn.nextLine());
                            System.out.println("Ingrese Inicial de sexo (M = Masculino, F = Femenino):");
                            sexo = sn.nextLine();
                            System.out.println("Ingrese Tipo de Documento (todo en minisculas):");
                            tipoDoc = sn.nextLine();
                            System.out.println("Ingrese Número de Documento:");
                            numDoc = sn.nextLine();
                            System.out.println("Ingrese nacionalidad:");
                            nacionalidad = sn.nextLine();
                            System.out.println("Ingrese Número de Tarjeta:");
                            numTarjeta = sn.nextLine();

                            String res = hotel.addCliente(nombres, apellidos, sexo, tipoDoc, numDoc, edad, nacionalidad, numTarjeta);
                            if(res.equals("")) System.out.println("--\n ------------- DATOS AGREGADO -------------\n --");
                            else {
                                System.out.println("--\n ------------- ERROR DE DATOS -------------\n --");
                                System.out.println(res);
                                System.out.println("--");
                            }
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 2:
                    System.out.println(hotel.mostrarSubMenu(accion));
                    int subMenu2 = validate.ValidateInt(sn.nextLine());
                    switch(subMenu2){
                        case 1:
                            System.out.println("Ingrese Nuevo Precio Base:");
                            hotel.updPreciobaseH(validate.ValidateDouble(sn.nextLine()));
                            break;
                        case 2:
                            int nivel;
                            int numHabitacion;
                            boolean estado;
                            System.out.println("Ingrese Nivel de Habitación:");
                            nivel = validate.ValidateInt(sn.nextLine());
                            System.out.println("Ingrese Número de Habitación:");
                            numHabitacion = validate.ValidateInt(sn.nextLine());
                            hotel.updEstadoHabitacion(nivel, numHabitacion, false);
                            break;
                        case 3:
                            int nivelH;
                            int numHabitacionH;
                            boolean estadoH;
                            System.out.println("Ingrese Nivel de Habitación:");
                            nivelH = validate.ValidateInt(sn.nextLine());
                            System.out.println("Ingrese Número de Habitación:");
                            numHabitacionH = validate.ValidateInt(sn.nextLine());
                            hotel.updEstadoHabitacion(nivelH, numHabitacionH, true);
                            break;
                        case 4:
                            int nivelp;
                            System.out.println("Ingrese el nivel a inhabilitar:");
                            nivelp = validate.ValidateInt(sn.nextLine());
                            hotel.updEstadoNivel(nivelp, false);                              
                            break;
                        case 5:
                            int nivel1;
                            System.out.println("Ingrese el nivel a habilitar:");
                            nivel1 = validate.ValidateInt(sn.nextLine());
                            hotel.updEstadoNivel(nivel1, true);                              
                            break;
                    }
                    break;
                case 4:
                    System.out.println(hotel.mostrarSubMenu(accion));
                    int subMenu4 = validate.ValidateInt(sn.nextLine());
                    switch(subMenu4)
                    {
                        case 1:
                            //Se Muestan Los Clientes 
                            hotel.todosClientes(0);
                            System.out.println("--\n--");
                            System.out.println("Escoja al Cliente: (Ingrese el numero)");
                            int cliente = validate.ValidateInt(sn.nextLine());

                            //habitaciones
                            hotel.todasHabitaciones(0);
                            System.out.println("--\n--");
                            System.out.println("Ingrese Letra de Nivel Nivel:");
                            String nivel = sn.nextLine();
                            System.out.println("Ingrese Habitacion:");
                            int habitacion = validate.ValidateInt(sn.nextLine());

                            hotel.todosPaquetes();
                            System.out.println("--\n--");
                            System.out.println("Escoja paquete: (Ingrese el numero o deje vacio si es ninguno)");
                            int paquete = validate.ValidateInt(sn.nextLine());

                            System.out.println("Total Dias:");
                            int dias = validate.ValidateInt(sn.nextLine());

                            String res = hotel.addReservacion(cliente,(nivel.toUpperCase().charAt(0) - 'A'), habitacion, paquete, dias);
                            if(res.equals("")) System.out.println("--\n ------------- DATOS AGREGADO -------------\n --");
                            else {
                                System.out.println("--\n ------------- ERROR DE DATOS -------------\n --");
                                System.out.println(res);
                                System.out.println("--");
                            }
                            break;
                        case 2:
                            hotel.todasReservaciones(0);
                            System.out.println("Ingrese Número de Reservación:");
                            int reser = validate.ValidateInt(sn.nextLine());
                            hotel.updEstadoReservacion(reser, "C");
                            break;
                        case 3:
                            hotel.todasReservaciones(0);
                            System.out.println("Ingrese Número de Reservación:");
                            int reser1 = validate.ValidateInt(sn.nextLine());
                            hotel.updEstadoReservacion(reser1, "F");
                            break;
                        case 4:
                            
                            System.out.println("-- NOTA\n-- SI NO DESEA MODIFICAR ALGUN DATOS SOLO DAR ENTER \n--");
                            System.out.println("*------------------------------- Ingrese Número de Reservación -------------------------------*");
                            //Se Muestran Las Reservaciones
                            hotel.todasReservaciones(0);
                            System.out.println("Escoja Reservacion: (Ingrese el numero)");
                            int numReser  = validate.ValidateInt(sn.nextLine());
                            
                            //Se Muestan Los Clientes 
                            hotel.todosClientes(0);
                            System.out.println("--\n--");
                            System.out.println("Escoja al Cliente: (Ingrese el numero)");
                            int clienteNuevo = validate.ValidateInt(sn.nextLine());

                            //habitaciones
                            hotel.todasHabitaciones(0);
                            System.out.println("--\n--");
                            System.out.println("Ingrese Letra de Nivel Nivel:");
                            String nivelNuevo = sn.nextLine();
                            System.out.println("Ingrese Habitacion:");
                            int habitacionNueva = validate.ValidateInt(sn.nextLine());

                            hotel.todosPaquetes();
                            System.out.println("--\n--");
                            System.out.println("Escoja paquete: (Ingrese el numero o deje vacio si es ninguno)");
                            int paqueteNuevo = validate.ValidateInt(sn.nextLine());

                            System.out.println("Total Dias:");
                            int diasNuevo = validate.ValidateInt(sn.nextLine());
                            
                            String resn = hotel.updReservacion(numReser, clienteNuevo, nivelNuevo.toUpperCase().charAt(0) - 'A', habitacionNueva, paqueteNuevo, diasNuevo);
                            if(resn.equals("")) System.out.println("--\n ------------- DATOS AGREGADO -------------\n --");
                            else {
                                System.out.println("--\n ------------- ERROR DE DATOS -------------\n --");
                                System.out.println(resn);
                                System.out.println("--");
                            }
                            
                            break;
                    }                    
                    break;
                case 5:
                    System.out.println(hotel.mostrarSubMenu(accion));
                    int subMenu5 = validate.ValidateInt(sn.nextLine());
                    switch(subMenu5){
                        case 1:
                            hotel.todosClientes(1);
                            break;
                        case 2:
                            hotel.todasHabitaciones(1);
                            break;
                        case 3:
                            hotel.todosPaquetes();
                            break;
                        case 4:
                            hotel.todasReservaciones(1);
                            break;
                    }
                    break;
                case 6:
                    flgMenu = false;
                    break;
            }            
        }        
    }    
}
