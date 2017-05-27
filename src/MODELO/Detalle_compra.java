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
public class Detalle_compra {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();

    private String sSQL = "";
    int pedido_id;
    int productos_id;
    int catidad;
    int precioP;

    public Detalle_compra() {
    }

    public Detalle_compra(int pedido_id, int productos_id, int catidad, int precioP) {
        this.pedido_id = pedido_id;
        this.productos_id = productos_id;
        this.catidad = catidad;
        this.precioP = precioP;
    }

    public Conexion getMysql() {
        return mysql;
    }

    public void setMysql(Conexion mysql) {
        this.mysql = mysql;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public String getsSQL() {
        return sSQL;
    }

    public void setsSQL(String sSQL) {
        this.sSQL = sSQL;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public int getProductos_id() {
        return productos_id;
    }

    public void setProductos_id(int productos_id) {
        this.productos_id = productos_id;
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
    
    public boolean insertar(Detalle_compra detalle) {

        sSQL = "INSERT INTO detalles_pedidos (pedidos_id,productos_id,cantidad,precioP) VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, detalle.getPedido_id());
            pst.setInt(2, detalle.getProductos_id());
            pst.setInt(3, detalle.getCatidad());
            pst.setInt(4, detalle.getPrecioP());
            pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar (Detalle_compra compra){
        sSQL= "DELETE FROM detalles_pedidos WHERE pedidos_id = ? and productos_id = ?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, compra.getPedido_id());
            pst.setInt(2, compra.getProductos_id());
            pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public DefaultTableModel mostrar(String id) {

        DefaultTableModel modelo;

        String[] titulos = {"Producto", "Precio", "Cantidad", "Total","codigoP","codigoV"};

        String[] registros = new String[6];
        // totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select pedidos.pedidos_id as pedido ,detalles_pedidos.productos_id as codigop,productos.nombre as producto, productos.precio_venta as precio,\n"
                + "     detalles_pedidos.cantidad, (productos.precio_venta*detalles_pedidos.cantidad) as total\n"
                + "     FROM pedidos INNER join detalles_pedidos on \n"
                + "     pedidos.pedidos_id = detalles_pedidos.pedidos_id\n"
                + "     INNER join productos on detalles_pedidos.productos_id = productos.productos_id \n"
                + "     where detalles_pedidos.pedidos_id =" + id;
        
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("producto");
                registros[1] = rs.getString("precio");
                registros[2] = rs.getString("detalles_pedidos.cantidad");
                registros[3] = rs.getString("total");
                registros[4] = rs.getString("codigop");
                registros[5] = rs.getString("pedido");
                //totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
}
