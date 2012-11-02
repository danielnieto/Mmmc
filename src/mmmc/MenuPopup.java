package mmmc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import org.tmatesoft.sqljet.core.SqlJetException;

/**
 *
 * @author danielnieto
 */
class MenuPopup extends JPopupMenu {

    public MenuPopup() {

        JMenuItem itmDelete;
        JMenuItem itmEdit;

        itmEdit = new JMenuItem("Edit");
        add(itmEdit);

        itmDelete = new JMenuItem("Delete");
        add(itmDelete);


        itmEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                int row = Ventana.tblTabla.convertRowIndexToModel(Ventana.tblTabla.getSelectedRow());
                new Editar(Ventana.dtm.getValueAt(row, 0).toString(), Ventana.dtm.getValueAt(row, 1).toString(), Ventana.dtm.getValueAt(row, 2).toString(), Ventana.dtm.getValueAt(row, 3).toString()).setVisible(true);

            }
        });


        itmDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                int row = Ventana.tblTabla.convertRowIndexToModel(Ventana.tblTabla.getSelectedRow());
                String name = Ventana.dtm.getValueAt(row, 1).toString();
                int option = JOptionPane.showConfirmDialog(null, "Delete " + name + "?", "Confirm action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    try {

                        Ventana.eliminarRegistro(Ventana.dtm.getValueAt(row, 0).toString());
                        Ventana.lblMessage.setText("Movie deleted: " + name);

                    } catch (SqlJetException ex) {
                        Logger.getLogger(MenuPopup.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

    }
}
