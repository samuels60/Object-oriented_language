package esercizio7.file;

import java.io.*;
import java.util.Scanner;

public class Metodi {
    public static void stampaScannerLine(File file) throws Exception {
        Scanner in = null;
        try {
            in = new Scanner(file);
            String s;
            while (in.hasNextLine()) {
                s = in.nextLine();
                System.out.println(s);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Il file non e' stato trovato!");
        }
        in.close();
    }

    public static void stampaScannerChar(File file) throws Exception {
        Scanner in = null;

        try {
            in = new Scanner(file);
            String s;
///            while (in.hasNextLine()) {
            while (in.hasNext()) {
                s = in.next();
                for (char c : s.toCharArray()) {
                    System.out.print(c);
                    if (c == '.') {
                        System.out.println("");
                    }
                }
            }

            ///in.hasNextLine();
            ///         }
        } catch (FileNotFoundException e) {
            System.out.println("errore");
        }
    }

    public static void stampaBufferLine(File file) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String s;
        while ((s = in.readLine()) != null) {

            System.out.println("" + s);
        }
        in.close();
    }

    public static void stampaBufferLineCopia(File file) throws Exception {
        BufferedReader in =
                new BufferedReader(new FileReader(file));

        PrintWriter out =
                new PrintWriter(new FileWriter("/home/samuel-falzone/Scrivania/Linguaggi/esempio1/src/esercizio7/out.txt "));
        String s;
        while ((s = in.readLine()) != null) {

            System.out.println("" + s);
            out.printf("\t%-30s\n", s);
        }
        in.close();
        out.close();
    }

    public static void stampaBurreChar(File file) throws Exception {
        BufferedReader in =
                new BufferedReader(new FileReader(file));

        int s;
        while ((s = in.read()) != -1) {
            System.out.print("" + s);
        }
    }


    public static void stampaBurreCharCopia(File file) throws Exception {
        BufferedReader in =
                new BufferedReader(new FileReader(file));
        PrintWriter out =
                new PrintWriter(new FileWriter("/home/samuel-falzone/Scrivania/Linguaggi/esempio1/src/esercizio7/out.txt", true));
        int s;
        System.out.println("\nquesto si aggiunge in succesione carattere per carattere");
        out.println("\nquesto si aggiunge in succesione carattere per carattere");
        while ((s = in.read()) != -1) {
            System.out.print("" + (char) s);
            out.printf("%c", s);
        }
    }

    public static void leggiSalva() throws Exception{
        InputStreamReader in =
                new InputStreamReader(System.in);
        BufferedReader buf =
                new BufferedReader(in);
        System.out.printf("Scrivi qualcosa ricchione");
        String s =
                new String(buf.readLine());

        PrintWriter out = new PrintWriter("/home/samuel-falzone/Scrivania/Linguaggi/esempio1/src/esercizio7/out.txt ");
        out.printf("*\t %-20s*\n", s);
        out.close();
    }


}

