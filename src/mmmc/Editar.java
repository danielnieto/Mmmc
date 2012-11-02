/*
 * Editar.java
 *
 * Created on 21-oct-2012, 1:59:02
 */
package mmmc;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;

/**
 *
 * @author danielnieto
 */
public class Editar extends javax.swing.JFrame {

    String name, notes, status;
    long id;

    public Editar(String id, String name, String notes, String status) {
        this.name = "" + name;
        this.notes = "" + notes;
        this.status = "" + status;
        this.id = Long.parseLong(id);

        initComponents();

        setLocationRelativeTo(null);

        this.setTitle("Editing record: " + this.id + " (" + this.name + ")");

        lblId.setText("ID: " + this.id);
        txtName.setText(this.name);
        txtNotes.setText(this.notes);
        cmbStatus.setSelectedItem(this.status);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        cmbStatus = new javax.swing.JComboBox();
        btnUpdate = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblNotes = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit");
        setResizable(false);
        setSize(new java.awt.Dimension(380, 330));

        lblId.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        lblId.setText("ID:");

        txtNotes.setColumns(20);
        txtNotes.setRows(5);
        txtNotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNotesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtNotes);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Wanted", "Downloading", "On disk", "Deleted" }));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mmmc/disk-save-icon.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblName.setText("Name");

        lblNotes.setText("Notes");

        lblStatus.setText("Status");

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mmmc/cancel-icon.png"))); // NOI18N
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
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lblId)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(lblNotes)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 281, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(lblName)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(lblStatus)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmbStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnUpdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblId)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblName))
                .add(2, 2, 2)
                .add(lblNotes)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblStatus)
                    .add(cmbStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btnUpdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        boolean dispose = true;
        try {
            ISqlJetTable table;
            ISqlJetCursor updateCursor;
            ISqlJetCursor checkCursor;


            try {
                Mmmc.db.beginTransaction(SqlJetTransactionMode.WRITE);

                table = Mmmc.db.getTable("movies");
                updateCursor = table.lookup("id_index", id);
                checkCursor = table.lookup("id_name", txtName.getText());


                if (checkCursor.getValue("id").equals(id) || checkCursor.eof()) {

                    updateCursor.update(updateCursor.getValue("id"), txtName.getText(), txtNotes.getText(), cmbStatus.getSelectedItem());


                } else {
                    JOptionPane.showMessageDialog(null, "A movie with that exact name is already added.", "Duplicate", JOptionPane.ERROR_MESSAGE);
                    dispose = false;
                }

                updateCursor.close();
                checkCursor.close();

            } finally {
                try {
                    Mmmc.db.commit();
                    Ventana.llenaTabla(Ventana.txtSearch.getText());
                    Ventana.lblMessage.setText("Edited successfully: " + txtName.getText());
                    if (dispose) {
                        this.dispose();
                    } else {
                        txtName.requestFocus();
                    }
                } catch (SqlJetException ex) {
                    Logger.getLogger(Editar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        } catch (SqlJetException ex) {
            Logger.getLogger(Editar.class.getName()).log(Level.SEVERE, null, ex);
        }



    }//GEN-LAST:event_btnUpdateActionPerformed

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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtNotes;
    // End of variables declaration//GEN-END:variables
}
