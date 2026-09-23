package View;

import javax.swing.*;

/**
 * Erstellt ein Frame indem Das GewinnPanel angezeigt wird
 * @author Gustav Lidl
 * @version 23.09.2026
 */
public class GewinnFrame extends JFrame {

    public GewinnFrame(JPanel p) {
        super("Zahlen-Gewinnspiel(v1.0)");
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(750, 450, 400, 250);
        this.setVisible(true);
    }
}