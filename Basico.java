import java.util.Random;
public class Basico implements Base {
    
    private String VueloInicio;
    private String VueloFinal;
    private int Boletos;
    private String Aerolinea;
    private String Tarjeta;
    private int Cuotas;
    private String ClaseVuelo;
    private int Asiento;
    private int Maletas;
    private boolean Cupon;

    public Basico(String VueloInicio, String VueloFinal, int Boletos, String Aerolinea, String Tarjeta, int Cuotas, String ClaseVuelo, int Asiento, int Maletas, boolean Cupon){
        this.VueloInicio = VueloInicio;
        this.VueloFinal = VueloFinal;
        this.Boletos = Boletos;
        this.Aerolinea = Aerolinea;
        this.Tarjeta = Tarjeta;
        this.Cuotas = Cuotas;
        this.ClaseVuelo = ClaseVuelo;
        this.Asiento = Asiento;
        this.Maletas = Maletas;
        this.Cupon = Cupon;
    }

    
    String getVueloInicio(){
        return VueloInicio;
    }

    String getVueloFinal(){
        return VueloFinal;
    }

    int getBoletos(){
        return Boletos;
    }

    String getAerolinea(){
        return Aerolinea;
    }

    String getTarjeta(){
        return Tarjeta;
    }

    int getCuotas(){
        return Cuotas;
    }

    String getClaseVuelo(){
        return ClaseVuelo;
    }

    int getAsiento(){
        return Asiento;
    }

    int getMaletas(){
        return Maletas;
    }

    boolean getCupon(){
        return Cupon;
    }


    @Override
    public void setVueloInicio(String ValorString){
        this.VueloInicio = ValorString;
    }

    @Override
    public void setVueloFinal(String ValorString){
        this.VueloFinal = ValorString;
    }

    @Override
    public void setBoletos(int ValorInt){
        this.Boletos = ValorInt;
    }

    @Override
    public void setAerolinea(String ValorString){
        this.Aerolinea = ValorString;
    }

    @Override
    public void setTarjeta(String ValorString){
        this.Tarjeta = ValorString;
    }

    @Override
    public void ModificarContra(){
        //Existo de decoracion pero el programa no sirve sin mi :)
    }

    @Override
    public void setCuotas(int ValorInt){
        this.Cuotas = ValorInt;
    }

    @Override
    public void setClaseVuelo(String ValorString){
        this.ClaseVuelo = ValorString;
    }

    @Override
    public void AsignacionAsiento(int ValorInt){
        Random random = new Random();
        int Aleatorio = random.nextInt(50 - ValorInt + 1) - ValorInt;
        this.Asiento = Aleatorio;
    }

    @Override
    public void setNumMaleta(int ValorInt){
        this.Maletas = ValorInt;
    }

    public void setCupon(boolean ValorBool){
        this.Cupon = ValorBool;
    }
}