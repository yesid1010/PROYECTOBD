/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import FORMULARIOS.FrmVentaDetalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YESID SANCHEZ
 */
public class MProducto {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSql = "";
    public Integer totalRegistros;
    private String codigo;
    private String nombre;
    private int existencia;
    private int precio_venta;
    private int precio_compra;
    private int categoria;
    private int cantidad;
    private int total;

    public MProducto() {
    }

    public MProducto(String codigo, String nombre, int precio_venta,int existencia,int cantidad,int categoria,int total) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio_venta = precio_venta;
        this.existencia = existencia;
        this.cantidad = cantidad;
        this.total=total;
        this.categoria =  categoria;
    }
    
    

    public MProducto(String codigo, String nombre, int existencia, int precio_venta, int precio_compra, int categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.existencia = existencia;
        this.precio_venta = precio_venta;
        this.precio_compra = precio_compra;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total= total;
    }
    
   //---------------------------------------------------------//

    // funcion para insertar
    public boolean insertarProducto(MProducto producto) {

        sSql = "insert into productos (productos_id,nombre,existencia,precio_venta,precio_compra,categoria_id)"
                + "value(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setString(1, producto.getCodigo());
            pst.setString(2, producto.getNombre());
            pst.setInt(3, producto.getExistencia());
            pst.setInt(4, producto.getPrecio_venta());
            pst.setInt(5, producto.getPrecio_compra());
            pst.setInt(6, producto.getCategoria());
            pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    // funcion para editar 
    public boolean editarProducto(MProducto producto) {
        sSql = "update productos set nombre = ?, existencia = ?, precio_venta = ?, precio_compra = ?, categoria_id = ? where productos_id = ?";
        try {

            PreparedStatement pst;
            pst = cn.prepareStatement(sSql);
            pst.setString(1, producto.getNombre());
            pst.setInt(2, producto.getExistencia());
            pst.setInt(3, producto.getPrecio_venta());
            pst.setInt(4, producto.getPrecio_compra());
            pst.setInt(5, producto.getCategoria());
            pst.setString(6, producto.getCodigo());
            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    // funcion para eliminar 
    public boolean eliminarProducto(MProducto producto) {

        sSql = "delete  from productos where productos_id = ?";

        try {
            PreparedStatement pst;
            pst = cn.prepareStatement(sSql);

            pst.setString(1, producto.getCodigo());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    // funcion para buscar
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"codigo", "Nombre", "existencia", "Precio_venta", "Precio_compra", "Categoria"};

        String[] registros = new String[7];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "select productos_id,productos.nombre,existencia,precio_venta,precio_compra,categoria.nombre"
                + " from productos inner join categoria on productos.categoria_id = categoria.categoria_id"
                + " where productos_id like '%" + buscar + "%'"
                + "or productos.nombre like '%" + buscar + "%'";
     

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {

                registros[0] = rs.getString("productos_id");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("existencia");
                registros[3] = rs.getString("precio_venta");
                registros[4] = rs.getString("precio_compra");
                registros[5] = rs.getString("categoria.nombre");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public static ArrayList<String> llenarcombo() {
        ArrayList<String> lista = new ArrayList<String>();
        String sql = "select * from categoria";
        Conexion mysql = new Conexion();
        Connection cn = mysql.conectar();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public String GuardarCodigo(String categoria) {
        String sSQL = "SELECT categoria_id from categoria where nombre = " + "'" + categoria + "'";
        Conexion mysql = new Conexion();
        Connection cn = mysql.conectar();
        ArrayList<String> lista = new ArrayList<String>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                lista.add(rs.getString("categoria_id"));
            }
             categoria = lista.get(0);
        } catch (Exception e) {
        }
        return categoria;
    }
    
    //funcion buscar cliente
    public String buscar(String codigo) {
        Conexion mysql = new Conexion();
        String nombrec = null;
        Connection cn = mysql.conectar();
        String sSQL = "select * from  productos where productos_id =" + codigo;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                if (rs.absolute(1)) {
                    FrmVentaDetalle.txtNombre_producto.setText( rs.getString("nombre"));
                    FrmVentaDetalle.txtPrecio_producto.setText(rs.getString("precio_venta"));
                    FrmVentaDetalle.txtexistencia.setText(rs.getString("existencia"));
                    FrmVentaDetalle.txtcategoria.setText(rs.getString("categoria_id"));
                } 
            }

        } catch (Exception e) {

        }
      return nombrec;
    }
}
