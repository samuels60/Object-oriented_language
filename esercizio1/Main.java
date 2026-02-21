package esercizio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Qual'è la capienza massima del serbatoio?(in litri)");
        Serbatoio s = new Serbatoio (input.nextInt());
        s.rifornisci(20);
        s.consuma(20);

        System.out.println("Il serbatoio è a " + s.getLivello());
    }
}