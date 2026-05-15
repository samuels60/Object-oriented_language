package conubiodiclassi2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class EsperimentiMappe {
    public static <K,V> Map<V, List<K>>valoriConChiaviUguali(Map<K,V> mappaIniziale){
        return mappaIniziale.entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toList())));
    }

    public static <T, SORCE extends Collection<T>, DEST extends Collection<T> > DEST copiaLista (SORCE inizio,Supplier<DEST> collectionFactory){

        DEST fine = collectionFactory.get();
        for(T t : inizio ){
            fine.add(t);
        }
        return fine;
    }
    /**
    public static Map<String,Double> mediaSaldi(List<ContoBancario> l){
        return l.stream()
                .collect(Collectors.groupingBy(
                        ContoBancario::getNomeTitolare))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(ContoBancario::getSaldo)
                                .average()
                                .orElse(0.)
                ));
    }
    */
    static Map<String, Long> worldFrequence(String percorso) throws FileNotFoundException {
        return new Scanner(new File(percorso))
                .tokens()
                .collect(Collectors.groupingBy(w->w,
                        Collectors.counting()));

    }
    public static Map<String, Long> worldFrequenceSorted(String percorso)
            throws FileNotFoundException {

        return new Scanner(new File(percorso))
                .tokens()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(w -> w,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new
                ));
    }

    public static Map<String, Long> wordFrequenciesPathLinesSorted(String nomeFile) {
        try (Stream<String> lines = Files.lines(Path.of(nomeFile))) {
            return lines
                    .map(String::toLowerCase)
                    .flatMap(s -> Arrays.stream(s.split("\\P{L}+")))
                    .filter(w -> !w.isEmpty())
                    .collect(Collectors.groupingBy(
                            w -> w,
                            Collectors.counting()
                    ))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue()) // o .reversed() per decrescente
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));
        } catch (IOException e) {
            // meglio rilanciare o loggare l'errore, invece di restituire null
            System.out.println("noooooooooooooooooooooooooooooo");
            throw new UncheckedIOException(e);
        }
    }
    public static SortedSet<Character> charsInWords(List<String> words){
        return String.join("", words)
                .chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toCollection(TreeSet::new));
    }
    static Map<Character, SortedSet<Integer>> mappaLettereRiga(String nomePercors) throws IOException{
        Map<Character,SortedSet<Integer>> mappa = null;
        try (BufferedReader bf = new BufferedReader(new FileReader(new File(nomePercors)))){
            String riga = null;
            while((riga = bf.readLine()) != null){
                int i = 1;

                for(Character c : riga.toCharArray()){
                    if((mappa.get(c).isEmpty())) {
                        SortedSet<Integer> lista = new TreeSet<>();
                        lista.add(i);
                        mappa.put(c,lista);
                    }else{
                        mappa.get(c).add(i);
                    }
                }
            }
            return mappa;
        }
    }
}