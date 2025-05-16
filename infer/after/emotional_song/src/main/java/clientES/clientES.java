package clientES;

import ClassiSerializzabili.Giudizio;
import ClassiSerializzabili.Playlist;
import ClassiSerializzabili.Brano;
import ClassiSerializzabili.ListOfBrani;
import ClassiSerializzabili.DatiUtenti;
import emotionalnew.*;
import serverES.serverES;
import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
* Questa classe permette di stabilire una connessione con il server e permette lo scambio d'informazioni tra client e serverSlave.
* All'interno della classe infatti sono presenti metodi che permettono d'inviare le informazioni dalle varie classi del
* programma al serverSlave
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/

public class clientES extends Thread{

    /**
     * Conterr&grave; indirizzo e porta del server
     */
    Socket socketClient;

    /**
     * Canali di comunicazione che permettono al client d'inviare dati al server
     */
    ObjectInputStream in;
    ObjectOutputStream out;

    /**
     * Classe che verrà richiamata nei metodi seguenti, all'interno di JOptionPane per creare messaggi d'informazione
     * all'utente
     */
    RegistraUtente registraUtente;

    /**
     * Classe che verrà richiamata nei metodi seguenti, all'interno di JOptionPane per creare messaggi d'informazione
     * all'utente
     */
    Accesso accesso;

    /**
     * Istanziazione della classe. Verr&agrave; richiamata all'interno dei metodi del client, poich&egrave; serializzabile.
     * Serve dunque per inviare dati al serverSlave in modo compatto
     */
    ListOfBrani miaLista = new ListOfBrani();

    /**
     * Istanziazione di una lista. Verr&grave; ritornata nei metodi per contenere elenchi di canzoni
     */
    JList<String> myList =  new JList<>();

    /**
     * Istanziazione di un arrayList di Playlist. Serve per mostrare le playlist all'interno dei metodi sottostanti
     * richiamati dal client
     */
    private ArrayList<Playlist> listaRicerca = new ArrayList<>();

    /**
     * Classe che verrà richiamata nei metodi seguenti, all'interno di JOptionPane per creare messaggi d'informazione
     * all'utente
     */
    private Playlist p;

    /**
     * Istanziazione della classe. Verr&agrave; richiamata all'interno dei metodi del client, poich&egrave; serializzabile.
     * Serve dunque per inviare dati al serverSlave in modo compatto
     */
    ListOfBrani list = new ListOfBrani();

    /**
     * Classe che verrà richiamata nei metodi seguenti, all'interno di JOptionPane per creare messaggi d'informazione
     * all'utente
     */
    ElencoPlaylist elencoPlaylist;

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
     * Istanziazione di un'ArrayList. Verr&agrave; ritornato nei metodi per contenere giudizi
     */
    private ArrayList<Giudizio> giudizi = new ArrayList<>();
    /**
     * Istanziazione di una stringa che Verr&agrave; utilizata come parametro per connettersi al server
     */
    private static String ipServerConnect;
    /**
     * Istanziazione di una variabile booleana che Verr&agrave; utilizata come parametro per effettuare diverse
     * operazioni nel main della classe a seconda del suo valore
     */
    private static boolean cambia=false;
    


