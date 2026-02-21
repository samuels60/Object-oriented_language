package esercizi3;

public class EserciziStringhe1 {

    public String getIniziali (String nome, String cognome) {
        String s = nome.charAt(0) + "&" + cognome.charAt(0);
        return s.toUpperCase();
    }
    public String stringRevers (String s) {
        String rev = "";
        for(int i = s.length() - 1; 0 <= i; i-- ){
            rev += s.charAt(i);
        }
        return rev;
    }
    public int contaOccorrenze (String string, String pattern) {
        int lp = pattern.length();
        int lt = string.length();
        int counter = 0;
        for (int i = 0 ; i < lt-lp ; i++){
            if ( string.substring(i, i + lp).equals(pattern)) counter++;
        }
        return counter;
    }

}
