package lt.Vardas_pavarde.Autonuoma.beans;

public class Automobilis extends TransportoPriemone{
    int maxGreitis;
    int sedimosVietos;
    String greiciuDeze;
    AutomobilioTipas automobilioTipas;


    public Automobilis(){}

    public Automobilis(String valstNr, int rida, int parosKaina, boolean arSiuoMetuIsnuomotas, int maxGreitis, int sedimosVietos, String greiciuDeze, AutomobilioTipas automobilioTipas) {
        super(valstNr, rida, parosKaina, arSiuoMetuIsnuomotas);
        this.maxGreitis = maxGreitis;
        this.sedimosVietos = sedimosVietos;
        this.greiciuDeze = greiciuDeze;
        this.automobilioTipas = automobilioTipas;
    }


    public int getMaxGreitis() {
        return maxGreitis;
    }

    public void setMaxGreitis(int maxGreitis) {
        this.maxGreitis = maxGreitis;
    }

    public int getSedimosVietos() {
        return sedimosVietos;
    }

    public void setSedimosVietos(int sedimosVietos) {
        this.sedimosVietos = sedimosVietos;
    }

    public String getGreiciuDeze() {
        return greiciuDeze;
    }

    public void setGreiciuDeze(String greiciuDeze) {
        this.greiciuDeze = greiciuDeze;
    }

    public AutomobilioTipas getAutomobilioTipas() {
        return automobilioTipas;
    }

    public void setAutomobilioTipas(AutomobilioTipas automobilioTipas) {
        this.automobilioTipas = automobilioTipas;
    }

}
