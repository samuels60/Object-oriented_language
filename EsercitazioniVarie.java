package stream;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Map.Entry;


class ContoBancario {

    private double saldo;
    private static String nomeProprietario;
    private final int numeroConto;
    private static int counter;

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
    public String getNome(){
        return nomeProprietario;
    }

    public double getSaldo() {
        return saldo;
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

public class EsercitazioniVarie {
    public static long contaNumeri2(File file)throws IOException {

        return new Scanner(file)
                .useDelimiter("[ \n;,':?!\"\\-.()\\[\\]{}<>/$#&%~`”“’]+")
                .tokens()
                .filter(s-> s.equals("2"))
                .count();
    }

    public static Map<String, Double> mappaSaldi(List<ContoBancario> l){
        return l.stream()
                .collect(
                        Collectors.toMap(
                                ContoBancario::getNome,
                                ContoBancario::getSaldo,
                                Double::sum
                        )
                );
    }
    public static Map<Character, Set<String>> mapFilt(Set<String> worlds) {
        return worlds.stream()
                .collect(Collectors.groupingBy(
                        w->w.charAt(0),
                        Collectors.filtering(
                                w->w.length() > 15,
                                Collectors.toSet()
                        )
                )
        );
    }
    public static long contaLettere(File f) throws IOException{
        return (new Scanner(f)
                .useDelimiter("[\n;.,':?!\\-()\\[\\]{}<>/]+")
                .tokens()
                .count());
    }
    public static Map<Character, Set<String>> mapping(Set<String> worlds) {
        return worlds.stream()
                .collect(Collectors.groupingBy(
                                w->w.charAt(0),
                                Collectors.mapping(
                                        String::toUpperCase,
                                        Collectors.toSet()
                                )
                        )
                );

    }
   public List<Integer> mappaValori(Map<String, Integer> mappa){
        return mappa.values()
                .stream()
                .sorted()
                .collect(Collectors.toList());
   }
   //ricevo una lista di stringhe e fare una mapppa (lettera iniziale , lista di occorrenze stringa)
    public Map<Character,List<String>> mappaLettere(List<String> listino){
        return listino
                .stream()
                .collect(Collectors.groupingBy(
                        s->s.charAt(0),
                        TreeMap::new,
                        Collectors.toList()));
    }

    /// ricevendo una lista di valori se pari dare true
    public Map<Boolean,List<Integer>> mappanumeri(List<Integer> listino){
        return listino
                .stream()
                .collect(Collectors.partitioningBy(s-> s % 2 == 0));
    }
    /// kiave con valore massimo
    public <K,V extends Comparable<V>> K mappaValore(Map<K,V> mappa){
        return (mappa)
                .entrySet()
                .stream()
                .max(Entry.comparingByValue())
                .map(Entry::getKey).orElse(null);

    }
    ///
    ///prende una lista di valori e torna una mappa dei multipli
    public Map<Integer, List<Integer>> mappaMultipli(List<Integer> input) {
        return input.stream()
                .collect(Collectors.toMap(
                        e -> e,
                        e -> IntStream.rangeClosed(1, 10)   // 1..10
                                .map(i -> i * e)    // multipli di e
                                .boxed()            // IntStream -> Stream<Integer>
                                .toList()           // List<Integer> (Java 16+)
                ));
    }
    /// mvalore medio di una mappa

    /// moda dei valori
  public <K,V extends Comparable<V>> Optional<Map.Entry<V, Long>> moda(Map<K,V> input){
      return input
              .entrySet()
              .stream()
              .collect(Collectors
                      .groupingBy(
                              e->e.getValue(),
                              Collectors.counting()))
              .entrySet()
              .stream()
              .max(Map.Entry.comparingByValue());
  }
    public static Map<Integer,Long> substringComplexity(String s){
        return IntStream.rangeClosed(0, s.length())
                .mapToObj(s::substring)
                .flatMap(suffix -> IntStream.rangeClosed(0, suffix.length())
                        .mapToObj(i -> suffix.substring(0,i)))
                .distinct()
                //.sorted(Comparator.comparing(String::length)
                //.thenComparing(String::compareTo))
                //.peek(System.out::println)
                .collect(Collectors
                .groupingBy(String::length, Collectors.counting()));
    }

    public static void main(String[] args) throws Exception {
       // {
            /*System.out.println(EsercitazioniVarie.contaNumeri2(new File("/home/samuel-falzone/Linguaggi/esempio1/src/stream/test.txt")));
            System.out.println(Stream.of(1, "f", 3, 4, 5)
                    .map(String::valueOf)
                    .collect(Collectors.joining()));
            System.out.println(Stream.of(1, "f", 3, 4, 5)
                    .map(String::valueOf)
                    .collect(Collectors.joining(" - ")));
            System.out.println(Stream.of(1, "f", 3, 4, 5)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "Numbers: ", ".")));
        }
        Set<String> strings = Set.of("ciao", "hello", "ok");
        Map<Boolean, Long> numberLengthMap = strings.stream()
                .collect(Collectors.partitioningBy(
                        s -> s.length() % 2 == 0,
                        Collectors.counting()));
        System.out.println(numberLengthMap);
        {
            long start1 = System.nanoTime();
            String s1 = Stream
                    .iterate(1, i -> i + 1)
                    .limit(100000)
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            long start2 = System.nanoTime();
            String s2 = Stream
                    .iterate(1, i -> i + 1)
                    .limit(100000)
                    .map(String::valueOf)
                    .reduce("", String::concat);
            long fine = System.nanoTime();
            System.out.println((start2 - start1) + " " + (fine - start2));
        }
        Map<Character, Set<String>> map = Stream.of(
                        "pippo e pluto", "pluto e topolino", "topolino e paperino")
                .collect(Collectors.groupingBy(
                        w -> w.charAt(0),
                        Collectors.flatMapping(
                                w -> Arrays.stream(w.split(" +")),
                                Collectors.toSet()
                        ))
                );


        System.out.println(map);
        Object[] multiplidi7 = Stream
                .iterate(1, i -> i+1)
                .limit(100)
                .filter(n -> n%7==0)
                .toArray();


        System.out.println(Arrays.toString(multiplidi7));
            String[] myArray = {"Ciao", "a", "tutti"};
            String result = Arrays.stream(myArray)
                    .reduce("", (a,b) -> a + " " + b);

             */
        String s = "banana bandana";
        Map<Integer, Long> result = substringComplexity(s);
        System.out.println(result);

        /// mappa di (stringhe , interi) a pratametro e restituisce una listra degli interi

    }}

