package lt.vardas_pavarde.KavosAparatasNaujas;

public class KavosReceptas {
    String name;
    int cukrus;
    int kavosPupeles;
    int vanduo;

    public KavosReceptas(String name, int cukrus, int kavosPupeles, int vanduo) {
        this.name = name;
        this.cukrus = cukrus;
        this.kavosPupeles = kavosPupeles;
        this.vanduo = vanduo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCukrus() {
        return cukrus;
    }

    public void setCukrus(int cukrus) {
        this.cukrus = cukrus;
    }

    public int getKavosPupeles() {
        return kavosPupeles;
    }

    public void setKavosPupeles(int kavosPupeles) {
        this.kavosPupeles = kavosPupeles;
    }

    public int getVanduo() {
        return vanduo;
    }

    public void setVanduo(int vanduo) {
        this.vanduo = vanduo;
    }
}

