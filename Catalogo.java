package esercizio7.biblioteca4;


import javax.print.Doc;
import java.io.Serializable;
import java.util.ArrayList;

public class Catalogo implements Serializable {
    private final ArrayList<Documento> catalogo ;
    public Catalogo(){
        catalogo = new ArrayList<>();
    }
    public Catalogo(ArrayList<Documento> param){
        this.catalogo = param;
    }
    public ArrayList<Documento> getCatalogo() {
        return this.catalogo;
    }

    public void ricercaPerAutore(String chiave) {
        Documento[] doc = new Documento[catalogo.size()];
        catalogo.toArray(doc);
        for (Documento d : doc) {
            if (d instanceof Libro libro)
                for (Autore autore : libro.getAutori())
                    if (autore.getCognome().equals(chiave))
                        System.out.println(d.toString());
            if (d instanceof Dizionario dizionario)
                for (Autore autore : dizionario.getAutori())
                    if (autore.getCognome().equals(chiave))
                        System.out.println(d.toString());
            if (d instanceof Quotidiano quotidiano)
                for (Autore autore : quotidiano.getAutori())
                    if (autore.getCognome().equals(chiave))
                        System.out.println(d.toString());
        }
    }

    public void ricercaPerTitolo(String chiave) {
        Documento[] doc = new Documento[catalogo.size()];
        catalogo.toArray(doc);
        for (Documento d : doc) {
            if (d instanceof Libro libro)
                if (libro.getTitolo().equals(chiave))
                    System.out.println(d.toString());
            if (d instanceof Dizionario dizionario)
                if (dizionario.getTitolo().equals(chiave))
                    System.out.println(d.toString());
            if (d instanceof Quotidiano quotidiano)
                if (quotidiano.getTitolo().equals(chiave))
                    System.out.println(d.toString());
        }
    }
    public void ricercaPerTitoloGenerics(String chiave){
        Documento[] doc = new Documento[catalogo.size()];
        catalogo.toArray(doc);
        for( T d: doc){
            if(d instanceof <T>)
        }
    }

    public void ricercaPerCasaEditrice(String chiave) {
        Documento[] doc = new Documento[catalogo.size()];
        catalogo.toArray(doc);
        for (Documento d : doc) {
            if (d instanceof Libro libro)
                if (libro.getCasaEditrice().equals(chiave))
                    System.out.println(d.toString());

            if (d instanceof Dizionario dizionario)
                if (dizionario.getCasaEditrice().equals(chiave))
                    System.out.println(d.toString());

            if (d instanceof Quotidiano quotidiano)
                if (quotidiano.getCasaEditrice().equals(chiave))
                    System.out.println(d.toString());
        }
    }

    public void ricercaPerLingua(String chiave) {
        Documento[] doc = new Documento[catalogo.size()];
        catalogo.toArray(doc);
        for (Documento d : doc) {

            if (d instanceof Libro libro)
                if (libro.getLingua().equals(chiave))
                    System.out.println(d.toString());

            if (d instanceof Dizionario dizionario)
                for (String lingua : dizionario.getLingua())
                    if (lingua.equals(chiave))
                        System.out.println(d.toString());

            if (d instanceof Quotidiano quotidiano)
                if (quotidiano.getLingua().equals(chiave))
                    System.out.println(d.toString());
        }
    }

    public void ricercaPrezzo(Double prezzo){
        Documento[] doc = new Documento[catalogo.size()];
        catalogo.toArray(doc);
        for (Documento d : doc) {

            if (d instanceof Libro libro)
                if (libro.getPrezzo()==prezzo)
                    System.out.println(d.toString());

            if (d instanceof Dizionario dizionario)
                    if (dizionario.getPrezzo()==prezzo)
                        System.out.println(d.toString());

            if (d instanceof Quotidiano quotidiano)
                if (quotidiano.getPrezzo()==prezzo)
                    System.out.println(d.toString());
        }
    }
}
