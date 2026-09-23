package View;

import javax.swing.*;

public class GewinnFrame extends JFrame {

    public GewinnFrame(JPanel p) {
        super("Zahlen-Gewinnspiel(v1.0)");
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(750, 450, 400, 250);
        this.setVisible(true);
    }
}