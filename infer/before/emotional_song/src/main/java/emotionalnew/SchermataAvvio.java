package emotionalnew;

import clientES.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Questa classe permette di scegliere se:
* <br>1) registrare un nuovo utente;
* <br>2) accedere con un account gi&agrave; creato;
* <br>3) cercare le canzoni nel repository, ma senza la possibilit&agrave; di eseguire azioni
* <br>4) visualizzare la lista intera di brani;
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola 749043 VA
* @author Mammì Matteo matricola:750714 VA
*/
public class SchermataAvvio extends JFrame {

    /**
    * Metodo principale della classe <code>SchermataAvvio</code>
    * Crea la finestra con tutte le componenti al suo interno
    * @throws java.sql.SQLException gestisce eccezione di tipo SQL
    */
    public SchermataAvvio() throws SQLException {
        super("EMOTIONAL SONGS"); //imposta il titolo della finestra
        setSize(500, 300); //imposta la dimensione della finestra
        setResizable(false); //non permette di ridimensionare la finestra
        setLocationRelativeTo(null); //posiziona al centro della pagina la finestra all'avvio dell'app
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //permette la chiusura dell'applicazione alla pressione della X
        //passaggio del socket dal client -> istanzio il socket da passare poi nelle altre classi
            //JLabel
                JLabel titolo = new JLabel("EMOTIONAL SONGS"); //JLabel che crea il titolo nella finestra
                titolo.setForeground(new Color(192, 68, 226)); //imposto il colore della scritta
                titolo.setFont(new Font("Impact", Font.PLAIN, 35)); //imposto font e dimensione delle scritte
                JLabel testo = new JLabel("Search a Song and Drop an Emotion"); //JLabel contente il motto dell'applicazione
                testo.setForeground(new Color(192, 68, 226)); //imposto il colore della scritta
                testo.setFont(new Font("Lobster", Font.ITALIC, 17)); //imposto font e dimensione delle scritte
               // ImageIcon immagine = new ImageIcon(System.getProperty("user.dir").replace("bin","data")+"/src/main/resources/icons/Immagine-emotional.jpg"); //inserimento dell'immagine
              
                java.net.URL logoOneUrl = getClass().getResource("/icons/Immagine-emotional.jpg");
                System.out.println(logoOneUrl);
                Icon logoOne = new ImageIcon(logoOneUrl);
                System.out.println(logoOne);
                 
                JLabel contenitoreImmagine = new JLabel(logoOne); //inserimento dell'immagine in una JLabel
                //ImageIcon im = new ImageIcon(getClass().getResource("C:\\Users\\Valerio\\Documents\\NetBeansProjects\\EmotionalWithMaven\\src\\main\\resources\\icons\\Immagine-emotional.jpg"));
                //System.out.println(im);
                //JButton
                    JButton cercaCanzoni = new JButton("Cerca Canzoni"); //permette di cercare le canzoni
                    JButton registrati = new JButton("Registrati"); //permette di registrarsi all'applicazione
                    JButton accedi = new JButton("Accedi"); //permette di accedere all'applicazione
                    JButton listaCanzoni = new JButton("Elenco Canzoni"); //permette di visualizzare la lista delle canzoni
                    JButton impostazioni = new JButton("Impostazioni"); //permette di modificare ip server
                    //aggiunta di ActionListener ai JButton
                        registrati.addActionListener(this::actionListenerRegistrati);
                        accedi.addActionListener(this::actionListenerAccedi);
                        cercaCanzoni.addActionListener(this::actionListenerConsultaRepo);
                        listaCanzoni.addActionListener(this::actionListenerLista);
                        impostazioni.addActionListener(this::actionListenerImpostazioni);
                        //pannelli per inserire elementi nel JFrame principale
                            JPanel pannelloBottoni = new JPanel(); //pannello contenete i bottoni
                                Dimension dimensioni = getPreferredSize(); //imposto le dimensioni del pannello
                                dimensioni.width = 150;
                                pannelloBottoni.setPreferredSize(dimensioni);
                                pannelloBottoni.setLayout(new GridBagLayout()); //imposto il layout al pannello dei bottoni --> il GridBagLayout forma una tabella, in cui posso distribuire a mio piacimento gli elementi
                                GridBagConstraints gbc = new GridBagConstraints(); //imposto un vincolo che mi permette di modellare il layout
                                //posizione primo bottone (Brani)
                                    gbc.gridx = 0; //imposto la colonna x (0)
                                    gbc.gridy = 0;  //imposto la riga y (0)

                                    gbc.weightx = 0.1; //dice per ogni cella quanto spazio deve occupare rispetto alle altre celle (range di valori da: 0.0 - 1.0)
                                    gbc.weighty = 0.1;

                                    gbc.gridwidth = 3; //definisce il numero di colonne che il bottone occupa

                                    gbc.ipady = 10; //definisce il padding interno del bottone (in altezza (y))

                                    gbc.fill = GridBagConstraints.HORIZONTAL; //riempie tutto lo spazio a lato del bottone

                                    pannelloBottoni.add(listaCanzoni, gbc); //aggiungo il bottone al pannello

                                //posizione secondo bottone (creaPlaylist)
                                    gbc.gridx = 0; //imposto la colonna x (0)
                                    gbc.gridy = 1; //imposto la riga y (1)

                                    gbc.gridwidth = 3; //definisce il numero di colonne che il bottone occupa

                                    gbc.ipady = 10; //definisce il padding interno del bottone (in altezza (y))

                                    gbc.fill = GridBagConstraints.HORIZONTAL; //riempie tutto lo spazio a lato del bottone

                                    pannelloBottoni.add(accedi, gbc); //aggiungo il bottone al pannello

                                //posizione terzo bottone (profile)
                                    gbc.gridx = 0; //imposto la colonna x (0)
                                    gbc.gridy = 2; //imposto la riga y (2)

                                    gbc.gridwidth = 3; //definisce il numero di colonne che il bottone occupa

                                    gbc.ipady = 10; //definisce il padding interno del bottone (in altezza (y))

                                    gbc.fill = GridBagConstraints.HORIZONTAL; //riempie tutto lo spazio a lato del bottone

                                    pannelloBottoni.add(registrati, gbc); //aggiungo il bottone al pannello

                                //posizione terzo bottone (profile)
                                    gbc.gridx = 0; //imposto la colonna x (0)
                                    gbc.gridy = 3; //imposto la riga y (3)

                                    gbc.gridwidth = 3; //definisce il numero di colonne che il bottone occupa

                                    gbc.ipady = 10; //definisce il padding interno del bottone (in altezza (y))

                                    gbc.fill = GridBagConstraints.HORIZONTAL; //riempie tutto lo spazio a lato del bottone

                                    pannelloBottoni.add(cercaCanzoni, gbc); //aggiungo il bottone al pannello
                                    
                                //posizione quarto bottone (profile)
                                    gbc.gridx = 0; //imposto la colonna x (0)
                                    gbc.gridy = 4; //imposto la riga y (3)

                                    gbc.gridwidth = 3; //definisce il numero di colonne che il bottone occupa

                                    gbc.ipady = 10; //definisce il padding interno del bottone (in altezza (y))

                                    gbc.fill = GridBagConstraints.HORIZONTAL; //riempie tutto lo spazio a lato del bottone

                                    pannelloBottoni.add(impostazioni, gbc); //aggiungo il bottone al pannello

                                    JPanel pannelloCentro = new JPanel(new BorderLayout()); //pannello contente JLabel

                                     //creo questi due pannelli per avere le label posizionate al centro del pannelloCentrale
                                        JPanel pannelloTitolo = new JPanel(); //pannello contente JLabelTitolo
                                        pannelloTitolo.add(titolo);
                                        JPanel pannelloTesto = new JPanel(); //pannello contente JLabelTesto
                                        pannelloTesto.add(testo);

                                        pannelloCentro.add(pannelloTitolo, BorderLayout.NORTH); //aggiungo il pannelloTitolo al pannello
                                        pannelloCentro.add(contenitoreImmagine, BorderLayout.CENTER); //inserisco la JLabelImmagine nel pannello
                                        pannelloCentro.add(pannelloTesto, BorderLayout.SOUTH); //aggiungo il pannelloTesto al pannello

                                        //aggiungo il tutto nel frame principale
                                            Container schermataAvvio = getContentPane();
                                            schermataAvvio.setLayout(new BorderLayout());
                                            schermataAvvio.add(pannelloBottoni, BorderLayout.WEST);
                                            schermataAvvio.add(pannelloCentro, BorderLayout.CENTER);
                                            setVisible(true); 
    }

