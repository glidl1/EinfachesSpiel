package View;

import Controller.GewinnController;

import javax.swing.*;
import java.awt.*;

public class GewinnPanel extends JPanel {
    private JButton nochmalButton;
    private JLabel ergebnisText, punkteText;
    private GewinnController controller;
    private JTextField spielerEingabe, computerEingabe;

    public GewinnPanel(GewinnController controller) {
        this.controller = controller;
        this.setLayout(new BorderLayout());
        JPanel statusTexte = new JPanel();
        statusTexte.setLayout(new GridLayout(3, 2 , 10, 0));
        JLabel rErgebnis = new JLabel("Rundenergebnis:");
        JLabel gPunkte = new JLabel(("Gesamtpunkte:"));
        ergebnisText = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        ergebnisText.setEnabled(false);
        punkteText = new JLabel("30", SwingConstants.CENTER);
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
        nochmalButton.setEnabled(true);
        nochmalButton.addActionListener(controller);
        nochmalButton.setActionCommand("Nochmal");
        nochmalButton.setPreferredSize(new Dimension(120, 30));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(nochmalButton);
        add(buttonPanel, BorderLayout.PAGE_END);
        Font feldFont = new Font("Arial", Font.BOLD, 40);
        spielerEingabe.setFont(feldFont);
        computerEingabe.setFont(feldFont);
        spielerEingabe.setHorizontalAlignment(JTextField.CENTER);
        computerEingabe.setHorizontalAlignment(JTextField.CENTER);
        Font kleinefeldFont = new Font("Arial", Font.BOLD, 16);
        ergebnisText.setFont(kleinefeldFont);
        punkteText.setFont(kleinefeldFont);
    }
    public void setComputerZahl(int computerZahl) {
        computerEingabe.setText(String.valueOf(computerZahl));
    }
    public void setRundenErgebnis(int zahl) {
        ergebnisText.setText(String.valueOf(zahl));
    }
    public void setGesamtpunkte(int zahl) {
        punkteText.setText(String.valueOf(zahl));
    }
    public int getEingabe() {
        return Integer.parseInt(spielerEingabe.getText());
    }
    public void showError(String error) {
        ergebnisText.setText(error);
    }
    public void setStatus(String text) {
        ergebnisText.setText(text);
    }
    public void resetRunde() {
        ergebnisText.setText("Tippe eine Zahl von 1 bis 9");
        spielerEingabe.setText("");
        computerEingabe.setText((""));
    }

}