    /**
     * Il costruttore istanzia gli attributi dichiarati precedentemente e permette la connessione col server
     * Ricava l'indirizzo del server, e istanzia il socket con indirizzo e numero di porta del server. Successivamente con
     * il socket appena creato, definisce il canali di comunicazione. Successivamente viene chiamato il metodo start per
     * far partire il Thread ClientES
     */
    public clientES() {
        try {
            System.out.println("ipinviato22: "+ipServerConnect);
            InetAddress addr = InetAddress.getByName(ipServerConnect);
            socketClient = new Socket(addr, serverES.PORT);
            in = new ObjectInputStream(socketClient.getInputStream());
            out = new ObjectOutputStream(socketClient.getOutputStream());
        } catch (IOException ex) {
            IpServer ip= new IpServer("server");
            //System.err.println("IMPOSSIBILE CONNETTERSI AL SERVER");
            Logger.getLogger(clientES.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        start();
    }
    
    /**
     * Il costruttore riceve in ingresso l'ip del server a cui connettersi e lo memorizza.
     * Fa partire il Thread ClientES.
     * @param ipServer definisce l'ip di connessione al server
     */
    public clientES(String ipServer) {
        this.ipServerConnect=ipServer;
        System.out.println("ipinviato: "+ipServerConnect);
        try {
            SchermataAvvio schermataAvvio = new SchermataAvvio();
            schermataAvvio.setVisible(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cambia=true;
        start();    
    }
    
    /**
     * Il costruttore riceve in ingresso un intero che definisce l'opzione da eseguire.
     * @param tipo contiene un valore intero, che corrisponde all'opzione da eseguire
     */
    public clientES(int tipo) {
        if(tipo == 0){
            this.ipServerConnect="localhost";
            System.out.println("ipBase: "+ipServerConnect);
        }    
    }

    /**
     * Metodo con cui il client invia i dati della registrazione al server. Il server invia una risposta sotto forma di
     * boolean che permette di sapere se l'operazione è andata a buon fine e quindi di comunicarlo al client mediante
     * un JOptionPane
     * @param datiUtenti classe serializzabile contenente i dati della registrazione
     * @return <code>esito</code>
     */
    public boolean invioDatiUtenti(DatiUtenti datiUtenti) {
        boolean esito;
        try {
            out.writeObject("InvioDatiRegistrazioneUtente");
            out.writeObject(datiUtenti);
            out.flush();
            esito = (boolean) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(registraUtente, "errore invio dati", "ERRORE REGISTRAZIONE", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
        return esito;
    }

    /**
     * Metodo con cui il client invia i dati del login al server. Il server invia una risposta sotto forma di boolean che
     * permette di sapere se l'operazione è andata a buon fine e quindi di comunicarlo al client mediante un JOptionPane
     * @param datiUtenti classe serializzabile contenente i dati del login
     * @return <code>esito</code>
     */
    public boolean accesoUtente (DatiUtenti datiUtenti) {
        boolean esito;
        try {
            out.writeObject("Accedi");
            out.writeObject(datiUtenti);
            out.flush();
            esito = (boolean) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(accesso, "errore invio dati", "ERRORE ACCESSO", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
        return esito;
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, permette di far ritornare
     * la lista completa delle canzoni
     * @return <code>myList</code>
     * @throws ClassNotFoundException eccezione lanciata quando il client non trova la classe necessaria per deserializzare
     * un oggetto ricevuto dal server tramite la comunicazione tramite oggetti Java (Object Serialization).
     */
    public JList<String> leggiCanzone() throws ClassNotFoundException {
        try {
            out.writeObject("VisualizzaElencoCanzoni");
            out.flush();
            miaLista = (ListOfBrani) in.readObject();
            myList = new JList<>(miaLista.toArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return myList;
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, ritorna l'elenco
     * delle playlist associate all'utente che sta eseguendo il programma
     * @param username rappresenta lo username dell'utente che sta eseguendo il programma
     * @return <code>listaRicerca</code>
     */
    public ArrayList<Playlist> ricercaPlaylist(String username) {
        try {
            out.writeObject("cercaPlaylist");
            out.writeObject(username);
            out.flush();
            listaRicerca = (ArrayList<Playlist>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listaRicerca;
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, verifica
     * l'esistenza di una playlist, associata a un certo utente
     * @param nomePl nome della playlist di cui si vuole verificare l'esistenza
     * @param username username dell'utente che ha usufruito del metodo
     * @return <code>esiste</code>
     * @throws IOException eccezione lanciata quando si verifica un errore durante l'operazione d'input/output
     * nel contesto di una comunicazione client-server.
     */
    public boolean esistePlyst(String nomePl, String username) throws IOException {
        boolean esiste = false;
        try {
            out.writeObject("EsistePl");
            out.writeObject(nomePl);
            out.writeObject(username);
            out.flush();
            esiste = (boolean) in.readObject();
        } catch (EOFException eofEx) {
            JOptionPane.showMessageDialog(elencoPlaylist, "ops... si è verificato un errore", "ERRORE", JOptionPane.ERROR_MESSAGE);
            System.err.println("errore EOFEX");
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } 
        return esiste;
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere,
     * cancella la playlist associata a un utente
     * @param username username dell'utente a cui bisogna cancellare la playlist
     * @param name nome della playlist da cancellare
     */
     public void cancellaPlay(String username, String name) {
        try {
            out.writeObject("CancellaPl");
            out.writeObject(username);
            out.writeObject(name);
            out.flush();
        } catch (EOFException eofEx) {
            JOptionPane.showMessageDialog(elencoPlaylist, "ops... si è verificato un errore", "ERRORE", JOptionPane.ERROR_MESSAGE);
            System.err.println("errore EOFEX");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, rimuove una
     * canzone da una playlist
     * @param idCanzone id della canzone da rimuovere
     * @param p playlist
     * @param username username dell'utente che sta usufruendo del metodo
     */
    public void cancellaCanzone(String idCanzone, Playlist p, String username) {
        this.p = p;
        try {
            out.writeObject("CancellaCanzone");
            out.writeObject(idCanzone);
            out.writeObject(p);
            out.writeObject(username);
            out.flush();
        } catch (EOFException eofEx) {
            System.err.println("errore EOFEX");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } 
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, cerca un brano
     * musicale
     * @param index indica se la ricerca avviene per titolo (0), oppure per autore e anno (1)
     * @param filtro1 se index = 0, si usa solo filtro1 per la ricerca
     * @param filtro2 se index = 1, si usano entrambi i filtri
     * @return <code>list.getList()</code>
     */
    public ArrayList<Brano> cercaBranoMusicale(int index, String filtro1, String filtro2) {
        try {
            out.writeObject("CercaBrano");
            out.writeObject(index);
            out.writeObject(filtro1);
            out.writeObject(filtro2);
            list = (ListOfBrani) in.readObject();
        } catch (EOFException eofEx) {
            System.err.println("errore EOFEX");
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return list.getList();
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, permette
     * la creazione di una playlist
     * @param s contiene la stringa di brani da inserire nella playlist.
     * @param nomePlaylist nome della playlist
     * @param username nome dell'utente che sta usufruendo dell'operazione
     * @return <code>esito</code>
     */
    public boolean RegistraPlaylist(String s, String nomePlaylist, String username) {
        boolean esito = false;
        try {
            out.writeObject("RegistraPlaylist");
            out.writeObject(s);
            out.writeObject(nomePlaylist);
            out.writeObject(username);
            out.flush();
            esito = (boolean) in.readObject();   
        } catch (EOFException eofEx) {
            System.err.println("errore EOFEX");
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return esito; 
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, permette di visualizzare
     * le emozioni associate a un brano
     * @param Canzone brano di cui si vogliono visualizzare le valutazioni relative alle emozioni
     */
    public void visualizzaEmozioneBrano(Brano Canzone) {
        try {
            out.writeObject("visualizzaEmozioneBrano");
            out.writeObject(Canzone);
            out.flush();
            emozioni=(int[]) in.readObject();   
            valutazione=(int[]) in.readObject();
            media= (double[]) in.readObject();
            giudizi=(ArrayList<Giudizio>) in.readObject();
        } catch (EOFException eofEx) {
            System.err.println("errore EOFEX");
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, aggiunge una canzone in
     * una playlist
     * @param IdSelezionato id della canzone da aggiungere
     * @param nomePl nome della playlist in cui aggiungere la canzone
     * @param username username dell'utente che usufruisce del metodo
     */
    public void creaCanzone(String IdSelezionato, String nomePl, String username) {
        try {
            out.writeObject("creaCanzone");
            out.writeObject(nomePl);
            out.writeObject(IdSelezionato);
            out.writeObject(username);
            out.flush();
        } catch (EOFException eofEx) {
            System.err.println("errore EOFEX");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, permette di visualizzare
     * le canzoni contenute in una playlist
     * @param username username dell'utente che usufruisce del metodo
     * @param nomePl nome della playlist di cui si vogliono visualizzare le canzoni
     * @return <code>list.getList()</code>
     */
    public ArrayList<Brano> VisualizzaCanzoniPLaylist(String username, String nomePl) {
        try {
            out.writeObject("VisualizzaCanzoniPLaylist");
            out.writeObject(username);
            out.writeObject(nomePl);
            out.flush();
            list=(ListOfBrani) in.readObject();
        } catch (EOFException eofEx) {
            System.err.println("errore EOFEX");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {  
            Logger.getLogger(clientES.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list.getList();
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, si occupa del controllo
     * della scrittura del giudizio di una canzone da parte dell'utente
     * @param username username dell'utente che usufruisce del metodo
     * @param IdSelezionato id della canzone in cui è stato lasciato un giudizio
     * @return <code>esito</code>
     */
    public boolean controllaGiudizio(String username, String IdSelezionato){
        boolean esito = false;
        try {
            out.writeObject("ControllaGiudizio");
            out.writeObject(IdSelezionato); 
            out.writeObject(username);
            out.flush();
            esito = (boolean) in.readObject();
        } catch (EOFException eofEx) {
            System.err.println("errore EOFEX");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {  
            Logger.getLogger(clientES.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return esito;
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, permette all'utente di
     * selezionare l'emozioni da inserire
     * @param username username dell'utente che usufruisce del servizio
     * @param IdSelezionato id della canzone in cui verranno lasciate le emozioni
     * @return <code>esito</code>
     */
    public String selezionaEmozione(String username, String IdSelezionato) {
        String esito="";
        try {
            out.writeObject("selezionaEmozione");
            out.writeObject(IdSelezionato); 
            out.writeObject(username);
            out.flush();
            esito = (String) in.readObject();
        } catch (EOFException eofEx) {
            System.err.println("errore EOFEX");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {  
            Logger.getLogger(clientES.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return esito;   
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, permette 
     * la sovrascrittura della vecchia recensione relativa ad un determinato brano
     * riguardo all'espressione delle emozioni suscitate
     * @param id id della canzone a cui verr&agrave; lasciato un commento
     * @param idEmozione id dell'emozione che andrà rimossa in modo che sia univoca per ogni utente
     * @param username username dell'utente che sta usufruendo del metodo
     * @param valutazione valutazione relativa alle singole emozioni provate
     * @param areaCommento commento eventuale lasciato riguardo all'emozione provata
     */
    public void sovrascriviCommento(String id, String idEmozione, String username, int[] valutazione, JTextArea[] areaCommento) {
        try {
            out.writeObject("SovrascriviCommento");
            out.writeObject(id);
            out.writeObject(idEmozione);
            out.writeObject(username);
            out.writeObject(valutazione);
            out.writeObject(areaCommento);
            out.flush();
        } catch (EOFException eofEx) {
            System.err.println("errore EOFEX");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Metodo con cui il client, avvisando il serverSlave con il nome dell'operazione da svolgere, permette di
     * scrivere emozioni suscitate relative ad un determinato brano Brano
     * @param id id della canzone a cui verr&agrave; lasciato un commento
     * @param username username dell'utente che sta usufruendo del metodo
     * @param valutazione valutazione relativa alle singole emozioni provate
     * @param areaCommento commento eventuale lasciato riguardo all'emozione provata
     */
    public void inserisciCommento(String id, String username, int[] valutazione, JTextArea[] areaCommento) {
        try {
            out.writeObject("inserisciCommento");
            out.writeObject(id);
            out.writeObject(username);
            out.writeObject(valutazione);
            out.writeObject(areaCommento);
            out.flush();
        } catch (EOFException eofEx) {
            System.err.println("errore EOFEX");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }     
    }

    /**
     * Metodo get per l'attributo <code>emozioni</code>
     * @return <code>emozioni</code>
     */
    public int[] getEmozioni(){
        return emozioni;
    }

    /**
     * Metodo get per l'attributo <code>valutazione</code>
     * @return <code>valutazione</code>
     */
    public int[] getValutazione(){
        return valutazione;  
    }

    /**
     * Metodo get per l'attributo <code>media</code>
     * @return <code>media</code>
     */
    public double[] getMedia(){
        return media;
    }

    /**
     * Metodo get per l'attributo <code>giudizi</code>
     * @return <code>giudizi</code>
     */
    public ArrayList<Giudizio> getGiudizio(){
        return giudizi;
    }
    
    /**
     * Metodo get per l'attributo <code>ipServerConnect</code>
     * @return <code>ipServerConnect</code>
     */
    public String GetIp(){
        return ipServerConnect;
    }

    /**
     * Metodo con cui andiamo a chiudere la connessione del client con il server. Viene inviata una stringa "END"
     * la quale dirà al serverSlave di chiudere il collegamento
     */
    public void close(){
        try {
            out.writeObject("END");
            in.close();
            out.close();
            socketClient.close();
        } catch (IOException ex) {
            Logger.getLogger(clientES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea la schermata avvio
     * @param args array di stringhe
     */
    public static void main(String[] args) {
        
        clientES client = new clientES(0);
        if(cambia==true){    
            try {
                SchermataAvvio schermataAvvio = new SchermataAvvio();
                schermataAvvio.setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }else{
            try {  
                IpServer ip=new IpServer(1);
            } catch (SQLException ex) {
                Logger.getLogger(clientES.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

