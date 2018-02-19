package lt.Vardas_pavarde.Autonuoma.beans;

public class KrovininisAutomobilis extends TransportoPriemone{
    int turis;
    int maxVezamasSvoris;
    String vairuotojoKategorija;
    KrovininioAutobusoTipas krovininioAutobusoTipas;

    public KrovininisAutomobilis(String valstNr, int rida, int parosKaina, boolean arSiuoMetuIsnuomotas, int turis, int maxVezamasSvoris, String vairuotojoKategorija, KrovininioAutobusoTipas krovininioAutobusoTipas) {
        super(valstNr, rida, parosKaina, arSiuoMetuIsnuomotas);
        this.turis = turis;
        this.maxVezamasSvoris = maxVezamasSvoris;
        this.vairuotojoKategorija = vairuotojoKategorija;
        this.krovininioAutobusoTipas = krovininioAutobusoTipas;
    }

    public int getTuris() {
        return turis;
    }

    public void setTuris(int turis) {
        this.turis = turis;
    }

    public int getMaxVezamasSvoris() {
        return maxVezamasSvoris;
    }

    public void setMaxVezamasSvoris(int maxVezamasSvoris) {
        this.maxVezamasSvoris = maxVezamasSvoris;
    }

    public String getVairuotojoKategorija() {
        return vairuotojoKategorija;
    }

    public void setVairuotojoKategorija(String vairuotojoKategorija) {
        this.vairuotojoKategorija = vairuotojoKategorija;
    }

    public KrovininioAutobusoTipas getKrovininioAutobusoTipas() {
        return krovininioAutobusoTipas;
    }

    public void setKrovininioAutobusoTipas(KrovininioAutobusoTipas krovininioAutobusoTipas) {
        this.krovininioAutobusoTipas = krovininioAutobusoTipas;
    }
}
