package comandi_db;

import ClassiSerializzabili.Brano;
import ClassiSerializzabili.ListOfBrani;
import ClassiSerializzabili.Playlist;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import serverES.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

/**
* Questa classe contiene le query che verranno richiamate nelle varie classi, dove necessario;
* @author Candiani Valerio matricola:750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class Query {

    /**
     * ArrayList che conterr&agrave; le playlist associate e un utente (usato nelle query sotto, vedere quelle per
     * capire l'uso specifico)
     */
    private ArrayList<Playlist> listaRicercaPl = new ArrayList<>();

    /**
     * ArrayList che conterr&agrave; le playlist associate e un utente (usato nelle query sotto, vedere quelle per
     * capire l'uso specifico)
     */
    private ArrayList<Playlist> listaRicercaPlnew = new ArrayList<>();

    /**
     * Istanza della classe ListOfBrani. Verr&agrave; richiamata all'interno delle query
     */
    private ListOfBrani list = new ListOfBrani();

    /**
     * Metodo costruttore vuoto della classe.
     */
    public Query() {
        
    }
    
    /**
     * Query per registrare un utente all'interno del database
     * @param db database in cui salvare i dati
     * @param query stringa contenente i dati da salvare
     * @throws SQLException eccezione che rappresenta errori specifici nell'accesso o nell'interazione con un database, generalmente
     * lanciata quando si verificano problemi durante l'esecuzione di query, la gestione delle transazioni o altre operazioni
     * Nel contesto di un'applicazione client-server che coinvolge l'accesso a un database, l'eccezione
     * può essere lanciata quando si verificano errori durante la connessione al database, l'esecuzione di query SQL o la
     * gestione delle transazioni.
     */
    public void queryInsertUser(DataBase db, String query) throws SQLException {        
        ResultSet result = db.submitQuery("INSERT INTO Utenti (nome,cognome,comune,provincia,via,nCivico,cap,mail,CF,username,password)"
                + " VALUES ("+query+")");
    }

    /**
     * Query per controllare se uno username è già presente all'interno del database, poich&egrave; username è primary key
     * @param db database
     * @param user stringa username su cui effettuare il controllo
     * @return <code>bol</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public boolean queryControlloUser(DataBase db, String user) throws SQLException { 
        String s="";
        boolean bol = true;
        ResultSet result = db.submitQuery("SELECT username FROM Utenti WHERE username = '"+user+"'");
        while(result.next()){
            s = result.getString("username"); //vado a leggere tutte le righe corrispondenti alla colonna 'username'
            if(s.equals(user)){
                bol=false;
                break;
            }
        }
        return bol;
    }

    /**
     * Query che controlla se la password inserita è corretta per far si che il rispettivo utente possa poi loggarsi
     * @param db database
     * @param user username inserito
     * @param password password inserita
     * @return <code>bol</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public boolean queryVerificaPassword(DataBase db, String user, String password) throws SQLException { 
        String s="";
        boolean bol = false;
        ResultSet result = db.submitQuery("SELECT password from utenti WHERE username = '"+user+"'");
        while(result.next()){
            s = result.getString("password");
            if(s.equals(password)){
                bol=true;
                break;
            }
        }
        return bol;
    }

    /**
     * Query che permette all'utente di ricercare le canzone mediante il titolo
     * @param db database
     * @param titolo stringa inserita dall'utente (corrisponde al titolo della canzone da ricercare)
     * @return <code>list</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public ListOfBrani queryRicercaPerTitolo(DataBase db, String titolo) throws SQLException { 
        list.clear();
        int index = 0;
        ResultSet result = db.submitQuery("SELECT * from canzoni WHERE LOWER(titolo) LIKE LOWER('%"+titolo+"%')");
        while(result.next()){
            Brano provvisorio = new Brano();
            provvisorio.setAnno(result.getString(1));
            provvisorio.setId(result.getString(2));
            provvisorio.setAutore(result.getString(3));
            provvisorio.setTitolo(result.getString(4));
            list.add(provvisorio);
            index++;
        }           
        return list;
    }

    /**
     * Query che permette dato l'id di una playlist di recuperare le informazioni delle singole canzoni, per evitare
     * problemi di omonimia delle playlist tra più utenti
     * @param db database
     * @param idPlaylist id della playlist
     * @return <code>list</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public ListOfBrani queryVisualizzaCanzoniPLaylist(DataBase db, String idPlaylist) throws SQLException { 
        list.clear();
        int index=0;
        ArrayList<String> idcanz = new ArrayList<>();
        DataBase data2=db;
        ResultSet result = db.submitQuery("SELECT idcanzone from canzoniplaylist WHERE idplaylist = '"+idPlaylist+"'");
        while(result.next()){
            idcanz.add(index,result.getString(1));
            index++;
        }
        for(int k=0;k<index;k++){
            ResultSet result2 = data2.submitQuery("SELECT * from canzoni WHERE idCanzone = '"+idcanz.get(k)+"'");
            while(result2.next()){
                Brano provvisorio = new Brano();
                provvisorio.setAnno(result2.getString(1));
                provvisorio.setId(result2.getString(2));
                provvisorio.setAutore(result2.getString(3));
                provvisorio.setTitolo(result2.getString(4));
                list.add(provvisorio);
            }
        }
        return list;
    }

    /**
     * Query che permette la ricerca delle canzoni mediante i parametri autore e anno
     * @param db database
     * @param autore autore inserito dall'utente
     * @param anno anno inserito dall'utente
     * @return <code>list</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public ListOfBrani queryRicercaPerAnnoAutore(DataBase db, String autore, String anno) throws SQLException { 
        list.clear();
        int index=0;
        ResultSet result = db.submitQuery("SELECT * from canzoni WHERE LOWER(autore) LIKE LOWER('%"+autore+"%') AND anno = "+anno+"");
        while(result.next()){
            Brano provvisorio = new Brano();
            provvisorio.setAnno(result.getString(1));
            provvisorio.setId(result.getString(2));
            provvisorio.setAutore(result.getString(3));
            provvisorio.setTitolo(result.getString(4));
            list.add(provvisorio);
            index++;
        }            
        return list;
    }

    /**
     * Query che serve a mostrare a video le informazioni di un brano
     * @param db database
     * @param idCanzone id della canzone di cui mostrare le informazioni
     * @return <code>provvisorio</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public Brano queryRicercaInfoCanzone(DataBase db, String idCanzone) throws SQLException { 
        int index = 0;
        ResultSet result = db.submitQuery("SELECT * from canzoni WHERE idCanzone = '"+idCanzone+"'");
        Brano provvisorio = new Brano();
        while(result.next()){
            provvisorio.setAnno(result.getString(1));
            provvisorio.setId(result.getString(2));
            provvisorio.setAutore(result.getString(3));
            provvisorio.setTitolo(result.getString(4));
        }            
        return provvisorio;
    }

    /**
     * Query che serve per verificare se un utente ha associato qualche playlist
     * @param db database
     * @param username username dell'utente
     * @return <code>listaRicercaPlnew</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public ArrayList<Playlist> queryRicercaPlaylist(DataBase db, String username) throws SQLException { 
        listaRicercaPl.clear();
        int index=0;
        int indice=0;
        DataBase db2=db;
        DataBase db3=db;
        Query qk=new Query();
        Query qz=new Query();
        ResultSet result = db.submitQuery("SELECT * from Playlist WHERE username = '"+username+"'");
        while(result.next()){
            Playlist provvisoria = new Playlist();
            provvisoria.setUsername(result.getString(1));
            provvisoria.setNome(result.getString(2));
            listaRicercaPl.add(index, provvisoria);
            index++;
        }
        for (Playlist p : listaRicercaPl) {
            Playlist k=new Playlist();
            String s="";
            ResultSet result3 = db3.submitQuery("SELECT idPlaylist from Playlist WHERE nomePlaylist = '"
            +p.getNome()+"'");
            while(result3.next()){
                s=(result3.getString(1));
            }
            String provv="";
            ResultSet result2 =db2.submitQuery("SELECT idCanzone from canzoniPlaylist WHERE idPlaylist = '"
            +s+"'");
            while(result2.next()){
                provv=provv+(result2.getString(1))+"$";
            }
            if(provv.length()>0){
                StringBuilder sb = new StringBuilder(provv);
                sb.deleteCharAt(provv.length() - 1);
                k.setBrani(sb.toString());
            }else{
                k.setBrani(provv);
            }
            k.setUsername(p.getUsername());
            k.setNome(p.getNome());
            listaRicercaPlnew.add(indice, k);
            indice++;
        }
        return listaRicercaPlnew;
    }

    /**
     * Query che ritorna l'id della playlist partendo dal nome della playlist
     * @param db database
     * @param nomePlaylist nome della playlist di cui ritornare l'id
     * @param username username dell'utente a cui è associata la playlist
     * @return <code>s</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public String queryIdPlaylist(DataBase db, String nomePlaylist, String username) throws SQLException{
        String s = "";
        ResultSet result = db.submitQuery("SELECT idPlaylist from Playlist WHERE nomePlaylist = '"+nomePlaylist+"' AND username = '"+ username +"'");
        while(result.next()){
            s = (result.getString(1));
        }
        return s;
    }

    /**
     * Query che verifica se esiste gi&agrave; una playlist con lo stesso nome
     * @param db database
     * @param nomePl nome della playlist da verificare
     * @param username username dell'utente a cui effetturare il controllo
     * @return <code>bol</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public boolean queryEsistePlaylist(DataBase db, String nomePl, String username) throws SQLException { 
        String s = "";
        boolean bol = false;
        ResultSet result = db.submitQuery("SELECT nomeplaylist FROM Playlist WHERE username = '"+username+"'");
        while(result.next()){
            s = result.getString("nomeplaylist");
            if(s.equals(nomePl)){
                bol=true;
                break;
            }
        }
        return bol;
    }

    /**
     * Query che inserisce un brano nella playlist corrispondente
     * @param db database
     * @param idPlaylist id della playlist in cui verr&agrave; inserito il brano
     * @param idCanzone id del brano da inserire nella playlist
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public void queryInsertSongPl(DataBase db,String idPlaylist,String idCanzone) throws SQLException { 
        ResultSet result = db.submitQuery("INSERT INTO CanzoniPlaylist (idPlaylist,idCanzone)"
            + " VALUES ( '"+idPlaylist+"','"+idCanzone+"')");
    }

    /**
     * Query che crea la playlist con il nome scelto
     * @param db database
     * @param username username dell'utente che ha creato la playlist
     * @param nomePlaylist nome scelto dall'utente per la sua playlist
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public void queryCreaPlaylist(DataBase db,String username,String nomePlaylist) throws SQLException{
        ResultSet result = db.submitQuery("INSERT INTO Playlist (username,nomePlaylist)"
            + " VALUES ( '"+username+"','"+nomePlaylist+"')");
    }

    /**
     * Ritorna l'elenco di tutte le canzoni presenti nel database
     * @param db database
     * @return <code>listaCanzoniTitolo</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public ListOfBrani listaCanzoniCompleta(DataBase db) throws SQLException { 
        ListOfBrani listaCanzoniTitolo = new ListOfBrani(); 
        int i=0;
        ResultSet result = db.submitQuery("SELECT * from canzoni");
        while(result.next()){
            Brano provvisorio = new Brano();
            provvisorio.setAnno(result.getString(1));
            provvisorio.setId(result.getString(2));
            provvisorio.setAutore(result.getString(3));
            provvisorio.setTitolo(result.getString(4));
            listaCanzoniTitolo.add(i,provvisorio);
            i++;
        }              
        return listaCanzoniTitolo;
    }

    /**
     * Query che seleziona l'id della canzone nella tabella Emozioni che ha l'id uguale al parametro passato
     * @param db database
     * @param id id della canzone
     * @return <code>idcanzone</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public String queryIdCanzoneEmozione(DataBase db,String id) throws SQLException { 
        String idcanzone = "";
        ResultSet result = db.submitQuery("SELECT idCanzone from emozioni WHERE idCanzone = '"+id+"'");
        while(result.next()){
            idcanzone=(result.getString(1));
        }
        return idcanzone;
    }

    /**
     * Query per selezionare lo username nella tabella emozioni che ha lo user e l'id uguali a quelli passati
     * Viene utilizzata per controllo sovrascrizione commento
     * @param db database
     * @param user username
     * @param id id
     * @return <code>username</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public String queryUsernameEmozione(DataBase db, String user, String id) throws SQLException { 
        String username ="";
        ResultSet result = db.submitQuery("SELECT idUtente from emozioni WHERE idUtente = '"+user+"' AND idCanzone= '"+id+"'");
        while(result.next()){
            username=(result.getString(1));
        }
        return username;
    }

    /**
     * Query per avere tutti gli username delle persone che hanno commentato una determinata canzone e poi mostrarli a
     * display con visualizza emozioni associate alla canzone
     * @param db databse
     * @param id id canzone
     * @param k indice array username
     * @return <code>username</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    //
    public String[] queryUsernameGiudizio(DataBase db, String id, int k) throws SQLException { 
        String[] username = new String[k];
        int i=0;
        ResultSet result = db.submitQuery("SELECT idUtente from emozioni WHERE idCanzone = '"+id+"'");
        while(result.next()){
            username[i]=(result.getString(1));
            i++;
        }
        return username;
    }

    /**
     * Query che mi serve per inizializzare gli array di stringhe che uso nella query queryUsernameGiudizio e nella
     * classe VisualizzaBranoMusicale
     * @param db database
     * @param id id
     * @return <code>n</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public int querycontaUtenti(DataBase db, String id) throws SQLException {
        int n=0;
        ResultSet resset = db.submitQuery("SELECT COUNT(idUtente) AS total FROM emozioni WHERE idCanzone = '"+id+"'");
        while(resset.next()){
            n = resset.getInt("total");
        }
        return n;
    }

    /**
     * Query per avere la valutazione delle emozioni relative ad una canzone
     * @param db database
     * @param emozione emozione
     * @param idemozione idemozione
     * @return <code>valutazione</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public String queryValutazioneEmozione(DataBase db, String emozione, String idemozione) throws SQLException { 
        String valutazione ="";
        ResultSet result = db.submitQuery("SELECT emozione"+emozione+" from emozioni WHERE idemozione="+idemozione);
        while(result.next()){
            valutazione=(result.getString(1));
        }
        return valutazione;
    }

    /**
     * Query per avere il commento associato alle emozioni relative ad una canzone
     * @param db database
     * @param emozione emozione
     * @param idemozione id emozione
     * @return <code>valutazione</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public String queryCommentoEmozione(DataBase db, String emozione, String idemozione) throws SQLException { 
        String valutazione ="";
        ResultSet result = db.submitQuery("SELECT valutazione"+emozione+" from emozioni WHERE idemozione="+idemozione);
        while(result.next()){
            valutazione=(result.getString(1));
        }
        return valutazione;
    }

    /**
     * Query per inserire i commenti e le relative valutazioni nella tabella emozioni
     * associati au un utente univoco e ad un brano
     * @param db database
     * @param query stringa contenente la query
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public void queryInserisciCommento(DataBase db, String query) throws SQLException { 
        ResultSet result = db.submitQuery("INSERT INTO emozioni (idUtente,idCanzone,emozione1,emozione2,emozione3,emozione4,emozione5,emozione6,emozione7,emozione8,emozione9,"
            + "valutazione1,valutazione2,valutazione3,valutazione4,valutazione5,valutazione6,valutazione7,valutazione8,valutazione9) VALUES ("+query+")");
    }

    /**
     * Query che mi serve per cancellare una emozione prima di sovrascriverla con lo stesso utente (nel caso scelga sovrascrivi)
     * ion quanto l'emozione rilasciata per un determinato brano è unvoca per ogni utente
     * @param db database
     * @param idemozione idemozione da cancellare
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public void queryCancellaEmozione(DataBase db, String idemozione) throws SQLException { 
        ResultSet result = db.submitQuery("DELETE FROM emozioni where idemozione="+idemozione);
    }

    /**
     * Query per cancellare un'intera Playlist
     * @param db database
     * @param idPlaylist id playlist da cancellare
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public void queryCancellaPlaylist(DataBase db, String idPlaylist)throws SQLException { 
        ResultSet result = db.submitQuery("DELETE FROM playlist where idPlaylist= '"+idPlaylist+"'");
    }

    /**
     * Query per cancellare una specifica canzone da una playlist
     * @param db database
     * @param idPlaylist id playlist da cancellare
     * @param idCanzone id canzone da cancellare
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public void queryCancellaCanzonePlaylist(DataBase db, String idPlaylist, String idCanzone)throws SQLException {
        ResultSet result = db.submitQuery("DELETE FROM canzoniPlaylist where idPlaylist= '"+idPlaylist+"' "
            + "AND idCanzone = '"+idCanzone +"'");
    }

    /**
     * Query che ritorna l’id dell'emozione relativa ad uno specifico utente 
     * e ad uno specifico brano interrogando la tabella emozioni utilizzando 
     * come parametri di ricerca lo username e l’id della canzone
     * @param db database
     * @param username username utente
     * @param id id canzone
     * @return <code>idselezionato</code>
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public String querySelezionaEmozione(DataBase db, String username, String id) throws SQLException { 
        String idselezionato ="";
        ResultSet result = db.submitQuery("SELECT idemozione FROM emozioni where idUtente= '"+username+"' AND idCanzone= '"+id+"'");
        while(result.next()){
            idselezionato=(result.getString(1));
        }
        return idselezionato;
    }
    
    /**
     * Variabile utilizzata per salvare percorso del file.
     */
    java.net.URL percorsoProgramma = getClass().getResource("/FiveHundredThousandSongsOK.csv");
    
    /**
     * Query per popolare il database al primo avvio del programma
     * @param db database
     * @throws SQLException vedi queryInsertUser per spiegazione
     */
    public void queryPopolaDb(DataBase db) throws SQLException {
        int n = 0;
        ResultSet resset = db.submitQuery("SELECT COUNT(anno) AS total FROM canzoni");
        while(resset.next()){
            n = resset.getInt("total");
        }
        
        if (n < 1) {
            String copyQuery = "COPY canzoni FROM STDIN WITH CSV HEADER DELIMITER ';'";

            try {
                Connection connection = (Connection) db.getConnection();
                CopyManager copyManager = new CopyManager((BaseConnection) connection);
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(percorsoProgramma.openConnection().getInputStream()));

                copyManager.copyIn(copyQuery, fileReader);
            } catch (SQLException | IOException e) {
               e.printStackTrace();
            }
        }
    }
}
