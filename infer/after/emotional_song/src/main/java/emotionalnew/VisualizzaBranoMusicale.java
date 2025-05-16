package emotionalnew;

import ClassiSerializzabili.Giudizio;
import ClassiSerializzabili.Brano;
import clientES.clientES;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

/**
* Questa classe consente di visualizzare i dati e le recensioni associate al brano selezionato
* nella finestra <code>RisultatiRicerca</code> oppure nella finestra <code>VisualizzaPlaylist</code>.
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class VisualizzaBranoMusicale extends javax.swing.JFrame {

    /**
    * Contiene l'oggetti <code>Brano</code> passato dal metodo precedente.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private Brano Canzone;

    /**
    * Contiene lo username del cliente che ha eseguito l'accesso.
    * Se invece &egrave; stata utilizzata la funzionalit&agrave; "consulta repository", questo attributo conterr&agrave; una stringa vuota.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private String username;

    /**
    * Contiene il riferimento della finestra "padre" <code>RisultatiRicerca</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private RisultatiRicerca risultatiRicerca;

    /**
    * Contiene il riferimento della finestra "padre" <code>VisualizzaPlaylist</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private VisualizzaPlaylist braniPlaylist;

    /**
    * Contiene il valore di ritorno associato al tipo di instanza di r.
    * Permette il ritorno alla finestra "padre" corretta.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private int ritorno;

    /**
    * Contiene il nome della canzone da visualizzare.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private String nomeCanzone;

    /**
    * Contiene gli oggetti <code>Giudizio</code> trovati in fase di ricerca.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private ArrayList<Giudizio> giudizi = new ArrayList<Giudizio>();

    /**
    * Contiene le stringhe con i dettagli di tutti i giudizi trovati, relativi al ristorante.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private JList<String> risultati;

    /**
    * Area in cui il cliente pu&ograve; visualizzare il commento, assegnato al ristorante, per ogni
    * giudizio presente nella JList <code>risultati</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private JTextArea areaCommento;

    /**
    * Area in cui il cliente pu&ograve; visualizzare il voto, assegnato alla singola emozione.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private JTextArea areaVoto;

    /**
    * Array in cui vengono assegnate tutti i commenti delle emozioni.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private int[] emozioni = new int[]{0,0,0,0,0,0,0,0,0};

    /**
    * Array in cui vengono assegnate tutte le valutazioni delle emozioni.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private int[] valutazione = new int[]{0,0,0,0,0,0,0,0,0};

    /**
    * Array in cui vengono assegnate tutte le medie delle valutazioni delle emozioni.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private double[] media = new double[]{0,0,0,0,0,0,0,0,0};

    /**
     * istanza della classe client
     */
    private clientES client;

    /**
    * Metodo costruttore della classe <code>VisualizzaBranoMusicale</code>
    * @param b In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>Canzone</code> della classe.
    * @param r In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>braniPlaylist</code> oppure l'attributo <code>risultatiRicerca</code> della classe.
    * @param username In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>nickname</code> della classe.
    */
    public VisualizzaBranoMusicale(String username, Brano b, Object r) {
        super("Visualizza: "+ b.getTitolo());
        this.setSize(680, 580);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.Canzone = b;
        this.nomeCanzone=b.getTitolo();
        this.username = username;
            if(r instanceof RisultatiRicerca){
                this.risultatiRicerca =(RisultatiRicerca) r;
                this.ritorno = 0;
            }
            else {
                this.braniPlaylist =(VisualizzaPlaylist) r;
                this.ritorno = 1;
            }
            try {
                visualizzaEmozioneBrano();
            } catch (EOFException eof) {
                eof.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JLabel titoloL = new JLabel("Dettagli "+nomeCanzone);
            JLabel canzoneL = new JLabel("NOME: " + nomeCanzone);
            JLabel annoL = new JLabel("ANNO: " + b.getAnno());
            JLabel autoreL = new JLabel("AUTORE: " + b.getAutore());
            JLabel riepilogoL = new JLabel("MEDIA GIUDIZI: ");
            JLabel stuporeL = new JLabel("Stupore: "+media[0]);
            JLabel solennitaL = new JLabel("Solennita': "+media[1]);
            JLabel tenerezzaL = new JLabel("tenerezza: "+media[2]);
            JLabel nostalgiaL = new JLabel("Nostalgia: "+media[3]);
            JLabel calmaL = new JLabel("Calma: "+media[4]);
            JLabel potenzaL = new JLabel("Potenza: "+media[5]);
            JLabel gioiaL = new JLabel("Gioia: "+media[6]);
            JLabel tensioneL = new JLabel("Tensione: "+media[7]);
            JLabel tristezzaL = new JLabel("Tristezza: "+media[8]);
            titoloL.setFont(new Font("Impact", Font.PLAIN, 20));
            titoloL.setForeground(new Color(168, 68, 226));
            JButton indietro = new JButton("Indietro");
            indietro.addActionListener(this::actionListenerIndietro);
            risultati = new JList<>();
            risultati.setPreferredSize(new Dimension(200, 100));
            risultati.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            risultati.addListSelectionListener(this::risulatiSelectionListener);
            JScrollPane js = new JScrollPane(risultati);
            DefaultListModel<String> lm = new DefaultListModel<String>();
            areaVoto = new JTextArea("Selezionare un utente",9,20);
            areaVoto.setLineWrap(true);
            areaVoto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            areaVoto.setEditable(false);
            areaVoto.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            JScrollPane jsP = new JScrollPane(areaVoto);
            areaCommento = new JTextArea("Selezionare un utente",9,20);
            areaCommento.setLineWrap(true);
            areaCommento.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            areaCommento.setEditable(false);
            areaCommento.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            JScrollPane jsC = new JScrollPane(areaCommento);
            String temp = "";
            int i=1;
            for (Giudizio g : giudizi) {
                temp = i+") Username: " + g.getUsername();
                lm.addElement(temp);
                i++;
            }
            if(i==1) {
                lm.addElement("Non sono presenti recensioni");
                risultati.setModel(lm);
                JOptionPane.showMessageDialog(this, "Non sono presenti recensioni per il brano selezionato", "Nessun elemento da visualizzare", 2);
            }else {
                risultati.setModel(lm);
            }
            JPanel pInfoBrano = new JPanel(new GridLayout(0, 1, 0, 2));
            JPanel pRiepilogoGiudizi = new JPanel(new GridLayout(0, 1));
            JPanel pBottoni =  new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JPanel pTitolo = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
            JPanel pLabelCommento = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel pLabelVoti = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel pLabelGiudizi = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel pSinistro = new JPanel();
            JPanel pCentro = new JPanel();
            JPanel pMod = new JPanel();
            JPanel pInterno = new JPanel();
            JPanel pInterno2 = new JPanel();
            pSinistro.setLayout(new BoxLayout(pSinistro, BoxLayout.Y_AXIS));
            pCentro.setLayout(new BoxLayout(pCentro, BoxLayout.Y_AXIS));
            pMod.setLayout(new BoxLayout(pMod, BoxLayout.X_AXIS));
            pInterno.setLayout(new BoxLayout(pInterno, BoxLayout.Y_AXIS));
            pInterno2.setLayout(new BoxLayout(pInterno2, BoxLayout.Y_AXIS));
            pLabelVoti.add(new JLabel("VOTO UTENTE: "));
            pLabelCommento.add(new JLabel("COMMENTI: "));
            pLabelGiudizi.add(new JLabel("GIUDIZI: "));
            pInfoBrano.add(canzoneL);
            pInfoBrano.add(annoL);
            pInfoBrano.add(autoreL);
            pRiepilogoGiudizi.add(riepilogoL);
            pRiepilogoGiudizi.add(stuporeL);
            pRiepilogoGiudizi.add(solennitaL);
            pRiepilogoGiudizi.add(tenerezzaL);
            pRiepilogoGiudizi.add(nostalgiaL);
            pRiepilogoGiudizi.add(calmaL);
            pRiepilogoGiudizi.add(potenzaL);
            pRiepilogoGiudizi.add(gioiaL);
            pRiepilogoGiudizi.add(tensioneL);
            pRiepilogoGiudizi.add(tristezzaL);
            pBottoni.add(indietro);
            pTitolo.add(titoloL);
            pSinistro.add(pInfoBrano);
            pSinistro.add(Box.createRigidArea(new Dimension(0, 20)));
            pSinistro.add(pRiepilogoGiudizi);
            pCentro.add(pLabelGiudizi);
            pCentro.add(js);
            pCentro.add(Box.createRigidArea(new Dimension(0, 10)));
            pInterno.add(pLabelVoti);
            pInterno.add(jsP);
            pInterno2.add(pLabelCommento);
            pInterno2.add(jsC);
            pMod.add(pInterno);
            pMod.add(pInterno2);
            pCentro.add(pMod);
            JPanel principale = new JPanel();
            principale.setBorder(new EmptyBorder(0, 10, 0, 10));
            principale.setLayout(new BorderLayout(10,5));
            principale.add(pTitolo, BorderLayout.NORTH);
            principale.add(pSinistro, BorderLayout.WEST);
            principale.add(pCentro, BorderLayout.CENTER);
            principale.add(pBottoni, BorderLayout.SOUTH);
            this.getContentPane().add(principale);
            this.setVisible(true);
    }

    /**
    * Alla selezione di un giudizio presente nella JList <code>risultati</code> viene valorizzata la JTextArea
    * <code>areaCommento</code> con il commento e la valutazione associate al giudizio selezionato.
    * @param e Oggetto di tipo ListSelectionEvent contenente tutte le informazioni
    * sul clic di un elemento della JList <code>risultati</code>
    */
    private void risulatiSelectionListener(ListSelectionEvent e) {
        if(!risultati.getSelectedValue().equals("Non sono presenti recensioni")) {
            int indice = Integer.parseInt(risultati.getSelectedValue().substring(0,1));
            Giudizio giudizioSelezionato = giudizi.get(indice-1);
            String temp =
                    "STUPORE: " + giudizioSelezionato.getCommentoStupore()+ "\n"
                            + "SOLENNITA': " + giudizioSelezionato.getCommentoSolennita()+"\n"
                            + "TENEREZZA: " + giudizioSelezionato.getCommentoTenerezza()+ "\n"
                            + "NOSTALGIA: " + giudizioSelezionato.getCommentoNostalgia()+ "\n"
                            + "CALMA: " + giudizioSelezionato.getCommentoCalma()+ "\n"
                            + "POTENZA: " + giudizioSelezionato.getCommentoPotenza()+ "\n"
                            + "GIOIA: " + giudizioSelezionato.getCommentoGioia()+ "\n"
                            + "TENSIONE: " + giudizioSelezionato.getCommentoTensione()+ "\n"
                            + "TRISTEZZA: " + giudizioSelezionato.getCommentoTristezza();
            areaCommento.setText(temp);
            String temp2 =
                    " Stupore: "+giudizioSelezionato.getValutazioneStupore()+ "\n"
                            +" Solennita': "+giudizioSelezionato.getValutazioneSolennita()+ "\n"
                            +" Tenerezza: "+giudizioSelezionato.getValutazioneTenerezza()+"\n"
                            +" Nostalgia: "+giudizioSelezionato.getValutazioneNostalgia()+"\n"
                            +" Calma: "+giudizioSelezionato.getValutazioneCalma()+"\n"
                            +" Potenza: "+giudizioSelezionato.getValutazionePotenza()+"\n"
                            +" Gioia: "+giudizioSelezionato.getValutazioneGioia()+"\n"
                            +" Tensione: "+giudizioSelezionato.getValutazioneTensione()+"\n"
                            +" Tristezza: "+giudizioSelezionato.getValutazioneTristezza();
            areaVoto.setText(temp2);
        }
    }

    /**
    * Al clic del bottone <code>indietro</code> viene settata a "true" la visibilità della schermata "padre"
    * <code>RisultatiRicerca</code> oppure <code>VisualizzaPlaylist</code> e successivamente viene chiusa la schermata <code>VisualizzaBranoMusicale</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * @see RisultatiRicerca
    */
    private void actionListenerIndietro(ActionEvent e) {
        if(ritorno == 0){
            this.setVisible(false);
            risultatiRicerca.setVisible(true);
            this.dispose();
        }else{
            this.setVisible(false);
            braniPlaylist.setVisible(true);
            this.dispose();
        }
    }

    /**
    * Il metodo si occupa di effettuare la ricerca di tutti i giudizi, associati al brano selezionato
    * @throws IOException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
    * @throws EOFException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>EOFException</code> che pu&ograve; essere sollevata dal metodo.
    */
    private void visualizzaEmozioneBrano() throws IOException, EOFException{
        client = new clientES();
        client.visualizzaEmozioneBrano(Canzone);
        emozioni=client.getEmozioni();
        valutazione=client.getValutazione();
        media=client.getMedia();
        giudizi=client.getGiudizio();
        client.close();
    }
}
    
