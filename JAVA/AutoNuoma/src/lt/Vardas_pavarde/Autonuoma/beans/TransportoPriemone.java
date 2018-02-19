package lt.Vardas_pavarde.Autonuoma.beans;

public class TransportoPriemone {
    String valstNr;
    int rida;
    int parosKaina;
    boolean arSiuoMetuIsnuomotas = false;

    public TransportoPriemone(){}

    public TransportoPriemone(String valstNr, int rida, int parosKaina, boolean arSiuoMetuIsnuomotas) {
        this.valstNr = valstNr;
        this.rida = rida;
        this.parosKaina = parosKaina;
        this.arSiuoMetuIsnuomotas = arSiuoMetuIsnuomotas;
    }

    public String getValstNr() {
        return valstNr;
    }

    public void setValstNr(String valstNr) {
        this.valstNr = valstNr;
    }

    public int getRida() {
        return rida;
    }

    public void setRida(int rida) {
        this.rida = rida;
    }

    public int getParosKaina() {
        return parosKaina;
    }

    public void setParosKaina(int parosKaina) {
        this.parosKaina = parosKaina;
    }

    public boolean isArSiuoMetuIsnuomotas() {
        return arSiuoMetuIsnuomotas;
    }

    public void setArSiuoMetuIsnuomotas(boolean arSiuoMetuIsnuomotas) {
        this.arSiuoMetuIsnuomotas = arSiuoMetuIsnuomotas;
    }
}
