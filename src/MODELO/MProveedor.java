/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YESID SANCHEZ
 */
public class MProveedor {

    private Conexion mysql = new Conexion(); //Instanciando la clase conexion
    private Connection cn = mysql.conectar();
    private String sSQL = ""; //Sentencia SQL
    public Integer totalRegistros;
    private String nit;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;

    public MProveedor() {
    }

    public MProveedor(String nit, String nombre, String telefono, String direccion, String email) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //---------------------------------------------------------//
     // funcion para insertar
    public boolean insertarProveedor(MProveedor proveedor) {
        sSQL = "INSERT INTO proveedores (proveedores_id,nombre,telefono,direccion,email) values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, proveedor.getNit());
            pst.setString(2, proveedor.getNombre());
            pst.setString(3, proveedor.getTelefono());
            pst.setString(4, proveedor.getDireccion());
            pst.setString(5, proveedor.getEmail());
            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }
    
   // funcion mostrar
    
     public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Nit", "Nombre",
                    "Telefono", "Direccion",
                    "Email"};

        String[] registros = new String[6];
         totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select proveedores_id,nombre,telefono,direccion,email from proveedores where proveedores_id like '%"+buscar+"%'"
                + "or nombre like '%"+buscar+"%'";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("proveedores_id");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("telefono");
                registros[3] = rs.getString("direccion");
                registros[4] = rs.getString("email");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
     
    // funcion para editar 
    public boolean editarProveedor(MProveedor proveedor) {
        sSQL = "UPDATE proveedores SET nombre = ?,telefono = ?,direccion = ?,email = ? where proveedores_id = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, proveedor.getNombre());
            pst.setString(2, proveedor.getTelefono());
            pst.setString(3, proveedor.getDireccion());
            pst.setString(4, proveedor.getEmail());
            pst.setString(5, proveedor.getNit());
            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    // funcion para eliminar 
    public boolean eliminarProveedor(MProveedor proveedor) {
     sSQL = "delete from proveedores where proveedores_id = ?";
        try {
             PreparedStatement pst = cn.prepareStatement(sSQL);
             pst.setString(1, proveedor.getNit());
             pst.executeUpdate();
             return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String buscar(String nit) {
        Conexion mysql = new Conexion();
        String nombrec = null;
        Connection cn = mysql.conectar();
        sSQL = "select * from  proveedores where proveedores_id =" + nit;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                if (rs.absolute(1)) {
                    nombrec = rs.getString("nombre");
                } 
            }

        } catch (Exception e) {

        }
      return nombrec;
    }
}
