package lt.vardas_pavarde.dideleOrganizacija.beans;

import java.util.Date;

public class Praktikantai extends Asmuo {
    Date nuoKadaDirba;
    Date ikiKadaDirba;

    public Praktikantai(String vardas, String pavarde, String asmKodas, Date nuoKadaDirba, Date ikiKadaDirba) {
        super(vardas, pavarde, asmKodas);
        this.nuoKadaDirba = nuoKadaDirba;
        this.ikiKadaDirba = ikiKadaDirba;
    }

    public Date getNuoKadaDirba() {
        return nuoKadaDirba;
    }

    public void setNuoKadaDirba(Date nuoKadaDirba) {
        this.nuoKadaDirba = nuoKadaDirba;
    }

    public Date getIkiKadaDirba() {
        return ikiKadaDirba;
    }

    public void setIkiKadaDirba(Date ikiKadaDirba) {
        this.ikiKadaDirba = ikiKadaDirba;
    }

    @Override
    public int getAlga() {
        return 0;
    }
}
