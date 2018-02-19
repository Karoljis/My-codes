package lt.vardas_pavarde.dideleOrganizacija.beans;

public class Padalinys {
    public static final Padalinys KAUNAS = new Padalinys("Kaunas");
    public static final Padalinys VILNIUS = new Padalinys("Vilnius");
    public static final Padalinys KLAIPEDA = new Padalinys("Klaipėda");
    public static final Padalinys PANEVEZYS = new Padalinys("Panevėžys");
    public static final Padalinys BIRZAI = new Padalinys("Biržai");

    String padalinys;

    private Padalinys(String padalinys) {
        this.padalinys = padalinys;
    }
}
