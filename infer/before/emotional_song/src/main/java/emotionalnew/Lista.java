package emotionalnew;

import clientES.clientES;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Questa classe mostra l'elenco di canzoni disponibili nella repository.
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class Lista extends JComponent {

    /**
     * variabile per la creazione della finestra della classe
     */
    JFrame frame;

    /**
     * pannello con slide bar laterale per far scorrere le canzoni
     */
    JScrollPane scrollPane;

    /***
     * dichiarazione della JList che conterrà le canzoni
     */
    JList<String> myList =  new JList<>();

    /**
     * variabile client
     */
    clientES client;

    /**
    * costruttore della classe che crea una finestra nella quale si possono visionare le canzoni dell'elenco
    * @throws java.io.IOException cattura IOE exception
    */
    public Lista() throws IOException { 
        frame = new JFrame("LISTA");
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        try {
            leggiCanzone();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
        }
            scrollPane = new JScrollPane(myList);
            scrollPane.setHorizontalScrollBar(null);
                frame.add(scrollPane, BorderLayout.CENTER);
                JPanel pannello = new JPanel();
                pannello.setLayout(new BorderLayout());
                JLabel label = new JLabel("ELENCO CANZONI");
                label.setForeground(new Color(168, 68,226));
                label.setFont(new Font("Impact", Font.PLAIN, 35));
                JButton indietro = new JButton("Indietro");
                indietro.addActionListener(this::actionListenerIndietro);
                pannello.add(label, BorderLayout.CENTER);
                pannello.add(indietro, BorderLayout.EAST);
                frame.add(pannello, BorderLayout.NORTH);
                frame.setVisible(true);
    }

    /**
     * Permette di nascondere la finestra <code>Lista</code> e mette in mostra la <code>SchermataAvvio</code>, ovvero la schermata
     * principale dell'applicazione
     * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
     */
    private void actionListenerIndietro(ActionEvent e){
        try {
            setVisible(false);
            frame.setVisible(false);
            (new SchermataAvvio()).setVisible(true);
        } catch (SQLException ex) {
            System.err.println("errore riga 76 classe Lista actionListener indietro");
            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    * Metodo che contiene un metodo del client, che a sua volta va a richiamare una query nel serverSlave.
    * Permette in breve d'inserire in un array tutti i nomi delle canzoni (Anno, Autore, Titolo),
     * che poi verranno inseriti in una JList
    * @throws java.lang.ClassNotFoundException eccezione lanciata quando il client non trova la classe necessaria per deserializzare
    * un oggetto ricevuto dal server tramite la comunicazione tramite oggetti Java (Object Serialization).
    */
    public void leggiCanzone() throws ClassNotFoundException {
        client = new clientES();
        myList = client.leggiCanzone();
        client.close();
    }
}


