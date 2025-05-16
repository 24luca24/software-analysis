package emotionalnew;

import ClassiSerializzabili.Playlist;
import ClassiSerializzabili.Brano;
import clientES.clientES;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Questa classe mostra il/i Brano/i trovati dalla ricerca e grazie alcuni metodi permette di:
* <br>1) Visulizzare un brano;
* <br>2) Aggiungere un brano alla playlist;
* <br>3) Creare una playlist;
* <br>4) Giudicare un brano;
* <br>4) Tornare al tipo di ricerca;
* Rende visibili con un elenco i brani cercati dall'utente.
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
* @see VisualizzaBranoMusicale
* @see GiudicaBrano
* @see CercaBranoMusicale
* @see ElencoPlaylist
*/
public class RisultatiRicerca extends javax.swing.JFrame {

    /**
    * Contiene lo username del cliente che ha eseguito l'accesso.
    * Se invece &egrave; stata utilizzata la funzionalit&agrave; "consulta repository", questo attributo conterr&agrave; una stringa vuota.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private String username;

    /**
    * Contiene gli oggetti di tipo <code>Brano</code>, trovati dalla ricerca.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private JList<Brano> risultati;

    /**
    * Pu&ograve; contenere il nome ricercato nella finestra <code>CercaBranoMusicale</code>, in base al
    * metodo di ricerca scelto.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String filtro1;

    /**
    * Nel caso in cui sia stata utilizzata la ricerca per autore e anno, questo attributo contiene
    * il tipo ricercato nella finestra precedente.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String filtro2;

    /**
    * Conterr&agrave; il nome dell'oggetto <code>Playlist</code> a cui appartiene il brano.
    * Se viene passato da <code>RisultatiRicerca</code> risulta null.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String nomePlaylist;

    /**
    * Conterr&agrave; l'oggetto <code>Brano</code> selezionato dalla JList <code>risultati</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private Brano branoSelezionato;

    /**
    * Contiene una variabile booleana che permette l'aggiunta di pi&ugrave; brani.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private boolean selezionaUnAltro;

    /**
    * Contiene una variabile booleana che permette la visualizzazione di alcuni bottoni solo dopo il login.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private boolean aggiungi;

    /**
    * Conterr&agrave; l'oggetto <code>Plyalist</code> che deve essere passato alla finestra <code>GiudicaBrano</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private Playlist pl;

    /**
    * Contiene gli oggetti <code>Brano</code> trovati dal metodo <code>cercaBranoMusicale</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private ArrayList<Brano> listaRicerca = new ArrayList<>();

    /**
    * Contiene i brani da aggiungere alla playlist.
    * Potrebbe essere vuota.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    String risultatiTitoli;

    /**
     * istanza di client
     */
    private clientES client;

