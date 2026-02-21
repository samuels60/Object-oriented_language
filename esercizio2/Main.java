package esercizio2;

public class Main {
    public static void main(String[] args) {
        ContoBancario conto = new ContoBancario("Franco");
        System.out.println("il conto è il seguente " + conto.ceckSaldo());
        conto.versamento(300.5);
        System.out.println("il conto è il seguente " + conto.ceckSaldo());
        conto.prelievo(200);
        System.out.println("il conto è il seguente " + conto.ceckSaldo() + " " + conto.getNumeroConto());


    }
}
