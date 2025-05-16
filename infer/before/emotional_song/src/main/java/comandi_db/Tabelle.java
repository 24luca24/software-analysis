package comandi_db;

import serverES.DataBase;
import org.postgresql.util.PSQLException;
import java.sql.SQLException;
import java.sql.Statement;

/**
* Questa classe permette di creare le tabelle del database:
* <br>0) crea database;
* <br>1) Canzoni;
* <br>2) Playlist;
* <br>3) Emozioni;
* <br>4) Utenti;
* <br>5) CanzoniPlaylist;
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class Tabelle {

    /**
     * contiene l'esito della creazione della tabella
     */
    boolean exist=false;
    
    /**
     * Costruttore vuoto della classe
     */
    public Tabelle() {
    }

    /**
    * Permette di creare il database emotionalsong, setta <code>esiste</code> a true per permettere di stampare un errore
    * nel caso il database esistesse gia
    * @param db passaggio del database
    * @return <code>exist</code>
    * @throws SQLException eccezione che rappresenta errori specifici nell'accesso o nell'interazione con un database, generalmente
    * lanciata quando si verificano problemi durante l'esecuzione di query, la gestione delle transazioni o altre operazioni
    * Nel contesto di un'applicazione client-server che coinvolge l'accesso a un database, l'eccezione
    * può essere lanciata quando si verificano errori durante la connessione al database, l'esecuzione di query SQL o la
    * gestione delle transazioni.
    */
    public boolean createDataBase(DataBase db) throws SQLException {
        String database = "CREATE DATABASE emotionalsong";
        try{ 
            Statement statement = db.getStatement();
            statement.execute(database);
       }catch(PSQLException e){
         System.out.println("il database esiste gia");  
       }
        exist=true;
        return exist;
    }

    /**
    * Query che permette la creazione della tabella Canzoni
    * @param db database
    * @throws SQLException vedi javadoc createDataBase
    */
    public void createTableCanzoni(DataBase db) throws SQLException {
        String canzoni = "CREATE TABLE IF NOT EXISTS Canzoni( "
            + "anno NUMERIC(4) NOT NULL, "
            + "idCanzone VARCHAR(18) PRIMARY KEY, "
            + "autore VARCHAR(400) NOT NULL, "
            + "titolo VARCHAR(400) NOT NULL "
            + ")";
        Statement statement = db.getStatement();
        statement.execute(canzoni);   
    }

    /**
    * Query che permette la creazione della tabella Playlist
    * @param db database
    * @throws SQLException vedi javadoc createDataBase
    */
    public void createTablePlaylist(DataBase db) throws SQLException {
        String playlist = "CREATE TABLE IF NOT EXISTS Playlist ("
            + "username VARCHAR(20) not null,"
            + "nomePlaylist VARCHAR(30) not null,"
            + "idPlaylist SERIAL PRIMARY KEY,"
            + "FOREIGN KEY (username) REFERENCES Utenti(username) ON DELETE CASCADE ON UPDATE CASCADE"
            + ")";
        Statement statement = db.getStatement();
        statement.execute(playlist);
    }

    /**
    * Query che permette la creazione della tabella utenti
    * @param db database
    * @throws SQLException vedi javadoc createDataBase
    */
    public void createUtenti(DataBase db) throws SQLException {
        String utenti = "CREATE TABLE IF NOT EXISTS Utenti ("
            + "nome varchar(30) not null,"
            + "cognome varchar(30) not null,"
            + "comune varchar(30) not null,"
            + "provincia varchar(2) not null,"
            + "via varchar(40) not null,"
            + "nCivico numeric(3) not null,"
            + "cap numeric(5) not null,"
            + "mail varchar(40) UNIQUE not null,"
            + "CF varchar(16) UNIQUE not null,"
            + "username varchar(20) PRIMARY KEY,"
            + "password varchar(16) not null"
            +")";
        Statement statement = db.getStatement();
        statement.execute(utenti);
    }

    /**
    * Query che permette la creazione della tabella emozioni
    * @param db database
    * @throws SQLException vedi javadoc createDataBase
    */
    public void createTableEmozioni(DataBase db) throws SQLException {
        String emozioni = "CREATE TABLE IF NOT EXISTS Emozioni ("
            + "idEmozione SERIAL PRIMARY KEY,"
            + "idUtente VARCHAR(20),"
            + "idCanzone VARCHAR(18),"
            + "emozione1 VARCHAR(30),"
            + "emozione2 VARCHAR(30),"
            + "emozione3 VARCHAR(30),"
            + "emozione4 VARCHAR(30),"
            + "emozione5 VARCHAR(30),"
            + "emozione6 VARCHAR(30),"
            + "emozione7 VARCHAR(30),"
            + "emozione8 VARCHAR(30),"
            + "emozione9 VARCHAR(30),"
            + "valutazione1 VARCHAR(256),"
            + "valutazione2 VARCHAR(256),"
            + "valutazione3 VARCHAR(256),"
            + "valutazione4 VARCHAR(256),"
            + "valutazione5 VARCHAR(256),"
            + "valutazione6 VARCHAR(256),"
            + "valutazione7 VARCHAR(256),"
            + "valutazione8 VARCHAR(256),"
            + "valutazione9 VARCHAR(256),"
            + "FOREIGN KEY (idUtente) REFERENCES Utenti(username) ON DELETE CASCADE ON UPDATE CASCADE,"
            + "FOREIGN KEY (idCanzone) REFERENCES Canzoni(idCanzone) ON DELETE CASCADE ON UPDATE CASCADE"
            + ")";
        Statement statement = db.getStatement();
        statement.execute(emozioni);
    }

    /**
    * Queyr che permette la creazione della tabella canzoniPlaylist
    * @param db database
    * @throws SQLException vedi javadoc createDataBase
    */
    public void createTableCanzoniPlaylist(DataBase db) throws SQLException {
        String canzoniPlaylist = "CREATE TABLE IF NOT EXISTS CanzoniPlaylist ("
            + "idPlaylist SERIAL,"
            + "idCanzone VARCHAR(18),"
            + "FOREIGN KEY (idPlaylist) REFERENCES Playlist(idPlaylist) ON DELETE CASCADE ON UPDATE CASCADE,"
            + "FOREIGN KEY (idCanzone) REFERENCES Canzoni(idCanzone) ON DELETE CASCADE ON UPDATE CASCADE"
            + ")";
        Statement statement = db.getStatement();
        statement.execute(canzoniPlaylist);
    }
}
