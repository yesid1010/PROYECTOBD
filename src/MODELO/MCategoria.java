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
public class MCategoria {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    public Integer totalRegistros;
    private String sSql;
    private int codigo;
    private String nombre;

    public MCategoria() {
    }

    public MCategoria(int codigo, String nombre) {
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
    public boolean insertarCategoria(MCategoria categoria) {

        sSql = "insert into categoria (nombre) value(?)";
        try {
            PreparedStatement pst;
            pst = cn.prepareStatement(sSql);

            pst.setString(1, categoria.getNombre());
            pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // funcion para editar 
    public boolean editarCategoria(MCategoria categoria) {

        sSql = "update categoria set nombre = ? where categoria_id = ?";

        try {
            PreparedStatement pst;
            pst = cn.prepareStatement(sSql);
            pst.setString(1, categoria.getNombre());
            pst.setInt(2, categoria.getCodigo());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    // funcion para eliminar 
    public boolean eliminarCategoria(MCategoria categoria) {
        sSql = "delete from categoria where categoria_id = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            pst.setInt(1, categoria.getCodigo());
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

        sSql = "select categoria_id,nombre from categoria where categoria_id like '%" + buscar + "%'"
                + "or nombre like '%" + buscar + "%'";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {

                registros[0] = rs.getString("categoria_id");
                registros[1] = rs.getString("nombre");
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
