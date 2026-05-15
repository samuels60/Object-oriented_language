package conubiodiclassi2;

public class Persona {
    private final String nome;
    private final String cognome;
    private final int eta;
    public Persona(String nome, String cognome,int intero){
        this.nome = nome;
        this.cognome = cognome;
        this.eta=intero;
    }

    public static Persona creaCostruttore(String nomeCognome,int intero){
        String[] nome = nomeCognome.split(";");
        return new Persona(nome[0],nome[1],intero);
    }
    public static Persona creaCostruttore(String nomeCognomeEta){
        String[] nome = nomeCognomeEta.split(" ");
        return new Persona(nome[0],nome[1],Integer.parseInt(nome[2]));
    }
    public String getNome() {
        return this.nome;
    }
    public  String getCognome () {
        return this.cognome;
    }

    @Override
    public String toString() {
        return "\n" + this.nome +
                "\n" + this.cognome +
                "\n" + this.eta;
    }
}
