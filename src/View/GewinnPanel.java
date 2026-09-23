package View;

import Controller.GewinnController;

import javax.swing.*;
import java.awt.*;

public class GewinnPanel extends JPanel {
    private JButton nochmalButton;
    private JTextField ergebnisText, punkteText;
    private GewinnController controller;
    private JTextField spielerEingabe, computerEingabe;

    public GewinnPanel(GewinnController controller) {
        this.controller = controller;
        this.setLayout(new BorderLayout());
        JPanel statusTexte = new JPanel();
        statusTexte.setLayout(new GridLayout(3, 2 , 10, 0));
        JLabel rErgebnis = new JLabel("Rundenergebnis:");
        JLabel gPunkte = new JLabel(("Gesamtpunkte:"));
        ergebnisText = new JTextField("Tippe eine Zahl von 1 bis 9");
        ergebnisText.setEnabled(false);
        punkteText = new JTextField("30");
        punkteText.setEnabled(false);
        JLabel dZahl = new JLabel("Deine Zahl:");
        JLabel cZahl = new JLabel("Computer:");
        statusTexte.add(rErgebnis);
        statusTexte.add(gPunkte);
        statusTexte.add(ergebnisText);
        statusTexte.add(punkteText);
        statusTexte.add(dZahl);
        statusTexte.add(cZahl);
        add(statusTexte, BorderLayout.PAGE_START);
        JPanel eingabeBereich = new JPanel();
        eingabeBereich.setLayout(new GridLayout(1, 2, 20, 10));
        spielerEingabe = new JTextField();
        spielerEingabe.addActionListener(controller);
        spielerEingabe.setActionCommand("EIN");
        computerEingabe = new JTextField();
        computerEingabe.setEnabled(false);
        eingabeBereich.add(spielerEingabe);
        eingabeBereich.add(computerEingabe);
        add(eingabeBereich, BorderLayout.CENTER);
        nochmalButton = new JButton("Noch einmal");
        nochmalButton.setEnabled(false);
        nochmalButton.addActionListener(controller);
        nochmalButton.setActionCommand("Nochmal");
        add(nochmalButton, BorderLayout.PAGE_END);
    }
}
