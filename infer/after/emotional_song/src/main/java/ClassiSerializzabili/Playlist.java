package ClassiSerializzabili;

import java.io.Serializable;

/**
* Questa classe definisce l'oggetto <code>Playlist</code>.
* Richiamando il metodo costruttore &egrave; possibile istanziare un oggetto <code>Playlist</code>
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class Playlist implements Serializable {

    /**
     * Attributo che indica il numero di versione univoco associato a una classe serializzabile.
     * Viene utilizzato per identificare in modo univoco la versione della classe durante il processo di
     * deserializzazione
     */
    private static final Long serialVersionUID = 1L;

    /**
    * Contiene lo username relativo alla Playlist selezionata.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String username;

    /**
    * Contiene il nome relativo alla Playlist selezionata.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String nome;

    /**
    * Contiene la stringa con i brani relativi alla Playlist selezionata.
    * <br>Dichiarato <strong>private</strong> cos&igrave; da essere visto solo dalla classe attuale
    */
    private String brani;

    /**
    * Metodo Costruttore della classe <code>Playlist</code>.
    */
    public Playlist(String brani, String username, String nome){
        this.brani = brani;
        this.username = username;
        this.nome = nome;
    }

    /**
    * Permette di settare il valore dell'attributo 'nickname' dell'oggetto.
    * @param s Valorizza l'attributo <code>nickname</code> dell'oggetto su cui &egrave; richiamato.
    */
    public void setUsername(String s) {
        this.username=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'nome' dell'oggetto.
    * @param s Valorizza l'attributo <code>nome</code> dell'oggetto su cui &egrave; richiamato.
    */
    public void setNome(String s) {
        this.nome=s;
    }

    /**
    * Permette di settare il valore dell'attributo 'Brani' dell'oggetto.
    * @param s Valorizza l'attributo <code>Brani</code> dell'oggetto su cui &egrave; richiamato.
    */
    public void setBrani(String s) {
        this.brani=s;
    }

    /**
    * Restituisce il valore dell'attributo 'nickname' dell'oggetto.
    * @return Il valore dell'attributo <code>nickname</code>
    */
    public String getUsername() {
        return username;
    }

    /**
    * Restituisce il valore dell'attributo 'nome' dell'oggetto.
    * @return Il valore dell'attributo <code>nome</code>
    */
    public String getNome() {
        return nome;
    }

    /**
    * Override
    * Restituisce il valore dell'attributo 'nome' dell'oggetto sovrascrivendo il metodo <code>toString</code>.
    * @return Il valore dell'attributo <code>nome</code>
    */
    @Override
    public String toString(){
        return this.nome;
    }
}

