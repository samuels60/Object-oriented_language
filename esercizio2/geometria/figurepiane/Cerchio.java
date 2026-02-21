///Questa classe vi permette di:
///   -  Creare un cerchio
///
///     @autor         Samuel Falzone
///     @version       0.1
package esercizio2.geometria.figurepiane;

public class Cerchio {
    private double raggio;
    final static double PI_GRECO = 3.1415;
    /// costruttore della classe che prende a parametro il raggio
    /// @param raggio raggio del cerchio
    public Cerchio(int raggio){
        this.raggio = raggio;
        System.out.println("Ho creato un cerchio");
    }

    /// metodo per verificare il raggio inserito
    public double getRaggio(){
        return this.raggio;
    }

    /// metodo per calcolare la circonferenza

    public double calcolaCirconferenza(){
        return 2*PI_GRECO*raggio;
    }

    /// metodo per ottenere il diametro
    public double getDiametro(){
        return this.raggio*2;
    }

    /// metodo per calcolare l'area del cerchio;
    public double calcolaArea(){
        return PI_GRECO*raggio*raggio;
    }



}
