package ClassiSerializzabili;

import java.io.Serializable;

/**
* Questa classe definisce l'oggetto <code>Giudizio</code>.
* Richiamando il metodo costruttore &egrave; possibile istanziare un oggetto <code>Giudizio</code>
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class Giudizio implements Serializable {

    /**
     * Attributo che indica il numero di versione univoco associato a una classe serializzabile.
     * Viene utilizzato per identificare in modo univoco la versione della classe durante il processo di
     * deserializzazione
     */
    private static final Long serialVersionUID = 1L;
    
    /**
    * Contiene lo username del cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String username;

    /**
    * Contiene la valutazione del cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private int valutazioneStupore;

    /**
    * Contiene la valutazione del parametro 'Solennit&agrave;' del cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private int valutazioneSolennita;

    /**
    * Contiene la valutazione del parametro 'Tenerezza' del cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private int valutazioneTenerezza;

    /**
    * Contiene la valutazione del parametro 'Nostalgia' del cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private int valutazioneNostalgia;

    /**
    * Contiene la valutazione del parametro 'Calma' del cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private int valutazioneCalma;

    /**
    * Contiene la valutazione del parametro 'Potenza' del cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private int valutazionePotenza;

    /**
    * Contiene la valutazione del parametro 'Gioia' del cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private int valutazioneGioia;

    /**
    * Contiene la valutazione del parametro 'Tensione' del cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private int valutazioneTensione;

    /**
    * Contiene la valutazione del parametro 'Tristezza' del cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private int valutazioneTristezza;

    /**
    * Contiene il commento del parametro 'Stupore' cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String commentoStupore;

    /**
    * Contiene il commento del parametro 'Solennit&agrave;' cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String commentoSolennita;

    /**
    * Contiene il commento del parametro 'Tenerezza' cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String commentoTenerezza;

    /**
    * Contiene il commento del parametro 'Nostalgia' cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String commentoNostalgia;

    /**
    * Contiene il commento del parametro 'Calma' cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String commentoCalma;

    /**
    * Contiene il commento del parametro 'Potenza' cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String commentoPotenza;

    /**
    * Contiene il commento del parametro 'Gioia' cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String commentoGioia;

    /**
    * Contiene il commento del parametro 'Tensione' cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String commentoTensione;

    /**
    * Contiene il commento del parametro 'Tristezza' cliente che ha espresso il giudizio.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String commentoTristezza;

    /**
    * Metodo Costruttore vuoto della classe <code>Giudizio</code>.
    */
    public Giudizio(){
    }

    /**
    * Permette di settare il valore dell'attributo 'nickname' dell'oggetto.
    * @param s Valorizza l'attributo <code>nickname</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setUsername(String s) {
        username=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'valutazione' dell'oggetto.
    * @param s Valorizza l'attributo <code>valutazioneStupore</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setValutazioneStupore(int s) {
        valutazioneStupore=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'solennita' dell'oggetto.
    * @param s Valorizza l'attributo <code>valutazioneSolennita</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setValutazioneSolennita(int s) {
        valutazioneSolennita=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'tenerezza' dell'oggetto.
    * @param s Valorizza l'attributo <code>valutazioneTenerezza</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setValutazioneTenerezza(int s) {
        valutazioneTenerezza=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'nostalgia' dell'oggetto.
    * @param s Valorizza l'attributo <code>valutazioneNostalgia</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setValutazioneNostalgia(int s) {
        valutazioneNostalgia=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'calma' dell'oggetto.
    * @param s Valorizza l'attributo <code>valutazioneCalma</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setValutazioneCalma(int s) {
        valutazioneCalma=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'potenza' dell'oggetto.
    * @param s Valorizza l'attributo <code>valutazionePotenza</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setValutazionePotenza(int s) {
        valutazionePotenza=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'gioia' dell'oggetto.
    * @param s Valorizza l'attributo <code>valutazioneGioia</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setValutazioneGioia(int s) {
        valutazioneGioia=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'tensione' dell'oggetto.
    * @param s Valorizza l'attributo <code>valutazioneTensione</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setValutazioneTensione(int s) {
        valutazioneTensione=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'tristezza' dell'oggetto.
    * @param s Valorizza l'attributo <code>valutazioneTristezza</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setValutazioneTristezza(int s) {
        valutazioneTristezza=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'commento' riferito all'emozione 'Stupore' dell'oggetto.
    * @param s Valorizza l'attributo <code>commentoStupore</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setCommentoStupore(String s) {
        commentoStupore=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'commento' riferito all'emozione 'Solennita' dell'oggetto.
    * @param s Valorizza l'attributo <code>commentoSolennita</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setCommentoSolennita(String s) {
        commentoSolennita=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'commento' riferito all'emozione 'Tenerezza' dell'oggetto.
    * @param s Valorizza l'attributo <code>commentoTenerezza</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setCommentoTenerezza(String s) {
        commentoTenerezza=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'commento' riferito all'emozione 'Nostalgia' dell'oggetto.
    * @param s Valorizza l'attributo <code>commentoNostalgia</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setCommentoNostalgia(String s) {
        commentoNostalgia=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'commento' riferito all'emozione 'Calma' dell'oggetto.
    * @param s Valorizza l'attributo <code>commentoCalma</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setCommentoCalma(String s) {
        commentoCalma=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'commento' riferito all'emozione 'Potenza' dell'oggetto.
    * @param s Valorizza l'attributo <code>commentoPotenza</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setCommentoPotenza(String s) {
        commentoPotenza=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'commento' riferito all'emozione 'Gioia' dell'oggetto.
    * @param s Valorizza l'attributo <code>commentoGioia</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setCommentoGioia(String s) {
        commentoGioia=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'commento' riferito all'emozione 'Tensione' dell'oggetto.
    * @param s Valorizza l'attributo <code>commentoTensione</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setCommentoTensione(String s) {
        commentoTensione=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'commento' riferito all'emozione 'Tristezza' dell'oggetto.
    * @param s Valorizza l'attributo <code>commentoTristezza</code> dell'oggetto su cui &egrave; richiamato.
    */
    public  void setCommentoTristezza(String s) {
        commentoTristezza=s;
    }

    /**
    * Restituisce il valore dell'attributo 'nickname' dell'oggetto.
    * @return Il valore dell'attributo <code>nickname</code>
    */
    public  String getUsername() {
        return username;
    }

    /**
    * Restituisce il valore dell'attributo 'stupore' dell'oggetto.
    * @return Il valore dell'attributo <code>valutazioneStupore</code>
    */
    public  int getValutazioneStupore() {
        return valutazioneStupore;
    }

    /**
    * Restituisce il valore dell'attributo 'solennita' dell'oggetto.
    * @return Il valore dell'attributo <code>valutazioneSolennita</code>
    */
    public  int getValutazioneSolennita() {
        return valutazioneSolennita;
    }

    /**
    * Restituisce il valore dell'attributo 'tenerezza' dell'oggetto.
    * @return Il valore dell'attributo <code>valutazioneTenerezza</code>
    */
    public  int getValutazioneTenerezza() {
        return valutazioneTenerezza;
    }

    /**
    * Restituisce il valore dell'attributo 'nostalgia' dell'oggetto.
    * @return Il valore dell'attributo <code>valutazioneNostalgia</code>
    */
    public  int getValutazioneNostalgia() {
        return valutazioneNostalgia;
    }

    /**
    * Restituisce il valore dell'attributo 'calma' dell'oggetto.
    * @return Il valore dell'attributo <code>valutazioneCalma</code>
    */
    public  int getValutazioneCalma() {
        return valutazioneCalma;
    }

    /**
    * Restituisce il valore dell'attributo 'potenza' dell'oggetto.
    * @return Il valore dell'attributo <code>valutazionePotenza</code>
    */
    public  int getValutazionePotenza() {
        return valutazionePotenza;
    }

    /**
    * Restituisce il valore dell'attributo 'gioia' dell'oggetto.
    * @return Il valore dell'attributo <code>valutazioneGioia</code>
    */
    public  int getValutazioneGioia() {
        return valutazioneGioia;
    }

    /**
    * Restituisce il valore dell'attributo 'tensione' dell'oggetto.
    * @return Il valore dell'attributo <code>valutazioneTensione</code>
    */
    public  int getValutazioneTensione() {
        return valutazioneTensione;
    }

    /**
    * Restituisce il valore dell'attributo 'tristezza' dell'oggetto.
    * @return Il valore dell'attributo <code>valutazioneTristezza</code>
    */
    public  int getValutazioneTristezza() {
        return valutazioneTristezza;
    }

    /**
    * Restituisce il valore dell'attributo 'commento' riferito all'emozione 'Stupore' dell'oggetto.
    * @return Il valore dell'attributo <code>commentoStupore</code>
    */
    public  String getCommentoStupore() {
        return commentoStupore;
    }

    /**
    * Restituisce il valore dell'attributo 'valutazione' riferito all'emozione 'Solennita' dell'oggetto.
    * @return Il valore dell'attributo <code>commentoSolennita</code>
    */
    public  String getCommentoSolennita() {
        return commentoSolennita;
    }

    /**
    * Restituisce il valore dell'attributo 'valutazione' riferito all'emozione 'Tristezza' dell'oggetto.
    * @return Il valore dell'attributo <code>commentoTenerezza</code>
    */
    public  String getCommentoTenerezza() {
        return commentoTenerezza;
    }

    /**
    * Restituisce il valore dell'attributo 'valutazione' riferito all'emozione 'Nostalgia' dell'oggetto.
    * @return Il valore dell'attributo <code>commentoNostalgia</code>
    */
    public  String getCommentoNostalgia() {
        return commentoNostalgia;
    }

    /**
    * Restituisce il valore dell'attributo 'valutazione' riferito all'emozione 'Calma' dell'oggetto.
    * @return Il valore dell'attributo <code>commentoCalma</code>
    */
    public  String getCommentoCalma() {
        return commentoCalma;
    }

    /**
    * Restituisce il valore dell'attributo 'valutazione' riferito all'emozione 'Potenza' dell'oggetto.
    * @return Il valore dell'attributo <code>commentoPotenza</code>
    */
    public  String getCommentoPotenza() {
        return commentoPotenza;
    }

    /**
    * Restituisce il valore dell'attributo 'valutazione' riferito all'emozione 'Gioia' dell'oggetto.
    * @return Il valore dell'attributo <code>commentoGioia</code>
    */
    public  String getCommentoGioia() {
        return commentoGioia;
    }

    /**
    * Restituisce il valore dell'attributo 'valutazione' riferito all'emozione 'Tensione' dell'oggetto.
    * @return Il valore dell'attributo <code>commentoTensione</code>
    */
    public  String getCommentoTensione() {
        return commentoTensione;
    }

    /**
    * Restituisce il valore dell'attributo 'valutazione' riferito all'emozione 'Tristezza' dell'oggetto.
    * @return Il valore dell'attributo <code>commentoTristezza</code>
    */
    public  String getCommentoTristezza() {
        return commentoTristezza;
    }
}
