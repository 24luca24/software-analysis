package emotionalnew;

import ClassiSerializzabili.Playlist;
import clientES.clientES;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
* Questa classe permette di scegliere se:
* <br>1) Visulizzare una playlist;
* <br>2) Aggiungere Una playlist;
* <br>3) Cancellare una playlist;
* <br>4) Tornare all'area riservata;
* Rende visibili con un elenco le playlist di un utente.
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class ElencoPlaylist extends javax.swing.JFrame {

    /**
    * Contiene lo username del cliente che ha eseguito l'accesso.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private String username;

    /**
    * Contiene il risultato del metodo <code>esistePl</code>.
    * Viene inizializzato a false come condizione base.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private boolean exst = false;

    /**
    * Contiene il nome della/e playlist, trovati dalla ricerca.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private JList<Playlist> risultati;

    /**
    * Conterr&agrave; l'oggetto <code>Plyalist</code> selezionato dalla JList <code>risultati</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private Playlist playlistSelezionata;

    /**
    * Contiene gli oggetti <code>Playlist</code> trovati dal metodo <code>ricercaPlaylist</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private ArrayList<Playlist> listaRicerca = new ArrayList<Playlist>();

    /**
    * Variabile privata che permette l'istanziazione di un elemento della classe client
    */
    private clientES client;

    /**
    * Metodo costruttore della finestra <code>ElencoPlaylist</code>
    * @param username In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>username</code> della classe.
    */
    public ElencoPlaylist(String username) {
        super("Risultati Ricerca");
        this.username = username;
        this.setSize(330, 260);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cercaPlaylist();
        if (listaRicerca.size() == 0) {
                    JLabel titoloL = new JLabel("Playlist trovate: 0");
                    titoloL.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
                    titoloL.setForeground(Color.decode("#6699FF"));
                        JButton indietro = new JButton("Indietro");
                        JButton crea = new JButton("Crea");
                        indietro.addActionListener(this::actionListenerIndietro);
                        crea.addActionListener(this::actionListenerCrea);
                            JList<String> vuota = new JList<>();
                            vuota.setPreferredSize(new Dimension(260, 100));
                            vuota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                            JScrollPane js = new JScrollPane(vuota);
                                DefaultListModel<String> lm = new DefaultListModel<String>();
                                lm.addElement("Non sono presenti playlist");
                                vuota.setModel(lm);
                                    JPanel pTitolo = new JPanel(new FlowLayout());
                                    JPanel pCentro = new JPanel();
                                    JPanel pBottoni = new JPanel(new FlowLayout());
                                    pTitolo.add(titoloL);
                                    pCentro.add(crea);
                                    pCentro.add(js);
                                    pBottoni.add(indietro);
                                    pBottoni.add(crea);
                                    Container principale = this.getContentPane();
                                    principale.setLayout(new BorderLayout());
                                    principale.add(pTitolo, BorderLayout.NORTH);
                                    principale.add(pCentro, BorderLayout.CENTER);
                                    principale.add(pBottoni, BorderLayout.SOUTH);
                                    this.pack();
                                    this.setVisible(true);
                                } else {
                                    JLabel titoloL = new JLabel("Playlist trovate: " + listaRicerca.size());
                                    titoloL.setFont(new Font("Impact", Font.PLAIN, 20));
                                    titoloL.setForeground(new Color(168, 68, 226));
                                        JButton visualizza = new JButton("Visualizza");
                                        JButton indietro = new JButton("Indietro");
                                        JButton crea = new JButton("Crea");
                                        JButton cancella = new JButton("Cancella");
                                        visualizza.addActionListener(this::actionListenerVisualizza);
                                        indietro.addActionListener(this::actionListenerIndietro);
                                        crea.addActionListener(this::actionListenerCrea);
                                        cancella.addActionListener(this::actionListenerCancella);
                                            risultati = new JList<>();
                                            risultati.setPreferredSize(new Dimension(260, listaRicerca.size()*18));
                                            risultati.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                                            JScrollPane js = new JScrollPane(risultati);
                                                DefaultListModel<Playlist> lm = new DefaultListModel<Playlist>();
                                                for (Playlist p : listaRicerca)
                                                    lm.addElement(p);
                                                    risultati.setModel(lm);
                                                        JPanel pTitolo = new JPanel(new FlowLayout());
                                                        JPanel pCentro = new JPanel();
                                                        JPanel pBottoni = new JPanel(new FlowLayout());
                                                        pTitolo.add(titoloL);
                                                        pCentro.add(crea);
                                                        pCentro.add(js);
                                                        pBottoni.add(indietro);
                                                        pBottoni.add(crea);
                                                        pBottoni.add(visualizza);
                                                        pBottoni.add(cancella);
                                                        Container principale = this.getContentPane();
                                                        principale.setLayout(new BorderLayout());
                                                        principale.add(pTitolo, BorderLayout.NORTH);
                                                        principale.add(pCentro, BorderLayout.CENTER);
                                                        principale.add(pBottoni, BorderLayout.SOUTH);
                                                        this.pack();
                                                        this.setVisible(true);
                                }
    }

    /**
    * Al clic del bottone <code>indietro</code> verr&agrave; creata una nuova finestra <code>AreaRiservata</code>
    * e verr&agrave; chiusa la finestra <code>ElencoPlaylist</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * @see AreaRiservata
    */
    private void actionListenerIndietro(ActionEvent e) {
        this.setVisible(false);
        new AreaRiservata(username).setVisible(true);
        this.dispose();
    }

    /**
    * Al clic del bottone <code>crea</code> verr&agrave; invocato il metodo <code>esistePl</code> e a seconda del risultato:
    * <br>True: verr&agrave; creata una nuova finestra <code>CercaBranoMusicale</code> e verr&agrave; chiusa la finestra <code>ElencoPlaylist</code> in esecuzione;
    * <br>False: verr&agrave; visualizzato un messaggio di errore.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>giudica</code>
    * @see RisultatiRicerca <code>RegistraPlaylist</code></code>
    */
    private void actionListenerCrea(ActionEvent e){
        String inputNomePlaylist = JOptionPane.showInputDialog(this, "Inserisci il Nome della Playlist da creare ", "Crea playlist", JOptionPane.QUESTION_MESSAGE);
        if (inputNomePlaylist != null && "".equals(inputNomePlaylist)) {
            JOptionPane.showMessageDialog(this, "E' necessario inserire un valore", "Errore Ricerca", JOptionPane.WARNING_MESSAGE);
        }else if(inputNomePlaylist != null){
            exst=esistePl(inputNomePlaylist);
            if(!exst){
                setVisible(false);
                (new CercaBranoMusicale(username,inputNomePlaylist,"",true,false)).setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Esiste già una Playlist con questo nome", "Errore", 2);
            }
        }
    }

    /**
    * Al clic del bottone <code>cancella</code>, se &egrave; stata selezionata una playlist nella JList <code>risultati</code>,
    * verr&agrave; invocato il metodo <code>cancellaPlaylist</code> che andrà ad eliminare la playlist selezionata.
    * <br>Successivamente verr&agrave; creata una nuova finestra <code>AreaRiservata</code>
    * e verr&agrave; chiusa la finestra <code>ElencoPlaylist</code> in esecuzione.
    * <br> Nel caso in cui non fosse stata selezionata una playlist, verr&agrave; mostrata una finestra
    * contenente un messaggio di errore.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>cancella</code>
    * @see AreaRiservata
    */
    private void actionListenerCancella(ActionEvent e){
        if(risultati.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Selezionare una playlist", "Errore Selezione", JOptionPane.WARNING_MESSAGE);
        } else {
            for (Playlist p : listaRicerca) {
                if(risultati.getSelectedValue().equals(p))
                    playlistSelezionata = p;
            }
            try {
                cancellaPlaylist(playlistSelezionata.getUsername(),playlistSelezionata.getNome());
            } catch (IOException eof) {
                eof.printStackTrace();
            }
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Playlist cancellata correttamente", "Cancellazione", JOptionPane.INFORMATION_MESSAGE);
            new AreaRiservata(username).setVisible(true);
            dispose();
        }
    }

    /**
    * Al clic del bottone <code>visualizza</code>, se &egrave; stato selezionata una playlist nella JList
    * <code>risultati</code>, verr&agrave; creata una nuova finestra <code>VisualizzaPlaylist</code> e verr&agrave;
    * settata a "false" la visibilit&agrave; della finestra <code>ElencoPlaylist</code> in esecuzione.
    * <br> Nel caso in cui non fosse stato selezionata una playlist, verr&agrave; mostrata una finestra
    * contenente un messaggio di errore.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>visualizza</code>
    * @see VisualizzaPlaylist
    */
    private void actionListenerVisualizza(ActionEvent e) {
        if(risultati.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Selezionare una playlist", "Errore Selezione", JOptionPane.WARNING_MESSAGE);
        } else {
            for (Playlist p : listaRicerca) {
                if(risultati.getSelectedValue().equals(p))
                    playlistSelezionata = p;
            }
            this.setVisible(false);
            new VisualizzaPlaylist(playlistSelezionata, username);
        }
    }

    /**
    * Metodo che ritorna le playlist di un utente
    * @return <code>listaRicerca</code>
    */
    private ArrayList<Playlist> cercaPlaylist() {
        client = new clientES();
        listaRicerca = client.ricercaPlaylist(this.username);
        client.close();
        if(listaRicerca.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Non sono presenti playlist associate all'utente", "ELENCO PLAYLIST VUOTO", JOptionPane.WARNING_MESSAGE);
        }
        return listaRicerca;
    }

    /**
    * Metoodo che verifica l'esistenza di una playlist, dato il suo nome
    * @param nomePl nome della playlist
    * @return <code>esiste</code>
    */
    private boolean esistePl(String nomePl) {
       boolean esiste = false;
        try {
            client = new clientES();
            esiste = client.esistePlyst(nomePl, this.username);
            client.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "non esistono playlist associate all'utente", "ERRORE", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
        return esiste;
    }

    /**
    * Metodo che cancella una playlist associata all'utente, dato il nome della playlist e lo username dell'utente
    * @param username di chi sta usando l'app in questo momento
    * @param name nome della playlist
    * @throws IOException eccezione lanciata quando si verifica un errore durante l'operazione d'input/output
    * nel contesto di una comunicazione client-server.
    */
    private void cancellaPlaylist(String username, String name) throws IOException {
        client = new clientES();
        client.cancellaPlay(username, name);
        client.close();
    }
}

