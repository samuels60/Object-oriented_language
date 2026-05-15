import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinestraContatore extends JFrame implements ActionListener {

    private JTextField campo;
    private JButton ok;
    private int contatore = 0;

    public FinestraContatore() {
        setTitle("Contatore progressivo");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        campo = new JTextField(10);
        ok = new JButton("OK");

        ok.addActionListener(this);

        add(campo);
        add(ok);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contatore++;
        campo.setText(String.valueOf(contatore));
    }

    public static void main(String[] args) {
        new FinestraContatore();
    }
}