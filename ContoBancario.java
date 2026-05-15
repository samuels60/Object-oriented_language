///Questa classe vi permette di:
///   -  Gestire un Conto Bancario
///   -  Versare nel conto
///   -  Prelevare dal conto
///   -  Verificare il saldo del conto
///
///     @autor         Samuel Falzone
///     @version       0.2
package esercizi3;
import java.util.*;

public class ContoBancario {

    private double saldo;
    private String nomeProprietario;
    private final int numeroConto;
    private static int counter;
    private String nome;
    private String cognome;
    /// costruttore della classe
    /// @param scanner istanza Scanner
    public ContoBancario(Scanner scanner){
        System.out.println("Inserisci il nome: ");
        this.nome = scanner.next();
        System.out.println("Inserisci il cognome: ");
        this.cognome = scanner.next();
        this.numeroConto = counter++;

    }

    /// costruttore della classe
    /// @param nomeProprietario nome del prorietario
    ///
    public ContoBancario (String nomeProprietario) {
        this.numeroConto = counter++;
        this.nomeProprietario = nomeProprietario;
    }
    /// costruttore della classe
    /// @param importo importo di apertura conto
    /// @param nomeProprietario nome del proprietario
    public ContoBancario ( String nomeProprietario, double importo){
        this.saldo = importo;
        this.numeroConto = counter++;
        this.nomeProprietario = nomeProprietario;
    }
    /// il metodo permette di versare una cifra sul conto
    /// @param importo cifra da versare
    public void versamento(double importo){
        this.saldo += importo;
        System.out.println("Versamento effetuato con successo ");
    }
    /// il metodo permette di prelevare una cifra dal conto
    /// @param importo cifra da prelevare
    public void prelievo(double importo){
        if(importo > this.saldo){
            System.out.println("Non hai sufficente denaro! ");
        }else{
            this.saldo -= importo;
            System.out.println("Prelievo effettuato con successo");
        }
    }
    /// @return saldo del conto
    public double ceckSaldo(){
        return this.saldo;
    }
    ///  @return numero del conto
    public int getNumeroConto(){
        return this.numeroConto ;
    }
    /// permette di effettuare transazioni tra un conto ed un'altro
    /// @param importo cifra
    /// @param conto conto destinatario
    public void bonificoBancario (double importo, ContoBancario conto) {
        this.prelievo(importo) ;
        conto.versamento(importo) ;
    }
}
