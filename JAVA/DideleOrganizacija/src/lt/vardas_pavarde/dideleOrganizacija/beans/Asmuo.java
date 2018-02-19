package lt.vardas_pavarde.dideleOrganizacija.beans;

public abstract class Asmuo {
    String vardas;
    String pavarde;
    String asmKodas;

    public Asmuo(String vardas, String pavarde, String asmKodas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.asmKodas = asmKodas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getAsmKodas() {
        return asmKodas;
    }

    public void setAsmKodas(String asmKodas) {
        this.asmKodas = asmKodas;
    }

    public abstract int getAlga();
}
