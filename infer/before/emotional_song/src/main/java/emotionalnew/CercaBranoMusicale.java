package emotionalnew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Questa classe permette di scegliere se:
* <br>1) Cercare un brano per Titolo;
* <br>2) Cerca un brano per Autore e anno;
* <br>3) tornare alla finestra precedente;
* <br>Permette di cercare le canzoni sia per la visualizzazione che per l'aggiunta alla playlist.
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class CercaBranoMusicale extends javax.swing.JFrame {

    /**
    * Contiene lo username del cliente che ha eseguito l'accesso.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private String username;

    /**
    * Contiene il nome della playlist a cui verr&agrave; aggiunta la canzone.
    * Contiene una stringa vuota se si cerca solamente la canzone.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private String nomePlaylist;

    /**
    * Contiene i brani da aggiungere alla playlist.
    * Potrebbe essere vuota.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private String risultatiTitoli;

    /**
    * Contiene un valore boolean che permette l'aggiunta della canzone alla playlist.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private boolean enabled;    

    /**
    * Metodo costruttore della finestra <code>CercaBranoMusicale</code>
    * @param username In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>username</code> della classe.
    * @param nomePlaylist In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>nomePlaylist</code> della classe.
    * @param risultatiT  In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>resultTitoli</code> della classe.
    * @param abilita In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per abilitare
    * il bottone <code>indietro</code> della classe.
    * @param add In fase di costruzione dell'oggetto, questo parametro verr&agrave; utilizzato per valorizzare
    * l'attributo <code>enabled </code> della classe.
    */
    public CercaBranoMusicale(String username, String nomePlaylist, String risultatiT, boolean abilita, boolean add) {
        super("Seleziona Ricerca");
        pack();
        setSize(400, 300);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.enabled = add;
            this.username = username;
            this.nomePlaylist = nomePlaylist;
            this.risultatiTitoli = risultatiT;
                JLabel descrizioneL = new JLabel("Seleziona una delle seguenti ricerche: ");
                descrizioneL.setFont(new Font("Impact", 0, 20));
                descrizioneL.setForeground(new Color(168, 68, 226));
                    JButton autoreEanno = new JButton("Ricerca per autore e anno");
                    JButton titolo = new JButton("Ricerca per titolo");
                    JButton indietro = new JButton("Annulla");
                    autoreEanno.addActionListener(this::actionListenerAutoreEanno);
                    titolo.addActionListener(this::actionListenerTitolo);
                    indietro.addActionListener(this::actionListenerIndietro);
                        if(!abilita){
                            indietro.setEnabled(false);
                        }
                        if(nomePlaylist.equals("")) indietro.setEnabled(true);
                            JPanel pTitolo = new JPanel(new FlowLayout(1, 0, 20));
                            JPanel pLogout = new JPanel(new FlowLayout());
                            JPanel p1 = new JPanel(new FlowLayout());
                            JPanel p2 = new JPanel(new FlowLayout());
                            pTitolo.add(descrizioneL);
                            pLogout.add(indietro);
                            p1.add(titolo);
                            p2.add(autoreEanno);
                            Container principale = getContentPane();
                            principale.setLayout(new GridLayout(4, 1));
                            principale.add(pTitolo);
                            principale.add(p1);
                            principale.add(p2);
                            principale.add(pLogout);
                            setVisible(true);
                            dispose();
    }

    /**
    * Al clic del bottone <code>indietro</code> a seconda dei valori di <code>nomePlaylist</code> e <code>username</code>:
    * <br>1)verr&agrave; creata una nuova finestra <code>SchermataAvvio</code>
    * e verr&agrave; chiusa la finestra <code>CercaBranoMusicale</code> in esecuzione;
    * <br>2)verr&agrave; creata una nuova finestra <code>ElencoPlaylist</code>
    * e verr&agrave; chiusa la finestra <code>CercaBranoMusicale</code> in esecuzione;
    * <br>3)verr&agrave; creata una nuova finestra <code>AreaRiservata</code>
    * e verr&agrave; chiusa la finestra <code>CercaBranoMusicale</code> in esecuzione;
    * <br>@param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * @see SchermataAvvio
    * @see ElencoPlaylist
    * @see AreaRiservata
    */
    private void actionListenerIndietro(ActionEvent e){
        if(nomePlaylist.equals("") && username.equals("")){
            try {
                setVisible(false);
                (new SchermataAvvio()).setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CercaBranoMusicale.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(!nomePlaylist.equals("") && !username.equals("")){
            setVisible(false);
            (new ElencoPlaylist(username)).setVisible(true);
            dispose();
        } else if(this.enabled){
            setVisible(false);
            (new ElencoPlaylist(username)).setVisible(true);
            dispose();
        } else{setVisible(false);
            (new AreaRiservata(username)).setVisible(true);
            dispose();
        }
    }

    /**
    * Al clic del bottone <code>titolo</code> verr&agrave; inizialmente creata una nuova finestra in cui inserire il titolo da cercare,
    * se non viene inserito verr&agrave; visualizzato un messaggio di errore,
    * altrimenti verr&agrave; creata una nuova finestra <code>RisultatiRicerca</code>
    * e verr&agrave; chiusa la finestra <code>CercaBranoMusicale</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * @see RisultatiRicerca
    */
    private void actionListenerTitolo(ActionEvent e) {
        String inputTitolo = JOptionPane.showInputDialog(this, "Inserisci il titolo da ricercare: ", "Ricerca per titolo", JOptionPane.QUESTION_MESSAGE);
        if (inputTitolo != null && "".equals(inputTitolo)) {
            JOptionPane.showMessageDialog(this, "E' necessario inserire un valore", "Errore Ricerca", JOptionPane.WARNING_MESSAGE);
        } else if (inputTitolo != null) {
            this.setVisible(false);
            new RisultatiRicerca(inputTitolo.toLowerCase(), "", 1, username, nomePlaylist, risultatiTitoli, enabled);
            dispose();
        }
    }

    /**
    * Al clic del bottone <code>autoreEanno</code> verr&agrave; inizialmente creata una nuova finestra in cui inserire l'autore da cercare
    * e se non viene inserito verr&agrave; visualizzato un messaggio di errore,
    * verr&agrave; poi creata una nuova finestra in cui inserire l'anno da cercare
    * e se non viene inserito verr&agrave; visualizzato un messaggio di errore.
    * Se i valori vengono inseriti correttamente verr&agrave; creata una nuova finestra <code>RisultatiRicerca</code>
    * e verr&agrave; chiusa la finestra <code>CercaBranoMusicale</code> in esecuzione.
    * <br>@param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * <br>@see RisultatiRicerca
    */
    private void actionListenerAutoreEanno(ActionEvent e) {
        String inputAutore = JOptionPane.showInputDialog(this, "Inserisci l'autore da ricercare: ", "Ricerca per autore", JOptionPane.QUESTION_MESSAGE);
        if (inputAutore != null && "".equals(inputAutore)) {
            JOptionPane.showMessageDialog(this, "E' necessario inserire un valore", "Errore Ricerca", JOptionPane.WARNING_MESSAGE);
        } else if (inputAutore != null) {
            String inputAnno = JOptionPane.showInputDialog(this, "Inserisci l'anno: ", "Ricerca per anno", JOptionPane.QUESTION_MESSAGE);
            if (inputAnno != null) {
                boolean procedi = false;
                char[] carattere = inputAnno.toCharArray();
                for (int i = 0; i < inputAnno.length(); i++) {
                    if (carattere[i] >= '0' && carattere[i] <= '9' || (carattere[i] == '\b')) {
                        procedi = true;
                    } else {
                        procedi = false;
                        break;
                    }
                }
                if (!procedi) {
                    JOptionPane.showMessageDialog(this, "Sono ammessi solo numeri", "Errore Ricerca", JOptionPane.WARNING_MESSAGE);
                } else {
                    int anno = Integer.parseInt(inputAnno);
                    System.out.print(anno);
                    if (1899 < anno) {
                        this.setVisible(false);
                        new RisultatiRicerca(inputAutore.toLowerCase(), inputAnno.toLowerCase(), 2, username, nomePlaylist, risultatiTitoli, enabled);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "E' necessario inserire un valore maggiore di 1899", "Errore Ricerca", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }
}
