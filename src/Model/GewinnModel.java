package Model;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
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

    }
    public void berechneRunde(int spielerZahl) {

    }
    public boolean hatGewonnen() {
        return true;
    }
    public boolean hatVerloren() {
        return true;
    }
}
