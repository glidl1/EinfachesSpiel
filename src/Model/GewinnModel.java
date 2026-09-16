package Model;

/**
 * Ein einfaches spiel
 * @@author Gustav Lidl
 * @version 2026-09-16
 */
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 30;

    }
    public int getSpielerZahl() {
        return spielerZahl;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }
    public void berechneComputerZahl() {
        this.computerZahl = (int) ((Math.random() * 9) + 1);
    }
    /**
     * Berechnet die Anzahl der Punkte anhand der Punkte des Computers und des Spielers
     * @param spielerZahl die übergeben Zahl als int von 1-9
     */
    public void berechneRunde(int spielerZahl) {
        if(spielerZahl > 9 || spielerZahl < 1) {
            return;
        }
        this.spielerZahl = spielerZahl;
        if(spielerZahl == computerZahl) {
            gesamtPunkte += 20;
        } else if(spielerZahl + 1 == computerZahl || spielerZahl - 1 == computerZahl) {
            gesamtPunkte += 5;
        } else {
            gesamtPunkte -= 10;
        }
    }

    /**
     * Gibt true zurück wenn punkte >= 100 ist
     * @return true wenn punkte >= 100 ist
     */
    public boolean hatGewonnen() {
        if(gesamtPunkte >= 100) {
            return true;
        }
        else return false;

    }

    /**
     * Gibt true zurück wenn punkte <= 0 ist
     * @return true wenn punkte <= 0 ist
     */
    public boolean hatVerloren() {
        if(gesamtPunkte <= 0) {
            return true;
        }
        else return false;
    }
}
