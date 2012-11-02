package mmmc;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

/**
 *
 * @author danielnieto
 */
public class Mmmc {

    public static SqlJetDb db;

    public static void main(String[] args) {
        Ventana v = null;


        v = new Ventana();

        v.setVisible(true);


        File dbFile = new File("mmmcdb");


        try {

            if (dbFile.exists()) {

                db = SqlJetDb.open(dbFile, true);
                Ventana.lblMessage.setText("Loading database");
                Ventana.llenaTabla(Ventana.txtSearch.getText());
                Ventana.lblMessage.setText("Database ready");



            } else {

                creaBaseDeDatos();

                Ventana.lblMessage.setText("No database was found. New database created and ready");
            }

        } catch (SqlJetException ex) {
            Logger.getLogger(Mmmc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void creaBaseDeDatos() throws SqlJetException {


        db = SqlJetDb.open(new File("mmmcdb"), true);
        db.getOptions().setAutovacuum(true);
        db.beginTransaction(SqlJetTransactionMode.WRITE);
        try {
            db.getOptions().setUserVersion(0);
        } finally {
            db.commit();
        }

        String createTableQuery = "CREATE TABLE movies(id INTEGER PRIMARY KEY, name TEXT NOT NULL,notes TEXT ,status TEXT)";
        String createIndex = "CREATE INDEX id_index ON movies(id)";
        String createIndexName = "CREATE INDEX id_name ON movies(name)";


        db.beginTransaction(SqlJetTransactionMode.WRITE);
        try {
            db.createTable(createTableQuery);
            db.createIndex(createIndex);
            db.createIndex(createIndexName);

        } finally {
            db.commit();
        }


    }
}
