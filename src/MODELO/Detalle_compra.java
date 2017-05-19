/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author YESID SANCHEZ
 */
public class Detalle_compra {

    private int codigo;
    private int cantidad;
    private int subtotal;
    private int precio_producto;
    private MProducto producto;
    private Factura_compra factura_compra;

    public Detalle_compra() {
    }

    public Detalle_compra(int codigo, int cantidad, int subtotal, int precio_producto, MProducto producto, Factura_compra factura_compra) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.precio_producto = precio_producto;
        this.producto = producto;
        this.factura_compra = factura_compra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public MProducto getProducto() {
        return producto;
    }

    public void setProducto(MProducto producto) {
        this.producto = producto;
    }

    public Factura_compra getFactura_compra() {
        return factura_compra;
    }

    public void setFactura_compra(Factura_compra factura_compra) {
        this.factura_compra = factura_compra;
    }

}
