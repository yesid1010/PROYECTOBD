/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
