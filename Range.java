package conubiodiclassi2;

public enum Range {
    ALTO,MEDIO,BASSO;

    public static Range fromVoto(int voto){
        if(voto<22){
            return BASSO;
        } else if (voto < 26) {
            return MEDIO;
        }
        return ALTO;

    }
}
