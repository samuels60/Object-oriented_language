package conubiodiclassi2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EsperimentiListe {


    /// Scrivi un metodo che, dato un array int[] voti, lo copia in List<Integer>, elimina i duplicati mantenendo l’ordine e restituisce la nuova lista.
  public static List<Integer> arrayInteriInLista (int[] array){
      return Arrays.stream(array)
              .distinct()
              .mapToObj(s->(Integer) s)
              .collect(Collectors.toCollection(ArrayList::new));
  }
    /// Scrivi un metodo che, dato List<Studente>, restituisce una Map<String, List<Studente>> dove
    ///la chiave è "basso", "medio", "alto" a seconda del range di voto (es. 18–22, 23–27, 28–30).

    public static Map<Range, List<Studente>> mappaturaStudentiXVoto (List<Studente> lista){
        return lista.stream()
                .collect(Collectors.groupingBy(s->Range.fromVoto(s.getVoto())));
    }

    public static void stampaPersona(){
        System.out.println("Inserisci le informazioni della persona: NOME COGNOME ETA");
        try (Stream<String> scanner = new Scanner(System.in).useDelimiter("[\\s]+").tokens()) {

            String persona = scanner.limit(3).collect(Collectors.joining(" "));

            Persona creata = Persona.creaCostruttore(persona);
            System.out.println(creata.toString());
        }
    }
   // Scrivi un metodo che legge N interi da tastiera e restituisce una List<Integer> con quei valori. Nel main stampa somma e media.
public static void stampaSommaMediaLetturaTastieraInteri(){
        ArrayList<Integer> lista = new Scanner(System.in)
                .useDelimiter("\\s+")
                .tokens()
                .limit(10)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    int somma = lista.stream()
            .mapToInt(Integer::intValue)
            .sum();
    OptionalDouble average = lista.stream()
            .mapToInt(Integer::intValue)
            .average();

}

//Scrivi un metodo che legge da tastiera una sequenza di numeri finché l’utente inserisce 0, poi restituisce solo quelli pari.
    public static void stampaPari(){
        System.out.println("Inserisci una sequenza di numeri, l'utlimo deve essere 0");
        try(Stream<String> sc = new Scanner(System.in).useDelimiter("\\s+").tokens()){
            sc.mapToInt(Integer::parseInt)
                    .takeWhile(n->n!=0)
                    .filter(s->s%2==0 )
                    .forEach(System.out::println);

        }
    }
    //Scrivi un metodo che legge da tastiera una sequenza di numeri finché l’utente inserisce 0, li salva in una lista e poi restituisce solo quelli pari.

    public static List<Integer> restituisciPari(){
        try(Stream<String> sc = new Scanner(System.in).useDelimiter("\\s+").tokens()){
            return sc
                    .mapToInt(Integer::parseInt)
                    .takeWhile(n->n!=0)
                    .filter(s->s%2==0)
                    .boxed()
                    .toList();

        }
    }
    ///    Scrivi un metodo che legge da tastiera nome, cognome e voto di più studenti (finché l’utente digita “fine”), li salva in una List<Studente> e restituisce la lista.
    public static List<Studente> mappaStudenteDaTastiera() {
        List<Studente> list = null;
        System.out.println("Inserisci nel seguente schema le informazioni degli studenti: nome cognome corso voto. \n Digita \"fine\" per conscludere il programma");
        try (Stream<String> persone = new Scanner(System.in).useDelimiter("\\s+").tokens()) {
            List<String> elementi = new ArrayList < String > (persone.takeWhile(s -> s != "fine")
                    .map(String::toString)
                    .collect(Collectors.toList()));
            ListIterator<String> iterator = elementi.listIterator();

            StringBuilder l1 = new StringBuilder();
            while((iterator.hasNext())){
                String l = iterator.next() ;
                if(l  == "fine") break;
                l1.append(l);
            }
            while(!l1.isEmpty()){
                Studente.creaCostruttore(l1.substring(0,4));
                l1.delete(0,4);
            }
        }
        return list;
    }
}
