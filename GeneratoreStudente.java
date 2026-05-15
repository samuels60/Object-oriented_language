package conubiodiclassi2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneratoreStudente {
    public static void popolaFile(File nomeFile) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFile))) {
            for (int i = 1; i <= 1000; i++) {

                String nome = "Studente" + i;
                String cognome = "Cognome" + i;

                String corso;

                switch (i % 4) {
                    case 0 -> corso = "Informatica";
                    case 1 -> corso = "Matematica";
                    case 2 -> corso = "Fisica";
                    default-> corso = "Chimica";
                }

                int voto = 18 + (i % 13); // 18–30

                String riga = nome + ";" + cognome + ";" + corso + ";" + voto;
                bw.write(riga);
                bw.newLine();

            }
            System.out.println("File creato: " + nomeFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
