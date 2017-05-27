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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author YESID SANCHEZ
 */
public class Factura_compra {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();

    private String sSQL = "";
    private int pedido_id;
    private String fecha;
    private int proveedor;
    int empleado_cedula;
    int total;
    

    public Factura_compra() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha = sdf.format(d);
    }

    public Factura_compra(int pedido_id, int proveedor, int empleado_cedula, int total) {
        this.pedido_id = pedido_id;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha = sdf.format(d);
        
        this.proveedor = proveedor;
        this.empleado_cedula = empleado_cedula;
        this.total = total;
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

    public void setPedido_id(int codigo) {
        this.pedido_id = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public int getEmpleado_cedula() {
        return empleado_cedula;
    }

    public void setEmpleado_cedula(int empleado_cedula) {
        this.empleado_cedula = empleado_cedula;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

   
    public boolean insertar(Factura_compra compra){
        
        sSQL = "INSERT INTO pedidos (fecha,proveedores_id,empleados_cedula,total) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setString(1, compra.getFecha());
            pst.setInt(2, compra.getProveedor());
            pst.setInt(3, compra.getEmpleado_cedula());
            pst.setInt(4, compra.getTotal());
            pst.execute();
            return true;
        } catch (Exception e) {
            
            return false;
        }
        
    }
    
    public String ultimoGuardado() {
        String sSQL = "SELECT * FROM pedidos";
        String pedido="";
        int i=0;
        Conexion mysql = new Conexion();
        Connection cn = mysql.conectar();
        ArrayList<String> lista = new ArrayList<String>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                lista.add(rs.getString("pedidos_id"));
                i++;
            }
             pedido = lista.get(i-1);
        } catch (Exception e) {
        }
        return pedido;
    }
    
}
