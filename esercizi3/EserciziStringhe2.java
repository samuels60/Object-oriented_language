package esercizi3;

import java.util.Scanner;


public class EserciziStringhe2 {

    public int sumOfDigit(int intero){
        StringBuilder interoStringa = new StringBuilder();
        interoStringa.append(intero);
        int sum = 0;
        for(int i = 0; i < interoStringa.length();i++)
            sum += (int)interoStringa.charAt(i);
        return sum;
    }

    public boolean isAnagram(String s){
        int l = s.length();
        int i = 0;
        boolean test  = true;
        while (l - i > i) {
            if ( s.charAt(i) != s.charAt(l-1-i) ) test = false;
            i++;
        }
        return test;
    }

    public String eliminaVocali (String s) {
        String ritorno = s.replaceAll("[aeiouAEIOU]","");
        return ritorno;
    }

    public String unario ( int x ) {
        StringBuilder returnamentState = null;
        if(x >= 0){
            returnamentState = new StringBuilder("0");
            while (x > 0) {
                returnamentState.append("0");
                x--;
            }
        }
        return returnamentState.toString();
    }

    public String textCapitalize(String text){

        StringBuilder result = new StringBuilder();
        String vector[]= text.strip().split("[ ']+");
        for(String elementi:vector){
            String init = elementi.toUpperCase();
            result.append(init.charAt(0)).append(elementi.substring(1)).append(" ");
        }
        return result.toString().trim();
    }

    public String casuale (int a, int n){

        StringBuilder testo = new StringBuilder();

        for (int i = 0; i < n; i++) {
            testo.append(Math.random()*a);
        }
        return testo.toString();

    }
}