    /**
    * Metodo costruttore della finestra <code>RisultatiRicerca</code>
    * @param filtro1 valorizza l'attributo <code>filtro1</code> della classe.
    * @param filtro2 valorizza l'attributo <code>filtro2</code> della classe.
    * @param tipoRicerca contiene un numero da 1 a 2, che indica quale tipo di ricerca si intende effettuare:
    * <br>1)per titolo
    * <br>2)per autore e anno
    * @param username In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>nickname</code> della classe.
    * @param nomePlaylist  In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>nomePlaylist</code> della classe.
    * @param RisTitol In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>risultatiTitoli</code> della classe.
    * @param add In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>aggiungi</code> della classe.
    */
    public RisultatiRicerca(String filtro1, String filtro2, int tipoRicerca, String username, String nomePlaylist, String RisTitol, boolean add) {
        super("Risultati Ricerca");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.username = username;
        this.filtro1 = filtro1;
        this.filtro2 = filtro2;
        this.nomePlaylist = nomePlaylist;
        this.risultatiTitoli= RisTitol;
        this.aggiungi= add;
        this.selezionaUnAltro=true;
        pl=new Playlist();
        pl.setNome("");
        try {
            cercaBranoMusicale(tipoRicerca);
        } catch (IOException eof) {
            eof.printStackTrace();
        }
        if (this.listaRicerca.size() == 0) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(this, "Nessun brano trovato", "Errore", 2);
            setVisible(false);
            if (aggiungi) (new CercaBranoMusicale(username,nomePlaylist,risultatiTitoli,true, aggiungi)).setVisible(true);
            else if(risultatiTitoli.equals("")) (new CercaBranoMusicale(username,nomePlaylist,risultatiTitoli,true, aggiungi)).setVisible(true);
            else (new CercaBranoMusicale(username,nomePlaylist,risultatiTitoli,false, aggiungi)).setVisible(true);
            dispose();
        } else {
            setSize(330, 260);
            setResizable(false);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                JLabel titoloL = new JLabel("Risultati Ricerca: " + this.listaRicerca.size());
                titoloL.setFont(new Font("Impact", 0, 20));
                titoloL.setForeground(new Color(168, 68, 226));
                JButton visualizza = new JButton("Visualizza");
                JButton indietro = new JButton("Annulla");
                JButton giudica = new JButton("Giudica");
                JButton addPlaylist = new JButton("Aggiungi alla Playlist");
                JButton addBranoSingolo = new JButton("Aggiungi");
                visualizza.addActionListener(this::actionListenerVisualizza);
                indietro.addActionListener(this::actionListenerIndietro);
                giudica.addActionListener(this::actionListenerGiudica);
                addPlaylist.addActionListener(this::actionListeneraddPlaylist);
                addBranoSingolo.addActionListener(this::actonlisteneraddBranoSingolo);
                if(nomePlaylist.equals("") || username.equals(""))
                    addPlaylist.setEnabled(false);
                if(username.equals("") || !nomePlaylist.equals(""))
                    giudica.setEnabled(false);
                if(aggiungi==false)
                    addBranoSingolo.setEnabled(false);
                this.risultati = new JList<>();
                this.risultati.setPreferredSize(new Dimension(460, this.listaRicerca.size()*18));
                this.risultati.setSelectionMode(0);
                JScrollPane js = new JScrollPane(this.risultati);
                DefaultListModel<Brano> lm = new DefaultListModel<>();
                for (Brano r : this.listaRicerca){
                    lm.addElement(r);
                }
                this.risultati.setModel(lm);
                JPanel pTitolo = new JPanel(new FlowLayout());
                JPanel pCentro = new JPanel();
                JPanel pBottoni = new JPanel(new FlowLayout());
                pTitolo.add(titoloL);
                pCentro.add(giudica);
                pCentro.add(js);
                pBottoni.add(indietro);
                pBottoni.add(visualizza);
                pBottoni.add(giudica);
                if(aggiungi==false){
                    pBottoni.add(addPlaylist);
                }else{
                    pBottoni.add(addBranoSingolo);
                }
                Container principale = getContentPane();
                principale.setLayout(new BorderLayout());
                principale.add(pTitolo, "North");
                principale.add(pCentro, "Center");
                principale.add(pBottoni, "South");
                pack();
                setVisible(true);
        }
    }

    /**
    * Al clic del bottone <code>indietro</code> verr&agrave; creata una nuova finestra <code>CercaBranoMusicale</code>
    * e verr&agrave; chiusa la finestra <code>VisualizzaPlaylist</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * @see ElencoPlaylist
    */
    private void actionListenerIndietro(ActionEvent e) {
        setVisible(false);
        (new CercaBranoMusicale(this.username,nomePlaylist,risultatiTitoli,true,aggiungi)).setVisible(true);
        dispose();
    }

    /**
    * Al clic del bottone <code>giudica</code>, se &egrave; stato selezionato un brano nella JList
    * <code>risultati</code>, viene creata una nuova finestra <code>GiudicaBrano</code> e viene
    * settata a "false" la visibilità della finestra <code>RisultatiRicerca</code> in esecuzione.
    * <br> Nel caso in cui non fosse stato selezionato un brano, viene mostrata una finestra
    * contenente un messaggio di errore.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>giudica</code>
    * @see GiudicaBrano
    */
    private void actionListenerGiudica(ActionEvent e) {
        if (this.risultati.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Selezionare un brano", "Errore Selezione", JOptionPane.WARNING_MESSAGE);
        } else {
            setVisible(false);
            (new GiudicaBrano(this.username,this,this.risultati.getSelectedValue(),pl)).setVisible(true);
            dispose();
        }
    }

    /**
    * Al clic del bottone <code>addPlaylist</code>, se &egrave; stato selezionato un brano nella JList
    * <code>risultati</code>, viene invocato il metodo <code>RegistraPlaylist</code> che permette di aggiungere i brani selezionati.
    * <br> Nel caso in cui non fosse stato selezionato un brano, viene mostrata una finestra
    * contenente un messaggio di errore.
    * <br>Il metodo effettua diversi controlli e risulta chiamabile solo quando viene creata una nuova playlist.
    * Permette tramite una finestra l'aggiunta di pi&ugrave; canzoni mantenendo o utilizzando una nuova ricerca.
    * Se si vanno ad aggiungere pi&ugrave; canzoni viene creata una nuova finestra <code>CercaBranoMusicale</code> e viene
    * settata a "false" la visibilità della finestra <code>RisultatiRicerca</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>giudica</code>
    * @see CercaBranoMusicale
    */
    private void actionListeneraddPlaylist(ActionEvent e){
        if (this.risultati.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Selezionare un brano", "Errore Selezione", 2);
        } else {
            Object[] options = {"Aggiungi","NO"};
            Object[] options2 = {"Cambia","Mantieni"};
            int conferma=0;
            int cambioTitolo=0;
            if(selezionaUnAltro){
                conferma = JOptionPane.showOptionDialog(null,"Vuoi aggiungere un altro brano?","seleziona Brano",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                if(conferma==0){
                    if(risultatiTitoli.equals("")) risultatiTitoli=risultatiTitoli+this.risultati.getSelectedValue().getId();
                    else risultatiTitoli=risultatiTitoli+ "$" + this.risultati.getSelectedValue().getId();
                    cambioTitolo = JOptionPane.showOptionDialog(null,"Vuoi utilizzare lo stesso parametro di ricerca?","seleziona Brano",
                            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options2,options2[0]);
                    if(cambioTitolo==0){
                        setVisible(false);
                        (new CercaBranoMusicale(username,nomePlaylist,risultatiTitoli,false,false)).setVisible(true);
                        dispose();
                    }
                }else if(conferma==1){
                    if(risultatiTitoli.equals("")) risultatiTitoli=risultatiTitoli+this.risultati.getSelectedValue().getId();
                    else risultatiTitoli=risultatiTitoli+ "$" + this.risultati.getSelectedValue().getId();
                    selezionaUnAltro = false;
                    try {
                        RegistraPlaylist(risultatiTitoli);
                    } catch (IOException ex) {
                        Logger.getLogger(RisultatiRicerca.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    /**
    * Al clic del bottone <code>visualizza</code>, se &egrave; stato selezionato un brano nella JList
    * <code>risultati</code>, viene creata una nuova finestra <code>VisualizzaBranoMusicale</code> e viene
    * settata a "false" la visibilità della finestra <code>RisultatiRicerca</code> in esecuzione.
    * <br> Nel caso in cui non fosse stato selezionato un brano, viene mostrata una finestra
    * contenente un messaggio di errore.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>visualizza</code>
    * @see VisualizzaBranoMusicale
    */
    private void actionListenerVisualizza(ActionEvent e) {
        if (this.risultati.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Selezionare un brano", "Errore Selezione", 2);
        } else {
            for (Brano r : this.listaRicerca) {
                if ((this.risultati.getSelectedValue()).equals(r))
                    this.branoSelezionato = r;
            }
            setVisible(false);
            (new VisualizzaBranoMusicale(username,branoSelezionato,this)).setVisible(true);
            dispose();
        }
    }

    /**
    * Al clic del bottone <code>addBranoSingolo</code>, se &egrave; stato selezionato un brano nella JList
    * <code>risultati</code>, viene invocato il metodo <code>creaCanzone</code> che permette di aggiungere il brano selezionato alla playlist.
    * <br> Nel caso in cui non fosse stato selezionato un brano, viene mostrata una finestra
    * contenente un messaggio di errore.
    * <br>Il metodo risulta chiamabile solo quando viene aggiunto un solo brano ad una playlist.
    * <br>Al termine del metodo viene creata una nuova finestra <code>ElencoPlaylist</code> e viene
    * settata a "false" la visibilità della finestra <code>RisultatiRicerca</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>giudica</code>
    * @see ElencoPlaylist
    */
    private void actonlisteneraddBranoSingolo(ActionEvent e) {
        if (this.risultati.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Selezionare un brano", "Errore Selezione", JOptionPane.WARNING_MESSAGE);
        }else {
            creaCanzone(this.risultati.getSelectedValue().getId());
            JOptionPane.showMessageDialog(this, "Canzone Aggiunta correttamente", "Aggiunta", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            new ElencoPlaylist(username);
            dispose();
        }
    }

    /**
    * Metodo che si occupa di effettuare la ricerca del/dei brano/brani sulla base dei parametri inseriti nella schermata
    * <code>CercaBranoMusicale</code> all'interno del file "Canzoni.dati. Viene unicamente richiamato in fase di costruzione della
    * finestra con il solo scopo di mostrare all'utente i risultati trovati all'interno della JList <code>risultati</code>.
    * @param index Contiene un numero da 1 a 2 indicante il tipo di ricerca da effettuare (1=Titolo, 2=Autore e anno).
    * @throws IOException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
    * @throws EOFException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>EOFException</code> che pu&ograve; essere sollevata dal metodo.
    */
    private void cercaBranoMusicale(int index) throws IOException {
        client = new clientES();
        listaRicerca = client.cercaBranoMusicale(index, filtro1, filtro2);
        client.close();
    }
    
    /**
    * Metodo che si occupa di passare i dati della registrazione della nuova playlist al metodo <code>RegistraPlaylist</code>
    * del client, il quale poi invier&agrave; i dati al serverSlave che li salveragrave; nel database e ritorner&agrave; un boolean
    * come esito dell'operazione
    * Viene chiamato in fase di costruzione della nuova playlist.
    * @param s Contiene la stringa di brani da inserire nella playlist.
    * @throws IOException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
    * @throws EOFException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>EOFException</code> che pu&ograve; essere sollevata dal metodo.
    */
    private void RegistraPlaylist(String s) throws IOException, EOFException{
        boolean esito = false;
        client = new clientES();
        esito = client.RegistraPlaylist(s, nomePlaylist, username);
        client.close();
        
        if(esito==true){
            JOptionPane.showMessageDialog(this, "Registrazione Playlist effettuata con successo", "Registrazione", 1);
                setVisible(false);
                (new ElencoPlaylist(username)).setVisible(true);
                dispose();
        } else{
        }  
    }

    /**
    * Metodo che si occupa di passare l'id di un brano da aggiungere a una playlist al metodo <code>creaCanzone</code>
 *  * della classe client, il quale poi lo passeer&agrave; al serverSlave che lo inserir&agrave; nel database
    * Viene chiamato in fase di un brano ad una playlist.
    * @param idSel Contiene l'id della canzone da aggiungere alla playlist.
    * @throws IOException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
    */
    private void creaCanzone(String idSel){
        client = new clientES();
        client.creaCanzone(idSel,nomePlaylist,username);
        client.close();
    }
}