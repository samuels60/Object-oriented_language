package esercizio6.biblioteca;

///  documento implementa l'interfaccia comparable per confrontare i documenti tra loro, introduce quindi la possibilita
/// di crearee un ordine tra le istanze di una classe, in questo caso l'rdine viene definito dal momento in cui un elemento viene creato
public abstract class Documento implements Comparable<Documento>{
    public final int ID;
    public static int counter;
    public Documento(){
        this.ID = this.counter++;
    }

    public int getID() {
        return ID;
    }

    @Override
    public int compareTo(Documento other){
        return this.ID - other.ID;
    }
    @Override
    public int hashCode() {
        return 0;
    }
    public abstract String getInfo();
}
