package ClassiSerializzabili;

import java.io.Serializable;
import java.util.ArrayList;

/**
* Questa classe permette di creare una lista di Brani. La classe è serializzabile quindi viene usata negli scambi
* d'informazioni tra serverSlave e client:
* @author Candiani Valerio matricola: 750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class ListOfBrani implements Serializable {

    /**
     * Attributo che indica il numero di versione univoco associato a una classe serializzabile.
     * Viene utilizzato per identificare in modo univoco la versione della classe durante il processo di
     * deserializzazione
     */
    private static final Long serialVersionUID = 1L;

    /**
     * Conterr&agrave; brani
     * <br>Dichiarato <strong>private</strong> cos&igrave; da esser visto solo dalla classe attuale
     */
    private ArrayList<Brano> lista;

    /**
     * Costruttore della classe, crea una nuova lista, Arraylist di tipo Brano
     */
    public ListOfBrani(){
        this.lista = new ArrayList<>();
    }

    /**
     * Metodo che permette l'aggiunta di un brano alla lista
     * @param b contiene il bano da aggiungere a <code>lista</code>
     */
    public void add(Brano b){
        this.lista.add(b);
    }

    /**
     * Metodo che permette l'aggiunta di un brano alla lista, dato anche un indice, quindi specificandone la posizione
     * @param i contiene l'idice dove aggiungere il brano
     * @param b contiene il bano da aggiungere a <code>lista</code>
     */
    public void add(int i, Brano b){
        this.lista.add(i,b);
    }

    /**
     * Metodo che permette alla lista di svuotarsi
     */
    public void clear(){
        this.lista.clear();
    }

    /**
     * Ritorna la lista
     * @return <code>lista</code>
     */
    public ArrayList<Brano> getList(){
        return this.lista;
    }

    /**
     * Converte la lista in un array
     * @return <code>list</code>
     */
    public String[] toArray() {
        String[] list = new String[lista.size()];
        for(int i = 0; i < lista.size(); i++){
            String provvisoria = "" + lista.get(i).getAnno() + " " + lista.get(i).getId()+ " (" + lista.get(i).getAutore()+ ") " + lista.get(i).getTitolo();
            list[i] = provvisoria;
        }
        return list;
    }
}
