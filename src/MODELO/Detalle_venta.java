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
public class Detalle_venta {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();

    private String sSQL = "";
    int factura_id;
    int producto_id;
    int catidad;
    int precioP;

    public Detalle_venta() {
    }

    public Detalle_venta(int factura_id, int producto_id, int catidad, int precioP) {
        this.factura_id = factura_id;
        this.producto_id = producto_id;
        this.catidad = catidad;
        this.precioP = precioP;
    }

    public int getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(int factura_id) {
        this.factura_id = factura_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }

    public int getPrecioP() {
        return precioP;
    }

    public void setPrecioP(int precioP) {
        this.precioP = precioP;
    }

    public boolean insertar(Detalle_venta detalle) {
      
        sSQL = "INSERT INTO detalles_factura (facturas_id,productos_id,cantidad,precioP) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement  pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, detalle.getFactura_id());
            pst.setInt(2, detalle.getProducto_id());
            pst.setInt(3, detalle.getCatidad());
            pst.setInt(4, detalle.getPrecioP());
            pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public DefaultTableModel mostrar() {

        DefaultTableModel modelo;

        String[] titulos = {"codigo", "Nombre", "precio", "cantidad", "existencia", "total"};

        modelo = new DefaultTableModel(null, titulos);

        return modelo;
    }

}
