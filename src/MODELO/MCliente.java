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
public class MCliente {

    private Conexion mysql = new Conexion(); //Instanciando la clase conexion
    private Connection cn = mysql.conectar();
    private String sSQL = ""; //Sentencia SQL
    public Integer totalRegistros;
    private String cedula;
    private String nombre;
    private String P_apellido;
    private String S_apellido;
    private String telefono;
    private String direccion;
    private String email;

    public MCliente() {
    }

    public MCliente(String cedula) {
        this.cedula = cedula;
    }

    public MCliente(String cedula, String nombre, String P_apellido, String S_apellido, String telefono, String direccion, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.P_apellido = P_apellido;
        this.S_apellido = S_apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getP_apellido() {
        return P_apellido;
    }

    public void SetP_apellido(String P_apellido) {
        this.P_apellido = P_apellido;
    }

    public String getS_apellido() {
        return S_apellido;
    }

    public void SetS_apellido(String S_apellido) {
        this.S_apellido = S_apellido;
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

     // funciones para la bd
    // funcion para insertar
    public boolean insertarCliente(MCliente cliente) {
        sSQL = "INSERT INTO cliente (cedula,nombre,p_apellido,s_apellido,telefono,direccion,email) values (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, cliente.getCedula());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getP_apellido());
            pst.setString(4, cliente.getS_apellido());
            pst.setString(5, cliente.getTelefono());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getEmail());
            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    // funcion para mostrar
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Cedula", "Nombre", "P.Apellido", "S.Apellido", "Telefono", "Direccion", "Email"};

        String[] registros = new String[8];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select cedula,nombre,p_apellido,s_apellido,telefono,direccion,email from cliente where cedula like '%" + buscar + "%'"
                + "or nombre like '%" + buscar + "%'";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("cedula");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("p_apellido");
                registros[3] = rs.getString("s_apellido");
                registros[4] = rs.getString("telefono");
                registros[5] = rs.getString("direccion");
                registros[6] = rs.getString("email");
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
    public boolean editarClientes(MCliente cliente) {

        sSQL = "UPDATE cliente SET nombre = ?, p_apellido = ?,s_apellido = ?, telefono = ?,direccion = ?,email = ? where cedula = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getP_apellido());
            pst.setString(3, cliente.getS_apellido());
            pst.setString(4, cliente.getTelefono());
            pst.setString(5, cliente.getDireccion());
            pst.setString(6, cliente.getEmail());
            pst.setString(7, cliente.getCedula());

            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    // funcion para eliminar 
    public boolean eliminarClientes(MCliente cliente) {

        sSQL = "delete from cliente where cedula = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, cliente.getCedula());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    //funcion buscar cliente
    public String buscar(String cedula) {
        Conexion mysql = new Conexion();
        String nombrec = null;
        Connection cn = mysql.conectar();
        sSQL = "select nombre,p_apellido from  cliente where cedula =" + cedula;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                if (rs.absolute(1)) {
                    nombrec = rs.getString("nombre")+" "+rs.getString("p_apellido");

                } 
            }

        } catch (Exception e) {

        }
      return nombrec;
    }
    
    public DefaultTableModel mostrarproductos(int id) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Producto", "Cantidad"};

        String[] registros = new String[2];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT productos.nombre as producto, SUM(detalles_factura.cantidad) as cantidad FROM\n" +
"    facturas INNER join detalles_factura on facturas.facturas_id = detalles_factura.facturas_id INNER join\n" +
"    cliente on facturas.cedula = cliente.cedula INNER JOIN\n" +
"    productos on productos.productos_id = detalles_factura.productos_id where cliente.cedula ="+id+" GROUP by producto";
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("producto");
                registros[1] = rs.getString("cantidad");
         
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }


}
