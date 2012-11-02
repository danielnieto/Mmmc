/*
 * Editar.java
 *
 * Created on 21-oct-2012, 1:59:02
 */
package mmmc;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import org.tmatesoft.sqljet.core.SqlJetException;

/**
 *
 * @author danielnieto
 */
public class Nuevo extends javax.swing.JFrame {

    String name, notes, status;
    long id;

    public Nuevo() {

        initComponents();

        setLocationRelativeTo(null);

        this.setTitle("Adding new movie");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        cmbStatus = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        lblId1 = new javax.swing.JLabel();
        lblId2 = new javax.swing.JLabel();
        lblId3 = new javax.swing.JLabel();
        chkMore = new javax.swing.JCheckBox();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add new");
        setResizable(false);
        setSize(new java.awt.Dimension(380, 330));

        txtNotes.setColumns(20);
        txtNotes.setRows(5);
        txtNotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNotesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtNotes);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Wanted", "Downloading", "On disk", "Deleted" }));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mmmc/ok-icon.png"))); // NOI18N
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblId1.setText("Name");

        lblId2.setText("Notes");

        lblId3.setText("Status");

        chkMore.setText("Add more");
        chkMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMoreActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mmmc/cancel-icon.png"))); // NOI18N
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .add(chkMore))
                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                            .add(24, 24, 24)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                .add(lblId2)
                                .add(layout.createSequentialGroup()
                                    .add(lblId3)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(cmbStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(layout.createSequentialGroup()
                                    .add(lblId1)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))))
                    .add(layout.createSequentialGroup()
                        .add(40, 40, 40)
                        .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnAdd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblId1))
                .add(2, 2, 2)
                .add(lblId2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblId3)
                    .add(cmbStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btnAdd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(chkMore)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (txtName.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Name cannot be empty", "Blank", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                Ventana.insertarRegistro(txtName.getText(), txtNotes.getText(), cmbStatus.getSelectedItem().toString());
                Ventana.llenaTabla(Ventana.txtSearch.getText());
                Ventana.lblMessage.setText("Added successfully: " + txtName.getText());
                if (chkMore.isSelected()) {

                    txtName.setText("");
                    txtNotes.setText("");
                    cmbStatus.setSelectedItem("Wanted");

                    txtName.requestFocusInWindow();

                } else {
                    this.dispose();
                }

            } catch (SqlJetException ex) {
            }


        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void chkMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMoreActionPerformed
    }//GEN-LAST:event_chkMoreActionPerformed

    private void txtNotesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotesKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (evt.getModifiers() > 0) {
                txtNotes.transferFocusBackward();
            } else {
                txtNotes.transferFocus();
            }
            evt.consume();
        }


    }//GEN-LAST:event_txtNotesKeyPressed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JCheckBox chkMore;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId1;
    private javax.swing.JLabel lblId2;
    private javax.swing.JLabel lblId3;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtNotes;
    // End of variables declaration//GEN-END:variables
}
