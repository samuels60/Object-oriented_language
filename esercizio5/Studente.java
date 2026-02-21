package esercizio5;

public class Studente extends Persona{
    private String universita;
    private int matricola;

    public Studente(String nome, String cognome){
        super(nome, cognome);
    }

    public Studente(String nome, String cognome, String universita, int matricola){
        this(nome,cognome);
        this.universita = universita;
        this.matricola = matricola;
    }
    @Override
    public void presentati(){
        super.presentati();
        System.out.print(",e studio presso " + this.universita );
    }


}
