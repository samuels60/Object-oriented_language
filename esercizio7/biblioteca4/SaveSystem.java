package esercizio7.biblioteca4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class SaveSystem {
    public void formattazione() throws IOException {
        PrintWriter out =
                new PrintWriter
                        (new FileWriter("/home/samuel-falzone/Scrivania/Linguaggi/esempio1/src/esercizio7/biblioteca4/tipo.txt"));
        out.printf("  tipo      |       Titolo          |   Casa editrice    |          lingua           |      Prezzo      |          Autori         |\n") ;
        out.close();
    }






    public void salvaFile(ArrayList<Documento> lista)throws IOException {

        PrintWriter out =
            new PrintWriter
                 (new FileWriter("/home/samuel-falzone/Scrivania/Linguaggi/esempio1/src/esercizio7/biblioteca4/tipo.txt",true));

        for(Documento d: lista){
            if(d instanceof Libro lib) {

                out.printf("Libro  %20s%20s%20s\t\t%2.2f\t\t%20s\n",lib.getTitolo(),lib.getCasaEditrice(),lib.getLingua(),lib.getPrezzo(), Arrays.toString(lib.getAutori()));
            }
        }
        out.close();
    }
}