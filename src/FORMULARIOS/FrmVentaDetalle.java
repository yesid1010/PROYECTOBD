package FORMULARIOS;

import MODELO.Conexion;
import MODELO.Detalle_venta;
import MODELO.Factura_venta;
import MODELO.MCliente;
import MODELO.MProducto;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmVentaDetalle extends javax.swing.JInternalFrame {

    int totaltodo = 0, total2 = 0;
    // DecimalFormat formatea = new DecimalFormat("#,###.##");
    private ArrayList<MProducto> productos;
    private Conexion mysql = new Conexion(); //Instanciando la clase conexion
    private Connection cn = mysql.conectar();

    public FrmVentaDetalle() {
        initComponents();
        mostrar();
        txtproducto2.setVisible(false);
        productos = new ArrayList<>();

        desactivar();
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        jTabla.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                l.setBackground(new java.awt.Color(36, 33, 33));
                l.setForeground(new java.awt.Color(25, 118, 210));
                l.setFont(new java.awt.Font("Arial", 1, 12));
                return l;
            }
        });
    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            Detalle_venta detalle = new Detalle_venta();
            modelo = detalle.mostrar1();
            jTabla.setModel(modelo);
            ocultarcolumna(4);
        } catch (Exception e) {
        }
    }

    public void desactivar() {

        txtCantidadProducto.setEditable(false);
        txtCod_producto.setEditable(false);

        txtImporte.setEnabled(false);
        txtNombre_producto.setEditable(false);

        txtcliente.setEditable(false);
        txtPrecio_producto.setEditable(false);

        btnAgregarProducto.setEnabled(false);
        btnCalcular.setEnabled(false);
        btnQuitarProducto.setEnabled(false);
        btnbuscarProducto.setEnabled(false);
        txtcategoria.setVisible(false);
        txtexistencia.setVisible(false);
        txtSubTotal.setText("");
        DefaultTableModel dtm = (DefaultTableModel) jTabla.getModel();
        int filas = dtm.getRowCount();

                    for (int i = 1; i <= filas; i++) {

                        dtm.removeRow(0);
                        productos.clear();

                    }

    }

    public void activar() {

        txtCantidadProducto.setEditable(true);
        txtCod_producto.setEditable(true);

        txtImporte.setEnabled(true);
        txtcliente.setEditable(false);

        btnAgregarProducto.setEnabled(true);
        btnCalcular.setEnabled(true);
        btnQuitarProducto.setEnabled(true);
        btnbuscarProducto.setEnabled(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        txtcliente = new javax.swing.JTextField();
        btncliente = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCod_producto = new javax.swing.JTextField();
        txtNombre_producto = new javax.swing.JTextField();
        txtPrecio_producto = new javax.swing.JTextField();
        txtCantidadProducto = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        btnbuscarProducto = new javax.swing.JButton();
        btnQuitarProducto = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtexistencia = new javax.swing.JTextField();
        txtcategoria = new javax.swing.JTextField();
        txtproducto2 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setBackground(new java.awt.Color(36, 33, 33));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(36, 33, 33));

        jPanel3.setBackground(new java.awt.Color(36, 33, 33));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(207, 207, 207));
        jLabel6.setText("Cedula : ");

        txtcedula.setBackground(new java.awt.Color(36, 33, 33));
        txtcedula.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtcedula.setForeground(new java.awt.Color(207, 207, 207));
        txtcedula.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtcedula.setCaretColor(new java.awt.Color(255, 255, 255));
        txtcedula.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(207, 207, 207));
        jLabel1.setText("Cliente : ");

        btnBuscarCliente.setBackground(new java.awt.Color(36, 33, 33));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        txtcliente.setBackground(new java.awt.Color(36, 33, 33));
        txtcliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtcliente.setForeground(new java.awt.Color(207, 207, 207));
        txtcliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtcliente.setCaretColor(new java.awt.Color(255, 255, 255));
        txtcliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtclienteKeyTyped(evt);
            }
        });

        btncliente.setBackground(new java.awt.Color(51, 51, 51));
        btncliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/usuarioMenu.png"))); // NOI18N
        btncliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclienteActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcedula)))
                .addGap(18, 18, 18)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btncliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabla.setBackground(new java.awt.Color(36, 33, 33));
        jTabla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabla.setForeground(new java.awt.Color(207, 207, 207));
        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod producto", "Nombre", "Precio", "Cantidad", "Existencia"
            }
        ));
        jTabla.setRowHeight(20);
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabla);

        jPanel5.setBackground(new java.awt.Color(36, 33, 33));

        jPanel7.setBackground(new java.awt.Color(238, 238, 238));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("SUB TOTAL");

        txtSubTotal.setEditable(false);
        txtSubTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtSubTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtSubTotal.setText("0");
        txtSubTotal.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSubTotal.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtSubTotal.setVerifyInputWhenFocusTarget(false);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/coins17_1.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("IMPORTE");

        txtImporte.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtImporte.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImporteActionPerformed(evt);
            }
        });
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImporteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImporteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtImporteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 69, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtImporte, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtSubTotal))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(207, 207, 207))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(36, 33, 33));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(207, 207, 207));
        jLabel11.setText("Cantidad :");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(207, 207, 207));
        jLabel12.setText("Precio :");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(207, 207, 207));
        jLabel7.setText("Producto :");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(207, 207, 207));
        jLabel10.setText("Codigo :");

        txtCod_producto.setBackground(new java.awt.Color(36, 33, 33));
        txtCod_producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCod_producto.setForeground(new java.awt.Color(207, 207, 207));
        txtCod_producto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtCod_producto.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCod_producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCod_producto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCod_productoCaretUpdate(evt);
            }
        });
        txtCod_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_productoActionPerformed(evt);
            }
        });
        txtCod_producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCod_productoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCod_productoKeyTyped(evt);
            }
        });

        txtNombre_producto.setBackground(new java.awt.Color(36, 33, 33));
        txtNombre_producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombre_producto.setForeground(new java.awt.Color(207, 207, 207));
        txtNombre_producto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtNombre_producto.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNombre_producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombre_producto.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                txtNombre_productoMouseWheelMoved(evt);
            }
        });
        txtNombre_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_productoActionPerformed(evt);
            }
        });

        txtPrecio_producto.setBackground(new java.awt.Color(36, 33, 33));
        txtPrecio_producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPrecio_producto.setForeground(new java.awt.Color(207, 207, 207));
        txtPrecio_producto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtPrecio_producto.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPrecio_producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecio_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio_productoActionPerformed(evt);
            }
        });

        txtCantidadProducto.setBackground(new java.awt.Color(36, 33, 33));
        txtCantidadProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCantidadProducto.setForeground(new java.awt.Color(207, 207, 207));
        txtCantidadProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtCantidadProducto.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCantidadProducto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCantidadProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadProductoActionPerformed(evt);
            }
        });
        txtCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyTyped(evt);
            }
        });

        btnAgregarProducto.setBackground(new java.awt.Color(36, 33, 33));
        btnAgregarProducto.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(207, 207, 207));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Agregarr.png"))); // NOI18N
        btnAgregarProducto.setMnemonic('a');
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnbuscarProducto.setBackground(new java.awt.Color(36, 33, 33));
        btnbuscarProducto.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnbuscarProducto.setForeground(new java.awt.Color(207, 207, 207));
        btnbuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        btnbuscarProducto.setText(" ");
        btnbuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarProductoActionPerformed(evt);
            }
        });

        btnQuitarProducto.setBackground(new java.awt.Color(36, 33, 33));
        btnQuitarProducto.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnQuitarProducto.setForeground(new java.awt.Color(207, 207, 207));
        btnQuitarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Quitar.png"))); // NOI18N
        btnQuitarProducto.setMnemonic('s');
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCod_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio_producto)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre_producto)))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbuscarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(btnQuitarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(btnbuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCod_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrecio_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(btnQuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCalcular.setBackground(new java.awt.Color(36, 33, 33));
        btnCalcular.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnCalcular.setForeground(new java.awt.Color(207, 207, 207));
        btnCalcular.setMnemonic('c');
        btnCalcular.setText("Registrar Venta");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(36, 33, 33));
        btncancelar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(207, 207, 207));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/CErrar2.png"))); // NOI18N
        btncancelar.setMnemonic('c');
        btncancelar.setText("Cancelar Venta");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(207, 207, 207));
        jLabel16.setText("FORMULARIO DE VENTAS");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/CErrar2.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(389, 389, 389)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(19, 19, 19))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtexistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtproducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtexistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtproducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarProductoActionPerformed
        Productotabla prd = new Productotabla();
        prd.setVisible(true);

    }//GEN-LAST:event_btnbuscarProductoActionPerformed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked


    }//GEN-LAST:event_jTablaMouseClicked

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        int precio = 0, existencia = 0, categoria = 0, cantidad = 0, total = 0, j = 0;
        String codigo = null, nombre = null;
        String sql = "UPDATE productos SET existencia = ? Where productos_id = ?";
        boolean bandera = false;
        if (txtCantidadProducto.getText().equals("") || txtCod_producto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No se admiten campos vacios.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int stock = Integer.valueOf(txtexistencia.getText());
            int cantidad2 = Integer.valueOf(txtCantidadProducto.getText());
            if (cantidad2 > stock) {
                JOptionPane.showMessageDialog(null, "!SOBREPASA! la cantidad de stock\nStock disponible " + stock);

            } else {

                for (j = 0; j < productos.size(); j++) {

                    String codigo2 = productos.get(j).getCodigo();

                    if (codigo2.equals(txtCod_producto.getText())) {
                        bandera = true;
                        break;
                    }
                }

                if (bandera) {

                    codigo = (txtCod_producto.getText());
                    nombre = (txtNombre_producto.getText());
                    precio = (Integer.valueOf(txtPrecio_producto.getText()));
                    existencia = Integer.valueOf(txtexistencia.getText());
                    categoria = Integer.valueOf(txtcategoria.getText());
                    int cantidad1 = Integer.valueOf(txtCantidadProducto.getText());
                    cantidad2 = Integer.valueOf(productos.get(j).getCantidad());
                    cantidad = cantidad1 + cantidad2;
                    total = Integer.valueOf(cantidad * precio);
                    txtexistencia.setText(String.valueOf(stock - cantidad1));
                    int existencia2 = Integer.valueOf(txtexistencia.getText());

                    try {

                        PreparedStatement pst = cn.prepareStatement(sql);

                        MProducto producto = new MProducto(codigo, nombre, precio, existencia2, cantidad, categoria, total);

                        productos.set(j, producto);

                        pst.setInt(1, Integer.valueOf(txtexistencia.getText()));
                        pst.setInt(2, Integer.valueOf(txtCod_producto.getText()));

                        pst.executeUpdate();

                        actualizartabla();
                    } catch (Exception e) {
                    }

                  

                } else {
                    codigo = (txtCod_producto.getText());
                    nombre = (txtNombre_producto.getText());
                    precio = (Integer.valueOf(txtPrecio_producto.getText()));
                    existencia = Integer.valueOf(txtexistencia.getText());
                    categoria = Integer.valueOf(txtcategoria.getText());
                    cantidad = Integer.valueOf(txtCantidadProducto.getText());
                    total = Integer.valueOf(cantidad * precio);
                    txtexistencia.setText(String.valueOf(stock - cantidad));
                    int stock2 = Integer.valueOf(txtexistencia.getText());

                    try {
                        PreparedStatement pst = cn.prepareStatement(sql);

                        MProducto producto = new MProducto(codigo, nombre, precio, existencia, cantidad, categoria, total);
                        productos.add(producto);

                        pst.setInt(1, Integer.valueOf(txtexistencia.getText()));
                        pst.setInt(2, Integer.valueOf(txtCod_producto.getText()));

                        pst.executeUpdate();

                        actualizartabla();
                    } catch (Exception e) {
                    }

                }

            }

        }
        txtCod_producto.setText("");
        txtNombre_producto.setText("");
        txtPrecio_producto.setText("");
        txtCantidadProducto.setText("");

    }//GEN-LAST:event_btnAgregarProductoActionPerformed


    private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed
        String sql = "UPDATE productos SET existencia = ? Where productos_id = ?";
        int i, cantidad, stock2;
        i = this.jTabla.getSelectedRow();

        DefaultTableModel dtm = (DefaultTableModel) jTabla.getModel();
        try {

            cantidad = productos.get(i).getCantidad();
            stock2 = productos.get(i).getExistencia() - cantidad;

            int stocknuevo = 0;
            stocknuevo = stock2 + cantidad;
            txtproducto2.setText(jTabla.getValueAt(i, 0).toString());

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, stocknuevo);
            pst.setNString(2, productos.get(i).getCodigo());

            int valor = JOptionPane.showConfirmDialog(this, "¿Seguro que desea ejecutar esta accion?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (valor == JOptionPane.YES_OPTION) {
                pst.executeUpdate();
                productos.remove(jTabla.getSelectedRow());
                dtm.removeRow(jTabla.getSelectedRow());
            }
            actualizarPrecio();

        } catch (Exception e) {
        }


    }//GEN-LAST:event_btnQuitarProductoActionPerformed

    public void actualizartabla() {
        DefaultTableModel modelo;
        Detalle_venta detalle = new Detalle_venta();
        modelo = detalle.mostrar1();
        jTabla.setModel(modelo);

        for (int i = 0; i < productos.size(); i++) {
            Object nuevaFila[] = {productos.get(i).getCodigo(), productos.get(i).getNombre(), productos.get(i).getPrecio_venta(), productos.get(i).getCantidad(), productos.get(i).getExistencia() - productos.get(i).getCantidad(), productos.get(i).getTotal()};
            modelo.addRow(nuevaFila);
        }
        ocultarcolumna(4);
        actualizarPrecio();
    }

    public void actualizarPrecio() {
        for (int j = 0; j < productos.size(); j++) {
            totaltodo += productos.get(j).getTotal();
        }
        txtSubTotal.setText(String.valueOf(totaltodo));
        totaltodo = 0;
    }

    void ocultarcolumna(int n) {
        jTabla.getColumnModel().getColumn(n).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(n).setMinWidth(0);
        jTabla.getColumnModel().getColumn(n).setPreferredWidth(0);
    }
    private void txtNombre_productoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_txtNombre_productoMouseWheelMoved

    }//GEN-LAST:event_txtNombre_productoMouseWheelMoved

    private void txtCod_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_productoActionPerformed


    }//GEN-LAST:event_txtCod_productoActionPerformed

    private void txtCod_productoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCod_productoCaretUpdate

    }//GEN-LAST:event_txtCod_productoCaretUpdate


    private void txtCantidadProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadProductoActionPerformed

    }//GEN-LAST:event_txtCantidadProductoActionPerformed

    private void txtPrecio_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio_productoActionPerformed

    }//GEN-LAST:event_txtPrecio_productoActionPerformed

    private void txtCod_productoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_productoKeyTyped
          char car = evt.getKeyChar();

        if ((car < '0' || car > '9') && txtCod_producto.getText().contains(".")
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo se admiten numeros");
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo se admiten numeros");
        }

    }//GEN-LAST:event_txtCod_productoKeyTyped

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTabla.getModel();
        if (jTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "no hay productos en la lista ");
        } else {
            if (txtImporte.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese el importe");
            } else {
                int importe = Integer.parseInt(txtImporte.getText());
                int total2 = Integer.parseInt(txtSubTotal.getText());

                if (importe < total2) {
                    JOptionPane.showMessageDialog(null, "El importe debe ser mayor que el total de la venta");
                } else {

                    Factura_venta venta = new Factura_venta();

                    venta.setFecha(venta.getFecha());
                    venta.setClinete_cedula(Integer.valueOf(txtcedula.getText()));
                    venta.setEmpleado_cedula(Integer.valueOf(Principal.txtcedula.getText()));
                    int total = Integer.valueOf(txtSubTotal.getText());
                    venta.setTotal(total);
                    if (venta.insertar(venta)) {

                        for (int i = 0; i < jTabla.getRowCount(); i++) {

                            int producto = Integer.parseInt(jTabla.getValueAt(i, 0).toString());
                            int cantidad = Integer.parseInt(jTabla.getValueAt(i, 3).toString());
                            int precioP = Integer.parseInt(jTabla.getValueAt(i, 2).toString());

                            Detalle_venta detalle = new Detalle_venta();
                            detalle.setProducto_id(producto);
                            detalle.setCatidad(cantidad);
                            detalle.setPrecioP(precioP);
                            detalle.setFactura_id(Integer.parseInt(venta.ultimoGuardado()));

                            if (detalle.insertar(detalle)) {
                                //JOptionPane.showMessageDialog(null, "detalle guardado correctamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "error al guardar el detalle");
                            }

                        }

                        int cambio = Factura_venta.cambio(Integer.parseInt(txtImporte.getText()), Integer.parseInt(txtSubTotal.getText()));
                        JOptionPane.showMessageDialog(null, "Cambio :\n" + cambio);

                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar la venta");
                    }
                    desactivar();
                    txtcedula.setEditable(true);
                    txtcedula.setText("");
                    txtcliente.setText("");
                    txtImporte.setText("");

                    txtCod_producto.setText("");
                    txtNombre_producto.setText("");
                    txtPrecio_producto.setText("");
                    

                }
            }

    }//GEN-LAST:event_btnCalcularActionPerformed
    }
    /*select facturas.facturas_id as factura,productos.nombre as producto, productos.precio_venta as precio,
     detalles_factura.cantidad, (productos.precio_venta*detalles_factura.cantidad) as total
     FROM facturas INNER join detalles_factura on 
     facturas.facturas_id = detalles_factura.facturas_id
     INNER join productos on detalles_factura.productos_id = productos.productos_id 
     where detalles_factura.facturas_id = 2*/
    
    /*SELECT cliente.nombre as cliente,productos.nombre as producto, detalles_factura.cantidad FROM
    facturas INNER join detalles_factura on facturas.facturas_id = detalles_factura.facturas_id INNER join
    cliente on facturas.cedula = cliente.cedula INNER JOIN
    productos on productos.productos_id = detalles_factura.productos_id where cliente.cedula = 132*/
    

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed

        if (txtcedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
        } else {
            MCliente cliente = new MCliente();

            String cedula = txtcedula.getText();
            String nombre = cliente.buscar(cedula);
            txtcliente.setText(nombre);

            if (!txtcliente.getText().equals("")) {
                activar();
                txtcedula.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario NO Registrado");
                desactivar();
            }
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyTyped
      char car = evt.getKeyChar();

        if ((car < '0' || car > '9') && txtCantidadProducto.getText().contains(".")
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo se admiten numeros");
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo se admiten numeros");
        }

    }//GEN-LAST:event_txtCantidadProductoKeyTyped

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
      if (jTabla.getRowCount() != 0) {
            JOptionPane.showMessageDialog(null, "Por favor quitar los articulos de la tabla");
        } else {
            int aceptar = JOptionPane.showConfirmDialog(this, "¿Seguro que desea ejecutar esta accion", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (aceptar == JOptionPane.YES_OPTION) {
                desactivar();
                this.dispose();
            }
        }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void txtImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyTyped

        char car = evt.getKeyChar();

        if ((car < '0' || car > '9') && txtImporte.getText().contains(".")
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo se admiten numeros");
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo se admiten numeros");
        }

    }//GEN-LAST:event_txtImporteKeyTyped

    private void txtNombre_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_productoActionPerformed

    }//GEN-LAST:event_txtNombre_productoActionPerformed

    private void txtclienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteKeyTyped

    private void btnclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclienteActionPerformed
        // TODO add your handling code here:

        Cliente2 cliente = new Cliente2();
        cliente.setVisible(true);

    }//GEN-LAST:event_btnclienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        desactivar();
        txtcedula.setEditable(true);
        txtcedula.setText("");
        txtcliente.setText("");
        txtImporte.setText("");

        txtCod_producto.setText("");
        txtNombre_producto.setText("");
        txtPrecio_producto.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCod_productoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_productoKeyReleased
        // TODO add your handling code here:
        MProducto prd = new MProducto();
        String codigo = txtCod_producto.getText();
        prd.buscar(codigo);
    }//GEN-LAST:event_txtCod_productoKeyReleased

    private void txtImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImporteActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtImporteActionPerformed

    private void txtImporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyReleased
        // TODO add your handling code here:
        char car = evt.getKeyChar();

        if ((car < '0' || car > '9') && txtImporte.getText().contains(".")
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo se admiten numeros");
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo se admiten numeros");
        }
    }//GEN-LAST:event_txtImporteKeyReleased

    private void txtImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtImporteKeyPressed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
           cancelar();
        

    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtCantidadProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyReleased
        // TODO add your handling code here:
        
         
    }//GEN-LAST:event_txtCantidadProductoKeyReleased

    private void txtcedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyReleased
        // TODO add your handling code here:
         
    }//GEN-LAST:event_txtcedulaKeyReleased

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();

        if ((car < '0' || car > '9') && txtcedula.getText().contains(".")
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo se admiten numeros");
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo se admiten numeros");
        }
    }//GEN-LAST:event_txtcedulaKeyTyped
    
    public void cancelar(){
        if (jTabla.getRowCount() != 0) {
            JOptionPane.showMessageDialog(null, "Por favor quitar los articulos de la tabla");
        } else {
            int aceptar = JOptionPane.showConfirmDialog(this, "¿Seguro que desea ejecutar esta accion", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (aceptar == JOptionPane.YES_OPTION) {
                desactivar();
            }
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentaDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JButton btnbuscarProducto;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncliente;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabla;
    public static javax.swing.JTextField txtCantidadProducto;
    public static javax.swing.JTextField txtCod_producto;
    private javax.swing.JTextField txtImporte;
    public static javax.swing.JTextField txtNombre_producto;
    public static javax.swing.JTextField txtPrecio_producto;
    private javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtcategoria;
    public static javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtexistencia;
    public static javax.swing.JTextField txtproducto2;
    // End of variables declaration//GEN-END:variables
}
