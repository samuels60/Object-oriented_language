///Questa classe vi permette di:
///   -  Gestire un serbatoio
///   -  Riempire il serbatoio
///   -  Consumare il carburante
///   -  Verificare il livello di carburante
///
///     @autor         Samuel Falzone
///     @version       0.1
package esercizio1;

public class Serbatoio {
    private int livello;
    private final int  capienza;

    /**Cosruttore con paramentro
     * @param capienza l'utente inserisce la capienza massima del serbatoio*/

    public Serbatoio ( int capienza ) {
        this.livello = 0;
        this.capienza = capienza ;
    }
    /**Cosruttore senza paramentri
     imposta il livello del serbatoio al massimo della sua capienza*/
    public Serbatoio(){
        this.livello = 0;
        this.capienza = 100;
    }

    /** Il metodo consumare il carburante
     * @param quantita decrementa la quantita di carburante nel serbatoio
     * */

    public void consuma ( int quantita ) {
        if ( this.livello >= quantita ) {
            this.livello -= quantita ;
        } else {
            System.out.println("Il serbatoio è vuoto");
            this.livello = 0;
        }
    }

    /**Il metodo aggiunge quantita di carburante
               al sebatoio non superando la soglia massima
        @param quantita incrementa la quantita di carburante nel serbatoio
     */

    public void rifornisci ( int quantita ) {
        int aus = this.livello + quantita;
        if( aus > capienza  ) {
            System.out.println("Il serbatoio è pieno, avanzano "+ ( aus - capienza) );
            livello = capienza;
        } else {
            livello = aus;
        }
    }

    /**Il metodo permettere conoscere il livello del serbatoio
     * @return livello del serbatoio
     * */

    public int getLivello() {

        return this.livello;

    }
}