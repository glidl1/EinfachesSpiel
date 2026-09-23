package Controller;

import Model.GewinnModel;
import View.GewinnFrame;
import View.GewinnPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Verbindet die GUI mit dem GewinnModel
 * @author Gustav Lidl
 * @version  23-09-2026
 */
public class GewinnController implements ActionListener {
    private GewinnModel model;
    private GewinnPanel panel;
    public GewinnController() {
        this.model = new GewinnModel();
        this.panel = new GewinnPanel(this);
        GewinnFrame gf = new GewinnFrame(panel);
    }

    /**
     * Liest die Eingabe über einen Action Listener, berechnet die Werte für den Computer und gibt sie im Label aus
     * @param e das Action Event welches vom User ausgelöst wird
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("EIN")) {
            int eingabe;
            try {
                eingabe = (panel.getEingabe());
            } catch (NumberFormatException exc) {
                panel.showError("Bitte Gib eine Zahl ein");
                return;
            }
            if(eingabe < 0 || eingabe > 9) {
                panel.showError("Die Zahl muss zwishen 0 und 9 sein");
                return;
            }
            model.berechneComputerZahl();
            model.berechneRunde(eingabe);
            panel.setComputerZahl(model.getComputerZahl());
            panel.setRundenErgebnis(model.getRundenErgebnis());
            panel.setGesamtpunkte(model.getGesamtPunkte());

            if(model.hatGewonnen()) {
                panel.setStatus("Gewonnen");
            } else if(model.hatVerloren()) {
                panel.setStatus("Verloren");
            }
        }
        if(e.getActionCommand().equals("Nochmal")) {
            panel.resetRunde();
        }
    }
    public static void main(String[] args) {
        new GewinnController();
    }
}

