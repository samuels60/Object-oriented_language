package esercizio7.biblioteca4;

import java.util.Scanner;

public interface Prestabile {

    /** Imposta il nome dell'utente a cui viene prestato.
     *
     @param nomeUtentePrestito il nome dell'utente. */

    void setNomeUtentePrestito(String nomeUtentePrestito);

    /** Imposta la data del prestito.
     *
     @param dataPrestito la data del prestito. */

    void setDataPrestito (String dataPrestito);

    /** Imposta la data di restituzione.
     *
     @param dataRestituzione la data di restituzione. */

    void setDataRestituzione (String dataRestituzione);

    /** Ottiene il nome di chi ha in prestito il documento.
     *
     @return il nome di chi ha in prestito il documento. */

    public String getNomeUtentePrestito();

    /** Ottiene la data del prestito del documento.
     *
     @return la data del prestito del documento. */

    public String getDataPrestito ();

    /** Ottiene la data di restituzione del documento.
     *
     @return la data di restituzione del documento. */

    public String getDataRestituzione ();

    /** Effettua il prestito. */

    public void presta (Scanner scanner);

    /** Effettua la restituzione. */

    public void restituisci ();

    /** Visualizza il prestito. */

    public void visualizzaPrestito () ;

}
