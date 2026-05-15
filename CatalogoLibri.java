package esercizi4.biblioteca;

import java.util.ArrayList;

public class CatalogoLibri {
    private ArrayList<Libro> catalogo = new ArrayList<>();

    public ArrayList<Libro> getCatalogo(){
        return this.catalogo;
    }
    public void stampaCatalogo(){
        System.out.println(catalogo);
    }
    public void inserisciLibro(Libro daInserire){
        catalogo.add(daInserire);
        System.out.println("Il libro e' stato inserito con successo");
    }
    public void ricercaPerAutore(String chiave){
        boolean trovato = true;

        for(Libro libro : this.catalogo){
            for(Autore autore: libro.getAuotori()){
                if(chiave.strip().equalsIgnoreCase(autore.getCognome())){
                    System.out.println(libro);
                    trovato = false;
                }

            }
        }
        if(trovato){
            System.out.println("Nessun risultato trovato");
        }

    }

}
