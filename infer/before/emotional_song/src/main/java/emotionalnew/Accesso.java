package emotionalnew;

import ClassiSerializzabili.DatiUtenti;
import clientES.clientES;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Questa classe permette di scegliere se:
* <br>1) effettuare il Login alla propria area riservata;
* <br>2) tornare indietro alla pagina iniziale;
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class Accesso extends javax.swing.JFrame{

    /**
    * Conterr&agrave; lo userName digitato nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField userName;

    /**
    * Conterr&agrave; la password digitata nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private final JPasswordField password;

    /**
    * Variabile privata che permette l'istanziazione di un elemento della classe client
    */
    private clientES client;

    /**
    * Metodo costruttore della finestra <code>Accesso</code>
    */
    public Accesso() {
        super("ACCESSO");
        setSize(500, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JLabel usernameL = new JLabel("Username: ");
                    JLabel passwordL = new JLabel("Password: ");
                    JLabel accessoL = new JLabel("Effettua l'accesso");
                    accessoL.setFont(new Font("Impact", Font.PLAIN, 35));
                    accessoL.setForeground(new Color(192, 68, 226));
                        JButton indietro = new JButton("Indietro");
                        JButton accedi = new JButton("Accedi");
                        indietro.addActionListener(this::actionListenerIndietro);
                        accedi.addActionListener(this::actionListenerAccedi);
                            this.userName = new JTextField(10);
                            this.password = new JPasswordField(10);
                            userName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                            password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                                JPanel pannelloTitolo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
                                JPanel pannelloUserName = new JPanel(new FlowLayout(FlowLayout.CENTER));
                                JPanel pannelloPassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
                                JPanel pannelloBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER));
                                JPanel pannelloCentro = new JPanel();
                                    pannelloTitolo.add(accessoL);
                                    pannelloUserName.add(usernameL);
                                    pannelloUserName.add(this.userName);
                                    pannelloPassword.add(passwordL);
                                    pannelloPassword.add(this.password);
                                    pannelloBottoni.add(indietro);
                                    pannelloBottoni.add(accedi);
                                    pannelloCentro.add(pannelloUserName);
                                    pannelloCentro.add(pannelloPassword);
                                        Container principale = getContentPane();
                                        principale.setLayout(new BorderLayout());
                                        principale.add(pannelloTitolo, BorderLayout.NORTH);
                                        principale.add(pannelloCentro, BorderLayout.CENTER);
                                        principale.add(pannelloBottoni, BorderLayout.SOUTH);
                                        setVisible(true);
    }

    /**
    * Al clic del bottone <code>indietro</code> verr&agrave; creata una nuova finestra <code>Principale</code>
    * e verr&agrave; chiusa la finestra <code>Accesso</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * @see SchermataAvvio
    */
    private void actionListenerIndietro(ActionEvent e){
        setVisible(false);
        dispose();
        try {
            SchermataAvvio schermataAvvio = new SchermataAvvio();
        } catch (SQLException ex) {
            Logger.getLogger(Accesso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
    * Al clic del bottone <code>Accedi</code> verr&agrave; effettuata la ricerca di userName e password
    * richiamando il metodo <code>accessoUtente</code>. Se quest'ultimo ritorna come valore:
    * <br>1) true, verr&agrave; creata una nuova finestra <code>AreaRiservata</code>
    * passando la stringa userName come parametro al costruttore e verr&agrave; chiusa la finestra <code>Accesso</code> in esecuzione.
    * <br>2) false, verr&agrave; creata una finestra <code>JOptionPane</code> contenente un messaggio di errore.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>accedi</code>
    * @see RisultatiRicerca
    */
    private void actionListenerAccedi(ActionEvent e) {
        boolean esitoOperazione = false;
        String usernameInvio = this.userName.getText();
        String passwordInvio = this.password.getText();
        DatiUtenti datiInvioAccesso = new DatiUtenti(usernameInvio, passwordInvio);
        this.client = new clientES();
        esitoOperazione = client.accesoUtente(datiInvioAccesso);
        client.close();
        if(esitoOperazione) {
            JOptionPane.showMessageDialog(this, "Accesso effettuato con successo \n" + "Bentornato " + usernameInvio +  "!" , "ACCESSO EFFETTUATO", JOptionPane.INFORMATION_MESSAGE);
            (new AreaRiservata(usernameInvio)).setVisible(true);
            this.setVisible(false);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Errore in fase di accesso, username o password errati", "CREDENZIALI ERRATE", JOptionPane.ERROR_MESSAGE);
        }
    } 
}

