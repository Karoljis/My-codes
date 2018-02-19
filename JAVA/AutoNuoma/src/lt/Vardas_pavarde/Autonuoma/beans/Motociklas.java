package lt.Vardas_pavarde.Autonuoma.beans;

public class Motociklas extends TransportoPriemone{
    MotocikloTipas motocikloTipas;
    int darbinisTuris;
    int maxGreitis;

    public Motociklas(){}

    public Motociklas(String valstNr, int rida, int parosKaina, boolean arSiuoMetuIsnuomotas, MotocikloTipas motocikloTipas, int darbinisTuris, int maxGreitis) {
        super(valstNr, rida, parosKaina, arSiuoMetuIsnuomotas);
        this.motocikloTipas = motocikloTipas;
        this.darbinisTuris = darbinisTuris;
        this.maxGreitis = maxGreitis;
    }

    public MotocikloTipas getMotocikloTipas() {
        return motocikloTipas;
    }

    public void setMotocikloTipas(MotocikloTipas motocikloTipas) {
        this.motocikloTipas = motocikloTipas;
    }

    public int getDarbinisTuris() {
        return darbinisTuris;
    }

    public void setDarbinisTuris(int darbinisTuris) {
        this.darbinisTuris = darbinisTuris;
    }

    public int getMaxGreitis() {
        return maxGreitis;
    }

    public void setMaxGreitis(int maxGreitis) {
        this.maxGreitis = maxGreitis;
    }
}
