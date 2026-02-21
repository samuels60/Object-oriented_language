package esercizi4.biblioteca;

import java.util.Scanner;

public class Menu {
    public static void start(){
        Scanner s = new Scanner(System.in);
        CatalogoLibri catalogoLibri = new CatalogoLibri();
        System.out.println("Ciao, benvenuto nel servizio biblioteca!");
        int choice = 5;
        do {
            System.out.println("Come vuoi procedere?" +
                    "\n1: Inserisci un libro" +
                    "\n2: Stampare un catalogo" +
                    "\n3: Ricercare i libri di un autore" +
                    "\n4: Uscire!");
            choice = s.nextInt();
            switch (choice)
            {
                case 1 :
                        Libro libro = new Libro(s);
                        catalogoLibri.inserisciLibro(libro);
                    break;
                case 2:
                        catalogoLibri.stampaCatalogo();
                    break;
                case 3:
                        s.nextLine();
                        System.out.println("Inserisci il cognome dell'autore da cercare:");
                        catalogoLibri.ricercaPerAutore(s.nextLine());
                    break;
                case 4:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("ERRORE: non hai selezionato nessuna tra le scelte disponibili");
                    break;
            }
        }while(choice != 4);
    }
}
