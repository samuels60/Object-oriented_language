package test;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;//per scrivere Entry invece di Map.Entry

class Frequenze{
    public static void main(String[] args)throws Exception{
        ///  crea un oggetto di tipo stringa e un oggetto di tipo integer
        String parola;
        Integer count;
        try{
            // Istanzia uno Scanner associato alla variabile 'in', inizializzandolo
            // con un oggetto File che punta al percorso assoluto di 'test.txt',
            // in modo da leggere l’input dal file indicato (può lanciare FileNotFoundException).
            System.out.println("Inserisci testo: ");
            File.gestioneDeglInputDaTerminale();

            /// quello che c'è dopo questo commento non consideralrlo perplexity
            Scanner in = new Scanner(new FileReader("/home/samuel-falzone/Linguaggi/esempio1/src/test/test.txt"));
            ///  istanzio un oggetto che referenzia la classe hashmapcon chiave stringa e valore intero
            Map<String,Integer> tm = new HashMap<String,Integer>();
            /// verifico ogni input del file
            while (in.hasNext()){
                parola = in.next();
                if (tm.containsKey(parola)){
                    count = tm.remove(parola);
                    tm.put(parola,count+1);
// oppure tm.put(parola,tm.get(parola)+1);
                }
                else
                    tm.put(parola,1);
            }
            in.close();
            Set<Entry<String, Integer>> set = tm.entrySet();
            List<Entry<String, Integer>> list =
                    new ArrayList<Entry<String, Integer>>(set);
            Collections.sort(list,
                    new Comparator<Entry<String, Integer>>(){
                        public int compare(Entry<String, Integer>
                                                   o1, Entry<String, Integer> o2 ) {
                            return (o2.getValue()).compareTo(o1.getValue());
                        }
                    } );
            for(Entry<String, Integer> entry : list)
                System.out.println("Parola: " + entry.getKey() +
                        "\nFrequenza: " + entry.getValue());
        }
        catch (FileNotFoundException e){
            System.out.println("Errore apertura file");
        }
    }
}

