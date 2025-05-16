package clientES;

import emotionalnew.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* Questa classe permette di impostare l'indirizzo del server a cui il client deve connettersi per stabilire una connessione.
* All'interno della classe infatti sono presenti metodi che permettono di inserire manualmente e impostare l'indirizzo ip del server
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class IpServer extends JFrame {
    
    /**
    * Oggetto di tipo JTextField dove viene digitato ip per connessione.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private JTextField ip;
    
    /**
    * Contiene ip per la connessione al server.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String ipInviato;
    
    /**
    * Oggetto di tipo clientES.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private clientES client;
    /**
     * contiene il valore per far scegliere un'azione da eseguire
     *  <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
     */
    private int impostazioni = 1;
    
    /**
    * Metodo principale della classe <code>IpServer</code>
    * Crea la finestra con tutte le componenti al suo interno al quale passiamo un parametro 
    * che permette di scegliere quale azione eseguire premendo il pulsante annulla
    * @param impo valore numerico che viene utilizzato per sovrascrivere il valore del parametro <code>impostazioni</code>  
    * @throws java.sql.SQLException cattura eccezzione di tipo sql
    */
    public IpServer(int impo) throws SQLException {
        super("Connecting..."); //imposta il titolo della finestra
        setSize(500, 250); //imposta la dimensione della finestra
        setResizable(false); //non permette di ridimensionare la finestra
        setLocationRelativeTo(null); //posiziona al centro della pagina la finestra all'avvio dell'app
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //permette la chiusura dell'applicazione alla pressione della X
        //passaggio del socket dal client -> istanzio il socket da passare poi nelle altre classi
        JLabel titolo = new JLabel("Ip Server"); //JLabel che crea il titolo nella finestra
                titolo.setForeground(new Color(192, 68, 226)); //imposto il colore della scritta
                titolo.setFont(new Font("Impact", Font.PLAIN, 35)); //imposto font e dimensione delle scritte
                JLabel testo = new JLabel("inserire l'ip del server a cui collegarsi:"); //JLabel contente il motto dell'applicazione
                testo.setForeground(new Color(192, 68, 226)); //imposto il colore della scritta
                testo.setFont(new Font("Lobster", Font.ITALIC, 17)); //imposto font e dimensione delle scritte
                JButton indietro = new JButton("Annulla");
                        JButton accedi = new JButton("Accedi");
                        indietro.addActionListener(this::actionListenerAnnulla);
                        accedi.addActionListener(this::actionListenerAccedi);
                        this.ip = new JTextField(30);
                        ip.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        int minHeight = 40; // Sostituisci con l'altezza desiderata
                        Dimension minSize = new Dimension(ip.getPreferredSize().width, minHeight);
                        ip.setMinimumSize(minSize);
                        JPanel pannelloTitolo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
                        JPanel pannelloIp = new JPanel(new FlowLayout(FlowLayout.CENTER));
                        JPanel pannelloBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER));
                        pannelloTitolo.add(titolo);
                        pannelloIp.add(testo);
                        pannelloIp.add(this.ip);
                        pannelloBottoni.add(indietro);
                        pannelloBottoni.add(accedi);
                        Container principale = getContentPane();
                        principale.setLayout(new BorderLayout());
                        principale.add(pannelloTitolo, BorderLayout.NORTH);
                        principale.add(pannelloIp, BorderLayout.CENTER);
                        principale.add(pannelloBottoni, BorderLayout.SOUTH);
                        
                        client = new clientES(1);
                        ip.setText(client.GetIp());
                        System.out.println("Ip in client: " + client.GetIp());
                        setVisible(true); 
                        this.impostazioni = impo;
    }
    
    /**
    * Il metodo si occupa di mostrare a schermo l'errore della connessione al server.
    * crea un oggetto di tipo JOptionPane dove viene visualizzato il messaggio d'errore.
    * @param error Stringa contenente errore
    */
    public IpServer(String error){
        JOptionPane.showMessageDialog(this, "IMPOSSIBILE CONNETTERSI AL SERVER", "Server Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
    * Al clic del bottone <code>indietro</code> verr&agrave; creata una nuova finestra <code>SchermataAccesso</code>
    * e verr&agrave; chiusa la finestra <code>IpServer</code> in esecuzione qualora il valore della variabile 
    * <code>impostazioni</code> fosse diverso da 1, altrimenti verr&agrave; cancellato il testo prensete nel pannello .
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * @see SchermataAvvio
    */
    private void actionListenerAnnulla(ActionEvent e){
        if (impostazioni ==1) {
            ip.setText("");
        } else {
            try {
                SchermataAvvio schermataAvvio = new SchermataAvvio();
            } catch (SQLException ex) {
                Logger.getLogger(Accesso.class.getName()).log(Level.SEVERE, null,ex);
            }
        this.setVisible(false);
        dispose();
        }
    }
    
    /**
    * Al clic del bottone <code>accedi</code> verr&agrave; creata una nuova finestra <code>SchermataAccesso</code>
    * e verr&agrave; chiusa la finestra <code>Avvio</code> in esecuzione.
    * Viene settato il parametro ip che utilizzer&agrave il client per effettuare la connessione con il server.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>accedi</code>
    */
    private void actionListenerAccedi(ActionEvent e) {
        ipInviato = this.ip.getText().trim();
        if(ipInviato.equals(""))
            new clientES("localhost");
        else
            new clientES(ipInviato);
        this.setVisible(false);
        dispose();
    }
}
