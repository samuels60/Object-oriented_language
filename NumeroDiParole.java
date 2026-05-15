package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NumeroDiParole {



    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder giggina  =new StringBuilder();
        try ( BufferedReader in = new BufferedReader
                ( new FileReader("file.txt"))){
            char aus;
            Map<String,Integer> ino = new HashMap<> ();
            int i;
            while((i = in.read()) != -1){
                aus = (char) i;
                if ( aus== '\'' || aus == ' ') {
                    String world = giggina.toString();
                    ino.put(world,ino.getOrDefault(world,0)+1);
                }
                giggina.append(aus);
            }
            /// purtroppo la classe hashMap non mi permette di ordinare
            Set<Map.Entry<String, Integer>> next = ino.entrySet();
            List<Map.Entry<String,Integer>> finisher = new ArrayList<>(next);
            Collections.sort(finisher, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> s1, Map.Entry<String, Integer> s2) {
                    return s1.getValue().compareTo(s2.getValue());
                }
            });
        } catch (IOException e) {
            System.out.println("è successo danno!");
        }
    }
}