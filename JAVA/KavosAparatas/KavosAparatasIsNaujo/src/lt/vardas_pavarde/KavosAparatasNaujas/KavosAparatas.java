package lt.vardas_pavarde.KavosAparatasNaujas;

public class KavosAparatas {
    private static final int maxPanaudojimai = 10;
    private static int cukrus = 1000;
    private static int kavosPupeles = 1000;
    private static int vanduo = 1000;
    private static int panaudojimuSkaicius = 0;
    KavuPasirinkimas kavuPasirinkimas = new KavuPasirinkimas();


    public void padarytiKava(int sk) {
        KavosReceptas issirinktaKava = KavuPasirinkimas.kavuRusys.get(sk);
        if (panaudojimuSkaicius >= maxPanaudojimai) {
            throw new RuntimeException("Reikia isvalyti aparata");
        }
        if (cukrus < issirinktaKava.getCukrus()) {
            throw new RuntimeException("Truksta cukraus");
        }
        if (kavosPupeles < issirinktaKava.getKavosPupeles()) {
            throw new RuntimeException("Truksta kavos pupeliu");
        }
        if (vanduo < issirinktaKava.getVanduo()) {
            throw new RuntimeException("Truksta vandens");
        }

        cukrus -= issirinktaKava.getCukrus();
        kavosPupeles -= issirinktaKava.getKavosPupeles();
        vanduo -= issirinktaKava.getVanduo();
        panaudojimuSkaicius++;
    }

    public void papildytiProduktus() {
        cukrus = 1000;
        kavosPupeles = 1000;
        vanduo = 1000;
    }

    public void atliktiPlovima() {
        panaudojimuSkaicius = 0;
    }
    public void printProduktuInfo(){
        System.out.println("Cukraus yra like: "+cukrus+"\nKavos pupeliu yra like: "+kavosPupeles+"\nVandens yra like: "+vanduo);
        System.out.println("Kava daryta: "+panaudojimuSkaicius+" kartu. Iki kito valymo liko: "+(maxPanaudojimai-panaudojimuSkaicius));
    }


}
