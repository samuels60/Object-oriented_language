///Questa classe vi permette di:
///   -  Creare un quadrato
///
///     @autor         Samuel Falzone
///     @version       0.1
package esercizio2.geometria.figurepiane;

public class Quadrato {

    private double lato;

    /// costruttore della classe
    /// @param lato lato del quadrato
    public  Quadrato(double lato){
        this.lato=lato;
        System.out.println("Ho creato il quadrato");
    }

    /// metodo per calcolare il perimetro del quadrato
    double calcolaPerimetro(){
        return this.lato*4;
    }

    /// metodo per ottenere il lato del quadrato
    double getLato(){
        return this.lato;
    }

    /// metoodo per calcolare l'area del quadrato
    double calcolaArea(){
        return this.lato * this.lato;
    }

    ///metodo che raddopia il lato del quadrato
    void raddopiaLato(){
        this.lato = this.lato * 2;
    }
}
