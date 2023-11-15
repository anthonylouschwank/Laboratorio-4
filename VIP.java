public class VIP implements Base {

    private String VueloInicio;
    private String VueloFinal;
    private int Boletos;
    private String Aerolinea;
    private String Tarjeta;
    private int Cuotas;
    private String ClaseVuelo;
    private int Asiento;
    private int Maletas;

    public VIP(String VueloInicio, String VueloFinal, int Boletos, String Aerolinea, String Tarjeta, int Cuotas, String ClaseVuelo, int Asiento, int Maletas){
        this.VueloInicio = VueloInicio;
        this.VueloFinal = VueloFinal;
        this.Boletos = Boletos;
        this.Aerolinea = Aerolinea;
        this.Tarjeta = Tarjeta;
        this.Cuotas = Cuotas;
        this.ClaseVuelo = ClaseVuelo;
        this.Asiento = Asiento;
        this.Maletas = Maletas;
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
    public void setCuotas(){
        this.Cuotas = 1;
    }

    @Override
    public void setClaseVuelo(String ValorString){
        this.ClaseVuelo = "VIP";
    }

    @Override
    public void AsignacionAsiento(int ValorInt){
        this.Asiento = ValorInt;
    }

    @Override
    public void setNumMaleta(int ValorInt){
        this.Maletas = ValorInt;
    }
}
