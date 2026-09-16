package Model;

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
    public void berechneRunde(int spielerZahl) {
        if(spielerZahl > 9 || spielerZahl < 1) {
            return;
        }
        this.spielerZahl = spielerZahl;
        if(spielerZahl == computerZahl) {
            gesamtPunkte += 20;
            return;
        } else if(spielerZahl + 1 == computerZahl || spielerZahl - 1 == computerZahl) {
            gesamtPunkte += 5;
        } else {
            gesamtPunkte -= 10;
        }
    }
    public boolean hatGewonnen() {
        if(gesamtPunkte >= 100) {
            return true;
        }
        else return false;

    }
    public boolean hatVerloren() {
        if(gesamtPunkte <= 0) {
            return true;
        }
        else return false;
    }
}
