package emotionalnew;

import ClassiSerializzabili.DatiUtenti;
import clientES.clientES;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Questa classe permette di scegliere se:
* <br>1) effettuare la registrazione di un nuovo utente;
* <br>2) tornare indietro alla pagina iniziale;
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class RegistraUtente extends javax.swing.JFrame {

    /**
    * Conterr&agrave; il nome digitato nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField nome;

    /**
    * Conterr&agrave; il cognome digitato nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField cognome;

    /**
    * Conterr&agrave; il codiceFiscale digitato nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField codiceFiscale;

    /**
    * Conterr&agrave; l'indirizzo mail digitato nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField mail;

    /**
    * Conterr&agrave; la provincia digitato nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField provincia;

    /**
    * Conterr&agrave; il cap digitato nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField cap;

    /**
    * Conterr&agrave; il comune digitato nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField comune;

    /**
    * Conterr&agrave; la via digitata nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField via;

    /**
    * Conterr&agrave; il numero civico digitato nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField numeroCivico;

    /**
    * Conterr&agrave; lo userName digitato nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JTextField userName;

    /**
    * Conterr&agrave; la password digitata nell'omonimo campo.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
    */
    private JPasswordField password;

    /**
    * Conterr&agrave; gli eventuali errori di compilazione, presenti nel form di registrazione.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String errori = "";

    /**
     * istanza di client, richiamata per inviare dati al client e poi al serverSlave
     */
    private clientES client;

    /**
     * array di stringhe contenente i domini delle mail per il controllo
     */
    private static String[] dominio;
    
    /**
     * attributo booleano che convalida la mail
     */
    private boolean chiocciola = false;

    /**
     * stringa contenente la mail inserita
     */
    private String mailInserita;

    /**
    * Metodo costruttore della finestra <code>RegistraUtente</code>.
    */
    public RegistraUtente() {
        super("REGISTRAZIONE");
        setSize(430, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel registrazione = new JLabel("Registrazione");
            JLabel nomeL = new JLabel("Nome: ");
            JLabel cognomeL = new JLabel("Cognome: ");
            JLabel comuneL = new JLabel("Comune: ");
            JLabel provinciaL = new JLabel("Provincia: ");
            final JLabel avvisoProvincia = new JLabel();
            JLabel viaL = new JLabel("via/piazza: ");
            JLabel nCivicoL = new JLabel("numero: ");
            final JLabel avvisoNum = new JLabel();
            JLabel codFiscaleL = new JLabel("CodiceF: ");
            final JLabel avvisoFiscale = new JLabel();
            JLabel mailL = new JLabel("E-mail: ");
            JLabel usernameL = new JLabel("Username: ");
            JLabel passwordL = new JLabel("Password: ");
            JLabel capL = new JLabel("C.A.P. : ");
            final JLabel avvisoCap = new JLabel();
            registrazione.setFont(new Font("Impact", 0, 25));
            registrazione.setForeground(new Color(168, 68, 226));
            avvisoProvincia.setForeground(new Color(168,68,226));
            avvisoCap.setForeground(new Color(168,68,226));
            avvisoNum.setForeground(new Color(168,68,226));
            avvisoFiscale.setForeground(new Color(168,68,226));
                this.nome = new JTextField(10);
                this.cognome = new JTextField(10);
                this.comune = new JTextField(10);
                this.provincia = new JTextField(2);
                this.via = new JTextField(25);
                this.numeroCivico = new JTextField(3);
                this.codiceFiscale = new JTextField(16);
                this.mail = new JTextField(16);
                this.userName = new JTextField(10);
                this.cap = new JTextField(5);
                this.password = new JPasswordField(10);
                        nome.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        cognome.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        comune.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        provincia.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        via.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        numeroCivico.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        codiceFiscale.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        mail.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        userName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        cap.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
                        password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(163, 68, 226)));
        //controllo valori inseriti per Provincia, Cap, NumeroCivico, CodiceFiscale
            this.provincia.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    String value = RegistraUtente.this.provincia.getText();
                    if (value.length() < 2) {
                        Character carattere = Character.valueOf(ke.getKeyChar());
                        if ((carattere.charValue() >= 'a' && carattere.charValue() <= 'z') || (carattere.charValue() >= 'A' && carattere.charValue() <= 'Z') || carattere.charValue() == '\b') {
                            RegistraUtente.this.provincia.setEditable(true);
                        } else {
                            RegistraUtente.this.provincia.setEditable(false);
                            avvisoProvincia.setText(" ammessi solo caratteri !");
                        }
                    } else if (ke.getKeyChar() == '\b') {
                        RegistraUtente.this.provincia.setEditable(true);
                    } else {
                        RegistraUtente.this.provincia.setEditable(false);
                        avvisoProvincia.setText(" Immettere solo la sigla ");
                    }
                }
            });
            this.cap.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    String value = RegistraUtente.this.cap.getText();
                    if (value.length() < 5) {
                        Character carattere = Character.valueOf(ke.getKeyChar());
                        if (carattere.charValue() >= '0' && carattere.charValue() <= '9' || (carattere.charValue() == '\b')){
                            RegistraUtente.this.cap.setEditable(true);
                        } else {
                            RegistraUtente.this.cap.setEditable(false);
                            avvisoCap.setText(" ammessi solo Numeri !");
                        }
                    } else if (ke.getKeyChar() == '\b') {
                        RegistraUtente.this.cap.setEditable(true);
                    } else {
                        RegistraUtente.this.cap.setEditable(false);
                        avvisoCap.setText("Limite di 5 numeri");
                    }
                }
            });
            this.numeroCivico.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    String value = RegistraUtente.this.numeroCivico.getText();
                    if (value.length() < 3) {
                        Character carattere = Character.valueOf(ke.getKeyChar());
                        if (carattere.charValue() >= '0' && carattere.charValue() <= '9' || (carattere.charValue() == '\b')){
                            RegistraUtente.this.numeroCivico.setEditable(true);
                        } else {
                            RegistraUtente.this.numeroCivico.setEditable(false);
                            avvisoNum.setText(" ammessi solo Numeri !");
                        }
                    } else if (ke.getKeyChar() == '\b') {
                        RegistraUtente.this.numeroCivico.setEditable(true);
                    } else {
                        RegistraUtente.this.numeroCivico.setEditable(false);
                        avvisoNum.setText("Limite di 3 numeri");
                    }
                }
            });
            this.codiceFiscale.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    String value = RegistraUtente.this.codiceFiscale.getText();
                    if (value.length() == 15) {
                        RegistraUtente.this.codiceFiscale.setEditable(true);
                    }else if (ke.getKeyChar() == '\b') {
                        RegistraUtente.this.codiceFiscale.setEditable(true);
                    }else if(value.length() < 15){
                        RegistraUtente.this.codiceFiscale.setEditable(true);
                        avvisoFiscale.setText("Deve avere 16 caratteri");
                    }else {
                        RegistraUtente.this.codiceFiscale.setEditable(false);
                        avvisoFiscale.setText("Limite di 16 caratteri");
                    }
                }
            });
            JButton indietro = new JButton("indietro");
            JButton conferma = new JButton("Conferma");
            indietro.addActionListener(this::actionListenerIndietro);
            conferma.addActionListener(event -> {
                try {
                    actionListenerConferma(event);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException ex) {
                Logger.getLogger(RegistraUtente.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
            JPanel pTitolo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel pBottoni = new JPanel(new GridLayout());
            JPanel pCentro = new JPanel(new GridLayout(12, 1));
            JPanel pSinistro = new JPanel(new GridLayout(12, 1));
            JPanel[] pLabel = new JPanel[12];
            JPanel[] pField = new JPanel[12];
            for (int i = 0; i < 12; i++) {
                pLabel[i] = new JPanel(new FlowLayout(0));
                pField[i] = new JPanel(new FlowLayout(0));
            }
            pTitolo.add(registrazione);
            pLabel[0].add(nomeL);
            pLabel[1].add(cognomeL);
            pLabel[2].add(comuneL);
            pLabel[3].add(provinciaL);
            pLabel[4].add(viaL);
            pLabel[5].add(nCivicoL);
            pLabel[6].add(capL);
            pLabel[7].add(mailL);
            pLabel[8].add(codFiscaleL);
            pLabel[9].add(usernameL);
            pLabel[10].add(passwordL);
            pField[0].add(this.nome);
            pField[1].add(this.cognome);
            pField[2].add(this.comune);
            pField[3].add(this.provincia);
            pField[3].add(avvisoProvincia);
            pField[4].add(this.via);
            pField[5].add(this.numeroCivico);
            pField[5].add(avvisoNum);
            pField[6].add(this.cap);
            pField[6].add(avvisoCap);
            pField[7].add(this.mail);
            pField[8].add(this.codiceFiscale);
            pField[8].add(avvisoFiscale);
            pField[9].add(this.userName);
            pField[10].add(this.password);
            pBottoni.add(indietro);
            pBottoni.add(conferma);
            for (int i = 0; i < 12; i++) {
                pSinistro.add(pLabel[i]);
                pCentro.add(pField[i]);
            }
            Container principale = getContentPane();
            principale.setLayout(new BorderLayout());
            principale.add(pTitolo, BorderLayout.NORTH);
            principale.add(pSinistro, BorderLayout.WEST);
            principale.add(pCentro, BorderLayout.CENTER);
            principale.add(pBottoni, BorderLayout.SOUTH);
            setVisible(true);
    }

    /**
    * Al clic del bottone <code>indietro</code> verr&agrave; creata una nuova finestra <code>SchermataAvvio</code>
    * e verr&agrave; chiusa la finestra <code>RegistraUtente</code> in esecuzione.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>indietro</code>
    * @see SchermataAvvio
    */
    private void actionListenerIndietro(ActionEvent e) {
        try {
            setVisible(false);
            (new SchermataAvvio()).setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(RegistraUtente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
    * Al clic del bottone <code>conferma</code> verr&agrave; effettuato un check sul contenuto di tutti i campi compilati nella form.
    * <br>Nel caso in cui non vi fossero presenti degli errori, i dati verrano impacchettati in un'istanza nella classe DatiUtenti
    * e spediti al client con il metodo <code>invioDatiUtentie</code>
    * <br>Successivamente verr&agrave; creata una nuova finestra <code>SchermataAvvio</code>
    * e verr&agrave; chiusa la finestra <code>RegistraUtente</code> in esecuzione.
    * <br>Nel caso opposto, verr&agrave; creata una finestra contenente gli errori riscontrati nell'inserimento dei campi.
    * @param e Oggetto di tipo ActionEvent contenente tutte le informazioni sul clic del bottone <code>conferma</code>
    * @throws IOException Dichiara che, in fase di richiamo di questo metodo, dovr&agrave; essere gestita un'eccezione
    * di tipo <code>IOException</code> che pu&ograve; essere sollevata dal metodo <code>scriviNuovoUtente</code>
    * richiamato nel corpo di questo metodo.
    * @see SchermataAvvio
    */
    private void actionListenerConferma(ActionEvent e) throws IOException, SQLException {
        if (this.nome.getText().equals(""))
            this.errori = String.valueOf(this.errori) + "Il campo Nome e' vuoto\n";
        if (this.cognome.getText().equals(""))
            this.errori = String.valueOf(this.errori) + "Il campo Cognome e' vuoto\n";
        if (this.comune.getText().equals(""))
            this.errori = String.valueOf(this.errori) + "Il campo Comune e' vuoto\n";
        if (this.provincia.getText().equals(""))
            this.errori = String.valueOf(this.errori) + "Il campo Provincia e' vuoto\n";
        if (this.via.getText().equals(""))
            this.errori = String.valueOf(this.errori) + "Il campo via/piazza e' vuoto\n";
        if (this.numeroCivico.getText().equals(""))
            this.errori = String.valueOf(this.errori) + "Il campo n° e' vuoto\n";
        if (this.cap.getText().equals(""))
            this.errori = String.valueOf(this.errori) + "Il campo C.A.P. e' vuoto\n";
        if (this.codiceFiscale.getText().equals(""))
            this.errori = String.valueOf(this.errori) + "Il campo CF e' vuoto\n";
        if (this.mail.getText().equals("")) {
            this.errori = String.valueOf(this.errori) + "Il campo E-mail e' vuoto\n";
        } else {
            mailInserita = mail.getText();
            for (int i = 0; i < mailInserita.length(); i++) {
                if (mailInserita.charAt(i) == '@') {
                    chiocciola = true;
                    break;
                } else {
                    chiocciola = false;
                }
            }
            if (chiocciola == false) {
                this.errori = String.valueOf(this.errori) + "E-mail non valida\n";
            } else {
                dominio = mailInserita.split("@");
                String dominioAttuale = dominio[1].toLowerCase();
                switch (dominioAttuale) {
                    case "gmail.com":
                        break;
                    case "libero.it":
                        break;
                    case "email.com":
                        break;
                    case "studenti.uninsubria.it":
                        break;
                    case "icloud.com":
                        break;
                    case "outlook.com":
                        break;
                    case "hotmail.com":
                        break;
                    default:
                        this.errori = String.valueOf(this.errori) + "E-mail non valida\n";
                        break;
                }
            }
        }
        if (this.userName.getText().equals(""))
            this.errori = String.valueOf(this.errori) + "Il campo Username e' vuoto\n";
        if (String.valueOf(this.password.getPassword()).equals(""))
            this.errori = String.valueOf(this.errori) + "Il campo Password e' vuoto\n";
        if (!this.errori.contentEquals("")) {
            JOptionPane.showMessageDialog(this, this.errori, " Attenzione ", 2);
            this.errori = "";
            //se non ci sono errori nei dati dell'utente, chiamo il metodo InviaDati e li mando al server
            //se ritorna vero, operazione andata a buon fine -> stampo messaggio di conferma avvenimento operazione
            //se ritorna falso, stampo messaggio operazione andata a male -> deve rifare tutto (COME???)!!!
        } else {
            if(invioDatiUtente()) {
                JOptionPane.showMessageDialog(this, "Invio dati avvenuto con successo!","OPERAZIONE ESEGUITA CON SUCCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "ATTENZIONE: Username già utilizzato","ERRORE INVIO DATI", JOptionPane.WARNING_MESSAGE);
            }
            setVisible(false);
            (new SchermataAvvio()).setVisible(true);
            dispose();
        }
    }

    /**
    * Metodo con cui avviso il server dell'operazione che vado a fare, successivamente salvo il valore dei campi contenti
    * i dati della registrazione dell'utente, li impacchetto dentro il costruttore della classe
    * @see DatiUtenti
    * e li spedisco al server. Il serve riceve i dati, li estrapola e li inserisce nel bd attraverso il metodo <code>registra</code>
    * della classe
    * @see serverES.ServerSlave
    * Il metodo registra ritornerà un booleano, che verr&grave; rispedito in questa classe e verr&grave; usato per stampare un messaggio di avviso
    * di esito dell'operazione
    * @return <code>esitoOperazione</code>
    */
    private boolean invioDatiUtente() {
        String passaggioNome = this.nome.getText();
        String passaggioCognome = this.cognome.getText();
        String passaggioComune = this.comune.getText();
        String passaggioProvincia = this.provincia.getText().toUpperCase();
        String passaggioVia = this.via.getText();
        int passaggioNumeroCivico = Integer.parseInt(this.numeroCivico.getText());
        int passaggioCap = Integer.parseInt(this.cap.getText());
        String passaggioMail = this.mail.getText();
        String passaggioCF = this.codiceFiscale.getText().toUpperCase();
        String passaggioUsername = this.userName.getText();
        String passaggioPassword = this.password.getText();
        //inserisco questi dati in un costruttore della classe DatiUtenti, così li rendo serializzabili e passo un solo oggetto
        DatiUtenti datiUtentiRegistrazione = new DatiUtenti(passaggioNome, passaggioCognome, passaggioComune, passaggioProvincia, passaggioVia, passaggioNumeroCivico, passaggioCap, passaggioMail, passaggioCF, passaggioUsername, passaggioPassword);
        client = new clientES();
        boolean esitoOperazione = client.invioDatiUtenti(datiUtentiRegistrazione);
        client.close();
        return esitoOperazione;
    }
}
