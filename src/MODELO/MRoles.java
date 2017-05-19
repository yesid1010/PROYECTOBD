/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YESID SANCHEZ
 */
public class MRoles {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    public Integer totalRegistros;
    private String sSql;
    private int codigo;
    private String nombre;

    public MRoles() {
    }

    public MRoles(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     //---------------------------------------------------------//
     // funcion para insertar
    public boolean insertarRol(MRoles roles) {

        sSql = "insert into rol (rol) value(?)";
        try {
            PreparedStatement pst;
            pst = cn.prepareStatement(sSql);

            pst.setString(1, roles.getNombre());
            pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // funcion para editar 
    public boolean editarRol(MRoles rol) {

        sSql = "update rol set rol = ? where rol_id = ?";

        try {
            PreparedStatement pst;
            pst = cn.prepareStatement(sSql);
            pst.setString(1, rol.getNombre());
            pst.setInt(2, rol.getCodigo());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    // funcion para eliminar 
    public boolean eliminarRol(MRoles rol) {
        sSql = "delete from rol where rol_id = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            pst.setInt(1, rol.getCodigo());
            pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }        
    }

   // funcion para buscar
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"codigo", "Nombre"};

        String[] registros = new String[2];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "select rol_id,rol from rol where rol_id like '%" + buscar + "%'"
                + "or rol like '%" + buscar + "%'";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {

                registros[0] = rs.getString("rol_id");
                registros[1] = rs.getString("rol");
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
