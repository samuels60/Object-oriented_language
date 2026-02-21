package esercizio7.biblioteca4;

import java.util.Arrays;
import java.util.Comparator;

public class OrdinatoreDocumenti implements Comparator<Documento> {
    @Override
    public int compare (Documento d1, Documento d2){
        if(d1 instanceof Libro lib1) {
            if (d2 instanceof Libro lib2)
                if (Arrays.equals(lib1.getAutori(),lib2.getAutori())){
                    if (lib1.getTitolo().equals(lib2.getTitolo())){
                        return lib1.getCasaEditrice().compareTo(lib2.getCasaEditrice());
                    }
                    else return lib1.getTitolo().compareTo(lib2.getTitolo());
                }
                else{
                    return Arrays.equals(lib1.getAutori(),lib2.getAutori()) ? 1 : -1;
                }
            else{ return -1;}
        }
        else if (d1 instanceof Dizionario diz1){
            if (d2 instanceof Dizionario diz2)
                if (Arrays.equals(diz1.getAutori(),diz2.getAutori())){
                    if (diz1.getLingua().equals(diz2.getLingua())){
                        return diz1.getCasaEditrice().compareTo(diz2.getCasaEditrice());
                    }
                    else{
                        return diz1.getLingua().equals(diz2.getLingua()) ? 0 : 1;
                    }
                }
                else {
                    return Arrays.equals(diz1.getAutori(),diz2.getAutori()) ? 0 : 1;
                }
            else {
                return -1;
            }
        }
        else {return Integer.MAX_VALUE;}
    }

}
