package lt.vardas_pavarde.dideleOrganizacija.beans;

public class Freelancers extends Asmuo {
    int valandosKaina;

    public Freelancers(String vardas, String pavarde, String asmKodas, int valandosKaina) {
        super(vardas, pavarde, asmKodas);
        this.valandosKaina = valandosKaina;
    }

    public int getValandosKaina() {
        return valandosKaina;
    }

    public void setValandosKaina(int valandosKaina) {
        this.valandosKaina = valandosKaina;
    }

    @Override
    public int getAlga() {
        return valandosKaina * 8 * 20;
    }
}
