package esercizi4;


import java.util.Arrays;

public class EserciziArray {
    public void StampaArray1(int[] array){
        System.out.println(Arrays.toString(array));
    }
    public void StampaArray2(int[] array){
        System.out.print("[ ");
        int l=array.length;
        if (l > 0) {
            System.out.print(array[0]);
            for(int i=1;i < l;i++){
                System.out.print(","+array[i]);
            }
        }
        System.out.println(" ]");
    }

    public double mediaValori(int...numeri){
        int counter = 0;
        int sum = 0;
        for ( int elemento:numeri )   {
            sum += elemento;
            counter++;
        }
        return (double) sum/counter;
    }

    public int[] eliminaDuplicati (int[] interi) {

        int[] senzaDuplicati1 = new int[interi.length];
        int counter = 0;

        for ( int elemento: interi ) {
            boolean nonDuplice = true;

            for( int i = 0; i <= counter; i++ ) {

                if(elemento == senzaDuplicati1[i])    nonDuplice = false;
            }
            if(nonDuplice) senzaDuplicati1[counter++] = elemento;

        }
        int[] senzaDuplicati = new int[counter+1];
        for(int i = 0; i <= counter;i++ ){
            senzaDuplicati[i] = senzaDuplicati1[i];
        }
        return senzaDuplicati;
    }
    public int sommaMax(int array[]){
        int current = 0;
        int sommaVolante = 0;
        for (int i = 0;i < array.length;i++) {
            sommaVolante += array[i];
            if(sommaVolante > current) current=sommaVolante;
            if(sommaVolante < 0) sommaVolante = 0;
        }
        return current;
    }

}
