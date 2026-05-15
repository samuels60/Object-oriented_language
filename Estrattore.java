package conubiodiclassi2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Estrattore {

    //Leggi da un String[] di righe "nome;cognome;corso;voto" e scrivi un metodo che restituisce List<Studente>.
    public static Studente istanziaturaStudenteleggiRiga(String riga) {
        String[] studente = riga.split(";");
        return new Studente(studente[0], studente[1], studente[2], Integer.parseInt(studente[3]));
    }

    // per ogni elemento di un file registra uno studente e restituisce una lista di quest'ultimi
    public static List<Studente> listaturaLeggiFile(String percorso) throws Exception {
        try (Stream<String> righe = Files.lines(Path.of(percorso)) ){
            return righe
                    .map(Estrattore::istanziaturaStudenteleggiRiga)
                    .collect(Collectors.toList());
        }
    }
    // ricerca lista di studenti con voto maggiore a quello chiesto
    public static List<Studente> listaturaRicercaStudentiVotoMagiore(List<Studente> studenti,int voto){
        return studenti.stream()
                .filter(studente -> studente.getVoto()>voto)
                .toList();
    }

    // ordinamento lista per voto
    public static List<Studente> listaturaStudentiOrdinamentoVoto(List<Studente> studentiList) {
        return studentiList.stream()
                .sorted(Comparator.comparingInt(Studente::getVoto))
                .toList();
    }

    /// raggruppa per materia (materia, studenti)
    public static Map<String, List<Studente>> mappaturaStudentiXMateria(List<Studente>  studentiList){
        return studentiList.stream()
                .collect(Collectors.groupingBy(Studente::getCorso));
    }
    ///  mappa (corso, media)
    public static Map<String,Double> mappaturaMediaMaterie ( List<Studente> studenteList) {
        return studenteList.stream()
                .collect(Collectors.groupingBy(
                        Studente::getCorso,
                        Collectors.averagingInt(Studente::getVoto)
                ));
    }
    ///  mappa (corso, studente voto massimo)

    public static Map<String, Optional<Studente>> mappaturaTopXMateria(List<Studente> studentiList) {
        return studentiList.stream()
                .collect(Collectors.groupingBy(
                        Studente::getCorso,
                        Collectors.maxBy(Comparator.comparingInt(Studente::getVoto))
                ));
    }
/// prendi una lista e ordina per voto e poi per nome
    public static List<Studente> listaturaOrdinaPerVotoNome( List<Studente> studenteList){
        return studenteList.stream()
                .sorted(Comparator
                        .comparingInt(Studente::getVoto)
                        .thenComparing(Comparator.comparing(Studente::getNome)))
                .toList();
    }

    //Scrivi un metodo che, data una List<Studente>, la ordina e restituisce una nuova lista ordinata per: voto decrescente, poi cognome, poi nome (usando Comparable o Comparator).
    public static List<Studente> listaturaOrdinaPerVotoDescCognomeNome (List<Studente> studenteList) {
        return studenteList.stream()
                .sorted(Comparator.comparingInt(Studente::getVoto)
                        .reversed()
                        .thenComparing(Studente::getCognome)
                        .thenComparing(Studente::getNome))
                .toList();
    }

    //Scrivi un metodo che, data una List<Studente>, restituisce una Map<String, Long> con cognome → numero di occorrenze (quanti studenti con lo stesso cognome).
    public static Map<String, Long> mappaturaContaOccorenzeCognome(List<Studente> studenteList){
        return studenteList.stream()
                .collect(Collectors.groupingBy(Studente::getCognome,
                        Collectors.counting()));
    }

    //Scrivi un metodo che, data una List<Studente>, costruisce una Map<String, List<String>> con corso → lista di nomi completi "Nome Cognome".
    public static Map<String, List<String>> mappaturaListaNomiCompletiPerCorso(List<Studente> studenteList) {
        return studenteList.stream()
                .collect(Collectors.groupingBy(Studente::getCorso,
                        Collectors.mapping(Studente::getNomeCompleto,
                                Collectors.toList())));
    }

    public static List<Studente> listaturaIntersezioneDiListeStudenti (List<Studente> lista1, List<Studente> lista2){
        List<Studente> nuovo = new ArrayList<Studente>();
        if(!lista1.isEmpty() && !lista2.isEmpty()){
            ListIterator<Studente> iterator = lista1.listIterator();
            while (iterator.hasNext()){
                Studente s = iterator.next();
                if(lista2.contains(s)){
                    nuovo.add(s);
                }
            }
        }
        return nuovo;
    }

    ///Dato un file di testo con parole (una per riga), scrivi un metodo che le legge in List<String> e poi restituisce una Map<String, Integer> con parola → frequenza.
 public static Map<String, Long >  mappaturaOccorenzeParoleInRiga(Path references) throws IOException {
     return Files.lines(references)
             .flatMap(s->Arrays.stream(s.split("\s")))
             .collect(Collectors.groupingBy(
                     s->s,
                     Collectors.counting()));
 }

 //A partire dalla mappa parola/frequenza
    // , scrivi un metodo che restituisce una List<Map.Entry<String,Integer>> ordinata per frequenza decrescente e, a parità, per parola alfabetica.

   public static List<Map.Entry<String,Long>> listaturaChiaveValoreOrdinaOccorrenzeDescrescente ( Map<String, Long> mappa) {
     return mappa.entrySet()
             .stream()
             .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
             .collect(Collectors.toList());
   }
}