package FORMULARIOS;

import MODELO.Conexion;
import MODELO.Detalle_compra;
import MODELO.Detalle_venta;
import MODELO.Factura_compra;
import MODELO.Factura_venta;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmMostrarCompras extends javax.swing.JInternalFrame {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();

    public FrmMostrarCompras() {
        initComponents();
        mostrar();
        txtCod_venta.setEditable(false);
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tablafactura.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                //l.setBorder(new LineBorder(Color.black, 1));
                l.setBackground(new java.awt.Color(36, 33, 33));
                l.setForeground(new java.awt.Color(25, 118, 210));
                l.setFont(new java.awt.Font("Arial", 1, 12));
                return l;
            }
        });
    }

    public void mostrar() {

        DefaultTableModel modelo;
        Factura_compra compra = new Factura_compra();
        modelo = compra.mostrar();
        tablafactura.setModel(modelo);
        ocultarcolumna(5);
        ocultarcolumna(6);

    }

    public void mostrardetalle(String id) {

        DefaultTableModel modelo;
        Detalle_compra detalle = new Detalle_compra();
        modelo = detalle.mostrar(id);
        tabladetalles.setModel(modelo);
        ocultarcolumnad(4);
        ocultarcolumnad(5);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablafactura = tablafactura = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel3 = new javax.swing.JPanel();
        txtTotal_venta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladetalles = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtCod_venta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombre_cliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtempleado = new javax.swing.JTextField();
        btnEliminar1 = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnEliminar = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setBackground(new java.awt.Color(36, 33, 33));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(36, 33, 33));

        jPanel4.setBackground(new java.awt.Color(36, 33, 33));

        tablafactura.setBackground(new java.awt.Color(36, 33, 33));
        tablafactura.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablafactura.setForeground(new java.awt.Color(207, 207, 207));
        tablafactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablafactura.setRowHeight(20);
        tablafactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablafacturaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablafactura);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(36, 33, 33));

        txtTotal_venta.setEditable(false);
        txtTotal_venta.setBackground(new java.awt.Color(36, 33, 33));
        txtTotal_venta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTotal_venta.setForeground(new java.awt.Color(207, 207, 207));
        txtTotal_venta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTotal_venta.setCaretColor(new java.awt.Color(255, 255, 255));
        txtTotal_venta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotal_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotal_ventaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(207, 207, 207));
        jLabel5.setText("Total :");

        tabladetalles.setBackground(new java.awt.Color(0, 0, 0));
        tabladetalles.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabladetalles.setForeground(new java.awt.Color(204, 204, 204));
        tabladetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabladetalles);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(207, 207, 207));
        jLabel4.setText("Factura Nro : ");

        txtCod_venta.setBackground(new java.awt.Color(36, 33, 33));
        txtCod_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCod_venta.setForeground(new java.awt.Color(207, 207, 207));
        txtCod_venta.setText(" ");
        txtCod_venta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCod_venta.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCod_venta.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(207, 207, 207));
        jLabel6.setText("Proveedor : ");

        txtNombre_cliente.setBackground(new java.awt.Color(36, 33, 33));
        txtNombre_cliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombre_cliente.setForeground(new java.awt.Color(207, 207, 207));
        txtNombre_cliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombre_cliente.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNombre_cliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(207, 207, 207));
        jLabel2.setText("Fecha :");

        txtfecha.setBackground(new java.awt.Color(36, 33, 33));
        txtfecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtfecha.setForeground(new java.awt.Color(207, 207, 207));
        txtfecha.setText(" ");
        txtfecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtfecha.setCaretColor(new java.awt.Color(255, 255, 255));
        txtfecha.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(207, 207, 207));
        jLabel3.setText("Empleado : ");

        txtempleado.setBackground(new java.awt.Color(36, 33, 33));
        txtempleado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtempleado.setForeground(new java.awt.Color(207, 207, 207));
        txtempleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtempleado.setCaretColor(new java.awt.Color(255, 255, 255));
        txtempleado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtempleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtempleadoKeyTyped(evt);
            }
        });

        btnEliminar1.setBackground(new java.awt.Color(36, 33, 33));
        btnEliminar1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEliminar1.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/eliminar.png"))); // NOI18N
        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnEditar1.setBackground(new java.awt.Color(36, 33, 33));
        btnEditar1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEditar1.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar.png"))); // NOI18N
        btnEditar1.setText("Editar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre_cliente)
                                .addComponent(txtCod_venta, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                            .addGap(73, 73, 73)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnEditar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCod_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtNombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnEliminar.setBackground(new java.awt.Color(36, 33, 33));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(36, 33, 33));
        btnPrint.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/reporteMenu.png"))); // NOI18N
        btnPrint.setText("Imprimir");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(36, 33, 33));
        btnEditar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(207, 207, 207));
        jLabel1.setText("COMPRAS REGISTRADAS EN EL SISTEMA");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/CErrar2.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int i = tablafactura.getSelectedRow();
        Factura_compra compra = new Factura_compra();
        compra.setPedido_id(Integer.parseInt(tablafactura.getValueAt(i, 0).toString()));
        int j = JOptionPane.showConfirmDialog(null, "¿Esta seguro de realizar esta accion?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (j == JOptionPane.YES_OPTION) {
            if (compra.eliminar(compra)) {
                JOptionPane.showMessageDialog(null, "Facuta Eliminada");
                mostrar();

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar factura");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (txtNombre_cliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo Proveedor no puede estar vacio");
        }
        if (txtfecha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo fecha no puede estar vacio");
        }
        if (txtempleado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo total no puede estar vacio");
        }

        Factura_compra factura = new Factura_compra();
        factura.setProveedor(Integer.parseInt(txtNombre_cliente.getText()));
        factura.setFecha((txtfecha.getText()));
        factura.setTotal(Integer.parseInt(txtTotal_venta.getText()));
        factura.setEmpleado_cedula(Integer.parseInt(txtempleado.getText()));
        factura.setPedido_id(Integer.parseInt(txtCod_venta.getText()));

        if (factura.editar(factura)) {
            JOptionPane.showMessageDialog(null, "factura editada");

        } else {
            JOptionPane.showMessageDialog(null, "factura NO editada");
        }
        mostrar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        JOptionPane.showMessageDialog(null, "Boton en Mantenimiento");
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtempleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtempleadoKeyTyped

    }//GEN-LAST:event_txtempleadoKeyTyped

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void tablafacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablafacturaMouseClicked
        // TODO add your handling code here:
        int i = tablafactura.getSelectedRow();

        txtNombre_cliente.setText(tablafactura.getValueAt(i, 5).toString());
        txtCod_venta.setText(tablafactura.getValueAt(i, 0).toString());
        txtfecha.setText(tablafactura.getValueAt(i, 1).toString());
        txtTotal_venta.setText(tablafactura.getValueAt(i, 4).toString());
        txtempleado.setText(tablafactura.getValueAt(i, 6).toString());

        int j = tablafactura.getSelectedRow();
        String codigo = tablafactura.getValueAt(j, 0).toString();
        mostrardetalle(codigo);


    }//GEN-LAST:event_tablafacturaMouseClicked
    void ocultarcolumna(int n) {
        tablafactura.getColumnModel().getColumn(n).setMaxWidth(0);
        tablafactura.getColumnModel().getColumn(n).setMinWidth(0);
        tablafactura.getColumnModel().getColumn(n).setPreferredWidth(0);
    }

    void ocultarcolumnad(int n) {
        tabladetalles.getColumnModel().getColumn(n).setMaxWidth(0);
        tabladetalles.getColumnModel().getColumn(n).setMinWidth(0);
        tabladetalles.getColumnModel().getColumn(n).setPreferredWidth(0);
    }
    private void txtTotal_ventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal_ventaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal_ventaKeyTyped

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:

        int i = tabladetalles.getSelectedRow();

        if (i != -1) {
            int valor = JOptionPane.showConfirmDialog(this, "¿Seguro que desea ejecutar esta accion?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (valor == 0) {
                Detalle_compra detalle = new Detalle_compra();
                detalle.setPedido_id(Integer.parseInt(tabladetalles.getValueAt(i, 5).toString()));
                detalle.setProductos_id(Integer.parseInt(tabladetalles.getValueAt(i, 4).toString()));
                if (detalle.eliminar(detalle)) {
                    JOptionPane.showMessageDialog(null, "Detalle eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar detalle");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione Fila a Eiliminar");

        }

        int j = tablafactura.getSelectedRow();
        String codigo = tablafactura.getValueAt(j, 0).toString();
        mostrardetalle(codigo);

    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "boton en mantenimiento");
    }//GEN-LAST:event_btnEditar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMostrarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMostrarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMostrarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMostrarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMostrarCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabladetalles;
    private javax.swing.JTable tablafactura;
    private javax.swing.JTextField txtCod_venta;
    public static javax.swing.JTextField txtNombre_cliente;
    private javax.swing.JTextField txtTotal_venta;
    private javax.swing.JTextField txtempleado;
    private javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables
}
