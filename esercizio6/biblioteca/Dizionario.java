package esercizio6.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dizionario extends Documento implements Serializable {
    private final Autore[] autori;
    private final String casaEditrice;
    private final String[] lingua;
    private final String titolo;
    private final double prezzo;

    public Dizionario(Scanner scanner) {
            super();
            scanner.nextLine();
            System.out.println("Inserisci il titolo del dizionario:");
            this.titolo = scanner.nextLine();
            System.out.println("Inserisci il prezzo:");
            this.prezzo = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Inserisci il nome della casa editrice:");
            this.casaEditrice = scanner.nextLine();
            /// iterazione per le lingue
            boolean restart = true;
            ArrayList<String> lingues = new ArrayList<>();
            System.out.println("inserisci le lingue trattate separate da uno spazio");
            while (!scanner.hasNextLine()) lingues.add(scanner.next());
            this.lingua = new String[lingues.size()];
            lingues.toArray(lingua);
            /// iterazione per gli autori
            restart = true;
            scanner.nextLine();
            ArrayList<Autore> autores = new ArrayList<>();
            do {
                Autore nome = new Autore(scanner);
                autores.add(nome);
                System.out.println("Devi inserire un'altro autore?(y:n)");
                String temp = scanner.nextLine();
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

    public String[] getLingua() {
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
                "\nCasa editrice: " + this.casaEditrice + "\n";
    }


    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getInfo() {
        return "Questo documento e' un dizionario";
    }
}
