package esercizio6.biblioteca;

import java.util.Scanner;

public class Autore {
    private final String nome;
    private final String cognome;

    /// il costruttore ha come parametro d'ingresso l'ogetto scanner
    public Autore(Scanner scanner) {
        System.out.println("Inserisci il nome e cognome dell'autore: ");
        this.nome = scanner.next();
        this.cognome = scanner.nextLine();
    }
    public String getNome(){
        return this.nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String toString() {
        return this.nome + " " + this.cognome;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
