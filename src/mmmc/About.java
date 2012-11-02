/*
 * About.java
 *
 * Created on 01-nov-2012, 2:13:45
 */
package mmmc;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielnieto
 */
public class About extends javax.swing.JFrame {

    public About() {
        initComponents();

        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        lblPaginaPersonal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblGithub = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblIcons = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSQLJet = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setResizable(false);
        setSize(new java.awt.Dimension(450, 550));

        jTextPane1.setBorder(null);
        jTextPane1.setEditable(false);
        jTextPane1.setText("\"THE BEER-WARE LICENSE\" \n\nAs long as you retain this notice you can do whatever you want with this stuff. If we meet some day, and you think this stuff is worth it, you can buy me a beer in return \nG. Daniel Nieto G.");
        jScrollPane1.setViewportView(jTextPane1);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        jLabel2.setText("Developed by: Daniel Nieto");

        lblPaginaPersonal.setForeground(java.awt.Color.blue);
        lblPaginaPersonal.setText("http://www.danielnieto.com");
        lblPaginaPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPaginaPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPaginaPersonalMouseClicked(evt);
            }
        });
        lblPaginaPersonal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblPaginaPersonalKeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mmmc/mmmc_logo.jpg"))); // NOI18N

        lblGithub.setForeground(java.awt.Color.blue);
        lblGithub.setText("http://github.com/danielnieto");
        lblGithub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGithub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGithubMouseClicked(evt);
            }
        });
        lblGithub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblGithubKeyPressed(evt);
            }
        });

        jLabel3.setText("Icons");

        lblIcons.setForeground(java.awt.Color.blue);
        lblIcons.setText("http://www.iconarchive.com");
        lblIcons.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIcons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconsMouseClicked(evt);
            }
        });
        lblIcons.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblIconsKeyPressed(evt);
            }
        });

        jLabel4.setText("SQLJet");

        lblSQLJet.setForeground(java.awt.Color.blue);
        lblSQLJet.setText("http://www.sqljet.com");
        lblSQLJet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSQLJet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSQLJetMouseClicked(evt);
            }
        });
        lblSQLJet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblSQLJetKeyPressed(evt);
            }
        });

        jLabel5.setText("License");

        jLabel6.setText("danielnieto89@gmail.com");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(119, 119, 119)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(lblPaginaPersonal)
                            .add(lblGithub)
                            .add(jLabel6))))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblIcons)
                    .add(layout.createSequentialGroup()
                        .add(67, 67, 67)
                        .add(jLabel3)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 81, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblSQLJet)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel4)
                        .add(49, 49, 49)))
                .add(44, 44, 44))
            .add(layout.createSequentialGroup()
                .add(36, 36, 36)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 379, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(200, 200, 200)
                .add(jLabel5)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblPaginaPersonal)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblGithub)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel6)
                .add(23, 23, 23)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblIcons))
                    .add(layout.createSequentialGroup()
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblSQLJet)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel5)
                .add(12, 12, 12)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblPaginaPersonalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblPaginaPersonalKeyPressed
    }//GEN-LAST:event_lblPaginaPersonalKeyPressed

    private void lblPaginaPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaginaPersonalMouseClicked
        String url = "http://danielnieto.com";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(About.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPaginaPersonalMouseClicked

    private void lblGithubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGithubMouseClicked

        String url = "http://github.com/danielnieto";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(About.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lblGithubMouseClicked

    private void lblGithubKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblGithubKeyPressed
    }//GEN-LAST:event_lblGithubKeyPressed

    private void lblIconsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconsMouseClicked
        String url = "http://www.iconarchive.com";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(About.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblIconsMouseClicked

    private void lblIconsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblIconsKeyPressed
    }//GEN-LAST:event_lblIconsKeyPressed

    private void lblSQLJetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSQLJetMouseClicked

        String url = "http://sqljet.com";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(About.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblSQLJetMouseClicked

    private void lblSQLJetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblSQLJetKeyPressed
    }//GEN-LAST:event_lblSQLJetKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblGithub;
    private javax.swing.JLabel lblIcons;
    private javax.swing.JLabel lblPaginaPersonal;
    private javax.swing.JLabel lblSQLJet;
    // End of variables declaration//GEN-END:variables
}
