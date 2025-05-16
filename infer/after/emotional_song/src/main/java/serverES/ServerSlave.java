package serverES;

import ClassiSerializzabili.Giudizio;
import ClassiSerializzabili.Playlist;
import ClassiSerializzabili.Brano;
import ClassiSerializzabili.ListOfBrani;
import ClassiSerializzabili.DatiUtenti;
import comandi_db.Query;
import emotionalnew.*;
import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
* Classe che riceve dati dal client, li elabora, li salva nel db e ritorna un risultato
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class ServerSlave extends Thread implements Serializable {

    /**
     * istanza di socket
     */
    private Socket socket;

    /**
     * canale di comunicazione in uscita
     */
    private ObjectOutputStream out;
    
    /**
     * canale di comunicazione in ingresso
     */
    private ObjectInputStream in;

    /**
     * intero
     */
    private int index;

    /**
     * arrayList di brano che conterr&agrave; elenchi di canzoni
     */
    private ArrayList<Brano> listaRicerca = new ArrayList<>();

    /**
     * definizione classe lista
     */
    private ListOfBrani list = new ListOfBrani();

    /**
     * stringa che conterr&agrave; filtri di ricerca (autore - anno - nome)
     */
    private String filtro1;

    /**
     * stringa che conterr&agrave; filtri di ricerca (autore - anno - nome)
     */
    private String filtro2;

    /**
     * stringa che conterr&agrave; un nome di una playlist
     */
    private String nomePl;

    /**
     * stringa che conterr&grave; lo username
     */
    private String username;

    /**
     * stringa che conterr&grave; un nome
     */
    private String name;

    /**
     * stringa che conterr&grave; un id (playlist / canzoni)
     */
    private String id;

    /**
     * Istanza classe playlist
     */
    private Playlist p;

    /**
     * stringa
     */
    private String stringa;

    /**
     * conterr&agrave; l'id dell'emozione
     */
    private String idemozione;

    /**
     * Definizione di un array d'interi, che conterr&agrave; la valutazione inserita dall'utente delle emozioni provate
     */
    private int[] emozioni = new int[]{0,0,0,0,0,0,0,0,0};

    /**
     * Definizione di un array d'interi, che conterr&agrave; la valutazione inserita dall'utente delle emozioni provate
     */
    private int[] valutazione = new int[]{0,0,0,0,0,0,0,0,0};

    /**
     * Definizione di un array di double che conterr&agrave; la media delle valutazioni lasciate dai vari utenti
     * dell'applicazione
     */
    private double[] media = new double[]{0,0,0,0,0,0,0,0,0};

    /**
     * Istanziazione di un'ArrayList. Verr&grave; ritornato nei metodi per contenere giudizi
     */
    private ArrayList<Giudizio> giudizi = new ArrayList<>();

    /**
     * riferimento a classe brano
     */
    private Brano Canzone;

    /**
     * string contenente id selezionato di canzoni
     */
    private String idSelezionato;

    /**
     * area per inserire commenti giudizi emozioni
     */
    private JTextArea[] areaCommento = new JTextArea[9];

    /**
     * riferimento a database
     */
    public DataBase db;

    /**
     * riferimento a classe serializzabile per passare i dati in modo più efficiente
     */
    private DatiUtenti ricevimentoDati;

    /**
     * Costruttore della classe. Riceve un socket dalla classe <code>Server</code> connesso al client, sul quale ci monta
     * i canali di comunicazione per inviare dati al client
     * @param s socket passato dal server
     * @param dt riferimento al database
     * @throws IOException eccezione lanciata quando si verifica un errore durante l'operazione d'input/output
     * nel contesto di una comunicazione client-server.
     */
    public ServerSlave(Socket s, CredenzialiDB dt) throws IOException {
        socket = s;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        db=dt.getDataBase();
        System.out.println("Database: "+ db);
    }

    /**
     * Metodo che viene eseguito quando il thread viene lanciato. Consiste in uno switch, in cui il client invia
     * una stringa contenete il nome dell'operazione da eseguire, e in base a quello il serverSlave esegue l'operazione,
     * salva i dati nel db, esegue query se necessario e ritorna un valore al client
     */
    @Override
    public void run() {
        try {
            while(true){
                System.out.println("LEGGE...");
                String operazione = (String) in.readObject();
                System.out.println("HA LETTO: " + operazione);
                System.out.println("eseguo");
                System.out.println();

                switch(operazione) {
                    case "InvioDatiRegistrazioneUtente":
                        ricevimentoDati = (DatiUtenti) in.readObject();
                        out.writeObject(registra(db));
                        out.flush();
                        break;
                    case "Accedi":
                        ricevimentoDati = (DatiUtenti) in.readObject();
                        out.writeObject(accessoUtente(db, ricevimentoDati.getUsernameDato(), ricevimentoDati.getPasswordDato()));
                        break;
                    case "cercaPlaylist":
                        username = (String) in.readObject();
                        out.writeObject(ricercaPlaylist(db,username));
                        break;
                    case "VisualizzaElencoCanzoni":
                        out.writeObject(leggiCanzoni(db));
                        break;
                    case "CercaBrano":
                        index = (int) in.readObject();
                        filtro1 = (String) in.readObject();
                        filtro2 = (String) in.readObject();
                        list = cercaBranoMusicale(index, db);
                        System.out.println("listaricerca Pre INVIO: "+ list);
                        out.writeObject(list);
                        break;
                    case "EsistePl":
                        nomePl= (String) in.readObject();
                        username = (String) in.readObject();
                        out.writeObject(esistePl(db));
                        break; 
                    case "CancellaPl":
                        username = (String) in.readObject();
                        name = (String) in.readObject();
                        cancellaPlaylist(db,name,username);
                        break;
                    case "DettagliCanzone":
                        id=(String) in.readObject();
                        out.writeObject(dettagliCanzone(id,db));
                        break;
                    case "CancellaCanzone":
                        id=(String) in.readObject();
                        p=(Playlist) in.readObject();
                        username=(String) in.readObject();
                        cancellaCanzone(id,db,p,username);
                        break;
                    case "RegistraPlaylist":
                        stringa=(String) in.readObject();
                        nomePl=(String) in.readObject();
                        username=(String) in.readObject();
                        System.out.println("NOME PLAYLIST DA REGISTRARE: "+nomePl);
                        out.writeObject(RegistraPlaylist(stringa,db,nomePl,username));
                        break;
                    case "visualizzaEmozioneBrano":
                        Canzone= (Brano) in.readObject();
                        visualizzaEmozioneBrano(db,Canzone);
                        out.writeObject(emozioni);   
                        out.writeObject(valutazione); 
                        out.writeObject(media);
                        out.writeObject(giudizi);    
                        break;   
                    case "creaCanzone":
                        nomePl= (String) in.readObject();
                        idSelezionato= (String) in.readObject();
                        username= (String) in.readObject();
                        creaCanzone(idSelezionato, nomePl, username);
                        break;
                    case "ControllaGiudizio":
                        id=(String) in.readObject();
                        username = (String) in.readObject();
                        out.writeObject(esisteGiudizio(username,id,db));
                        break;
                    case "selezionaEmozione":
                        id=(String) in.readObject();
                        username = (String) in.readObject();
                        out.writeObject(selezionaEmozione(db,username,id));
                        break;
                    case "SovrascriviCommento":
                        id=(String) in.readObject();
                        idemozione=(String) in.readObject();
                        username = (String) in.readObject();
                        valutazione=(int[]) in.readObject();
                        areaCommento=(JTextArea[]) in.readObject();
                        sovrascriviCommento(db,id,username);
                        break;
                    case "inserisciCommento":
                        id=(String) in.readObject();
                        username = (String) in.readObject();
                        valutazione=(int[]) in.readObject();
                        areaCommento=(JTextArea[]) in.readObject();
                        inserisciCommento(db,username);
                        break;
                    case "VisualizzaCanzoniPLaylist":
                        username = (String) in.readObject();
                        nomePl= (String) in.readObject();
                        out.writeObject(VisualizzaCanzoniPLaylist(db,nomePl,username));
                        break;
                    case "END":
                        System.out.println("Chiusura socket...");
                        break;
                    default:
                        System.err.println("Comando sconosciuto");
                        out.writeObject("comando sconosciuto");
                }
                if (operazione.equals("END")){
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
           try {
                in.close();
                out.close();
                socket.close();
                System.out.println("Socket chiuso");
            } catch (IOException e) {
                throw new RuntimeException(e);
           }
        }
    }

    /**
     * Metodo richiamato dal serverSlave, che consente l'esecuzione della query che permette di salvare i dati nel database
     * Se la query va a buon fine viene ritornato true, altrimenti false
     * @param databs riferimento al database
     * @return <code>true</code> o <code>false</code> in base all'esito operazione
     * @throws IOException eccezione lanciata quando si verifica un errore durante l'operazione d'input/output
     * nel contesto di una comunicazione client-server.
     */
    private synchronized boolean registra(DataBase databs) throws IOException {
        try {
            Query qy = new Query();
            boolean login = controlloUsername(databs,qy,ricevimentoDati.getUsernameDato());
            
            System.out.println(ricevimentoDati.getUsernameDato());
            if (login) {
                String stringa = "'";
                stringa=stringa+ ricevimentoDati.getUsernameDato() + "', '" +
                        ricevimentoDati.getCognomeDato() + "', '" + ricevimentoDati.getComuneDato() + "', '"
                        + ricevimentoDati.getProvinciaDato() + "', '" +
                        ricevimentoDati.getViaDato() + "', " + ricevimentoDati.getNumeroCivicoDato() + ", " +
                        ricevimentoDati.getCapDato() + ", '" +  ricevimentoDati.getMailDato() + "', '" +
                        ricevimentoDati.getcFDato() + "', '" + ricevimentoDati.getUsernameDato() + "', '" +
                        ricevimentoDati.getPasswordDato() + "'";
                qy = new comandi_db.Query();
                try {
                    qy.queryInsertUser(databs,stringa);
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(RegistraUtente.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                    return false;
                }
            } else {
                return false;
            }
        } catch (IOException ioex) {
            System.err.println(ioex);
        }
        return false;
    }

    /**
     * Mrtodo con cui si fa il controllo dell'username inserito dall'utente durante il login
     * @param dt riferimento al database
     * @param q query
     * @param username username utente
     * @return <code>esiste</code>
     * @throws IOException eccezione lanciata quando si verifica un errore durante l'operazione d'input/output
     * nel contesto di una comunicazione client-server.
     * @throws EOFException
     */
    private synchronized boolean controlloUsername(DataBase dt, Query q, String username) throws IOException, EOFException {
        boolean esiste = true;
        try {
            esiste=q.queryControlloUser(dt,username);

        } catch (SQLException ex) {
            Logger.getLogger(RegistraUtente.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        System.out.println("esiste: "+esiste);
        return esiste;
    }

    /**
    * Vengono ricercati i due parametri, in ingresso al metodo (username e password), all'interno del database, se vengono trovati, il metodo
    * restituisce "true" altrimenti restituisce "false".
    * @param username contiene lo username
    * @param password contiene la password
    * @return <code>Accedi</code>: "true" se username e password corretti, "false" se non corretti.
    * @throws IOException eccezione lanciata quando si verifica un errore durante l'operazione d'input/output
    * nel contesto di una comunicazione client-server.
    * @throws EOFException eccezione che indica che è stata raggiunta la fine dell'input inaspettatamente durante una comunicazione client-server.
    * Questa eccezione viene sollevata quando un client o un server si aspettano ulteriori dati in ingresso, ma invece si verifica la fine del flusso.
    */
    private synchronized boolean accessoUtente(DataBase dt, String username, String password) throws IOException, EOFException {
        boolean accedi = false;
        Query qy = new Query();
        try {
            accedi = qy.queryVerificaPassword(dt, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(Accesso.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        return accedi;
    }

    /**
    * Metodo che si occupa di effettuare la ricerca della/e playlist sulla base del parametro username
    * all'interno del database. Scopo di mostrare all'utente i risultati trovati all'interno della JList <code>risultati</code>.
    * @param datab riferimento al database
    * @param username riferimento allo username
    * @throws IOException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
    */
    private synchronized ArrayList<Playlist> ricercaPlaylist(DataBase datab, String username) throws IOException {
        Query qy = new Query();
        ArrayList<Playlist> listaRicerca = new ArrayList<>();
        try {
            listaRicerca = qy.queryRicercaPlaylist(datab, username);
        } catch (SQLException ex) {
            Logger.getLogger(ElencoPlaylist.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        return listaRicerca;
    }

    /**
     * Metodo che ricerca un brano musicale
     * @param index riferisce alla ricerca per autore e anno oppure per titolo
     * @param datab riferimento al database
     * @return <code>this.list</code>
     * @throws IOException dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
     * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
     * @throws EOFException eccezione che indica che è stata raggiunta la fine dell'input inaspettatamente durante una comunicazione client-server.
     * Questa eccezione viene sollevata quando un client o un server si aspettano ulteriori dati in ingresso, ma invece si verifica la fine del flusso.
     */
    private synchronized ListOfBrani cercaBranoMusicale(int index, DataBase datab) throws IOException, EOFException {
        int indice = 0;
        String temp = "";
        Query qy = new Query();
        System.out.println("index: "+ index);
         if (index == 1) { 
            try {
                this.list = qy.queryRicercaPerTitolo(datab, this.filtro1.toLowerCase());
                System.out.println("listaricerca: "+ list);
            } catch (SQLException ex) {
                Logger.getLogger(RisultatiRicerca.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
            }
        } else {
            try {
                this.list=qy.queryRicercaPerAnnoAutore(datab,this.filtro1.toLowerCase(),this.filtro2.toLowerCase());
            } catch (SQLException ex) {
                Logger.getLogger(RisultatiRicerca.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
            }
        }
        return this.list;
    }
    
    //creare una query che mi torna ArrayList<Brano> contenente le canzoni di una playlist passando idplaylist tramite query queryIdPlaylist.
     //il return dovrà essere passato a ricercaBrani() di visulizzaPlaylist.

    /**
     * Metodo che crea una query che ritorna un ArrayList<Brano> contenente tutte le canzoni di una playlist passando
     * idplaylist tramite query. Il return dovr&agrave; essere passato a <code>ricercaBrani</code> di visualizzaPlaylist
     * @param datab riferimento al database
     * @param namePl nome della playlist di cui visualizzare le canzoni
     * @param username username dell'utente
     * @return <code>this.list</code>
     * @throws IOException dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
     * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
     * @throws EOFException eccezione che indica che è stata raggiunta la fine dell'input inaspettatamente durante una comunicazione client-server.
     * Questa eccezione viene sollevata quando un client o un server si aspettano ulteriori dati in ingresso, ma invece si verifica la fine del flusso.
     */
    private synchronized  ListOfBrani VisualizzaCanzoniPLaylist(DataBase datab, String namePl, String username) throws IOException, EOFException{
        Query qy = new Query();
        String idpl="";
        try {
            idpl=qy.queryIdPlaylist(datab, namePl, username);
            this.list =qy.queryVisualizzaCanzoniPLaylist(datab,idpl);
        } catch (SQLException ex) {
            Logger.getLogger(RisultatiRicerca.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        return this.list;
    }

    /**
     * Metodo che legge la lista delle canzoni completa
     * @param datab riferimento a database
     * @return <code>lista</code>
     */
    private synchronized ListOfBrani leggiCanzoni(DataBase datab) {
        ListOfBrani lista = new ListOfBrani();
        try {
            Query qy = new Query();
            lista = qy.listaCanzoniCompleta(datab);
        } catch (SQLException ex) {
            Logger.getLogger(ServerSlave.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        return lista;
    }

    /**
     * Metodo che vrifica l'esistenza di una playlist, tramite username e nome playlist
     * @param datab riferimento al database
     * @return <code>esiste</code>
     * @throws IOException dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
     * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
     */
    private synchronized boolean esistePl(DataBase datab)throws IOException {
       boolean esiste=false;
       Query qy = new Query();
            try {
                esiste = qy.queryEsistePlaylist(datab,nomePl,username);
            } catch (SQLException ex) {
                Logger.getLogger(ServerSlave.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
            }
        return esiste;
    }

    /**
     * Metodo che dato il nome dell'utente e il nome della playlist, va a cancellarla
     * @param datab riferimento al database
     * @param name riferimento al nome della playlist
     * @param username riferimento al nome dell'utente
     * @throws IOException dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
     * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
     */
    private synchronized void cancellaPlaylist(DataBase datab, String name, String username) throws IOException {
        Query qy=new Query();
        String idpl="";
        try {
            idpl=qy.queryIdPlaylist(datab, name, username);
            qy.queryCancellaPlaylist(datab,idpl);
        } catch (SQLException ex) {
            Logger.getLogger(ServerSlave.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }

    }

    /**
     * Quer che ritorna un brano dato l'id della canzone
     * @param id id canzone
     * @param datab rifeirmento al databse
     * @return <code>b</code>
     * @throws IOException dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
     * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
     */
    private synchronized Brano dettagliCanzone(String id, DataBase datab) throws IOException{
        Query qy=new Query();
        Brano b=new Brano();
        try {
            b = qy.queryRicercaInfoCanzone(datab,id);
        } catch (SQLException ex) {
            Logger.getLogger(ServerSlave.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        return b;
    }

    /**
     * Cancella una canzone dalla playlist
     * @param idCanzone id canzone
     * @param datab riferimento a database
     * @param p riferimento a classe playlist
     * @param username riferimento a username
     * @throws IOException dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
     * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
     */
    private synchronized void cancellaCanzone(String idCanzone, DataBase datab, Playlist p, String username) throws IOException {
        Query qy=new Query();
        try {
            String idPlaylist=qy.queryIdPlaylist(datab, p.getNome(), username);
            System.out.println("ID PLAYLIST: "+idPlaylist);
            qy.queryCancellaCanzonePlaylist(datab,idPlaylist,idCanzone);
        } catch (SQLException ex) {
            Logger.getLogger(VisualizzaPlaylist.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
    }

    /**
     * Metodo con cui il serverslave, dato un nome per la playlist, una stringa s contenente l'elenco delle canzoni e il nome
     * utente, crea la playlist
     * @param s stringa contenente le canzoni da inserire nella playlist
     * @param datab riferimento al database
     * @param nomePlaylist nome della playlist che si vuole creare
     * @param username username dell'utente
     * @return <code>esito</code>
     * @throws IOException dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
     * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
     * @throws EOFException eccezione che indica che è stata raggiunta la fine dell'input inaspettatamente durante una comunicazione client-server.
     * Questa eccezione viene sollevata quando un client o un server si aspettano ulteriori dati in ingresso, ma invece si verifica la fine del flusso.
     */
    private synchronized boolean RegistraPlaylist(String s, DataBase datab, String nomePlaylist, String username) throws IOException, EOFException{
        boolean esito=false;
        Query qk = new Query();
        try {
            qk.queryCreaPlaylist(datab,username,nomePlaylist);
        } catch (SQLException ex) {
            Logger.getLogger(RisultatiRicerca.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        String idPlaylist="";
        try {
            idPlaylist=qk.queryIdPlaylist(datab,nomePlaylist,username);
        } catch (SQLException ex) {
            Logger.getLogger(RisultatiRicerca.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        String[] StringaSeparata = s.split("\\$");
        int lunghezza=StringaSeparata.length;
        for(int k=0;k<lunghezza;k++){
            try {
                qk.queryInsertSongPl(datab,idPlaylist,StringaSeparata[k]);
                esito=true;
            } catch (SQLException ex) {
                Logger.getLogger(ElencoPlaylist.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                esito=false;
            }
        }
        return esito;
    }

    /**
     * Metodo con cui si mostrano le emozioni assegnate da vari utenti ad un brano
     * @param datab riferimento al database
     * @param Canzone riferimento alla classe brano
     * @throws IOException dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
     * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
     * @throws EOFException eccezione che indica che è stata raggiunta la fine dell'input inaspettatamente durante una comunicazione client-server.
     * Questa eccezione viene sollevata quando un client o un server si aspettano ulteriori dati in ingresso, ma invece si verifica la fine del flusso.
     */
    private synchronized void visualizzaEmozioneBrano(DataBase datab, Brano Canzone) throws IOException, EOFException{
        System.out.println("BRANO "+Canzone);
        int indice=0;
        String temp = "";
        boolean mediaok=false;
        Query qy = new Query();
        String newid = "";
        String idemozione="";
        int contuser=0; //conta quanti utenti hanno lasciato un emozione relativa a quella canzone
        try { 
            contuser=qy.querycontaUtenti(datab, Canzone.getId().trim());
            newid=qy.queryIdCanzoneEmozione(datab,Canzone.getId().trim());
        } catch (SQLException ex) {
            Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        String[] newUser =new String[contuser];
        if(newid.equals(Canzone.getId().trim())) {
            mediaok=true;
            try {
                //Acquisisco le recensioni dalla tabella emozioni
                newUser=qy.queryUsernameGiudizio(datab, newid,contuser);
            } catch (SQLException ex) {
                Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
            }
            for(int f=0; f<newUser.length; f++){
                Giudizio provvisorio;
                provvisorio = new Giudizio();
                try {
                    provvisorio.setUsername(newUser[f]);
                    idemozione=qy.querySelezionaEmozione(datab,newUser[f],Canzone.getId());
                    
                    //STUPORE
                    try {
                        temp = qy.queryValutazioneEmozione(datab,"1",idemozione);
                        provvisorio.setValutazioneStupore(Integer.valueOf(temp));
                        temp = qy.queryCommentoEmozione(datab,"1",idemozione);
                        provvisorio.setCommentoStupore(temp);
                        emozioni[0]++;//nome emozione
                        valutazione[0]=valutazione[0]+provvisorio.getValutazioneStupore();
                    } catch (SQLException ex) {
                        Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                    }
                    
                    //SOLENNITA
                    try {
                        temp = qy.queryValutazioneEmozione(datab,"2",idemozione);
                        provvisorio.setValutazioneSolennita(Integer.valueOf(temp));
                        temp = qy.queryCommentoEmozione(datab,"2",idemozione);
                        provvisorio.setCommentoSolennita(temp);
                        emozioni[1]++;
                        valutazione[1]=valutazione[1]+provvisorio.getValutazioneSolennita();
                    } catch (SQLException ex) {
                        Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                    }
                    
                    //TENEREZZA
                    try {
                        temp = qy.queryValutazioneEmozione(datab,"3",idemozione);
                        provvisorio.setValutazioneTenerezza(Integer.valueOf(temp));
                        temp = qy.queryCommentoEmozione(datab,"3",idemozione);
                        provvisorio.setCommentoTenerezza(temp);
                        emozioni[2]++;
                        valutazione[2]=valutazione[2]+provvisorio.getValutazioneTenerezza();
                    } catch (SQLException ex) {
                        Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                    }
                    
                    //NOSTALGIA
                    try {
                        temp = qy.queryValutazioneEmozione(datab,"4",idemozione);
                        provvisorio.setValutazioneNostalgia(Integer.valueOf(temp));
                        temp = qy.queryCommentoEmozione(datab,"4",idemozione);
                        provvisorio.setCommentoNostalgia(temp);
                        emozioni[3]++;
                        valutazione[3]=valutazione[3]+provvisorio.getValutazioneNostalgia();
                    } catch (SQLException ex) {
                        Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                    }
                    
                    //CALMA
                    try {
                        temp = qy.queryValutazioneEmozione(datab,"5",idemozione);
                        provvisorio.setValutazioneCalma(Integer.valueOf(temp));
                        temp = qy.queryCommentoEmozione(datab,"5",idemozione);
                        provvisorio.setCommentoCalma(temp);
                        emozioni[4]++;
                        valutazione[4]=valutazione[4]+provvisorio.getValutazioneCalma();
                    } catch (SQLException ex) {
                        Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                    }

                    //POTENZA
                    try {
                        temp = qy.queryValutazioneEmozione(datab,"6",idemozione);
                        provvisorio.setValutazionePotenza(Integer.valueOf(temp));
                        temp = qy.queryCommentoEmozione(datab,"6",idemozione);
                        provvisorio.setCommentoPotenza(temp);
                        emozioni[5]++;
                        valutazione[5]=valutazione[5]+provvisorio.getValutazionePotenza();
                    } catch (SQLException ex) {
                        Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                    }

                    //GIOIA
                    try {
                        temp = qy.queryValutazioneEmozione(datab,"7",idemozione);
                        provvisorio.setValutazioneGioia(Integer.valueOf(temp));
                        temp = qy.queryCommentoEmozione(datab,"7",idemozione);
                        provvisorio.setCommentoGioia(temp);
                        emozioni[6]++;
                        valutazione[6]=valutazione[6]+provvisorio.getValutazioneGioia();
                    } catch (SQLException ex) {
                        Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                    }

                    //TENSIONE
                    try {
                        temp = qy.queryValutazioneEmozione(datab,"8",idemozione);
                        provvisorio.setValutazioneTensione(Integer.valueOf(temp));
                        temp = qy.queryCommentoEmozione(datab,"8",idemozione);
                        provvisorio.setCommentoTensione(temp);
                        emozioni[7]++;
                        valutazione[7]=valutazione[7]+provvisorio.getValutazioneTensione();
                    } catch (SQLException ex) {
                        Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                    }

                    //TRISTEZZA
                    try {
                        temp = qy.queryValutazioneEmozione(datab,"9",idemozione);
                        provvisorio.setValutazioneTristezza(Integer.valueOf(temp));
                        temp = qy.queryCommentoEmozione(datab,"9",idemozione);
                        provvisorio.setCommentoTristezza(temp);
                        emozioni[8]++;
                        valutazione[8]=valutazione[8]+provvisorio.getValutazioneTristezza();
                    } catch (SQLException ex) {
                        Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                    }
                    
                    System.out.println("username"+provvisorio.getUsername());
                    giudizi.add(indice, provvisorio);
                    indice++;
                } catch (SQLException ex) {
                    Logger.getLogger(VisualizzaBranoMusicale.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
                }
            }
            
            if(mediaok==true){
                for(int h=0;h<emozioni.length;h++){
                    //funzione per avere solo due numeri decmali dopo la virgola
                    media[h]=Math.round((Double.valueOf(valutazione[h])/Double.valueOf(emozioni[h]))*100.0)/100.0;
                }
            }
        }  
    }

    /**
     * Metodo per aggiungere una canzone ad una playlist
     * @param idSel id della canzone da aggiungere
     * @param nomePlaylist nome della playlist
     * @param username username dell'utente che sta eseguendo
     */
    private synchronized void creaCanzone(String idSel, String nomePlaylist,String username){
        Query qk = new Query();
        String idPlaylist="";   
        try {
            idPlaylist=qk.queryIdPlaylist(db,nomePlaylist,username);
            System.out.println("ID playlist: "+idPlaylist+" Username: "+ username);
        } catch (SQLException ex) {
            Logger.getLogger(RisultatiRicerca.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        Query qy = new Query();
        try {
            qy.queryInsertSongPl(db,idPlaylist,idSel);
        } catch (SQLException ex) {
            Logger.getLogger(ElencoPlaylist.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
    }

    /**
     * Metodo che controlla se un dato username ha gi&agrave; lasciato un commento su una data canzone
     * @param username username dell'utente che sta usando l'applicazione
     * @param id id canzone
     * @param datab riferimento al database
     * @return <code>esistegiudizio</code>
     */
    private synchronized boolean esisteGiudizio(String username, String id, DataBase datab){
        boolean esistegiudizio= false;
        Query qy = new Query();
        String newid = "";
        String newUser = "";
        String idemozione="";
        String query= "";//query da inserire
        try {
            //cerco se esiste uno username nella tabella Emozioni ugaule a quello loggato a cui associare il commento corrispondente all'id della canzone
            newUser=qy.queryUsernameEmozione(datab,username,id);
            //cerco se esiste una canzone con lo stesso id di quella da commentare già presente nella tabella emozioni
            newid=qy.queryIdCanzoneEmozione(datab,id); 
            
            System.out.println("id: "+newid);
            System.out.println("usernameame: "+newUser);
        } catch (SQLException ex) {
            Logger.getLogger(GiudicaBrano.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        //se esiste già un commento presente relativo allo stesso username ed alla stessa canzone        
        if(newid.equals(id) && newUser.equals(username)){
            esistegiudizio=true;
        }
        return esistegiudizio;
    }

    /**
     * Query che ritorna l'id dell'emozione relativa ai parametri passati ovvero emozione per una determinata canzone
     * @param datab riferimento al database
     * @param username username dell'utente che sta usando l'applicazione
     * @param id idcanzone
     * @return <code>risultato</code>
     */
    private synchronized String selezionaEmozione(DataBase datab, String username, String id){ 
        Query qy = new Query();
        String risultato="";
        try {
            risultato=qy.querySelezionaEmozione(datab,username,id);
        } catch (SQLException ex) {
            Logger.getLogger(ServerSlave.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
        return risultato;
    }

    /**
     * Metodo che consente all'utente di sovrascrivere un commento precedentemente lasciato
     * @param datab riferimento al database
     * @param id riferimento all'id canzone
     * @param username utente che sta usando l'app
     */
    private synchronized void sovrascriviCommento(DataBase datab, String id, String username){
        Query qy = new Query();
        String query= "";
        try {
            query="'"+username+"','"+id;
            for (int j = 0; j < valutazione.length; j++){
                query = query + "','" + valutazione[j];
            }
            for (int i = 0; i < valutazione.length; i++){
                query = query + "','" + areaCommento[i].getText().replace("\n"," ");
            } 
            query = query + "'";  
            qy.queryCancellaEmozione(datab,idemozione);
            System.out.println("Query cancello emozione effettuata");
            qy.queryInserisciCommento(datab,query);
                
        } catch (SQLException ex) {
            Logger.getLogger(GiudicaBrano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo con cui un utente può inserire un commento per esprimere il suo giudizio per una data canzone
     * @param datab riferimento al database
     * @param username username utente che sta usando applicazione
     */
    private synchronized void inserisciCommento(DataBase datab, String username){
        Query qy = new Query();
        String query= "";
        try {
             query="'"+username+"','"+id;
            for (int j = 0; j < valutazione.length; j++){
                query = query + "','" + valutazione[j];
            }
            for (int i = 0; i < valutazione.length; i++){
                query = query + "','" + areaCommento[i].getText().replace("\n"," ");
            }
            query = query + "'";
            System.out.println("Query controllo emozione: "+query);
            qy.queryInserisciCommento(datab,query);
        } catch (SQLException ex) {
            Logger.getLogger(GiudicaBrano.class.getName()).log(Level.SEVERE, "SQL Exception occurred", ex);
        }
    }
}



