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
public class Factura_venta {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();

    private String sSQL = "";
    int factura_id;
    String fecha;
    int clinete_cedula;
    int empleado_cedula;
    int total;

    public Factura_venta() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha = sdf.format(d);
    }

    public Factura_venta(int factura_id,int clinete_cedula, int empleado_cedula,int total) {
        this.factura_id = factura_id;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha = sdf.format(d);
        this.clinete_cedula = clinete_cedula;
        this.empleado_cedula = empleado_cedula;
        this.total= total;
    }

    public int getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(int factura_id) {
        this.factura_id = factura_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getClinete_cedula() {
        return clinete_cedula;
    }

    public void setClinete_cedula(int clinete_cedula) {
        this.clinete_cedula = clinete_cedula;
    }

    public int getEmpleado_cedula() {
        return empleado_cedula;
    }

    public void setEmpleado_cedula(int empleado_cedula) {
        this.empleado_cedula = empleado_cedula;
    }
    
    public int getTotal(){
        return total;
    }
    
    public void setTotal(int total){
        this.total= total;
    }
    
    public boolean insertar(Factura_venta venta){
        
        sSQL = "INSERT INTO facturas (fecha,cedula,empleados_cedula,total) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setString(1, venta.getFecha());
            pst.setInt(2, venta.getClinete_cedula());
            pst.setInt(3, venta.getEmpleado_cedula());
            pst.setInt(4, venta.getTotal());
            pst.execute();
            return true;
        } catch (Exception e) {
            
            return false;
        }
        
    }
    
    public String ultimoGuardado() {
        String sSQL = "SELECT * FROM facturas";
        String factura="";
        int i=0;
        Conexion mysql = new Conexion();
        Connection cn = mysql.conectar();
        ArrayList<String> lista = new ArrayList<String>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                lista.add(rs.getString("facturas_id"));
                i++;
            }
             factura = lista.get(i-1);
        } catch (Exception e) {
        }
        return factura;
    }
    
}
