package View;

import Controller.GewinnController;

import javax.swing.*;
import java.awt.*;

/**
 * Erstellt eine GUI für das einfache Spiel
 * @author Gustav Lidl
 * @version 21.09.2026
 */
public class GewinnPanel extends JPanel {
    private JButton nochmalButton;
    private JLabel ergebnisText, punkteText;
    private GewinnController controller;
    private JTextField spielerEingabe, computerEingabe;

    public GewinnPanel(GewinnController controller) {
        this.controller = controller;
        this.setLayout(new BorderLayout());
        JPanel statusTexte = new JPanel();
        /*
        Erstellt Alle Labels für die Top Leiste und anzeige und fügt diese Zum BorderLayout hinzu
         */
        statusTexte.setLayout(new GridLayout(3, 2 , 10, 0));
        JLabel rErgebnis = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        JLabel gPunkte = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);
        ergebnisText = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        ergebnisText.setEnabled(false);
        punkteText = new JLabel("30", SwingConstants.CENTER);
        punkteText.setEnabled(false);
        JLabel dZahl = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        JLabel cZahl = new JLabel("Computer:", SwingConstants.CENTER);
        statusTexte.add(rErgebnis);
        statusTexte.add(gPunkte);
        statusTexte.add(ergebnisText);
        statusTexte.add(punkteText);
        statusTexte.add(dZahl);
        statusTexte.add(cZahl);
        add(statusTexte, BorderLayout.PAGE_START);
        /*
        Erstellt alle Text Fields im eingabebereich, fügt einen Action Command und den ActionListener hinzu und stellt die Textgröße
        auf 40 und die Schriftart auf fett
         */
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
        ergebnisText.setOpaque(true);
        punkteText.setOpaque(true);
    }

    /**
     * Setzt die Zahl im Label auf die Random Zahl des Computers
     * @param computerZahl die Zahl die im Label angezeigt wird
     */
    public void setComputerZahl(int computerZahl) {
        computerEingabe.setText(String.valueOf(computerZahl));
    }

    /**
     * Gibt an wie viele Punkte man verloren oder bekommen hat
     * @param zahl die anzahl der Punkte die Verloren oder Gewonnen wurden
     */
    public void setRundenErgebnis(int zahl) {
        ergebnisText.setText(String.valueOf(zahl));
        spielerEingabe.setEnabled(false);
        nochmalButton.setEnabled(true);
        if (zahl > 0) {
            ergebnisText.setBackground(Color.GREEN);
            punkteText.setBackground(Color.GREEN);
        } else {
            ergebnisText.setBackground(Color.RED);
            punkteText.setBackground(Color.RED);
        }
    }

    /**
     * Gibt die Anzahl der Gesamtpunkte im Label an
     * @param zahl die Anzahl der Punkte
     */
    public void setGesamtpunkte(int zahl) {
        punkteText.setText(String.valueOf(zahl));
    }

    /**
     * Liest die eingabe im Textfield aus
     * @return die Eingabe als String
     */
    public int getEingabe() {
        return Integer.parseInt(spielerEingabe.getText());
    }

    /**
     * Gibt einen Fehler bei einer Falshcen Eingabe aus
     * @param error der Fehler als String
     */
    public void showError(String error) {
        ergebnisText.setText(error);
    }

    /**
     * Gibt Verloren oder Gewonnen aus je nachdem die Punkte über 0 oder unter 100 sind
     * @param text Verloren oder Gewonnen
     */
    public void setStatus(String text) {
        ergebnisText.setText(text);
    }

    /**
     * Setzt die Eingabefelder für die nächste Eingabe zurück
     */
    public void resetRunde() {
        ergebnisText.setText("Tippe eine Zahl von 1 bis 9");
        spielerEingabe.setText("");
        computerEingabe.setText("");
        spielerEingabe.setEnabled(true);
        nochmalButton.setEnabled(false);
        computerEingabe.setText("");
        ergebnisText.setBackground(Color.WHITE);
        punkteText.setBackground(Color.WHITE);
    }

}
