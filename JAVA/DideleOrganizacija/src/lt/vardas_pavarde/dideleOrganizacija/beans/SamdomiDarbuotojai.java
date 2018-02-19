package lt.vardas_pavarde.dideleOrganizacija.beans;

import java.util.Date;

public class SamdomiDarbuotojai extends Asmuo {
    Padalinys padalinys;
    int alga;
    Date nuoKadaDirba;

    public SamdomiDarbuotojai(String vardas, String pavarde, String asmKodas, Padalinys padalinys, int alga, Date nuoKadaDirba) {
        super(vardas, pavarde, asmKodas);
        this.padalinys = padalinys;
        this.alga = alga;
        this.nuoKadaDirba = nuoKadaDirba;
    }

    public Padalinys getPadalinys() {
        return padalinys;
    }

    public void setPadalinys(Padalinys padalinys) {
        this.padalinys = padalinys;
    }

    public int getAlga() {
        return alga;
    }

    public void setAlga(int alga) {
        this.alga = alga;
    }

    public Date getNuoKadaDirba() {
        return nuoKadaDirba;
    }

    public void setNuoKadaDirba(Date nuoKadaDirba) {
        this.nuoKadaDirba = nuoKadaDirba;
    }
}
