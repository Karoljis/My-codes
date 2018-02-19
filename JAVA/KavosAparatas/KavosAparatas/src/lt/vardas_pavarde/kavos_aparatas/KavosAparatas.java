package lt.vardas_pavarde.kavos_aparatas;

public class KavosAparatas {
    public final static int PANAUDOJIMU_RIBA = 11;
    static int cukrus = 500;
    static int kavosPupos = 500;
    static int vanduo = 1000;
    static int panaudojimuSkaicius;

    Receptas[] receptai = new KavuPasirinkimas().getKavuRusys();


    public Receptas[] gautiReceptus() {
        return receptai;
    }

    public void padarykGerima(int receptoId) {

        Receptas receptas = receptai[receptoId];
        if (panaudojimuSkaicius >= PANAUDOJIMU_RIBA) {
            throw new RuntimeException("Reikia isvalyti aparata");
        }
        if (cukrus < receptas.getCukrus()) {
            throw new RuntimeException("Neuztenka cukraus");
        }
        if (kavosPupos < receptas.getKavosPupos()) {
            throw new RuntimeException("Neuztenka pupu");
        }
        if (vanduo < receptas.getVandensKiekis()) {
            throw new RuntimeException("Neuztenka vandens");
        }

        cukrus -= receptas.getCukrus();
        kavosPupos -= receptas.getKavosPupos();
        vanduo -= receptas.getVandensKiekis();
        panaudojimuSkaicius++;


    }

    public void plovimas() {
        panaudojimuSkaicius = 0;
        System.out.println("Plovimas atliktas");
    }

    public void produktuKiekiai() {
        System.out.println("Cukraus yra: " + cukrus);
        System.out.println("Kavos pupu yra: " + kavosPupos);
        System.out.println("Vandens yra: " + vanduo);
        System.out.println("Kava daryta " + panaudojimuSkaicius + " kartu. Iki kito valymo liko: " + (PANAUDOJIMU_RIBA - panaudojimuSkaicius));
    }

    public void papildytiProduktus() {
         cukrus = 500;
         kavosPupos = 500;
         vanduo = 1000;
    }

}
