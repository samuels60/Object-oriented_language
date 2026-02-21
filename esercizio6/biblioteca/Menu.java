package esercizio6.biblioteca;

import java.util.Scanner;

public class Menu {
    public static void start() {
        int scelta = 1;
        String chiave;
        Scanner in = new Scanner (System.in);
        Catalogo catalogo = new Catalogo();

        System.out.println ( "\n***** Catalogo Libri *****" );

        while (scelta != 0){
            System.out.println ( "\n************** Menu " );
            System.out.println ( "\tDigita 1 per stampare il catalogo" );
            System.out.println ( "\tDigita 2 per aggiungere un documento" );
            System.out.println ( "\tDigita 3 per la ricerca per autore" );
            System.out.println ( "\tDigita 4 per la ricerca per lingua");
            System.out.println ( "\tDigita 5 per la ricerca per titolo");
            System.out.println ( "\tDigita 6 per la ricerca per casa editrice");
            System.out.println ( "\tDigita 7 per la ricerca per il prezzo");
            System.out.println ( "\tDigita 0 per uscire" );

            while (! in.hasNextInt()) {
                System.out.println( "Non hai digitato un numero! Riprova." );
                in.nextLine(); // per svuotare il buffer dello scanner
            }
            
            scelta = in.nextInt();
            in.nextLine();
            switch (scelta) {
                case 1:
                    System.out.println(catalogo.getCatalogo());
                    break;
                case 2:
                    System.out.println("Che tipo di documento vuoi inserire?\n1:Libro\n2:Dizionario\n3:Quotidiano");
                    while (! in.hasNextInt()) {
                        System.out.println( "Non hai digitato un numero! Riprova." );
                        in.nextLine(); // per svuotare il buffer dello scanner
                    }
                    scelta = in.nextInt();
                    switch (scelta){
                        case 1:
                            Libro libro = new Libro(in);
                            catalogo.getCatalogo().add(libro);
                            break;
                        case 2 :
                            Dizionario dizionario = new Dizionario(in);
                            catalogo.getCatalogo().add(dizionario);
                            break;
                        case 3 :
                            Quotidiano  quotidiano = new Quotidiano(in);
                            catalogo.getCatalogo().add(quotidiano);
                            break;
                        default:
                            System.out.println("non hai selezionato nessuna tra le scelte disponibili");
                    }
                    break;
                case 3:
                    System.out.println("\tDigita il cognome dell'autore:");
                    chiave = in.nextLine().strip();
                    System.out.println("\tHo trovato i seguenti libri di " + chiave + ":");
                    catalogo.ricercaPerAutore(chiave);
                    break;
                case 4:
                    System.out.println("\tDigita la lingua:");
                    chiave = in.nextLine().strip();
                    System.out.println("\tHo trovato i seguenti libri di in lingua  " + chiave + ":");
                    catalogo.ricercaPerLingua(chiave);
                    break;
                case 5:
                    System.out.println("\tDigita il titolo dell'opera:");
                    chiave = in.nextLine().strip();
                    System.out.println("\tHo trovato i seguenti libri intitolati " + chiave + ":");
                    catalogo.ricercaPerTitolo(chiave);
                    break;
                case 6:
                    System.out.println("\tDigita la casa editrice:");
                    chiave = in.nextLine().strip();
                    System.out.println("\tHo trovato i seguenti prodotti da  " + chiave + ":");
                    catalogo.ricercaPerCasaEditrice(chiave);
                    break;
                case 7:
                    System.out.println("\tDigita il prezzo");
                    double prezzo = in.nextDouble();
                    System.out.println("\tHo trovato i seguenti prodotti da  " + prezzo + ":");
                    catalogo.ricercaPrezzo(prezzo);
                    break;
                case 0 :
                    System.out.println("Arrivederci!");
                    break;
                default : System.out.println("Scelta non valida! Riprova.");
                break;
            }
        }
    }
}

