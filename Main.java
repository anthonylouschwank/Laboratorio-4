import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Base> MovList = new ArrayList<>();
        List<Usuario> UsuarioList = new ArrayList<>();
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
