package agendatelefonica;

public class Contactos {
    //atributos
    private String nombre, numero, domicilio;
    
    public Contactos(String nombre,String numero, String domicilio){
        this.nombre=nombre;
        this.numero=numero;
        this.domicilio=domicilio;
    }
    public String verNombre(){
        return this.nombre;
    }
    public String verNumero(){
        return this.numero;
    }
    public String verDomicilio(){
        return this.domicilio;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }
}
