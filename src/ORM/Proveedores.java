package ORM;
// Generated 29/05/2017 06:15:36 PM by Hibernate Tools 4.3.1



/**
 * Proveedores generated by hbm2java
 */
public class Proveedores  implements java.io.Serializable {


     private Integer proveedoresId;
     private String nombre;
     private String telefono;
     private String direccion;
     private String email;

    public Proveedores() {
    }

    public Proveedores(String nombre, String telefono, String direccion, String email) {
       this.nombre = nombre;
       this.telefono = telefono;
       this.direccion = direccion;
       this.email = email;
    }
   
    public Integer getProveedoresId() {
        return this.proveedoresId;
    }
    
    public void setProveedoresId(Integer proveedoresId) {
        this.proveedoresId = proveedoresId;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

