package emotionalnew;

import ClassiSerializzabili.Playlist;
import ClassiSerializzabili.Brano;
import clientES.clientES;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

/**
* Questa classe permette di scegliere se:
* <br>1) Visulizzare un brano;
* <br>2) Aggiungere un brano alla playlist;
* <br>3) Cancellare un brano dalla playlist;
* <br>4) Giudicare un brano;
* <br>4) Tornare all'elenco delle playlist;
* Rende visibili con un elenco i brani di una specifica playlist di un utente.
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class VisualizzaPlaylist extends javax.swing.JFrame {

    /**
    * Contiene lo username del cliente che ha eseguito l'accesso.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private String username;
    
    /**
    * Contiene l'oggetto di tipo <code>Playlist</code> ricevuto.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private Playlist p;

    /**
    * Contiene il nome della playlist che contiene i brani.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String nome;

    /**
    * Contiene gli oggetti di tipo <code>Brano</code>, trovati dalla ricerca.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private JList<Brano> risultati;

    /**
    * Conterr&agrave; l'oggetto <code>Brano</code> selezionato dalla JList <code>risultati</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private Brano BranoSelezionato;

    /**
    * Contiene gli oggetti <code>Brano</code> trovati dal metodo <code>ricercaBrani</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private ArrayList<Brano> listaRicerca = new ArrayList<Brano>();

    /**
     * istanza classe client
     */
    private clientES client;

    /**
    * Metodo costruttore della finestra <code>VisualizzaPlaylist</code>
    * @param p valorizza l'attributo <code>p</code> della classe.
    * @param username In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>username</code> della classe.
    */
    public VisualizzaPlaylist(Playlist p, String username) {
        super(p.getNome());
        this.setSize(450, 260);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.username = username;
        this.p = p;
        this.nome = p.getNome();

        try {
            ricercaBrani();
        } catch (EOFException eof) {
            eof.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if(listaRicerca.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nessun Brano", "Info", JOptionPane.INFORMATION_MESSAGE);

            JLabel titoloL = new JLabel("Brani presenti: 0");
            titoloL.setFont(new Font("Impact", Font.PLAIN, 20));
            titoloL.setForeground(new Color(168, 68, 226));

            //JButton
                JButton indietro = new JButton("Indietro");
                JButton add = new JButton("Aggiungi");
                indietro.addActionListener(this::actionListenerIndietro);
                add.addActionListener(this::actionListenerAggiungiCanzone);

            //JList
                JList<String> vuota = new JList<>();
                vuota.setPreferredSize(new Dimension(260, 100));
                vuota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                JScrollPane js = new JScrollPane(vuota);

            //Riempio la JList con i nomi dei Brani
                DefaultListModel<String> lm = new DefaultListModel<String>();

                lm.addElement("Non sono presenti Brani");
                vuota.setModel(lm);

            //JPanel
                JPanel pTitolo = new JPanel(new FlowLayout());
                JPanel pCentro = new JPanel();
                JPanel pBottoni = new JPanel(new FlowLayout());

                pTitolo.add(titoloL);
                pCentro.add(js);
                pBottoni.add(indietro);
                pBottoni.add(add);

                Container principale = this.getContentPane();
                principale.setLayout(new BorderLayout());
                principale.add(pTitolo, BorderLayout.NORTH);
                principale.add(pCentro, BorderLayout.CENTER);
                principale.add(pBottoni, BorderLayout.SOUTH);
                this.pack();
                this.setVisible(true);

            }
            else {
            //JLabel
                JLabel titoloL = new JLabel("Brani presenti: " + listaRicerca.size());
                titoloL.setFont(new Font("Impact", Font.PLAIN, 20));
                titoloL.setForeground(new Color(168, 68, 226));

            //JButton
                JButton visualizza = new JButton("Visualizza");
                JButton indietro = new JButton("Indietro");
                JButton cancella = new JButton("Cancella");
                JButton giudica = new JButton("Giudica");
                JButton add = new JButton("Aggiungi");
                visualizza.addActionListener(this::actionListenerVisualizza);
                indietro.addActionListener(this::actionListenerIndietro);
                cancella.addActionListener(this::actionListenerCancellaCanzone);
                giudica.addActionListener(this::actionListenerGiudica);
                add.addActionListener(this::actionListenerAggiungiCanzone);

            //JList
                risultati = new JList<>();
                risultati.setPreferredSize(new Dimension(260, listaRicerca.size()*18));
                risultati.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                JScrollPane js = new JScrollPane(risultati);

            //Riempio la JList con i Brani
                DefaultListModel<Brano> lm = new DefaultListModel<Brano>();
                for (Brano b : listaRicerca)
                    lm.addElement(b);
                risultati.setModel(lm);

            //JPanel
                JPanel pTitolo = new JPanel(new FlowLayout());
                JPanel pCentro = new JPanel();
                JPanel pBottoni = new JPanel(new FlowLayout());

                pTitolo.add(titoloL);
                pCentro.add(js);
                pBottoni.add(indietro);
                pBottoni.add(cancella);
                pBottoni.add(add);
                pBottoni.add(visualizza);
                pBottoni.add(giudica);

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
    * Al clic del bottone <code>indietro</code> verr&agrave; creata una nuova finestra <code>ElencoPlaylist</code>
    * e verr&agrave; chiusa la finestra <code>VisualizzaPlaylist</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * @see ElencoPlaylist
    */
    private void actionListenerIndietro(ActionEvent e) {
        this.setVisible(false);
        new ElencoPlaylist(username).setVisible(true);
        this.dispose();
    }

    /**
    * Al clic del bottone <code>cancella</code> verr&agrave; cancellata la canzone selezionata utilizzando il metodo <code>cancellaCanzone</code>,
    * verr&agrave; creata una nuova finestra <code>ElencoPlaylist</code> e verr&agrave; chiusa la finestra <code>VisualizzaPlaylist</code> in esecuzione.
    * <br>se non &egrave; stato selezionato nessun brano verr&agrave; visualizzato un messaggio di errore.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>cancella</code>
    * @see ElencoPlaylist
    */
    private void actionListenerCancellaCanzone(ActionEvent e){
        if (this.risultati.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Selezionare una canzone", "Errore Selezione", 2);
        } else {
            try {
                cancellaCanzone(this.risultati.getSelectedValue().getId());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Canzone Cancellata correttamente", "Cancellazione", 1);
            this.setVisible(false);
            new ElencoPlaylist(username);
            dispose();
        }
    }

    /**
    * Al clic del bottone <code>aggiungi</code> verr&agrave; creata una nuova finestra <code>CercaBranoMusicale</code>
    * e verr&agrave; chiusa la finestra <code>VisualizzaPlaylist</code> in esecuzione per permettere l'agiunta di una nuova canzone alla playlist.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>aggiungi</code>
    * @see CercaBranoMusicale
    */
    private void actionListenerAggiungiCanzone(ActionEvent e){
        this.setVisible(false);
        (new CercaBranoMusicale(username,this.p.getNome(),"",true,true)).setVisible(true);
        dispose();

    }

    /**
    * Al clic del bottone <code>giudica</code>, se &egrave; stato selezionato un brano nella JList
    * <code>risultati</code>, viene creata una nuova finestra <code>GiudicaBrano</code> e viene
    * settata a "false" la visibilità della finestra <code>VisualizzaPlaylist</code> in esecuzione.
    * <br> Nel caso in cui non fosse stato selezionato un brano, viene mostrata una finstra
    * contenente un messaggio di errore.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>giudica</code>
    * @see GiudicaBrano
    */
    private void actionListenerGiudica(ActionEvent e) {
        if (this.risultati.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Selezionare un brano", "Errore Selezione", 2);
        } else {
            setVisible(false);
            (new GiudicaBrano(username,this,this.risultati.getSelectedValue(),this.p)).setVisible(true);
            dispose();
        }
    }

    /**
    * Al clic del bottone <code>visualizza</code>, se &egrave; stato selezionato un brano nella JList
    * <code>risultati</code>, viene creata una nuova finestra <code>VisualizzaBranoMusicale</code> e viene
    * settata a "false" la visibilità della finestra <code>VisualizzaPlaylist</code> in esecuzione.
    * <br> Nel caso in cui non fosse stato selezionato un brano, viene mostrata una finestra
    * contenente un messaggio di errore.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>visualizza</code>
    * @see VisualizzaBranoMusicale
    */
    private void actionListenerVisualizza(ActionEvent e) {
        if(risultati.getSelectedValue()==null) {
            JOptionPane.showMessageDialog(this, "Selezionare un brano", "Errore Selezione", JOptionPane.WARNING_MESSAGE);
        }else {
            for (Brano b : listaRicerca) {
                if(risultati.getSelectedValue().equals(b))
                    BranoSelezionato = b;
            }
            this.setVisible(false);
            new VisualizzaBranoMusicale(username, BranoSelezionato,this).setVisible(true);
        }
    }

    /**
    * Metodo che si occupa di effettuare la ricerca del/dei brano/brani sulla base dei parametri inseriti nella schermata
    * <code>ElencoPlaytlist</code> all'interno del file "Canzoni.dati. Viene unicamente richiamato in fase di costruzione della
    * finestra con il solo scopo di mostrare all'utente i risultati trovati all'interno della JList <code>risultati</code>.
    * A sua volta utilizza il metodo <code>dettagliCanzone</code> per riempire la JList <code>risultati</code> di oggetti di tipo <code>Brano</code>.
    * @throws IOException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
    * @throws EOFException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>EOFException</code> che pu&ograve; essere sollevata dal metodo.
    */
    private void ricercaBrani() throws IOException, EOFException{
        client=new clientES();
        listaRicerca=client.VisualizzaCanzoniPLaylist(username, nome);
        client.close();
    }


    /**
    * Metodo che si occupa di effettuare la cancellazione del brano selezionato p
    * Viene sempre chiamato quando si vuole effettuare la cancellazione di un brano dalla playlist.
    * @param  &egrave; la stringa che permette la ricerca e l'eliminazione del brano corretto dal file.
    * @throws IOException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
    */
    private void cancellaCanzone(String idCanzone) throws IOException {
        client = new clientES();
        client.cancellaCanzone(idCanzone, this.p, username);
        client.close();
    }
}