    /**
    * Al clic del bottone <code>registrati</code> verr&agrave; creata una nuova finestra <code>RegistraUtente</code>
    * e verr&agrave; chiusa la finestra <code>Avvio</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>registrati</code>
    * @see RegistraUtente
    */
    private void actionListenerRegistrati(ActionEvent e) {
        setVisible(false);
        (new RegistraUtente()).setVisible(true);
        dispose();
    }

    /**
    * Al clic del bottone <code>accedi</code> verr&agrave; creata una nuova finestra <code>Accesso</code>
    * e verr&agrave; chiusa la finestra <code>Avvio</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>accedi</code>
    * @see Accesso
    */
    private void actionListenerAccedi(ActionEvent e) {
        setVisible(false);
        new Accesso().setVisible(true);
        dispose();
    }

    /**
    * Al clic del bottone <code>cerca</code> verr&agrave; creata una nuova finestra <code>CercaBranoMusicale</code>
    * e verr&agrave; chiusa la finestra <code>Avvio</code> in esecuzione.
    * <br>Alla creazione di <code>CercaBranoMusicale</code>
    * verranno passati come parametri:
    * <br>1) una stringa che corrisponde allo username
    * <br>2) una stringa che corrisponde al nome playlist
    * <br>3) una stringa che corrisponde ai risultati ricerca
    * <br>4) un boolean che servir&agrave; ad attivare l'opzione del tasto <code>indietro</code> nella classe <code>CercaBranoMusicale</code>
    * <br>5) un boolean che servir&agrave; ad abilitare un'opzione differente nella classe <code>RisultatiRicerca ì</code>
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>cerca</code>
    * @see CercaBranoMusicale
    */
    private void actionListenerConsultaRepo(ActionEvent e) {
        setVisible(false);
        (new CercaBranoMusicale("","","",true,false)).setVisible(true);
        dispose();
    }

    /**
    * Al clic del bottone <code>listaCanzoni</code> verr&agrave; creata una nuova finestra <code>Lista</code>
    * e verr&agrave; chiusa la finestra <code>Avvio</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>listaCanzoni</code>
    * @see Lista
    */
    private void actionListenerLista(ActionEvent e) {
        setVisible(false);
        try {
            (new Lista()).setVisible(true);
        } catch (IOException ex) {
            System.err.println("Errore schermata avvio, actionListener lista");
            throw new RuntimeException(ex);
        }
        dispose();
    }
    
    /**
    * Al clic del bottone <code>impostazioni</code> verr&agrave; creata una nuova finestra <code>IpServer</code>
    * e verr&agrave; chiusa la finestra <code>SchermataAvvio</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>impostazioni</code>
    * @see Lista
    */
    private void actionListenerImpostazioni(ActionEvent e){
        setVisible(false);
        try {
            IpServer ip = new IpServer(2);
        } catch (SQLException ex) {
            Logger.getLogger(SchermataAvvio.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }
}
