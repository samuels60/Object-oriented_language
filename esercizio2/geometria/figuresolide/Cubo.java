///Questa classe vi permette di:
///   -  Creare un cubo
///
///     @autor         Samuel Falzone
///     @version       0.1
package esercizio2.geometria.figuresolide;

public class Cubo {
   private double spigoli;
   /// costruttore della classe
   /// @param spigoli lunghezza spigolosa che compone il cubo, ogni faccia ne ha 4
   public Cubo ( double spigoli ) {
       this.spigoli=spigoli;
       System.out.println("Ho creato un cubo");
   }
   /// metodo per ottenere l'area del cubo
    public double calcolaArea(){
        return this.spigoli * this.spigoli * this.spigoli;
    }
}
