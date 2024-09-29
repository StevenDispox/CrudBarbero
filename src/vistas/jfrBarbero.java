
package vistas;

import modelo.mdlBarbero;
import controlador.ctrlBarbero;

public class jfrBarbero extends javax.swing.JFrame {

    public jfrBarbero() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    public static void initBarbero() {
        mdlBarbero modelo = new mdlBarbero();
        jfrBarbero vista = new jfrBarbero();
        ctrlBarbero controlador = new ctrlBarbero(modelo, vista);

        vista.setVisible(true);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBarbero = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("CRUD BARBERO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 70, 50, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 289, 35));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setText("Edad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));
        getContentPane().add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 289, 35));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel6.setText("Correo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 70, -1));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 290, 35));

        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });
        getContentPane().add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 290, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel7.setText("Peso");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 50, 20));

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        btnEliminar.setText("Eliminar");
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        btnActualizar.setText("Actualizar");
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        btnLimpiar.setText("Limpiar");
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, -1, -1));

        jLabel1.setText("Buscar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 50, 30));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 300, 30));

        tbBarbero.setModel(new javax.swing.table.DefaultTableModel(
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
        tbBarbero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBarberoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBarbero);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 590, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tbBarberoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBarberoMouseClicked

    }//GEN-LAST:event_tbBarberoMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initBarbero();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbBarbero;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
