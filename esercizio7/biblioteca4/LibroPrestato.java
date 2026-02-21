package esercizio7.biblioteca4;

import java.util.Scanner;

public class LibroPrestato extends Libro implements Prestabile{
    private String nomeUtentePrestito;
    private String dataPrestito;
    private String dataRestituzione;
    public boolean inPrestito;


    @Override
    public void setNomeUtentePrestito(String nomeUtentePrestito) {
        this.nomeUtentePrestito = nomeUtentePrestito;
    }

    @Override
    public void setDataPrestito(String dataPrestito) {
        this.dataPrestito= dataPrestito;
    }

    @Override
    public void setDataRestituzione(String dataRestituzione) {
        this.dataRestituzione=dataRestituzione;
    }

    @Override
    public String getNomeUtentePrestito() {
        return "Utente del prestito: " + this.nomeUtentePrestito;
    }

    @Override
    public String getDataPrestito() {
        return "Data del prestito: " + this.dataPrestito ;
    }

    @Override
    public String getDataRestituzione() {
        return "Data restituzione prevista: " + this.dataRestituzione;
    }

    @Override
    public void presta(Scanner scanner) {
        System.out.println("inserisci la data del prestito: ");
        setDataPrestito(scanner.nextLine());
        System.out.println("inserisci il tuo nome utente:");
        setNomeUtentePrestito(scanner.nextLine());
        System.out.println("Inserisci la data di oggi");
        setDataPrestito(scanner.nextLine());
        System.out.println("Inserisci la data della restituzione ");
        setDataRestituzione(scanner.nextLine());
        this.inPrestito= true;

    }

    @Override
    public void restituisci() {
        this.dataPrestito = null;
        this.dataRestituzione = null;
        this.nomeUtentePrestito = null;
        this.inPrestito=false;
    }

    @Override
    public void visualizzaPrestito() {
        if(this.inPrestito) {
            System.out.println("\nUtente: " + this.nomeUtentePrestito +
                    "\nData inizio prestito: " + this.dataPrestito +
                    "\nData restituzione prevista: " + this.dataRestituzione);
        }else{
            System.out.println("Il libro non e' in prestito!");
        }

    }
}
