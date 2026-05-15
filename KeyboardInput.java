package conubiodiclassi2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {

    public static void leggiStampaDaLibro(){
        System.out.println("Digita qualcosa e premi invio....\n" +
                "Per terminare il programma digita \"fine\"");
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){

            String stringa = in.readLine();
            while(!(stringa == null)) {
                if(stringa.equals("fine")){
                    System.out.println("Programma terminato!");
                    break;
                }
                System.out.println("Hai scritto : " + stringa);
                stringa = in.readLine();
            }

        }catch(IOException e){
            System.out.println("affucati");
        }
    }

    public static void leggiStampaMio(){

    }
}
