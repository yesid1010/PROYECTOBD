/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author YESID SANCHEZ
 */
public class Factura_compra {
    private String codigo;
    private String fecha;
    private int total;
    private int numero_factura;
    private int proveedor;

    public Factura_compra() {
    }

    public Factura_compra(String codigo, int total, int numero_factura, int proveedor) {
        this.codigo = codigo;
        this.total = total;
        this.numero_factura = numero_factura;
        this.proveedor = proveedor;
        Date date = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha = sdf.format(date);
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(int numero_factura) {
        this.numero_factura = numero_factura;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }
    
    
}
