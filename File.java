package test;

import java.io.*;
public class File {
    static public void gestioneDeglInputDaTerminale() throws Exception{
        try(
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter("/home/samuel-falzone/Linguaggi/esempio1/src/test/testo.txt",true)))
                ){

            writer.println(reader.readLine());

        }catch (FileNotFoundException e){
            System.out.println("file non trovato");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
