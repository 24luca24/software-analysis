package emotionalnew;

import comandi_db.Query;
import comandi_db.Tabelle;
import serverES.DataBase;
import java.sql.SQLException;

/**
 * Classe in cui si lanciano le query e dove vengono istanziate le tabelle
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class MainDB {

    /**
     * booleano che indica se il db esiste o meno
     */
    boolean esiste = false;

    /**
     * intero
     */
    static int ist=0;

    /**
     * istanza del database
     */
    private DataBase db;

    /**
     * costruttore della classe, va a creare il db e le sue tabelle qualora il valore di esiste sia false
     * @throws SQLException cattura eccezione di tipo SQL
     */
    public MainDB() throws SQLException {
        db = DataBase.getInstance(esiste, ist);
        Query qy = new comandi_db.Query();
        Tabelle tabelle = new Tabelle();
        esiste = tabelle.createDataBase(db);
        db = DataBase.getInstance(esiste,ist);
        tabelle.createUtenti(db);
        tabelle.createTableCanzoni(db);
        tabelle.createTableEmozioni(db);
        tabelle.createTablePlaylist(db);
        tabelle.createTableCanzoniPlaylist(db);
        qy.queryPopolaDb(db);
        ist=1;
    }

    /**
     * metodo get per ottenere l'istanza di db, usata nel costruttore MainDB
     * @return db ritorna il DB
     */
    public DataBase getDataBase(){
        return db;
    }
}
