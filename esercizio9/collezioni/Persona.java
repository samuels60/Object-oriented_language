package esercizio9.collezioni;

import java.util.Scanner;

public class Persona {
    private final String nome;
    private final String cognome;
    private int eta;
    public Persona(Scanner scanner){
        System.out.println("Inserisci il nome e il cognome:");
        this.nome = scanner.next(); this.cognome = scanner.next(); scanner.nextLine();
        System.out.println("Inserisci la tua eta: ");
        this.eta = scanner.nextInt();
    }

    @Override
    public String toString(){
        return this.nome + " "
                + this.cognome + " "
                + "anni "+this.eta;
    }

}
