package esercizio7.biblioteca4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Quotidiano extends Documento implements Serializable {
    private Autore[] autori;
    private String casaEditrice;
    private String lingua;
    private String titolo;
    private double prezzo;
    public Quotidiano(Scanner scanner){
        scanner.nextLine();
        System.out.println("Inserisci il titolo di prima pagina:");
        this.titolo = scanner.nextLine();
        System.out.println("Inserisci il prezzo:");
        this.prezzo = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Inserisci il nome della casa editrice:");
        this.casaEditrice = scanner.nextLine();
        System.out.println("Inserisci la lingua:");
        this.lingua = scanner.nextLine();
        boolean restart = true;
        ArrayList<Autore> autores =new ArrayList<>();
        do {

            Autore nome = new Autore(scanner);
            System.out.println("Devi inserire un'altro autore?(y:n)");
            String temp = scanner.nextLine();
            autores.add(nome);
            if (temp.toLowerCase().equals("n")) restart = false;
        } while (restart);
        this.autori = new Autore[autores.size()];
        autores.toArray(autori);
    }

    public String getCasaEditrice() {
        return this.casaEditrice;
    }

    public Autore[] getAutori() {
        return this.autori;
    }

    public String getLingua() {
        return this.lingua;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    @Override
    public String toString() {
        return
                "\nTitolo: " + this.titolo +
                "\nAutori: " + Arrays.toString(this.autori)+
                "\nPrezzo: " + this.prezzo +
                "\nCasa editrice: " + this.casaEditrice +
                "\nprezzo: " + this.prezzo + "\n";
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getInfo() {
        return "Questo documento e' un quotidiano";
    }
}
