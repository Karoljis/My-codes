package lt.Vardas_pavarde.Autonuoma.beans;

public class KrovininioAutobusoTipas {
    public static final KrovininioAutobusoTipas DIDELIS = new KrovininioAutobusoTipas("Didelis");
    public static final KrovininioAutobusoTipas MAZAS = new KrovininioAutobusoTipas("Mazas");

    String krovininioAutobusoTipas;

    private KrovininioAutobusoTipas(String krovininioAutobusoTipas) {
        this.krovininioAutobusoTipas = krovininioAutobusoTipas;
    }
}
