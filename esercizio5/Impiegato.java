package esercizio5;

public class Impiegato extends Persona {
    private String datoreLavoro;
    private double salario;

    public Impiegato(String nome,String cognome){
        super(nome,cognome);
    }
    public Impiegato(String nome,String cognome,String datoreLavoro,  double salario){
        this(nome,cognome);
        this.datoreLavoro = datoreLavoro;
        this.salario = salario;
    }
    @Override
    public void presentati(){
        super.presentati();
        System.out.print(", lavoro per "+ this.datoreLavoro);
    }
}
