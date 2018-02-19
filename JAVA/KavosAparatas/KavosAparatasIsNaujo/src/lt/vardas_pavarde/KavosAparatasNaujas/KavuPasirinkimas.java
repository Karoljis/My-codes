package lt.vardas_pavarde.KavosAparatasNaujas;

import java.util.ArrayList;
import java.util.List;

public class KavuPasirinkimas {
    static List<KavosReceptas> kavuRusys = new ArrayList<>();

    public List<KavosReceptas> setPradinesKavosRusys() {
        KavosReceptas kavosReceptas = new KavosReceptas("Juoda kava", 50, 50, 50);
        kavuRusys.add(kavosReceptas);
        kavosReceptas = new KavosReceptas("Balta kava", 75, 75, 75);
        kavuRusys.add(kavosReceptas);
        kavosReceptas = new KavosReceptas("Kapucino", 25, 25, 100);
        kavuRusys.add(kavosReceptas);
        return kavuRusys;

    }


    public void printKavuPavadinimai() {
        if (kavuRusys.size() == 0) {
            throw new RuntimeException("Nera prideta kavu receptu");
        }
        for (KavosReceptas receptas : kavuRusys) {
            System.out.println(kavuRusys.indexOf(receptas) + ") " + receptas.getName());
        }
    }

    public void pridetiKavosRecepta(String name, int cukrus, int kavosPupeles, int vanduo) {
        KavosReceptas receptas = new KavosReceptas(name, cukrus, kavosPupeles, vanduo);
        kavuRusys.add(receptas);
        System.out.println("Kavos receptas pridetas");
    }

    public void istrintiKavosRecepta(int index) {
        kavuRusys.remove(index);
        System.out.println("Kava istrinta is saraso");
    }

}
