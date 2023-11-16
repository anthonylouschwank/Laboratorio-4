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
            System.out.println("3. Salir del Sistema");
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
                String usuario = sca.nextLine();
                System.out.println("Cual es su clave?");
                String clave = sca.nextLine();
                for(Usuario elemento : UsuarioList){
                    if(elemento.getNombre().equals(usuario) && elemento.getContrasena().equals(clave)){
                        if(elemento.getPlan().equals("Basico")){
                            System.out.println("---------------------------------");
                            System.out.println("Se identifico al usuario como plan Basico");
                            System.out.println("Desea subir de nivel de su plan y convertirse en VIP?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            System.out.println("---------------------------------");
                            int ans2 = sca.nextInt();
                            if(ans2 == 1){
                                elemento.setPlan("VIP"); //Aqui empieza logica de vuelos

                            }
                            if(ans2 == 2){
                                System.out.println("Te lo pierdes bro");
                            }

                        } 
                        if(elemento.getPlan().equals("VIP")){
                            System.out.println("---------------------------------");
                            System.out.println("Se identifico al usuario como plan VIP");
                            System.out.println("Esta parte del codigo no me fue asignada, pero gracias por intentar igual :)");
                        }

                    }
                }



            }

            else if(ans == 3){
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
                    VIP nuevoVIP = new VIP(partes[1].trim(), partes[2].trim(),  Integer.parseInt(partes[3].trim()), partes[4], partes[5], Integer.parseInt(partes[6].trim()), partes[6], Integer.parseInt(partes[7].trim()), Integer.parseInt(partes[7].trim()));
                    MovList.add(nuevoVIP);
                }
                if(partes[0] == "Basico"){
                    Basico nuevoBasico = new Basico(partes[1].trim(), partes[2].trim(),  Integer.parseInt(partes[3].trim()), partes[4], partes[5], Integer.parseInt(partes[6].trim()), partes[6], Integer.parseInt(partes[7].trim()), Integer.parseInt(partes[7].trim()));
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
                    writer.write("VIP" + vip.getVueloInicio() + "," + vip.getVueloFinal() + "," + vip.getBoletos() + "," + vip.getAerolinea() + "," + vip.getTarjeta() + "," + vip.getCuotas() + "," + vip.getClaseVuelo() + "," + vip.getAsiento() + "," + vip.getMaletas() + "\n");
                }
                if(elemento instanceof Basico){
                    Basico bas = (Basico) elemento;
                    writer.write("Basico" + bas.getVueloInicio() + "," + bas.getVueloFinal() + "," + bas.getBoletos() + "," + bas.getAerolinea() + "," + bas.getTarjeta() + "," + bas.getCuotas() + "," + bas.getClaseVuelo() + "," + bas.getAsiento() + "," + bas.getMaletas() + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
