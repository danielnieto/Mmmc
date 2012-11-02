
/*
 * Scan.java
 *
 * Created on 25-oct-2012, 22:26:59
 */
package mmmc;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;

/**
 *
 * @author danielnieto
 */
public class Scan extends javax.swing.JFrame implements Runnable {

    ArrayList<String> lst = new ArrayList<String>();
    DefaultTableModel dtm;
    boolean stop = false;
    ISqlJetTable table;
    Scan thisInstance;
    Thread addThread = new Thread() {

        ISqlJetCursor cursor;

        @Override
        public void run() {

            pbProgreso.setVisible(true);



            int countSelected = 0;
            for (int x = 0; x < dtm.getRowCount(); x++) {
                if (Boolean.parseBoolean(dtm.getValueAt(x, 0).toString()) == true) {
                    countSelected++;

                }
            }

            if (countSelected == 0) {
                Ventana.vtnScan.dispose();
                return;
            }

            int countProgress = 0;
            int countAdded = 0;

            try {
                Mmmc.db.beginTransaction(SqlJetTransactionMode.WRITE);

                for (int x = 0; x < dtm.getRowCount(); x++) {

                    if (Boolean.parseBoolean(dtm.getValueAt(x, 0).toString()) == true) {


                        table = Mmmc.db.getTable("movies");

                        cursor = table.lookup("id_name", dtm.getValueAt(x, 1).toString());

                        if (cursor.eof()) {

                            table.insert(null, dtm.getValueAt(x, 1).toString(), "", "On disk");
                            countAdded++;
                        }

                        countProgress++;

                        pbProgreso.setValue((countProgress * 100) / countSelected);
                        pbProgreso.setString("Adding: " + countProgress + "/" + countSelected);
                    }
                }


                Mmmc.db.commit();
                cursor.close();

                Ventana.llenaTabla(Ventana.txtSearch.getText());

                Ventana.lblMessage.setText(countAdded + " movies were added, " + (countSelected - countAdded) + " duplicates ignored");

                Ventana.vtnScan.dispose();
            } catch (SqlJetException ex) {
                Logger.getLogger(Scan.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
    };
    String name;
    private int countVideos = 0;

    public Scan() {

        llenarListaDeExtensiones();

        initComponents();

        pbProgreso.setVisible(false);

        setLocationRelativeTo(null);

        tblTabla.getColumnModel().getColumn(0).setMaxWidth(40);
        tblTabla.getColumnModel().getColumn(0).setMinWidth(40);



        Thread t = new Thread(this);
        t.start();

        dtm = (DefaultTableModel) tblTabla.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        txtFound = new javax.swing.JLabel();
        txtFile = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        btnDeselect = new javax.swing.JButton();
        btnAddSelected = new javax.swing.JButton();
        pbProgreso = new javax.swing.JProgressBar();
        pbProgreso.setStringPainted(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Scan for movies");
        setPreferredSize(new java.awt.Dimension(505, 565));
        setResizable(false);
        setSize(new java.awt.Dimension(505, 565));

        lblStatus.setText("Scan in progress");

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Add", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTabla);

        txtFound.setText("Found: ");

        txtFile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtFile.setText("Files");

        btnSelect.setText("Select all");
        btnSelect.setEnabled(false);
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnDeselect.setText("Deselect all");
        btnDeselect.setEnabled(false);
        btnDeselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectActionPerformed(evt);
            }
        });

        btnAddSelected.setText("Stop scan");
        btnAddSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSelectedActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(btnSelect)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnDeselect)
                .add(155, 155, 155)
                .add(txtFound)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(132, 132, 132)
                .add(btnAddSelected, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 216, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblStatus)
                    .add(txtFile))
                .addContainerGap(373, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, pbProgreso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblStatus)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(txtFile)
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(btnSelect)
                            .add(btnDeselect)))
                    .add(txtFound))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 367, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAddSelected, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pbProgreso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed

        for (int x = 0; x < dtm.getRowCount(); x++) {

            dtm.setValueAt(true, x, 0);

        }
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnDeselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectActionPerformed

        for (int x = 0; x < dtm.getRowCount(); x++) {

            dtm.setValueAt(false, x, 0);

        }

    }//GEN-LAST:event_btnDeselectActionPerformed

    private void btnAddSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSelectedActionPerformed
        if (btnAddSelected.getText().contentEquals("Stop scan")) {

            stop = true;
            btnAddSelected.setText("Add selected movies");

        } else {

            btnSelect.setEnabled(false);
            btnDeselect.setEnabled(false);
            btnAddSelected.setVisible(false);
            addThread.start();
        }




    }//GEN-LAST:event_btnAddSelectedActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSelected;
    private javax.swing.JButton btnDeselect;
    private javax.swing.JButton btnSelect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JProgressBar pbProgreso;
    private javax.swing.JTable tblTabla;
    private javax.swing.JLabel txtFile;
    private javax.swing.JLabel txtFound;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {

        obtenerTodosLosArchivos(Ventana.jfc.getSelectedFile());

        txtFile.setText("" + countVideos + " movie(s) found");
        lblStatus.setText("Scan completed. ");
        txtFound.setVisible(false);
        btnAddSelected.setText("Add selected movies");
        btnSelect.setEnabled(true);
        btnDeselect.setEnabled(true);
        btnAddSelected.setEnabled(true);
    }

    private void obtenerTodosLosArchivos(File folder) {

        if (!stop) {
            if (folder.listFiles() == null) {
                return;
            }

            for (File fileEntry : folder.listFiles()) {


                if (fileEntry.isDirectory()) {
                    obtenerTodosLosArchivos(fileEntry);
                } else {

                    txtFile.setText(chop(fileEntry.getName(), 45));

                    if (esVideo(fileEntry.getName())) {


                        countVideos++;
                        txtFound.setText("Found: " + countVideos);
                        Object[] row = {true, fileEntry.getName()};

                        dtm.addRow(row);
                    }
                }
            }
        }


    }

    private boolean esVideo(String name) {
        String extension = null;
        int ultimoPunto = name.lastIndexOf(".");

        if (ultimoPunto == 0) {
            return false;
        }

        try {
            extension = name.substring(ultimoPunto, name.length()).toLowerCase();
            if (lst.contains(extension)) {
                return true;

            }
        } catch (Exception e) {
        }




        return false;
    }

    private void llenarListaDeExtensiones() {
        lst.add(".avi");
        lst.add(".mpg");
        lst.add(".mp4");
        lst.add(".3gp");
        lst.add(".3g2");
        lst.add(".asf");
        lst.add(".asx");
        lst.add(".flv");
        lst.add(".mov");
        lst.add(".mpeg");
        lst.add(".rmvb");
        lst.add(".rm");
        lst.add(".vob");
        lst.add(".wmv");
        lst.add(".m1v");
        lst.add(".m2v");
        lst.add(".mkv");
        lst.add(".ogg");
        lst.add(".ogm");
        lst.add(".divx");
        lst.add(".k3g");
        lst.add(".gom");
        lst.add(".svi");
        lst.add(".wmx");
        lst.add(".wvx");
        lst.add(".wm");
        lst.add(".wmp");
        lst.add(".mpe");
        lst.add(".ifo");
        lst.add(".m4v");
        lst.add(".ogv");



    }

    private String chop(String name, int size) {
        if (name.length() > size) {
            return name.substring(0, size - 3) + "...";
        }
        return name;
    }
}
