package esercizi4.biblioteca;

import java.util.Scanner;

public class Autore {
    private final String nome;
    private final String cognome;

    public Autore(Scanner s  ){
        System.out.println("Inserisci Il nome e cognome dell'autore:");
        this.nome = s.next();
        this.cognome = s.next();
        System.out.println("Autore registrato");
        }
    @Override
    public String toString() {
        return this.nome + " "  + this.cognome;
    }

    public final String getNome(){return this.nome;}
    public final String getCognome(){return this.cognome;}

}
