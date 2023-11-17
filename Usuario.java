public class Usuario {
    private String Nombre;
    private String Contrasena;
    private String Plan;
    private boolean Cupon;

    public Usuario(String Nombre, String Contrasena, String Plan, boolean Cupon){
        this.Nombre = Nombre;
        this.Contrasena = Contrasena;
        this.Plan = Plan;
        this.Cupon = Cupon;
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

    boolean getCupon(){
        return Cupon;
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

    public void setCupon(boolean ValorBool){
        this.Cupon = ValorBool;
    }
}
