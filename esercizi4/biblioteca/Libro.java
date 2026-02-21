package esercizi4.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Libro {
    private static int counter;
    private final int ID;
    private String titolo;
    private double prezzo;
    private final Autore[] autori;
    private String casaEditrice;

    public Libro(Scanner s){
        s = new Scanner(System.in);
        this.ID = counter++;
        System.out.println("Inserisci il titolo del libro");
        this.titolo = s.nextLine();
        boolean request = true;

        ArrayList<Autore> autoriList = new ArrayList<Autore>();

        do{
            Autore autore = new Autore(s);
            autoriList.add(autore);
            System.out.println("Vuoi inserire un'altro autore? \n\t(no:0)\t(si:1)");
            if(s.nextInt() == 0) request = false;
        }while(request);

        this.autori = new Autore[autoriList.size()];
        autoriList.toArray(this.autori);
        System.out.println("Inserisci il prezzo: ");
        this.prezzo = s.nextDouble();
        s.nextLine();
        System.out.println("Inserisci la casa editrice: ");
        this.casaEditrice = s.nextLine();

    }

    public final Autore[] getAuotori(){
        return this.autori;
    }

    @Override
    public String toString(){
        return  "\nID: " + this.ID +
                "\nTitolo: " + this.titolo +
                "\nPrezzo: " + this.prezzo +
                "\nAutori: "+ Arrays.toString(this.autori) +
                "\nCasa Editice: " + this.casaEditrice + "\n";
    }

}
