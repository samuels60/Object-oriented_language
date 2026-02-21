package esercizio7.biblioteca4;

import javax.management.InstanceNotFoundException;
import java.io.*;
import java.util.*;


public class Menu {
    public static void start() throws Exception {
        int scelta = 1;
        String chiave;
        Scanner in = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        BufferedReader input;
        System.out.println("\n***** Catalogo Libri *****");

        try (ObjectInputStream inStream = new ObjectInputStream(
                new FileInputStream("/home/samuel-falzone/Scrivania/Linguaggi/esempio1/src/esercizio7/biblioteca4/bibliotecachissima.dat"))) {
            Object obj =inStream.readObject();
            catalogo = new Catalogo((ArrayList<Documento>) obj) ;

        } catch (EOFException e) {
            System.out.println("Fine del file");
        } catch (FileNotFoundException e){
            System.out.println("Il file non e' presente e verra creato quando salverai i dati!");
            catalogo= new Catalogo();
        }

        while (scelta != 0) {
            System.out.println("\n************** Menu ");
            System.out.println("\tDigita 1 per stampare il catalogo");
            System.out.println("\tDigita 2 per aggiungere un documento");
            System.out.println("\tDigita 3 per la ricerca per autore");
            System.out.println("\tDigita 4 per la ricerca per lingua");
            System.out.println("\tDigita 5 per la ricerca per titolo");
            System.out.println("\tDigita 6 per la ricerca per casa editrice");
            System.out.println("\tDigita 7 per la ricerca per il prezzo");
            System.out.println("\teefetuare un prestito");
            System.out.println("\teefetuare un restituzione");
            System.out.println("\t salva su file");
            System.out.println("\tDigita 0 per uscire");


            scelta = in.nextInt();
            in.nextLine();
            switch (scelta) {
                case 1:
                    System.out.println(catalogo.getCatalogo());
                    break;
                case 2:
                    System.out.println("Che tipo di documento vuoi inserire?\n1:Libro\n2:Dizionario\n3:Quotidiano");
                    while (!in.hasNextInt()) {
                        System.out.println("Non hai digitato un numero! Riprova.");
                        in.nextLine(); // per svuotare il buffer dello scanner
                    }
                    scelta = in.nextInt();
                    switch (scelta) {
                        case 1:
                            Libro libro = new Libro(in);
                            catalogo.getCatalogo().add(libro);
                            break;
                        case 2:
                            Dizionario dizionario = new Dizionario(in);
                            catalogo.getCatalogo().add(dizionario);
                            break;
                        case 3:
                            Quotidiano quotidiano = new Quotidiano(in);
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
                case 8:
                    SaveSystem instance = new SaveSystem();
                    instance.formattazione();
                    instance.salvaFile(catalogo.getCatalogo());
                    /// scrittura su file di testo
                    /**File file = new File("/home/samuel-falzone/Scrivania/Linguaggi/esempio1/src/esercizio7/biblioteca4/biblioteca.txt");
                    FileWriter scrivi = new FileWriter(file, true);
                    for (Documento c : catalogo.getCatalogo()) {
                        if (c instanceof Libro l) {
                            scrivi.write("\nLibro:\n" +
                                    l.getTitolo() + "\n" +
                                    l.getLingua() + "\n" +
                                    Arrays.toString(l.getAutori()) + "\n" +
                                    l.getCasaEditrice() + "\n" +
                                    l.getPrezzo());
                        }
                        if (c instanceof Dizionario l) {
                            scrivi.write("\nDizionario:\n" +
                                    l.getTitolo() + "\n" +
                                    Arrays.toString(l.getLingua()) + "\n" +
                                    Arrays.toString(l.getAutori()) + "\n" +
                                    l.getCasaEditrice() + "\n" +
                                    l.getPrezzo());
                        }
                        if (c instanceof Quotidiano l) {
                            scrivi.write("\nQuotidiano:\n" +
                                    l.getTitolo() + "\n" +
                                    l.getLingua() + "\n" +
                                    Arrays.toString(l.getAutori()) + "\n" +
                                    l.getCasaEditrice() + "\n" +
                                    l.getPrezzo());
                        }
                    }
                    scrivi.close();*/
                    /// scrittura su file bat
                    try (ObjectOutput out =
                                 new ObjectOutputStream
                                         (new FileOutputStream("/home/samuel-falzone/Scrivania/Linguaggi/esempio1/src/esercizio7/biblioteca4/bibliotecachissima.dat",true))) {
                        out.writeObject(catalogo.getCatalogo());

                    } catch (EOFException e) {
                        System.out.println("Fine del file");
                    }

                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida! Riprova.");
                    break;
            }
        }

        }

    }


