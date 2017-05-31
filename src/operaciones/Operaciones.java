/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import ORM.Categoria;
import ORM.Cliente;
import ORM.Proveedores;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author EMERITA
 */
public class Operaciones {

    public boolean insertar(Object objet) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(objet);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "ingresado correctamente");
        return true;
    }

    public boolean editar(Object objet) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.update(objet);
        tx.commit();
        session.close();

        return true;
    }

    public boolean eliminar(Object objet) {

        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(objet);
        tx.commit();
        session.close();

        return true;
    }

    public DefaultTableModel listaCategorias() throws HibernateException {
        ArrayList<Categoria> listaContactos = null;

        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        listaContactos = (ArrayList<Categoria>) session.createQuery("from Categoria").list();
        session.close();

        DefaultTableModel modelo;
        String[] titulos = {"codigo", "Nombre"};
        modelo = new DefaultTableModel(null, titulos);
        
        String[] registros = new String[2];
        for (Categoria c : listaContactos) {
            registros[0] = String.valueOf(c.getCategoriaId());
            registros[1] = c.getNombre();
            modelo.addRow(registros);
        }
        return modelo;
    }
    
     public DefaultTableModel listaClientes() throws HibernateException {
        ArrayList<Cliente> lista = null;

        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        lista = (ArrayList<Cliente>) session.createQuery("from Cliente").list();
        session.close();

        DefaultTableModel modelo;
        String[] titulos = {"Cedula", "Nombre","P.Apellido","S.Apellido","Telefono","Direccion","Email"};
        modelo = new DefaultTableModel(null, titulos);
        
        String[] registros = new String[7];
        for (Cliente c : lista) {
            registros[0] = String.valueOf(c.getCedula());
            registros[1] = c.getNombre();
            registros[2] = c.getPApellido();
            registros[3]= c.getSApellido();
            registros[4] = c.getTelefono();
            registros[5] = c.getDireccion();
            registros[6] = c.getEmail();
            modelo.addRow(registros);
        }
        return modelo;
    }
    
     public DefaultTableModel listaProveedores() throws HibernateException {
        ArrayList<Proveedores> lista = null;

        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        lista = (ArrayList<Proveedores>) session.createQuery("from Proveedores").list();
        session.close();

        DefaultTableModel modelo;
        String[] titulos = {"Nit", "Nombre","Telefono","Direccion","Email"};
        modelo = new DefaultTableModel(null, titulos);
        
        String[] registros = new String[5];
        for (Proveedores c : lista) {
            registros[0] = String.valueOf(c.getProveedoresId());
            registros[1] = c.getNombre();
            registros[2] = c.getTelefono();
            registros[3] = c.getDireccion();
            registros[4] = c.getEmail();
            modelo.addRow(registros);
        }
        return modelo;
    }
    
}
