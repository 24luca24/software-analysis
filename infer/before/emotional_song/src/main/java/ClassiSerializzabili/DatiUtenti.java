package ClassiSerializzabili;

import java.io.Serializable;
/**
 * Questa classe definisce un oggetto di tipo DatiUtente, ovvero un oggetto contenente informazioni serializzabili
 * riguardati la registrazione e l'accesso dell'utente. La classe risulta molto utile perchè permette di mandare tanti
 * elementi al server, raggruppati in un semplice oggetto
 * @author Candiani Valerio matricola: 750632VA
 * @author Candiani Luca matricola: 749717 VA
 * @author Airaghi Luca matricola: 749043 VA
 * @author Mammì Matteo matricola: 750714 VA
 */

/**
 * Classe usata per "impacchettare" i dati dell'utente dalla classe registrazione e accesso. I dati vengono messi in questa
 * classe serializzabile e inviati poi al server che mediante i metodi get li può elaborare
 */
public class DatiUtenti implements Serializable {

    /**
     * Attributo che indica il numero di versione univoco associato a una classe serializzabile.
     * Viene utilizzato per identificare in modo univoco la versione della classe durante il processo di
     * deserializzazione
     */
    private static final Long serialVersionUID = 1L;

    /**
     * Conterr&agrave; il nome passato come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private String nomeDato;

    /**
     * Conterr&agrave; il cognome come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private String cognomeDato;

    /**
     * Conterr&agrave; il comune passato come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private String comuneDato;

    /**
     * Conterr&agrave; la provincia passata come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private String provinciaDato;

    /**
     * Conterr&agrave; la via passata come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private String viaDato;

    /**
     * Conterr&agrave; il numero civico passato come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private int numeroCivicoDato;

    /**
     * Conterr&agrave; il cap passato come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private int capDato;

    /**
     * Conterr&agrave; la mail passata come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private String mailDato;

    /**
     * Conterr&agrave; il codice fiscale passato come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private String cFDato;

    /**
     * Conterr&agrave; lo username passato come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private String usernameDato;

    /**
     * Conterr&agrave; la password passato come parametro dal costruttore
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private String passwordDato;


    /**
     * Costruttore della classe, inizializza gli attributi precedentemente dichiarati mediante i parametri ricevuti come argomento
     * @param passaggioNome contiene il nome dell'utente
     * @param passaggioCognome contiene il cognome dell'utente
     * @param passaggioComune contiene il comune dell'utente
     * @param passaggioProvincia contiene la provincia dell'utente
     * @param passaggioVia contiene la via dell'utente
     * @param passaggioNumeroCivico contiene il numero civico dell'utente
     * @param passaggioCap contiene il cap dell'utente
     * @param passaggioMail contiene l'indirizzo mail dell'utente
     * @param passaggioCF contiene il CF dell'utente
     * @param passaggioUsername contiene l'username dell'utente
     * @param passaggioPassword contiene la password dell'utente
     */
    public DatiUtenti(String passaggioNome, String passaggioCognome, String passaggioComune, String passaggioProvincia, String passaggioVia, int passaggioNumeroCivico, int passaggioCap, String passaggioMail, String passaggioCF, String passaggioUsername, String passaggioPassword) {
        this.nomeDato = passaggioNome;
        this.cognomeDato = passaggioCognome;
        this.comuneDato = passaggioComune;
        this.provinciaDato = passaggioProvincia;
        this.viaDato = passaggioVia;
        this.numeroCivicoDato = passaggioNumeroCivico;
        this.capDato = passaggioCap;
        this.mailDato = passaggioMail;
        this.cFDato = passaggioCF;
        this.usernameDato = passaggioUsername;
        this.passwordDato = passaggioPassword;
    }

    /**
     * Altro costruttore che impacchetta come dato solamente username e password. Utile nella classe
     * @see emotionalnew.Accesso
     * @param usernameInvio contene username dell'utente
     * @param passwordInvio contiene password dell'utente
     */
    public DatiUtenti(String usernameInvio, String passwordInvio) {
        this.usernameDato = usernameInvio;
        this.passwordDato = passwordInvio;
    }

    /**
     * Metodo get per l'attributo cognomeDato
     * @return <code>cognomeDato</code>
     */
    public String getCognomeDato() {
        return cognomeDato;
    }

    /**
     * Metodo get per l'attributo comuneDato
     * @return <code>comuneDato</code>
     */
    public String getComuneDato() {
        return comuneDato;
    }

    /**
     * Metodo get per l'attributo provinciaDato
     * @return <code>provinciaDato</code>
     */
    public String getProvinciaDato() {
        return provinciaDato;
    }

    /**
     * Metodo get per l'attributo viaDato
     * @return <code>viaDato</code>
     */
    public String getViaDato() {
        return viaDato;
    }

    /**
     * Metodo get per l'attributo numeroCivicoDato
     * @return <code>numeroCivicoDato</code>
     */
    public int getNumeroCivicoDato() {
        return numeroCivicoDato;
    }

    /**
     * Metodo get per l'attributo capDato
     * @return <code>capDato</code>
     */
    public int getCapDato() {
        return capDato;
    }

    /**
     * Metodo get per l'attributo mailDato
     * @return <code>nomeDato</code>
     */
    public String getMailDato() {
        return mailDato;
    }

    /**
     * Metodo get per l'attributo cFDato
     * @return <code>cFDato</code>
     */
    public String getcFDato() {
        return cFDato;
    }

    /**
     * Metodo get per l'attributo usernameDato
     * @return <code>usernameDato</code>
     */
    public String getUsernameDato() {
        return usernameDato;
    }

    /**
     * Metodo get per l'attributo passwordDato
     * @return <code>passwordDato</code>
     */
    public String getPasswordDato() {
        return passwordDato;
    }
}
