package conubiodiclassi2;

import java.util.Arrays;

public class ContaLettere {
    public enum Pari {
        ZERO(0),
        DUE(2),
        QUATTRO(4),
        SEI(6),
        OTTO(8),
        DIECI(10),
        DODICI(12),
        QUATTORDICI(14),
        SEDICI(16),
        DICIOTTO(18),
        VENTI(20),
        VENTIDUE(22),
        VENTIQUATTRO(24),
        VENTISEI(26),
        VENTOTTO(28);

        private final int valore;

        Pari(int valore) {
            this.valore = valore;
        }

        public int getValore() {
            return valore;
        }
    }

    public static long contaSpeciali() {
        return Arrays.stream(Pari.values())
                .filter(p -> p.name().length() == p.getValore() / 2)
                .count();
    }


}
