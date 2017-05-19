   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import FORMULARIOS.Login;
import FORMULARIOS.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 */
public class MEmpleado {

    private Conexion mysql = new Conexion(); //Instanciando la clase conexion
    private Connection cn = mysql.conectar();
    private String sSQL = ""; //Sentencia SQL
    public Integer totalRegistros;

    private String cedula;
    private String nombre;
    private String p_apellido;
    private String s_apellido;
    private String telefono;
    private String direccion;
    private String email;
    private String estado;
    private int rol;
    private String usuario;
    private String contrasena;

    public MEmpleado() {
    }

    public MEmpleado(String cedula, String nombre, String p_apellido, String s_apellido, String telefono, String direccion, String email, String estado, int rol, String usuario, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.p_apellido = p_apellido;
        this.s_apellido = s_apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasena = contrasena;
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
        return p_apellido;
    }

    public void setP_apellido(String p_apellido) {
        this.p_apellido = p_apellido;
    }

    public String getS_apellido() {
        return s_apellido;
    }

    public void setS_apellido(String s_apellido) {
        this.s_apellido = s_apellido;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    //---------------------------------------------------------//
    // funcion para insertar
    public boolean insertarEmpleado(MEmpleado empleado) {
        sSQL = "INSERT INTO empleados (cedula,nombre,p_apellido,s_apellido,telefono,direccion,email,estado,rol_id,usuario,contrasena)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, empleado.getCedula());
            pst.setString(2, empleado.getNombre());
            pst.setString(3, empleado.getP_apellido());
            pst.setString(4, empleado.getS_apellido());
            pst.setString(5, empleado.getTelefono());
            pst.setString(6, empleado.getDireccion());
            pst.setString(7, empleado.getEmail());
            pst.setString(8, empleado.getEstado());
            pst.setInt(9, empleado.getRol());
            pst.setString(10, empleado.getUsuario());
            pst.setString(11, empleado.getContrasena());

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

        String[] titulos = {"Contrasena", "Usuario", "Cargo", "Estado", "Email", "Cedula", "Nombre", "Apellido", "S_Apellido", "Telefono", "Direccion"};

        String[] registros = new String[11];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select cedula,nombre,p_apellido,s_apellido,telefono,direccion,email,estado,rol,usuario,contrasena   from empleados join rol on empleados.rol_id = rol.rol_id where cedula like '%" + buscar + "%'"
                + "or nombre like '%" + buscar + "%'";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[5] = rs.getString("cedula");
                registros[6] = rs.getString("nombre");
                registros[7] = rs.getString("p_apellido");
                registros[8] = rs.getString("s_apellido");
                registros[9] = rs.getString("telefono");
                registros[10] = rs.getString("direccion");
                registros[4] = rs.getString("email");
                registros[3] = rs.getString("estado");
                registros[2] = rs.getString("rol");
                registros[1] = rs.getString("usuario");
                registros[0] = rs.getString("contrasena");

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
    public boolean editarEmpleado(MEmpleado empleado) {
        sSQL = "UPDATE empleados SET nombre = ?, p_apellido = ?, s_apellido = ?, telefono = ?, direccion = ?, email = ?, estado = ?, rol_id = ?, usuario = ?, contrasena = ?   where cedula = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, empleado.getNombre());
            pst.setString(2, empleado.getP_apellido());
            pst.setString(3, empleado.getS_apellido());
            pst.setString(4, empleado.getTelefono());
            pst.setString(5, empleado.getDireccion());
            pst.setString(6, empleado.getEmail());
            pst.setString(7, empleado.getEstado());
            pst.setInt(8, empleado.getRol());
            pst.setString(9, empleado.getUsuario());
            pst.setString(10, empleado.getContrasena());
            pst.setString(11, empleado.getCedula());

            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    // funcion para eliminar 
    public boolean eliminarEmpleado(MEmpleado empleado) {
        sSQL = "delete from empleados where cedula = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, empleado.getCedula());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // funcion login
    public static boolean sw = false;

    public void login(String contrasena, String usuario) {

        sSQL = "select * from empleados inner join rol on empleados.rol_id = rol.rol_id where usuario = " + "'" + usuario + "' and contrasena = " + "MD5(" + contrasena + ") and estado = 'Activo'";
        Conexion mysql = new Conexion();
        Connection cn = mysql.conectar();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            if (rs.absolute(1)) {
                
                Principal principal = new Principal();
                principal.setVisible(true);
                sw = true;
                Principal.usuario.setText(rs.getString("nombre") + " " + rs.getString("p_apellido"));
                Principal.cargo.setText(rs.getString("rol"));
                Principal.txtcedula.setText(rs.getString("cedula"));
                if (!Principal.cargo.getText().equals("Administrador")) {
                    Principal.menuherramientas.setEnabled(false);
                    Principal.menuinformes.setEnabled(false);
                    Principal.menuproductos.setEnabled(false);
                    Principal.jButton3.setEnabled(false);
                    Principal.menuPersonal.setEnabled(false);

                }

            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
                sw = false;
            }

        } catch (Exception e) {
        }

    }

    public static ArrayList<String> llenarcombo() {
        ArrayList<String> lista = new ArrayList<String>();
        String sql = "select * from rol";
        Conexion mysql = new Conexion();
        Connection cn = mysql.conectar();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(rs.getString("rol"));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public String GuardarCodigo(String rol) {
        String sSQL = "SELECT rol_id from rol where rol = " + "'" + rol + "'";
        Conexion mysql = new Conexion();
        Connection cn = mysql.conectar();
        ArrayList<String> lista = new ArrayList<String>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                lista.add(rs.getString("rol_id"));
            }
            rol = lista.get(0);
        } catch (Exception e) {
        }
        return rol;
    }

}
