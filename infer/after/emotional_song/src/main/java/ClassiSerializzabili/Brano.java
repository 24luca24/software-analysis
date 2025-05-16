package ClassiSerializzabili;

import java.io.Serializable;

/**
* Questa classe definisce l'oggetto <code>Brano</code>.
* Richiamando il metodo costruttore &egrave; possibile istanziare un oggetto <code>Brano</code>
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class Brano implements Serializable {

    /**
    * Attributo che indica il numero di versione univoco associato a una classe serializzabile.
    * Viene utilizzato per identificare in modo univoco la versione della classe durante il processo di
    * deserializzazione
    */
    private static final Long serialVersionUID = 1L;

    /**
    * Contiene l'id del Brano selezionato.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String id;

    /**
    * Contiene il titolo del Brano selezionato.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String titolo;

    /**
    * Contiene l'autore del Brano selezionato.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String autore;

    /**
    * Contiene l'anno del Brano selezionato.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String anno;
    
    /**
    * Costruttore vuoto della classe
    */
    public Brano() {
        
    }

    public Brano(String titolo, String autore, String anno, String id){
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.id = id;
    }
    
    /**
    * Permette di settare il valore dell'attributo titolo dell'oggetto.
    * @param s Valorizza l'attributo <code>titolo</code> dell'oggetto su cui &egrave; richiamato.
    */
    public void setTitolo(String s) {
        this.titolo = s;
    }

    /**
    * Permette di settare il valore dell'attributo autore dell'oggetto.
    * @param s Valorizza l'attributo <code>autore</code> dell'oggetto su cui &egrave; richiamato.
    */
    public void setAutore(String s) {
        this.autore = s;
    }

    /**
    * Permette di settare il valore dell'attributo anno dell'oggetto.
    * @param s Valorizza l'attributo <code>anno</code> dell'oggetto su cui &egrave; richiamato.
    */
    public void setAnno(String s) {
        this.anno = s;
    }

    /**
    * Permette di settare il valore dell'attributo id dell'oggetto.
    * @param s Valorizza l'attributo <code>id</code> dell'oggetto su cui &egrave; richiamato.
    */
    public void setId(String s) {
        this.id = s;
    }

    /**
    * Restituisce il valore dell'attributo titolo dell'oggetto.
    * @return Il valore dell'attributo <code>titolo</code>
    */
    public String getTitolo() {
        return this.titolo;
    }

    /**
    * Restituisce il valore dell'attributo autore dell'oggetto.
    * @return Il valore dell'attributo <code>autore</code>
    */
    public String getAutore() {
        return this.autore;
    }

    /**
    * Restituisce il valore dell'attributo anno dell'oggetto.
    * @return Il valore dell'attributo <code>anno</code>
    */
    public String getAnno() {
        return this.anno;
    }


    /**
    * Restituisce il valore dell'attributo id dell'oggetto.
    * @return Il valore dell'attributo <code>id</code>
    */
    public String getId() {
        return this.id;
    }

    /**
    * Override
    * Restituisce il valore dell'attributo titolo dell'oggetto sovrascrivendo il metodo <code>toString</code>.
    * @return Il valore dell'attributo <code>titolo</code>
    */
    @Override
    public String toString() {
        return this.titolo;
    }
}
