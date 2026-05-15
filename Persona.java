package esercizio10;

import java.util.Comparator;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome,String cognome,int eta){
        this.nome = nome;
        this.cognome = cognome;
        this.eta=eta;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCognome() {
        return this.cognome;
    }
    public int getEta(){return this.eta;}
    public void presentati(){
        System.out.print(("Piacere, mi chiamo " + this.nome + " " + this.cognome ));
    }

    private static Comparator<Persona> etaComp =
            (persona1, persona2) -> Integer.compare(persona1.getEta(),persona2.getEta());
    private static Comparator<Persona> nomeComp =
            (persona1, persona2) -> persona1.getNome().compareTo(persona2.getNome());
    private static Comparator<Persona> cognomeComp =
            (persona1, persona2) -> persona1.getCognome().compareTo((persona2.getCognome()));
}
