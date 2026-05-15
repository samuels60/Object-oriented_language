package conubiodiclassi2;

import javax.swing.*;
import java.awt.*;

public class InterfacciaEsercitazione extends JFrame {
    private final JButton b1 = new JButton("OK");
    private final JLabel l1 = new JLabel("Ineserisci");
    private final JTextField t1 = new JTextField(20);
    private final JPanel p1 = new JPanel();
    public InterfacciaEsercitazione() {
        super("Finestra d'esempio");
        Container c = this.getContentPane();
        c.add(p1);
        p1.add(l1);
        p1.add(t1);
        p1.add(b1);
        this.setSize(400,200);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
