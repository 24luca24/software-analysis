package emotionalnew;

import ClassiSerializzabili.Playlist;
import ClassiSerializzabili.Brano;
import clientES.clientES;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
* Questa classe consente di giudicare il brano selezionato nella finestra <code>RisultatiRicerca</code> o nella finestra <code>VisualizzaPlaylist</code>.
* Se il brano &egrave; gi&agrave; stato giudicato permette di sovrascriverne il giudizio
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class GiudicaBrano extends javax.swing.JFrame {

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
    * Conterr&agrave; un numero da 1 a 5, in base alla valutazione assegnata dal cliente per ogni emozione.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private int[] valutazione= new int[9];

    /**
    * Contiene il nome del brano selezionato nella finestra "padre" <code>RisultatiRicerca</code> o <code>VisualizzaPlaylist</code>.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String titolo;

    /**
    * Contiene lo username dell'utente che ha eseguito l'accesso.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String username;

    /**
    * Contiene il valore di ritorno associato al tipo d'instanza di r.
    * Permette il ritorno alla finestra "padre" corretta.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private int ritorno;

    /**
    * Contiene l'id della canzone da giudicare.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private String id;

    /**
    * Conterr&agrave; l'oggetto <code>Playlist</code> a cui appartiene il brano.
    * Se viene passato da <code>RisultatiRicerca</code> risulta null.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private Playlist pl;

    /**
    * Variabile boolean che permette di annullare o salvare il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale.
    */
    private boolean nomEssaggio;

    /**
    * Array di Stringhe contenenti i nomi delle emozioni.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String[] emozioni = {"Stupore:", "Solennita':", "Tenerezza:","Nostalgia:","Calma:","Potenza:","Gioia:","Tensione:","Tristezza:"};

    /**
    * Array di Stringhe contenenti le colonne presenti.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String[] colonne = {"Categoria emozioni","Spiegazioni","Valutazione","Note (max 256 caratteri)"};

    /**
    * Array di bottoni. Sono necessari per assegnare la valutazione.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private JButton[] stelle = new JButton[45];

    /**
    * URL Icona stella piena.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private  java.net.URL logoFull = getClass().getResource("/icons/starFull.png");
    
    /**
    * URL Icona stella piena.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private Icon stellaFull = new ImageIcon(logoFull);

    /**
     * Icona stella vuota.
     * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
     */
    private  java.net.URL logoUnfilled = getClass().getResource("/icons/starUnfilled.png");

    /**
    * Icona stella vuota.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private Icon stellaUnfilled = new ImageIcon(logoUnfilled);
    
    /**
    * Area in cui l'utente dovr&agrave; inserire il commento sul brano.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private JTextArea[] areaCommento = new JTextArea[9];

    /**
    * Permette di visualizzare tutti i commenti.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private JScrollPane[] js = new JScrollPane[9];

    /**
    * Contiene "true" se è stata assegnata una valutazione o "false" in caso contrario.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private boolean boolValutazione = false;

    /**
    * Metodo costruttore della classe <code>GiudicaBrano</code>
    * @param pl In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>Playlist</code>.
    * @param b In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>Brano</code>.
    * @param r In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>RisultatiRicerca</code> o <code>VisualizzaPlaylist</code> della classe.
    * @param username In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>username</code> della classe.
    */
    public GiudicaBrano(String username,Object r, Brano b, Playlist pl) {
        super("Giudica: " + b.getTitolo());
        this.pack();
        this.setSize(1150, 620);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pl = pl;
            this.nomEssaggio = false;
            this.titolo = b.getTitolo();
            this.id = b.getId();
            this.username = username;
            if(r instanceof RisultatiRicerca){
                this.risultatiRicerca =(RisultatiRicerca) r;
                this.ritorno = 0;
            }
            else {
                this.braniPlaylist =(VisualizzaPlaylist) r;
                this.ritorno = 1;
            }
                JLabel giudicaL = new JLabel("Giudica: ");
                JLabel[] commentoL = new JLabel[9];
                for(int y=0; y<9;y++){
                    commentoL[y]=new JLabel("Commento: ");
                }
                JLabel emozioneL;
                JLabel titoloL = new JLabel(titolo);
                titoloL.setFont(new Font("Impact", Font.PLAIN, 25));
                titoloL.setForeground(new Color(168, 68, 226));
                    JButton conferma = new JButton("Conferma");
                    JButton annulla = new JButton("Annulla");
                    conferma.addActionListener(this::actionListenerConferma);
                    annulla.addActionListener(this::actionListenerAnnulla);
                        for(int y=0;y<9;y++){
                            areaCommento[y] = new JTextArea(12,20);
                            areaCommento[y].setLineWrap(true);
                            areaCommento[y].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                            js[y]=new JScrollPane(areaCommento[y]);
                        }
                            JPanel pCommento = new JPanel(new FlowLayout(0));
                            JPanel pText = new JPanel(new FlowLayout(0));
                            JPanel pCentro = new JPanel(new GridLayout(9, 4));
                            JPanel pCorpo = new JPanel();
                            JPanel pSinistra = new JPanel();
                            JPanel pDestra = new JPanel();
                            JPanel pIntestazione = new JPanel();
                            pCorpo.setLayout(new BoxLayout(pCorpo, BoxLayout.X_AXIS));
                            pSinistra.setLayout(new BoxLayout(pSinistra, BoxLayout.X_AXIS));
                            pDestra.setLayout(new BoxLayout(pDestra, BoxLayout.X_AXIS));
                            pIntestazione.setLayout(new BoxLayout(pIntestazione, BoxLayout.X_AXIS));
                            JPanel pTitolo = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
                            JPanel pStelle = new JPanel(new FlowLayout(FlowLayout.LEFT));
                            JPanel pBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER));
                                JLabel descEmozL = new JLabel("EMOZIONE:");
                                JLabel spiegEmozL = new JLabel("DESCRIZIONE EMOZIONE:");//SOLENNITA'
                                JLabel valutazioneL = new JLabel("VALUTAZIONE:");//SOLENNITA'
                                JLabel commL = new JLabel("COMMENTO:");//SOLENNITA'
                                JLabel stuporeL = new JLabel("(Sensazione di meraviglia o felicità)");//STUPORE
                                JLabel solennitaL = new JLabel("(Sensazione di trascendenza, ispirazione. Emozioni)");//SOLENNITA'
                                JLabel tenerezzaL = new JLabel("(Sensualità, affetto, sentimento d'amore)");//TENEREZZA
                                JLabel nostalgiaL = new JLabel("(Sensazioni malinconiche, sentimentali e sogni)");//NOSTALGIA
                                JLabel calmaL = new JLabel("(Relax, serenità, meditazione)");//CALMA
                                JLabel potenzaL = new JLabel("(Sentirsi forte, eroico, trionfante, energico)");//POTENZA
                                JLabel gioiaL = new JLabel("(Avere la sensazione di ballare, saltellare, sentirsi animato, divertito)");//GIOIA
                                JLabel tensioneL = new JLabel("(Sentirsi nervosi, impazienti, irritati)");//tensioneL
                                JLabel tristezzaL = new JLabel("(Sentirsi depressi, addolorati)");//TRISTEZZA
                                        JPanel[] pLabel = new JPanel[9];
                                        JPanel[] pFstelle = new JPanel[9];
                                        JPanel[] pDescrizione = new JPanel[9];
                                        JPanel pEmozioni = new JPanel(new GridLayout(9,1));
                                        JPanel pSpiegazioneEmozioni = new JPanel(new GridLayout(9, 1));
                                        int k;
                                        for (k = 0; k< emozioni.length; k++) {
                                            pLabel[k] = new JPanel(new FlowLayout(0));
                                            pLabel[k].setForeground(Color.red);
                                            pFstelle[k] = new JPanel(new GridLayout(1, 5));
                                            pDescrizione[k] = new JPanel(new FlowLayout(1, 0, 20));
                                        }
                                            pTitolo.add(titoloL);
                                            pIntestazione.add(descEmozL);
                                            pIntestazione.add(spiegEmozL);
                                            pIntestazione.add(valutazioneL);
                                            pIntestazione.add(commL);
                                            int i=0;
                                            int j=0;
                                            String name;
                                            for(int z=0;z<emozioni.length;z++){
                                                emozioneL = new JLabel(emozioni[z]);
                                                pLabel[z].add(emozioneL);
                                            }
                                            pDescrizione[j].add(commentoL[j]);
                                            while(i<stelle.length && j<emozioni.length) {
                                                if(i==5 || i==10 || i==15 || i==20 || i==25 || i==30 || i==35 || i==40){
                                                    j++;
                                                    pDescrizione[j].add(commentoL[j]);
                                                }
                                                stelle[i] = new JButton(stellaUnfilled);
                                                stelle[i].setBorderPainted(false);
                                                stelle[i].setName("stella:"+i);
                                                stelle[i].setContentAreaFilled(false);
                                                stelle[i].setFocusPainted(false);
                                                stelle[i].setPreferredSize(new Dimension(45, 27));
                                                stelle[i].addActionListener(this::listenerStelle);
                                                pFstelle[j].add(stelle[i]);
                                                i++;
                                            }
                                            for (k = 0; k < emozioni.length; k++) {
                                                pEmozioni.add(pLabel[k]);
                                                pCentro.add(pFstelle[k]);
                                                pCentro.add(pDescrizione[k]);
                                                pCentro.add(js[k]);
                                            }
                                            pBottoni.add(annulla);
                                            pBottoni.add(conferma);
                                            pSpiegazioneEmozioni.add(stuporeL);
                                            pSpiegazioneEmozioni.add(solennitaL);
                                            pSpiegazioneEmozioni.add(tenerezzaL);
                                            pSpiegazioneEmozioni.add(nostalgiaL);
                                            pSpiegazioneEmozioni.add(calmaL);
                                            pSpiegazioneEmozioni.add(potenzaL);
                                            pSpiegazioneEmozioni.add(gioiaL);
                                            pSpiegazioneEmozioni.add(tensioneL);
                                            pSpiegazioneEmozioni.add(tristezzaL);
                                            pSinistra.add(pEmozioni);
                                            pDestra.add(pSpiegazioneEmozioni);
                                            pCorpo.add(pSinistra);
                                            pCorpo.add(pDestra);
                                            pCorpo.add(pCentro);
                                            Container principale = this.getContentPane();
                                            principale.setLayout(new BorderLayout());
                                            principale.add(pTitolo, BorderLayout.NORTH);
                                            principale.add(pCorpo, BorderLayout.CENTER);
                                            principale.add(pBottoni, BorderLayout.SOUTH);
                                            setVisible(true);
                                            
    }

    /**
    * Al clic del bottone <code>annulla</code> viene settata a "true" la visibilità della schermata "padre"
    * <code>RisultatiRicerca</code> oppure <code>VisualizzaPlaylist</code> e successivamente viene chiusa la schermata <code>GiudicaBrano</code> in esecuzione.
    * Il giudizio scritto non viene salvato.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * @see RisultatiRicerca
    * @see VisualizzaPlaylist
    */
    private void actionListenerAnnulla(ActionEvent e) {
        if (ritorno == 0) {
            this.setVisible(false);
            risultatiRicerca.setVisible(true);
            this.dispose();
        } else {
            this.setVisible(false);
            braniPlaylist.setVisible(true);
            this.dispose();
        }
    }

    /**
    * Al clic del bottone <code>conferma</code> viene valutata la presenza di errori,
    * se non ci sono, il giudizio scritto viene salvato sul file tramite il metodo <code>inserisciEmozioniBrano</code>
    * e poi viene settata a "true" la visibilità della schermata "padre" <code>RisultatiRicerca</code> oppure <code>VisualizzaPlaylist</code>
    * e successivamente viene chiusa la schermata <code>GiudicaBrano</code> in esecuzione;
    * Se invece ci sono errori viene visualizzata una finestra contenente il messaggio di errore.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>conferma</code>
    * @see RisultatiRicerca
    * @see VisualizzaPlaylist
    */
    private void actionListenerConferma(ActionEvent e) {
        String errori = "";
        if(boolValutazione==false) {
            errori = errori + "E'necessario assegnare una valutazione\n";
        }
        for(int u=0; u<9; u++){
            if (areaCommento[u].getText().length() > 256) {
                errori = errori + "Superato il limite massimo di caratteri (MAX 256)\n";
                break;
            }
        }
        System.out.println("errori: "+ errori);
        if(errori.equals("")) {
            try {
                inserisciEmozioniBrano();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(errori.equals("")){
            if(nomEssaggio==false){
                if(pl.getNome().equals("")){
                    JOptionPane.showMessageDialog(this, "Il giudizio e' stato salvato correttamente", "Giudizio Salvato", JOptionPane.INFORMATION_MESSAGE);
                    risultatiRicerca.setVisible(true);
                    nomEssaggio=false;
                    this.dispose();
                } else if(!pl.getNome().equals("")){
                    JOptionPane.showMessageDialog(this, "Il giudizio e' stato salvato correttamente", "Giudizio Salvato", JOptionPane.INFORMATION_MESSAGE);
                    new VisualizzaPlaylist(this.pl,username).setVisible(true);
                    nomEssaggio=false;
                    this.dispose();
                }
            }
            if(nomEssaggio==true){
                if(pl.getNome().equals("")){
                JOptionPane.showMessageDialog(this, "Operazione annullata correttamente", "Giudizio non Salvato", JOptionPane.INFORMATION_MESSAGE);
                risultatiRicerca.setVisible(true);
                nomEssaggio=false;
                this.dispose();
                }else if(!pl.getNome().equals("")){
                    JOptionPane.showMessageDialog(this, "Operazione annullata correttamente", "Giudizio non Salvato", JOptionPane.INFORMATION_MESSAGE);
                    new VisualizzaPlaylist(this.pl,username).setVisible(true);
                    nomEssaggio=false;
                    this.dispose();
               } 
            }
        }else{
            JOptionPane.showMessageDialog(this, "ATTENZIONE:\n"+errori, "Attenzione!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
    * Al clic di uno dei 45 bottoni presenti nell'array di bottoni <code>stelle</code>,
    * in base al valore della valutazione, viene cambiata l'icona di tutti i bottoni,
    * in modo da rispecchiare il voto assegnato.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone presente
    * nell'array <code>stelle</code>
    */

    private void listenerStelle(ActionEvent e) {
        boolValutazione = true;
        JButton button = (JButton)e.getSource();
        String s = button.getName();
        String[] nStella = s.split(":");
        int stPremuta = Integer.parseInt(nStella[1]);
        if(stPremuta==0 || stPremuta==5|| stPremuta==10|
                stPremuta==15|| stPremuta==20| stPremuta==25|
                stPremuta==30||stPremuta==35 || stPremuta==40) {
            stelle[stPremuta].setIcon(stellaFull);
            stelle[stPremuta+1].setIcon(stellaUnfilled);
            stelle[stPremuta+2].setIcon(stellaUnfilled);
            stelle[stPremuta+3].setIcon(stellaUnfilled);
            stelle[stPremuta+4].setIcon(stellaUnfilled);
            switch (stPremuta) {
                case 0:
                    valutazione[0]=1;
                    break;
                case 5:
                    valutazione[1]=1;
                    break;
                case 10:
                    valutazione[2]=1;
                    break;
                case 15:
                    valutazione[3]=1;
                    break;
                case 20:
                    valutazione[4]=1;
                    break;
                case 25:
                    valutazione[5]=1;
                    break;
                case 30:
                    valutazione[6]=1;
                    break;
                case 35:
                    valutazione[7]=1;
                    break;
                case 40:
                    valutazione[8]=1;
                    break;
                default:
                    break;
            }
        }else if(stPremuta==1 || stPremuta==6|| stPremuta==11|
                stPremuta==16|| stPremuta==21| stPremuta==26|
                stPremuta==31||stPremuta==36 || stPremuta==41) {
            stelle[stPremuta-1].setIcon(stellaFull);
            stelle[stPremuta].setIcon(stellaFull);
            stelle[stPremuta+1].setIcon(stellaUnfilled);
            stelle[stPremuta+2].setIcon(stellaUnfilled);
            stelle[stPremuta+3].setIcon(stellaUnfilled);
            switch (stPremuta) {
                case 1:
                    valutazione[0]=2;
                    break;
                case 6:
                    valutazione[1]=2;
                    break;
                case 11:
                    valutazione[2]=2;
                    break;
                case 16:
                    valutazione[3]=2;
                    break;
                case 21:
                    valutazione[4]=2;
                    break;
                case 26:
                    valutazione[5]=2;
                    break;
                case 31:
                    valutazione[6]=2;
                    break;
                case 36:
                    valutazione[7]=2;
                    break;
                case 41:
                    valutazione[8]=2;
                    break;
                default:
                    break;
            }
        }else if(stPremuta==2 || stPremuta==7|| stPremuta==12|
                stPremuta==17|| stPremuta==22| stPremuta==27|
                stPremuta==32||stPremuta==37 || stPremuta==42) {
            stelle[stPremuta-2].setIcon(stellaFull);
            stelle[stPremuta-1].setIcon(stellaFull);
            stelle[stPremuta].setIcon(stellaFull);
            stelle[stPremuta+1].setIcon(stellaUnfilled);
            stelle[stPremuta+2].setIcon(stellaUnfilled);
            switch (stPremuta) {
                case 2:
                    valutazione[0]=3;
                    break;
                case 7:
                    valutazione[1]=3;
                    break;
                case 12:
                    valutazione[2]=3;
                    break;
                case 17:
                    valutazione[3]=3;
                    break;
                case 22:
                    valutazione[4]=3;
                    break;
                case 27:
                    valutazione[5]=3;
                    break;
                case 32:
                    valutazione[6]=3;
                    break;
                case 37:
                    valutazione[7]=3;
                    break;
                case 42:
                    valutazione[8]=3;
                    break;
                default:
                    break;
            }
        } else if(stPremuta==3 || stPremuta==8|| stPremuta==13|
                stPremuta==18|| stPremuta==23| stPremuta==28|
                stPremuta==33||stPremuta==38 || stPremuta==43) {
            stelle[stPremuta-3].setIcon(stellaFull);
            stelle[stPremuta-2].setIcon(stellaFull);
            stelle[stPremuta-1].setIcon(stellaFull);
            stelle[stPremuta].setIcon(stellaFull);
            stelle[stPremuta+1].setIcon(stellaUnfilled);
            switch (stPremuta) {
                case 3:
                    valutazione[0]=4;
                    break;
                case 8:
                    valutazione[1]=4;
                    break;
                case 13:
                    valutazione[2]=4;
                    break;
                case 18:
                    valutazione[3]=4;
                    break;
                case 23:
                    valutazione[4]=4;
                    break;
                case 28:
                    valutazione[5]=4;
                    break;
                case 33:
                    valutazione[6]=4;
                    break;
                case 38:
                    valutazione[7]=4;
                    break;
                case 43:
                    valutazione[8]=4;
                    break;
                default:
                    break;
            }
        } else if(stPremuta==4 || stPremuta==9|| stPremuta==14|
                stPremuta==19|| stPremuta==24| stPremuta==29|
                stPremuta==34||stPremuta==39 || stPremuta==44) {
            stelle[stPremuta-4].setIcon(stellaFull);
            stelle[stPremuta-3].setIcon(stellaFull);
            stelle[stPremuta-2].setIcon(stellaFull);
            stelle[stPremuta-1].setIcon(stellaFull);
            stelle[stPremuta].setIcon(stellaFull);
            switch (stPremuta) {
                case 4:
                    valutazione[0]=5;
                    break;
                case 9:
                    valutazione[1]=5;
                    break;
                case 14:
                    valutazione[2]=5;
                    break;
                case 19:
                    valutazione[3]=5;
                    break;
                case 24:
                    valutazione[4]=5;
                    break;
                case 29:
                    valutazione[5]=5;
                    break;
                case 34:
                    valutazione[6]=5;
                    break;
                case 39:
                    valutazione[7]=5;
                    break;
                case 44:
                    valutazione[8]=5;
                    break;
                default:
                    break;
            }
        }
    }

    /**
    * Il metodo si occupa di effettuare passare i dati inseriti dall'utente al client, il quale poi invier&agrave; i dati
    * da elaborare al <code>serverSlave</code>
     * I dati sono passati attraverso il metodo <code>controllaGiudizio</code> e <code>selezionaEmozione</code>
    * Se il giudizio &egrave; gi&agrave; presente viene visualizzato una nuova finestra con l'opzione di riscrittura del giudizio.
    * @throws IOException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo.
    */
    private void inserisciEmozioniBrano() throws IOException {
        boolean duplicato = false;
        int conferma=0;
        boolean esiste=false;
        String idemozione="";
        clientES client=new clientES();
        duplicato = client.controllaGiudizio(username, id);
        if(duplicato==true){
            Object[] options = {"Sovrascrivi","Annulla"};
            conferma = JOptionPane.showOptionDialog(null,"Vuoi sovrascrivere il tuo precedente commento?","Aggiunta commento per "+ titolo,
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            esiste=true;
            idemozione=client.selezionaEmozione(username, id);
        }
        if(conferma==0 && esiste==true){
                client.sovrascriviCommento(id,idemozione, username, valutazione, areaCommento);
        }else if(conferma==1 && esiste==true){
                nomEssaggio=true;
        }
        if(esiste==false){
           client.inserisciCommento(id, username, valutazione, areaCommento);
        }
        client.close();
    }          
}

