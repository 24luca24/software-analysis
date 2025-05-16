package serverES;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe Server, implementa la connessione con il client er genera un serverSlave per ogni client connesso
 * @author Candiani Valerio matricola: 750632 VA
 * @author Candiani Luca matricola: 749717 VA
 * @author Airaghi Luca matricola: 749043 VA
 * @author Mammì Matteo matricola: 750714 VA
*/
public class serverES extends javax.swing.JFrame{

    /**
     * variabile static che contiene il valore della porta del server.
     */
    public static int PORT=8999;
    
    /**
     * istanza di ServerSocket
     */
    private static ServerSocket ss;
    
    /**
     * costruttore classe server
     */
    public serverES(){
        super("CLOSE CONNECTION"); //imposta il titolo della finestra
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel titolo = new JLabel("Termina servizio"); //JLabel che crea il titolo nella finestra
                titolo.setForeground(new Color(192, 68, 226)); //imposto il colore della scritta
                titolo.setFont(new Font("Impact", Font.PLAIN, 35)); //imposto font e dimensione delle scritte
                JLabel testo = new JLabel("Spegni server"); //JLabel contente il motto dell'applicazione
                testo.setForeground(new Color(192, 68, 226)); //imposto il colore della scritta
                testo.setFont(new Font("Lobster", Font.ITALIC, 17)); //imposto font e dimensione delle scritte
                JButton poweroff = new JButton("Power OFF"); //permette di cercare le canzoni
                poweroff.addActionListener(this::actionListenerpoweroff);
                JPanel pannelloTitolo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
                JPanel pannelloBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER));
                pannelloTitolo.add(titolo);
                pannelloBottoni.add(poweroff);
                Container principale = getContentPane();
                principale.setLayout(new BorderLayout());
                principale.add(pannelloTitolo, BorderLayout.CENTER);
                principale.add(pannelloBottoni, BorderLayout.SOUTH);
                setVisible(true);   
    }
    
    /**
    * Al clic del bottone <code>poweroff</code> viene chiusa la connessione con il server DB e viene terminata l'applicazione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>poweroff</code>
    */
    private void actionListenerpoweroff(ActionEvent e){
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(serverES.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Server Power off");
        setVisible(false);
        System.exit(0);
   
    }
    
    /**
    * Metodo che permette di aprire la schermata credenziali avvio
    * @param args array di string argomento
    * @throws IOException eccezione lanciata quando si verifica un errore durante l'operazione d'input/output
    * nel contesto di una comunicazione client-server.
    */
    public static void main(String[] args)throws IOException {
        CredenzialiDB credenziali = new CredenzialiDB(); //permette l'apertura della classe SchermataAvvio, contenente la schermata principale
        credenziali.setVisible(true); //rende visibile la finestra
        ss= new ServerSocket(PORT);
        System.out.println("Server started"); 
        try{
            while(true){ 
                Socket s=ss.accept();
                System.out.println("Server accetta connessioni");
                new ServerSlave(s,credenziali).start();       
            }
    
        }finally{
            ss.close();
        }        
    }
}
   
