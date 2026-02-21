package esercizio5;

public class Persona {
    private String nome;
    private String cognome;

    public Persona(String nome,String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCognome() {
        return this.cognome;
    }
    public void presentati(){
        System.out.print(("Piacere, mi chiamo " + this.nome + " " + this.cognome ));
    }
}
