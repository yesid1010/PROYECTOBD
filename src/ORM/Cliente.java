package ORM;
// Generated 29/05/2017 06:15:36 PM by Hibernate Tools 4.3.1



/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int cedula;
     private String nombre;
     private String PApellido;
     private String SApellido;
     private String telefono;
     private String direccion;
     private String email;

    public Cliente() {
    }
    
    public Cliente(int cedula){
        this.cedula = cedula;
    }
    public Cliente(int cedula, String nombre, String PApellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.PApellido = PApellido;
    }
    public Cliente(int cedula, String nombre, String PApellido, String SApellido, String telefono, String direccion, String email) {
       this.cedula = cedula;
       this.nombre = nombre;
       this.PApellido = PApellido;
       this.SApellido = SApellido;
       this.telefono = telefono;
       this.direccion = direccion;
       this.email = email;
    }
   
    public int getCedula() {
        return this.cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPApellido() {
        return this.PApellido;
    }
    
    public void setPApellido(String PApellido) {
        this.PApellido = PApellido;
    }
    public String getSApellido() {
        return this.SApellido;
    }
    
    public void setSApellido(String SApellido) {
        this.SApellido = SApellido;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}

