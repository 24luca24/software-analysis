package serverES;

import emotionalnew.MainDB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Classe che crea la schermata di avvio del server, in cui richiede di inserire le credenziali del db
* @author Candiani Valerio matricola:750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class CredenzialiDB extends JFrame {

    /**
     * Stringa che conterr&grave; l'hostname
     */
    private JTextField hostName;

    /**
     * campo che conterr&grave; l'username inserito per l'accesso al db
     */
    private JTextField userName;

    /**
     * campo che conterr&grave; la password inserita per l'accesso al db
     */
    private JPasswordField password;

    /**
     * istanza classe databse
     */
    public DataBase database;

    /**
     * booleano che se diventa true, indica che le credenziali inserite sono valide
     */
    private boolean procedi=false;

    /**
     * istanza classe databse
     */
    public DataBase db;

    /**
    * Variabile in cui verr&grave; inserito l'username per l'accesso al database
    */
    String user ="";
    
    /**
    * Variabile che contiene l'host
    */
    String host ="";
    
    /**
    * Variabile in cui verr&grave; inserita la password per accedere al database
    */
    String psw = "";

    /**
     * costruttore della classe
     */
    public CredenzialiDB(){
        super("LOGIN DATABASE"); //imposta il titolo della finestra
            setSize(500, 250); //imposta la dimensione della finestra
            setResizable(false); //non permette di ridimensionare la finestra
            setLocationRelativeTo(null); //posiziona al centro della pagina la finestra all'avvio dell'app
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //permette la chiusura dell'applicazione alla pressione della X
            JLabel hostnameL = new JLabel("Hostname");
            JLabel usernameL = new JLabel("Username: ");
            JLabel passwordL = new JLabel("Password: ");
            JLabel accessoL = new JLabel("Effettua login database");
            accessoL.setFont(new Font("Impact", Font.PLAIN, 35)); //imposto font e dimensione delle scritte
            accessoL.setForeground(new Color(192, 68, 226));
            
            JButton annulla = new JButton("Annulla");
            JButton connetti = new JButton("Connetti");
            annulla.addActionListener(this::actionListenerAnnulla);
            connetti.addActionListener(this::actionListenerConnetti);
            this.userName = new JTextField(30);
            this.hostName = new JTextField(30);
            this.password = new JPasswordField(30);
            userName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
            password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
            hostName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
            
            JPanel pannelloTitolo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
            JPanel pannelloUserName = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel pannelloPassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel pannelloHostname = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel pannelloBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel pannelloCentro = new JPanel();
            
            
                pannelloTitolo.add(accessoL);
                pannelloHostname.add(hostnameL);
                pannelloHostname.add(this.hostName);
                pannelloUserName.add(usernameL);
                pannelloUserName.add(this.userName);
                pannelloPassword.add(passwordL);
                pannelloPassword.add(this.password);
                pannelloBottoni.add(annulla);
                pannelloBottoni.add(connetti);
                pannelloCentro.add(pannelloHostname);
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
     * annulla l'inserimento delle credenziali, inizializzando vuoti i textfield
     * @param e
     */
    private void actionListenerAnnulla(ActionEvent e){
        hostName.setText("");
        userName.setText("");
        password.setText("");        
    }

    /**
     * Al clic del bottone <code>connetti</code> verr&agrave; effettuato l'accesso al database, qualora le credenziali siano corrette
     * Se le credenziali inserite non sono valide, verr&agrave; stampato un messaggio di errore attraverso un JOPtionPane
     */
    private void actionListenerConnetti(ActionEvent e) {
        user=this.userName.getText();
        host=this.hostName.getText();
        psw=this.password.getText();

        database = new DataBase(host,user,psw);
        try {
            database = new DataBase(false,0);
            this.setVisible(false);
            MainDB maindb= new MainDB();
            db = maindb.getDataBase();
            procedi=true;
            serverES se=new serverES();
        } catch (SQLException ex) {
            System.err.println("errore db");
            Logger.getLogger(serverES.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Dati inseriti non corretti", "Errore Accesso", 2);
        }           
    }

    /**
     * metodo get classe db, per prendere la sua istanza
     * @return <code>db</code>
     */
    public DataBase getDataBase(){
        return db;
    }
    
}