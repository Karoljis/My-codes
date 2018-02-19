package lt.vardas_pavarde.kavos_aparatas;

public class Receptas {
    String name;
    int cukrus;
    int kavosPupos;
    int vandensKiekis;

    public Receptas(String name, int cukrus, int kavosPupos, int vandensKiekis) {
        this.name = name;
        this.cukrus = cukrus;
        this.kavosPupos = kavosPupos;
        this.vandensKiekis = vandensKiekis;

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

    public int getKavosPupos() {
        return kavosPupos;
    }

    public void setKavosPupos(int kavosPupos) {
        this.kavosPupos = kavosPupos;
    }

    public int getVandensKiekis() {
        return vandensKiekis;
    }

    public void setVandensKiekis(int vandensKiekis) {
        this.vandensKiekis = vandensKiekis;
    }
}
