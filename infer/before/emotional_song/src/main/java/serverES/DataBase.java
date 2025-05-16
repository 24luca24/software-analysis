package serverES;

import java.sql.*;

/**
* Classe stbilisce la connessione con il database.
* @author Candiani Valerio matricola:750632 VA
* @author Candiani Luca matricola: 749717 VA
* @author Airaghi Luca matricola: 749043 VA
* @author Mammì Matteo matricola: 750714 VA
*/
public class DataBase {
    /**
    * Variabile che contiene il protocollo
    */
    private final String protocol = "jdbc:postgresql://";

    /**
    * Variabile che contiene l'host
    */
    private static String host = "";

    /**
    * Variabile che contiene il nome del database
    */
    private final String db_name = "emotionalsong";

    /**
    * Variabile che contiene la stringa protocollo concatenata con la stringa host
    */
    private String url = protocol + host;

    /**
    * Variabile in cui verr&grave; inserito l'username per l'accesso al database
    */
    private static String user = ""; 

    /**
    * Variabile in cui verr&grave; inserita la password per accedere al database
    */
    private static String password = "";

    /**
    * Variabile formata dalla concatenazione delle stringhe: <code>protocol</code>, <code>host</code>, <code>db_name</code>
    */
    private String urlnew = protocol + host + db_name;

    /**
    * Elementi privati e statici per creare la connessione al database
    */
    private static Connection connection;
    
    /**
    * Elementi privati e statici per creare lo statement del database
    */
    private static Statement statement;

    /**
    * Costruttore della classe. Riceve i parametri per accedere al db
    * @param h contiene l'Hostname per la connessione al db
    * @param u contiene il nome utente
    * @param p contiene la password per il db
    */
    public DataBase(String h, String u, String p){       
        this.host=h+"/";
        this.user=u;
        this.password=p;
    }

    /**
    * Secondo costruttore della classe che si prova a connettere col database con i dati che forniti nel precedente
    * costruttore
    * @param variabile variabile boolean di controllo
    * @param var variabile intera di controllo
    * @throws SQLException cattura eccezione di tipo SQL
    */
    public DataBase(boolean variabile, int var) throws SQLException {
        if (var == 0){
            if(variabile == false){
                url = protocol + host;
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Collegamento postgres");
            }else{
                urlnew = protocol + host + db_name;
                connection = DriverManager.getConnection(urlnew, user, password);
                System.out.println("Collegamento db emotionalsong");
            }
            if(connection != null){
                System.out.println("Collegamento avvenuto con successo");
            }else{
                System.out.println("Collegamento NON avvenuto");
            }
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
        }else{
            System.out.println("non mi collego nuovamente");
        }
    }

    /**
     * metodo che verifica che la classe non esiste
     * @param var parametro di tipo boolean
     * @param dato parametro contenente il dato
     * @return <code>database</code>
     * @throws SQLException cattura eccezione sql
     */
    public static DataBase getInstance(boolean var,int dato) throws SQLException { //verifica che la classe non esiste
        DataBase  database = new DataBase(var,dato);
        return database;
    }

    /**
     * metodo per ottenere lo statement del db
     * @return <code>statement</code>
     */
    public static Statement getStatement() {
        return statement;
    }

    /**
     * metodo che restitiuisce un valore se la query viene eseguita, altrimenti null
     * @param sql parametro contenete la query
     * @return <code>statement.getResult</code> oppure <code>null</code> se qualcosa va storto
     * @throws SQLException cattura eccezione sql
     */
    public ResultSet submitQuery(String sql) throws SQLException { //eseguo la query e se mi restituisce un risultato bene, altrimenti mi restituisce null
        if(statement.execute(sql)) {
            return statement.getResultSet();
        }
        return null;
    }
    
    /**
     * metodo per ottenere la connessione del db
     * @return <code>connection</code>
     */
    public Connection getConnection(){
        return connection;
    }
}