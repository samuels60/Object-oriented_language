package esercizio5;

public class Dirigente extends Impiegato{
    private String dipartimento;

    public Dirigente(String nome,String cognome, String datoreLavoro,double salario){
        super(nome,cognome,datoreLavoro,salario);
    }

    public Dirigente(String nome,String cognome, String datoreLavoro,double salario,String dipartimento){
        this(nome,cognome,datoreLavoro,salario);
        this.dipartimento = dipartimento;
    }
    @Override
    public void presentati(){
        super.presentati();
        System.out.print(" nel diparitimento di "+this.dipartimento);
    }
}
