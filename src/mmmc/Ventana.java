/*
 * ventana.java
 *
 * Created on 20-oct-2012, 22:24:46
 */
package mmmc;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;

/**
 *
 * @author danielnieto
 */
public class Ventana extends javax.swing.JFrame {

    public static Scan vtnScan;
    public static JFileChooser jfc;
    static DefaultTableModel dtm = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }

        @Override
        public Class getColumnClass(int c) {
            if (c == 0) {

                return Integer.class;
            }

            return String.class;
        }
    };
    static ISqlJetTable table;

    private static boolean addThisRow(Object[] row, String search) {

        String status = cmbStatus.getSelectedItem().toString();
        int hits = 0;

        if (!status.equals("All")) {

            if (!row[3].toString().contains(status)) {
                return false;

            }
        }



        if (cbId.isSelected()) {

            if (row[0].toString().toLowerCase().contains(search.toLowerCase())) {
                hits++;

            }

        }

        if (cbName.isSelected()) {

            if (row[1].toString().toLowerCase().contains(search.toLowerCase())) {
                hits++;

            }

        }

        if (cbNotes.isSelected()) {

            if (row[2].toString().toLowerCase().contains(search.toLowerCase())) {
                hits++;

            }

        }


        if (hits == 0 && !search.equals("")) {
            return false;
        }

        return true;
    }

    public Ventana() {
        initComponents();


        setLocationRelativeTo(null);
        tblTabla.setModel(dtm);

        tblTabla.setGridColor(Color.gray);

        dtm.addColumn("Id");
        dtm.addColumn("Name");
        dtm.addColumn("Notes");
        dtm.addColumn("Status");

        tblTabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblTabla.getColumnModel().getColumn(0).setMaxWidth(40);
        tblTabla.getColumnModel().getColumn(0).setMinWidth(40);
        tblTabla.getColumnModel().getColumn(1).setMaxWidth(1900);
        tblTabla.getColumnModel().getColumn(1).setMinWidth(300);
        tblTabla.getColumnModel().getColumn(2).setMaxWidth(1500);
        tblTabla.getColumnModel().getColumn(2).setMinWidth(500);
        tblTabla.getColumnModel().getColumn(3).setMaxWidth(100);
        tblTabla.getColumnModel().getColumn(3).setMinWidth(100);


        tblTabla.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    JTable target = (JTable) e.getSource();

                    int row = tblTabla.convertRowIndexToModel((tblTabla.rowAtPoint(e.getPoint())));

                    new Editar(dtm.getValueAt(row, 0).toString(), dtm.getValueAt(row, 1).toString(), dtm.getValueAt(row, 2).toString(), dtm.getValueAt(row, 3).toString()).setVisible(true);

                }

                if (SwingUtilities.isRightMouseButton(e)) {

                    int row = tblTabla.rowAtPoint(e.getPoint());


                    tblTabla.setRowSelectionInterval(row, row);


                }

            }
        });

        tblTabla.setComponentPopupMenu(new MenuPopup());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lblId4 = new javax.swing.JLabel();
        lblId6 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        cbId = new javax.swing.JCheckBox();
        cbName = new javax.swing.JCheckBox();
        cbNotes = new javax.swing.JCheckBox();
        lblMovieCount = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnNew1 = new javax.swing.JButton();
        btnAbout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MMMC - My Minimal Movie Collection");
        setBounds(new java.awt.Rectangle(0, 15, 1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 300));

        tblTabla.setModel(dtm);
        tblTabla.setAutoCreateRowSorter(true);
        tblTabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTabla.setShowGrid(true);
        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMouseClicked(evt);
            }
        });
        tblTabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblTablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabla);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Search for movie"));

        txtSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSearchInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtSearchCaretPositionChanged(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblId4.setText("Search");

        lblId6.setText("Status");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Wanted", "Downloading", "On disk", "Deleted" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        cbId.setText("Id");
        cbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdActionPerformed(evt);
            }
        });

        cbName.setSelected(true);
        cbName.setText("Name");
        cbName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNameActionPerformed(evt);
            }
        });

        cbNotes.setSelected(true);
        cbNotes.setText("Notes");
        cbNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNotesActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(lblId6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmbStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(lblId4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(cbId)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cbName)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cbNotes))
                            .add(txtSearch, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblId4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cbId)
                    .add(cbName)
                    .add(cbNotes))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblId6)
                    .add(cmbStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(36, 36, 36))
        );

        lblMovieCount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblMovieCount.setText("Movies: Loading");
        lblMovieCount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblMessage.setText("Looking for database");
        lblMessage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mmmc/plus-icon.png"))); // NOI18N
        btnNew.setText("Add new");
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mmmc/minus-icon.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setMaximumSize(new java.awt.Dimension(98, 29));
        btnDelete.setMinimumSize(new java.awt.Dimension(98, 29));
        btnDelete.setPreferredSize(new java.awt.Dimension(98, 29));
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mmmc/pencil-icon.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setMaximumSize(new java.awt.Dimension(98, 29));
        btnEdit.setMinimumSize(new java.awt.Dimension(98, 29));
        btnEdit.setPreferredSize(new java.awt.Dimension(98, 29));
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnNew1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mmmc/search-icon.png"))); // NOI18N
        btnNew1.setText("Scan for movies");
        btnNew1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew1.setMaximumSize(new java.awt.Dimension(98, 29));
        btnNew1.setMinimumSize(new java.awt.Dimension(98, 29));
        btnNew1.setPreferredSize(new java.awt.Dimension(98, 29));
        btnNew1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(btnNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(4, 4, 4)
                .add(btnDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(4, 4, 4)
                .add(btnEdit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(4, 4, 4)
                .add(btnNew1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnEdit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnNew1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mmmc/info-icon.png"))); // NOI18N
        btnAbout.setText("About");
        btnAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(lblMovieCount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(1, 1, 1))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(btnAbout, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(19, 19, 19))))
                    .add(lblMessage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(8, 8, 8))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(btnAbout, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(lblMovieCount)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblMessage)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            llenaTabla(txtSearch.getText());

        } catch (SqlJetException ex) {
        }



    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSearchInputMethodTextChanged
    }//GEN-LAST:event_txtSearchInputMethodTextChanged

    private void txtSearchCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSearchCaretPositionChanged
    }//GEN-LAST:event_txtSearchCaretPositionChanged

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

        new Nuevo().setVisible(true);

    }//GEN-LAST:event_btnNewActionPerformed

    private void tblTablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTablaKeyPressed

        if (evt.getKeyCode() == 127) {
            try {


                int row = Ventana.tblTabla.convertRowIndexToModel(Ventana.tblTabla.getSelectedRow());
                String name = Ventana.dtm.getValueAt(row, 1).toString();
                int option = JOptionPane.showConfirmDialog(null, "Delete " + name + "?", "Confirm action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {

                    eliminarRegistro(dtm.getValueAt(row, 0).toString());
                    lblMessage.setText("Movie deleted: " + name);

                }


            } catch (SqlJetException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblTablaKeyPressed

    private void tblTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseClicked
    }//GEN-LAST:event_tblTablaMouseClicked

    private void btnNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew1ActionPerformed

        jfc = new JFileChooser();
        jfc.setDialogTitle("Select folder");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.showOpenDialog(this);


        if (jfc.getSelectedFile() == null) {
            return;
        }

        vtnScan = new Scan();
        vtnScan.setVisible(true);

    }//GEN-LAST:event_btnNew1ActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        try {

            llenaTabla(txtSearch.getText());

        } catch (SqlJetException ex) {
        }
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void cbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdActionPerformed
        try {

            llenaTabla(txtSearch.getText());

        } catch (SqlJetException ex) {
        }
    }//GEN-LAST:event_cbIdActionPerformed

    private void cbNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNameActionPerformed
        try {

            llenaTabla(txtSearch.getText());

        } catch (SqlJetException ex) {
        }
    }//GEN-LAST:event_cbNameActionPerformed

    private void cbNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNotesActionPerformed
        try {

            llenaTabla(txtSearch.getText());

        } catch (SqlJetException ex) {
        }
    }//GEN-LAST:event_cbNotesActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        try {

            int row = Ventana.tblTabla.convertRowIndexToModel(Ventana.tblTabla.getSelectedRow());
            new Editar(Ventana.dtm.getValueAt(row, 0).toString(), Ventana.dtm.getValueAt(row, 1).toString(), Ventana.dtm.getValueAt(row, 2).toString(), Ventana.dtm.getValueAt(row, 3).toString()).setVisible(true);

        } catch (IndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(null, "No movie is selected", "Select a movie to edit", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed


        int row = 0;
        String name;
        try {
            row = Ventana.tblTabla.convertRowIndexToModel(Ventana.tblTabla.getSelectedRow());
            name = Ventana.dtm.getValueAt(row, 1).toString();
        } catch (IndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(null, "No movie is selected", "Select a movie to delete", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


        int option = JOptionPane.showConfirmDialog(null, "Delete " + name + "?", "Confirm action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {

            try {
                eliminarRegistro(dtm.getValueAt(row, 0).toString());
                lblMessage.setText("Movie deleted: " + name);

            } catch (SqlJetException ex) {
            }

        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        new About().setVisible(true);
    }//GEN-LAST:event_btnAboutActionPerformed

    public static void eliminarRegistro(Object id) throws SqlJetException {
        ISqlJetCursor cursor = null;
        try {

            Mmmc.db.beginTransaction(SqlJetTransactionMode.WRITE);

            table = Mmmc.db.getTable("movies");


            cursor = table.lookup("id_index", Long.parseLong(id.toString()));

            cursor.delete();


        } catch (SqlJetException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            cursor.close();
            Mmmc.db.commit();
        }

        llenaTabla(txtSearch.getText());

    }

    public static void llenaTabla(String search) throws SqlJetException {
        dtm.setRowCount(0);

        ISqlJetCursor cursor;

        try {
            table = Mmmc.db.getTable("movies");
        } catch (SqlJetException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }


        Mmmc.db.beginTransaction(SqlJetTransactionMode.READ_ONLY);
        try {

            cursor = table.open();

            try {
                if (!cursor.eof()) {
                    do {

                        Object[] row = {cursor.getRowId(), cursor.getString("name"), cursor.getString("notes"), cursor.getString("status")};

                        try {
                            if (addThisRow(row, search)) {
                                dtm.addRow(row);
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }

                    } while (cursor.next());
                }
            } finally {
                cursor.close();
            }

        } finally {
            Mmmc.db.commit();
        }

        lblMovieCount.setVisible(true);
        lblMovieCount.setText("Movies: " + dtm.getRowCount());

        if (search.equals("")) {

            lblMessage.setText("Showing all movies");
        } else {
            lblMessage.setText("Showing results for *" + search + "*");
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNew1;
    private static javax.swing.JCheckBox cbId;
    private static javax.swing.JCheckBox cbName;
    private static javax.swing.JCheckBox cbNotes;
    private static javax.swing.JComboBox cmbStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId4;
    private javax.swing.JLabel lblId6;
    public static javax.swing.JLabel lblMessage;
    private static javax.swing.JLabel lblMovieCount;
    private javax.swing.JPopupMenu popMenu;
    public static javax.swing.JTable tblTabla;
    public static javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public static void insertarRegistro(String code, String notes, String status) throws SqlJetException {

        ISqlJetCursor cursor;

        Mmmc.db.beginTransaction(SqlJetTransactionMode.WRITE);

        table = Mmmc.db.getTable("movies");

        cursor = table.lookup("id_name", code);

        if (cursor.eof()) {

            table.insert(null, code, notes, status);
        } else {

            JOptionPane.showMessageDialog(null, "A movie with that exact name is already added.", "Duplicate", JOptionPane.ERROR_MESSAGE);
        }


        Mmmc.db.commit();
        cursor.close();

    }
}
