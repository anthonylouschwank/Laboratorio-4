public class Usuario {
    private String Nombre;
    private String Contrasena;
    private String Plan;

    public Usuario(String Nombre, String Contrasena, String Plan){
        this.Nombre = Nombre;
        this.Contrasena = Contrasena;
        this.Plan = Plan;
    }

    String getNombre(){
        return Nombre;
    }

    String getContrasena(){
        return Contrasena;
    }

    String getPlan(){
        return Plan;
    }

    public void setNombre(String ValorString){
        this.Nombre = ValorString;
    }

    public void setContrasena(String ValorString){
        this.Contrasena = ValorString;
    }

    public void setPlan(String ValorString){
        this.Plan = ValorString;
    }
}
