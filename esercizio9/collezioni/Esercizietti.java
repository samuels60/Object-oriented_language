package esercizio9.collezioni;

import java.util.*;
 class Punto{
    private final int x;
    private final int y;
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.y + ")";
    }
}

public class Esercizietti {
    static boolean consecutivi1(Set<Integer> interi) {

        for (int i = -10; i <= 10; i++)
            if (interi.contains(i) && interi.contains(i + 1)) return true;

        return false;
    }

    static boolean consecutivi2For(Set<Integer> interi) {
        for (int i : interi)
            if (interi.contains(i+1)) return true;
        return false;

    }
    static boolean consecutivi2Iter(Set<Integer> interi) {
        Iterator<Integer> integerIterator = interi.iterator();
        while (integerIterator.hasNext()) if(interi.contains(integerIterator.next() + 1)) return true;
        return false;
    }

    static void eliminaPari(Set<Integer> interi){
        for(int i : interi)
            if(i % 2 == 0)
                interi.remove(i);
    }

    static void stampaPrimoQuadrato(Set <Punto> ciccio ){
        for(Punto p : ciccio){
            if(p.getX() > 0 && p.getY() > 0) System.out.println(p);
        }
    }
    public static SortedSet<Persona> ordinaSet (Set<Persona> set, Comparator<Persona> personaComparator) {
        SortedSet<Persona> sortedSet = new TreeSet<Persona>(personaComparator);
        sortedSet.addAll(set);
        return sortedSet;
    }
    /// restituisce solo treeSet con parametro in ingresso hashset, molto rigido
    public TreeSet<Persona> pulisciOrdina(HashSet <Persona> ciccini, Comparator<Persona> personaComparator) {
        TreeSet<Persona> treeSet = new TreeSet<>(personaComparator);
        treeSet.addAll(ciccini);
        return treeSet;
    }
    /// orientato ai generics accetta qualsiasi sda in input
    ///
    /// fatto da me
    public <T> SortedSet<T> pulisciOrdina(Set<T> set , Comparator <T> setComparator){
        SortedSet <T> sortedSet = new TreeSet<>(setComparator);
        sortedSet.addAll(set);
        return sortedSet;
    }

    public Collection<Integer> selezionaPari(Collection<Integer> ingresso){
        Iterator<Integer> giggimo = ingresso.iterator();
        while(giggimo.hasNext()) giggimo.remove();
        return ingresso;
    }

    public Collection<?> eliminaDuplicati(Collection<?> input){
        Set<?> newInput = new HashSet<>(input) ;
        return newInput;
    }
    public static void main(String[] args) {

    }
    public Map<Integer,Integer> migliagio(){
        Map<Integer,Integer> maometto =  new HashMap<>();
//        for(int i = 0;i < 10;i++){
//            maometto.put(i,0);
//        }

        for (int i = 0; i < 1000;i++){
            int addingNumber = (int) (Math.random() * 10);
            int count = maometto.getOrDefault(addingNumber,0);
            maometto.put(addingNumber,count + 1 );
        }
        return maometto;
    }
    public <T> Map<Integer,T> mappaLista(List<T> input){
        Map<Integer,T> mappatura = new HashMap<>();
        for(T elemento: input){
            mappatura.put(elemento.hashCode(),elemento);
        }
        return mappatura;
    }
    public String chiaveMassima(Map<Integer,String> mappa){
        if (mappa == null || mappa.isEmpty()) {
            return "vuota"; // o quello che richiede l’esercizio
        }

        SortedMap<Integer,String> sorted = new TreeMap<>(mappa);
        Integer maxKey = sorted.lastKey();          // chiave più grande
        return mappa.get(maxKey);                   // valore associato alla chiave massima
    }

}
