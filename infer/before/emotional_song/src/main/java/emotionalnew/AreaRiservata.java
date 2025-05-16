package emotionalnew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Questa classe permette di scegliere se:
* <br>1) effettuare il Logout dalla propria area riservata;
* <br>2) consultare le canzoni presenti nel repository con funzionalit&agrave; complete;
* <br>3) visualizzare le proprie Playlist;
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class AreaRiservata extends javax.swing.JFrame implements Serializable {

    /**
    * Conterr&agrave; lo userName utilizzato sia dalla finestra corrente che come parametro per richiamare altri costruttori
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private String userName;

    /**
    * Costruttore della classe <code>AreaRiservata</code>
    * @param username contiene l'username dell'utente loggato
    */
    public AreaRiservata(String username) {
        super("AREA RISERVATA");
        setSize(500, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.userName = username;
                    JLabel accessoPL = new JLabel("Benvenuto ");
                    accessoPL.setFont(new Font("Impact", 0, 35));
                    accessoPL.setForeground(new Color(168, 68, 226));
                    JLabel namePL= new JLabel(this.userName);
                    namePL.setFont(new Font("Impact", 0, 35));
                    namePL.setForeground(new Color(168, 68, 226));
                        JButton logout = new JButton("Logout");
                        JButton cerca = new JButton("Cerca Canzoni");
                        JButton playlist = new JButton("Le mie Playlist");
                        logout.addActionListener(this::actionListenerLogout);
                        cerca.addActionListener(this::actionListenerCerca);
                        playlist.addActionListener(this::actionListenerPlaylist);
                        JButton visualizzaCanzoni = new JButton ("Elenco canzoni");
                            JPanel pTitolo = new JPanel(new FlowLayout(1, 0, 70));
                            JPanel pBottoni = new JPanel(new FlowLayout(1));
                            pTitolo.add(accessoPL);
                            pTitolo.add(namePL);
                            pBottoni.add(logout);
                            pBottoni.add(cerca);
                            pBottoni.add(playlist);
                            Container principale = getContentPane();
                            principale.setLayout(new BorderLayout());
                            principale.add(pTitolo, BorderLayout.CENTER);
                            principale.add(pBottoni, BorderLayout.SOUTH);
                            setVisible(true);
    }

    /**
    * Al clic del bottone <code>logout</code> verr&agrave; creata una nuova finestra <code>SchermataAvvio</code>
    * e verr&agrave; chiusa la finestra <code>AreaRiservata</code> in esecuzione.
    * <br>@param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>logout</code>
    * <br>
     * @see SchermataAvvio
    */
    private void actionListenerLogout(ActionEvent e){
        try {
            setVisible(false);
            (new SchermataAvvio()).setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(RegistraUtente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
    * Al clic del bottone <code>cerca</code> verr&agrave; creata una nuova finestra <code>CercaBranoMusicale</code>
    * e verr&agrave; chiusa la finestra <code>Area Riservata</code> in esecuzione.
    * <br>Alla creazione di <code>CercaBranoMusicale</code>
    * verranno passati come parametri:
    * <br>1) una stringa che corrisponde allo username
    * <br>2) una stringa che corrisponde al nome playlist
    * <br>3) una stringa che corrisponde ai risultati ricerca
    * <br>4) un boolean che servir&agrave; ad attivare l'opzione del tasto <code>indietro</code> nella classe <code>CercaBranoMusicale</code>
    * <br>5) un boolean che servir&agrave; ad abilitare un'opzione differente nella classe <code>RisultatiRicerca</code>
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>cerca</code>
    * @see CercaBranoMusicale
    */
    private void actionListenerCerca(ActionEvent e) {
        setVisible(false);
        (new CercaBranoMusicale(userName,"","",true,false)).setVisible(true);
        dispose();
    }

    /**
    * Al clic del bottone <code>playlist</code> verr&agrave; chiamato il costruttore della classe <code>ElencoPlaylist</code>
    * e verr&agrave; chiusa la finestra <code>Area Riservata</code> in esecuzione.
    * Verr&agrave; passato il parametro <code>userName</code> che sar&agrave; utilizzato nella classe <code>ElencoPlaylist</code>.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>playlist</code>
    * @see ElencoPlaylist
    */
    private void actionListenerPlaylist(ActionEvent e) {
        setVisible(false);
        (new ElencoPlaylist(userName)).setVisible(true);
        dispose();
    }
}
