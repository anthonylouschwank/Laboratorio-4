import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Base> MovList = leerCSVMov("Movimientos.csv");
        List<Usuario> UsuarioList = leerCSVUsuario("Usuarios.csv");
        boolean terminado = false;
        Scanner sca = new Scanner(System.in);

        while(!terminado){
            System.out.println("---------------------------------");
            System.out.println("Bienvenido al sistema de aerolineas UVG! Eliga de las siguientes opciones!");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Agendar un vuelo");
            System.out.println("3. Editar perfil usuario");
            System.out.println("4. Salir del Sistema");
            System.out.println("---------------------------------");
            int ans = sca.nextInt();

            if(ans == 1){
                Usuario nuevo = new Usuario(null, null, null);
                System.out.println("---------------------------------");
                System.out.println("Entrando a Sistema de Creacion de Usuario");
                System.out.println("---------------------------------");
                System.out.println("Cual desea que sea el nombre asignado?");
                sca.nextLine();
                String nombre = sca.nextLine();
                nuevo.setNombre(nombre);
                System.out.println("---------------------------------");
                System.out.println("Escriba la clave que desea usar");
                String contrasena = sca.nextLine();
                nuevo.setContrasena(contrasena);
                System.out.println("---------------------------------");
                System.out.println("Cual es el plan que piensa usar para el Usuaio " + nombre + "?");
                System.out.println("1. Basica");
                System.out.println("2. VIP");
                int ans1 = sca.nextInt();

                if(ans1 == 1){
                    nuevo.setPlan("Basico");
                } 
                else if(ans == 2){
                    nuevo.setPlan("VIP");
                }
                else {
                    System.out.println("Opcion invalida!");
                }
                UsuarioList.add(nuevo);
            }

            else if(ans == 2){
                System.out.println("---------------------------------");
                System.out.println("Entrando a Sistema de Agenda de Vuelos");
                System.out.println("---------------------------------");
                System.out.println("Cual es el usuario?");
                sca.nextLine();
                String usuario = sca.nextLine();
                System.out.println("Cual es su clave?");
                String clave = sca.nextLine();
                for(Usuario elemento : UsuarioList){
                    if(elemento.getNombre().equals(usuario) && elemento.getContrasena().equals(clave)){
                        if(elemento.getPlan().equals("Basico")){
                            System.out.println("---------------------------------");
                            System.out.println("Se identifico al usuario como plan Basico");
                            System.out.println("Desea subir de nivel a su plan y convertirse en VIP?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            System.out.println("---------------------------------");
                            int ans2 = sca.nextInt();
                            if(ans2 == 1){
                                elemento.setPlan("VIP"); //Aqui empieza logica de vuelos
                                 System.out.println("----------------VIP-----------------");
                                System.out.println("Esta parte del codigo no me fue asignada, pero gracias por intentar igual :)");
                            }
                            if(ans2 == 2){
                                Basico movimiento = new Basico("", "", 0, "", "", 0, "", 0, 0, false);
                                System.out.println("----------------Basico-----------------");
                                System.out.println("Te lo pierdes bro");
                                System.out.println("Acaso tu viaje es de ida y vuelta o solo ida?");
                                System.out.println("1. Ida y Vuelta");
                                System.out.println("2. Ida");
                                System.out.println("---------------------------------");
                                int ans3 = sca.nextInt();
                                boolean terminado1 = false;
                                while(!terminado1){
                                    if(ans3 == 1){
                                        System.out.println("A que horas quieres irte?");
                                        sca.nextLine();
                                        String Vo = sca.nextLine();
                                        movimiento.setVueloInicio(Vo);
                                        System.out.println("A que horas quieres volver?");
                                        String Vf = sca.nextLine();
                                        movimiento.setVueloFinal(Vf);
                                        terminado1 = true;
                                    }
                                    if(ans3 == 2){
                                        System.out.println("A que horas quieres irte?");
                                        String Vo = sca.nextLine();
                                        movimiento.setVueloInicio(Vo);
                                        movimiento.setVueloFinal("NA");
                                        terminado1 = true;
                                    }
                                    else if(ans3 >= 3){
                                        System.out.println("Valor invalido");
                                    }
                                }
                                System.out.println("----------------Basico-----------------");
                                System.out.println("Cuantos boletos desea?");
                                int boleto = sca.nextInt();
                                movimiento.setBoletos(boleto);
                                System.out.println("Cual es la aerolinea preferida para el vuelo?");
                                sca.nextLine();
                                String aero = sca.nextLine();
                                movimiento.setAerolinea(aero);
                                System.out.println("Confirmando configuracion...");
                                System.out.println("Vuelos disponibles encontrados!... Redirigiendo a caja...");
                                System.out.println("---------------------------------");
                                //Entramos a cobros
                                boolean terminado2 = false;
                                while(!terminado2){
                                    System.out.println("----------------Caja-----------------");
                                    System.out.println("Bienvenido al sistema de caja, por favor llene todos los datos para acabar su reserva!");
                                    System.out.println("1. Tarjeta");
                                    System.out.println("2. Cuotas");
                                    System.out.println("3. Clase de Vuelo");
                                    System.out.println("4. Imprimir Itinerario");
                                    System.out.println("---------------------------------");
                                    int ans4 = sca.nextInt();
                                    if(ans4 == 1){
                                        System.out.println("---------------------------------");
                                        System.out.println("Cual es la tarjeta con la que desea hacer el cobro?");
                                        sca.nextLine();
                                        String tar = sca.nextLine();
                                        movimiento.setTarjeta(tar);
                                    } else if(ans4 == 2){
                                        System.out.println("---------------------------------");
                                        System.out.println("En cuentas cuotas desea dividir la cantidad a pagar, Maximo de 24");
                                        int cuota = sca.nextInt();
                                        if(cuota > 24){
                                            System.out.println("El maximo es de 24, asumiendo 6");
                                            movimiento.setCuotas(6);
                                        } else if(cuota <= 24){
                                            movimiento.setCuotas(cuota);
                                        }
                                    } else if(ans4 == 3){
                                        System.out.println("---------------------------------");
                                        System.out.println("En que clase de vuelo desea estar");
                                        System.out.println("1. Coach");
                                        System.out.println("2. VIP");
                                        int ans5 = sca.nextInt();
                                        if(ans5 == 1){
                                            movimiento.setClaseVuelo("Coach");
                                        } else if(ans5 == 2){
                                            movimiento.setClaseVuelo("VIP");
                                        } else if(ans5 > 2){
                                            System.out.println("Valor invalido, asumiendo Coach");
                                            movimiento.setClaseVuelo("Coach");
                                        }
                                    } else if(ans4 == 4){
                                        System.out.println("---------------------------------");
                                        System.out.println("Iinerario del usuario " + usuario);
                                        System.out.println("Hora de salida        " + movimiento.getVueloInicio());
                                        System.out.println("Hora de reingreso     " + movimiento.getVueloFinal());
                                        System.out.println("Cantidad de boletos   " + movimiento.getBoletos());
                                        System.out.println("Aerolinea             " + movimiento.getAerolinea());
                                    }
                                    if(movimiento.getTarjeta() != "" && movimiento.getClaseVuelo() != "" && movimiento.getTarjeta() != ""){
                                        System.out.println("Datos de corobro completados!");
                                        movimiento.setNumMaleta(1);
                                        movimiento.AsignacionAsiento(50);
                                        
                                        System.out.println("---------------Resumen de Reserva------------------");
                                        System.out.println("Iinerario del usuario " + usuario);
                                        System.out.println("Hora de salida        " + movimiento.getVueloInicio());
                                        System.out.println("Hora de reingreso     " + movimiento.getVueloFinal());
                                        System.out.println("Cantidad de boletos   " + movimiento.getBoletos());
                                        System.out.println("Aerolinea             " + movimiento.getAerolinea());
                                        System.out.println("Tarjeta               " + movimiento.getTarjeta());
                                        System.out.println("Cuotas                " + movimiento.getCuotas());
                                        System.out.println("Clase de vuelo        " + movimiento.getClaseVuelo());
                                        System.out.println("Asiento               " + movimiento.getAsiento());
                                        MovList.add(movimiento);
                                        terminado2 = true;
                                    }
                                }
                            }
                        } 
                        if(elemento.getPlan().equals("VIP")){
                            System.out.println("---------------------------------");
                            System.out.println("Se identifico al usuario como plan VIP");
                            System.out.println("Esta parte del codigo no me fue asignada, pero gracias por intentar igual :)");
                        }
                    } else {
                       System.out.println("El usuario no a sido reconocido, revise que este bien escrito"); 
                    }
                }
            } else if(ans == 3){
                System.out.println("---------------------------------");
                System.out.println("Entrando a Sistema de edicion de Usuarios");
                System.out.println("---------------------------------");
                System.out.println("Cual es el usuario?");
                sca.nextLine();
                String usuario = sca.nextLine();
                System.out.println("Cual es su clave?");
                String clave = sca.nextLine();
                for(Usuario elemento : UsuarioList){
                    if(elemento.getNombre().equals(usuario) && elemento.getContrasena().equals(clave)){
                        System.out.println("Usuario encontrado, que desea editar de el?");
                    } else {

                    }
                }

            } else if(ans == 4){
                terminado = true;
                System.out.println("Saliendo del sistema...");
                escribirCSVMovs(MovList, "Movimientos.csv");
                escribirCSVUsuario(UsuarioList, "Usuarios.csv");
            }

            else {
                System.out.println("Opcion invalida!");
            }
        }

    }
    public static ArrayList<Base> leerCSVMov(String nombreArchivo) {
        ArrayList<Base> MovList = new ArrayList<>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
    
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if(partes[0] == "VIP"){
                    VIP nuevoVIP = new VIP(partes[1].trim(), partes[2].trim(),  Integer.parseInt(partes[3].trim()), partes[4].trim(), partes[5].trim(), Integer.parseInt(partes[6].trim()), partes[6].trim(), Integer.parseInt(partes[7].trim()), Integer.parseInt(partes[7].trim()));
                    MovList.add(nuevoVIP);
                }
                if(partes[0] == "Basico"){
                    Basico nuevoBasico = new Basico(partes[1].trim(), partes[2].trim(),  Integer.parseInt(partes[3].trim()), partes[4].trim(), partes[5].trim(), Integer.parseInt(partes[6].trim()), partes[6].trim(), Integer.parseInt(partes[7].trim()), Integer.parseInt(partes[7].trim()), Boolean.parseBoolean(partes[8].trim()));
                    MovList.add(nuevoBasico);
                }
                    
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return MovList;
    }

    public static ArrayList<Usuario> leerCSVUsuario(String nombreArchivo) {
        ArrayList<Usuario> usuarioList = new ArrayList<>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
    
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
    
                if (partes.length == 3) { 
                    // Crear una instancia de Usuario utilizando el constructor
                    Usuario usuario = new Usuario(partes[0].trim(), partes[1].trim(), partes[2].trim());
    
                    // Agregar el objeto Usuario a la lista
                    usuarioList.add(usuario);
                } else {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return usuarioList;
    }
    

    public static void escribirCSVUsuario(List<Usuario> usuarios, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo, false)) {
    
            for (Usuario usuario : usuarios) {
                writer.write(usuario.getNombre() + "," + usuario.getContrasena() + "," + usuario.getPlan() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirCSVMovs(List<Base> elementos, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo, false)) {
    
            for (Base elemento : elementos) {
                if(elemento instanceof VIP){
                    VIP vip = (VIP) elemento;
                    writer.write("VIP" + "," + vip.getVueloInicio() + "," + vip.getVueloFinal() + "," + vip.getBoletos() + "," + vip.getAerolinea() + "," + vip.getTarjeta() + "," + vip.getCuotas() + "," + vip.getClaseVuelo() + "," + vip.getAsiento() + "," + vip.getMaletas() + "\n");
                }
                if(elemento instanceof Basico){
                    Basico bas = (Basico) elemento;
                    writer.write("Basico" + "," + bas.getVueloInicio() + "," + bas.getVueloFinal() + "," + bas.getBoletos() + "," + bas.getAerolinea() + "," + bas.getTarjeta() + "," + bas.getCuotas() + "," + bas.getClaseVuelo() + "," + bas.getAsiento() + "," + bas.getMaletas() + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
