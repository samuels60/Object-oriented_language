package esercizi3;

public class Email {

    public boolean isValidEmail(String s){
        boolean returnamentState = false;
        if (s.matches (".@.\.com|net|edu|gov|it|fr|de") ) returnamentState = true;
        return returnamentState;
    }

}
