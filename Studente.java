package conubiodiclassi2;

public class Studente{
    private final String nome;
    private final String cognome;
    private final String corso;
    private final int voto;

    public Studente(String nome, String cognome, String corso, int voto) {
        this.nome = nome;
        this.cognome = cognome;
        this.corso = corso;
        this.voto = voto;
    }
    public static Studente creaCostruttore(String info){
        String [] studenti = info.split(" ");
        return new Studente(studenti[0],studenti[1],studenti[2],Integer.parseInt(studenti[3]));
    }
    public String getNome(){return this.nome;}
    public String getCognome(){return this.cognome;}
    public String getNomeCompleto(){return this.nome + " " + this.cognome;}
    public int getVoto() {
        return this.voto;
    }
    public  String getCorso(){
        return this.corso;
    }
    @Override
    public String toString(){
        return  nome + " " + cognome + " " + corso + " " + voto ;
    }
    @Override
    public boolean equals(Object obj){
        if(obj==this)return true;
        if(obj==null) return false;
        if(obj instanceof Studente s){
            if(s.getNomeCompleto().equals(this.getNomeCompleto())){
                if(s.voto == this.getVoto()){
                    if(s.getCorso().equals(this.getCorso())) return true;
                }
            }
        }
        return false;
    }


}