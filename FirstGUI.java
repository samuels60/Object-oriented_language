import java.awt.*;
import javax.swing.*;

public class FirstGUI extends JFrame {

    private final JPanel pan1, pan2, pan3, interpannel1, interpannel2;

    private final JButton b1, b2, b3, b4, b5;
    private final JTextField t1;
    private final JMenuBar barraMenu;
    private final JMenu menu1,subMenu1;
    private final JMenuItem ciccio;
    private final JToolBar toolBar;

    private FirstGUI() {
        super("Lamborghini & Porche");

        /// titolino divertente
        pan3 = new JPanel();
        menu1 = new JMenu("testino");
        menu1.add(ciccio = new JMenuItem("ciccio"));
        menu1.add(subMenu1 = new JMenu("subTest"));
        subMenu1.add(ciccio);
        barraMenu = new JMenuBar();
        barraMenu.add(menu1);

        /// barra di ricerca
        pan2 = new JPanel();
        /// interpannel
        interpannel1= new JPanel();
        interpannel2 = new JPanel();
        interpannel1.add(t1 = new JTextField("Ricerca"), BorderLayout.WEST);
        interpannel1.add(b5 = new JButton("Invia"), BorderLayout.EAST);


        /// pannelli normali
        pan2.setBackground(Color.WHITE);
        pan2.add(interpannel1, BorderLayout.NORTH);
        pan2.add(interpannel2,BorderLayout.CENTER);


        interpannel1.setBorder(BorderFactory.createTitledBorder("Test"));


        /// menu visibile in basso
        toolBar = new JToolBar();
        toolBar.add(b1 = new JButton("Home"));
        toolBar.addSeparator();
        toolBar.add(b2 = new JButton("Accout"));
        toolBar.addSeparator();
        toolBar.add(b3 = new JButton("Prestiti"));
        toolBar.addSeparator();
        toolBar.add((b4 = new JButton("Catoalogo")));
/// pannello su cui è pasato il menu che verra incollato
        pan1 = new JPanel();
        pan1.add(toolBar, BorderLayout.SOUTH);


        Container c = this.getContentPane();
        c.add(pan3, BorderLayout.NORTH);
        c.add(pan2, BorderLayout.CENTER);
        c.add(pan1, BorderLayout.SOUTH);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setJMenuBar(barraMenu);
        }


    public static void main(String[] args) {
        new FirstGUI();
    }
}
