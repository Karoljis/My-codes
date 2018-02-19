package lt.Vardas_pavarde.Autonuoma.beans;

public class MotocikloTipas {
    public static final MotocikloTipas PAAUGLIAMS = new MotocikloTipas("Paaugliams");
    public static final MotocikloTipas PATYRUSIEMS = new MotocikloTipas("Patyrusiems");

    private String moticikliTipas;
    MotocikloTipas(String moticikliTipas){
        this.moticikliTipas = moticikliTipas;
    }
}
