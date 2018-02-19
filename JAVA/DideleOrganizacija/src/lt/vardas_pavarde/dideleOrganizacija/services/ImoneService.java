package lt.vardas_pavarde.dideleOrganizacija.services;

import lt.vardas_pavarde.dideleOrganizacija.beans.*;
import lt.vardas_pavarde.dideleOrganizacija.comparators.FreelancersComparatorByValandinisIkainis;
import lt.vardas_pavarde.dideleOrganizacija.comparators.SamdomiDarbuotojaiSortedByPavarde;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ImoneService {
    public List<Asmuo> getPersonalas() {
        List<Asmuo> rezultatas = new ArrayList<>();
        Asmuo asmuo = new SamdomiDarbuotojai("Citadele", "BBBB", "234123", Padalinys.KAUNAS, 600, new Date());
        rezultatas.add(asmuo);
        asmuo = new SamdomiDarbuotojai("Bernardas", "AAb", "234123", Padalinys.KAUNAS, 600, new Date());
        rezultatas.add(asmuo);
        asmuo = new SamdomiDarbuotojai("ANTANAS", "A", "234123", Padalinys.KAUNAS, 600, new Date());
        rezultatas.add(asmuo);
        asmuo = new SamdomiDarbuotojai("ANTANAS", "Kazkoks", "234123", Padalinys.KLAIPEDA, 600, new Date());
        rezultatas.add(asmuo);
        asmuo = new SamdomiDarbuotojai("CCCC", "DDDDD", "23452345", Padalinys.KLAIPEDA, 800, new Date());
        rezultatas.add(asmuo);

        asmuo = new Freelancers("GGGGG", "FFFFF", "624563456", 10);
        rezultatas.add(asmuo);
        asmuo = new Freelancers("TTTTT", "WWWWWW", "3456356", 11);
        rezultatas.add(asmuo);
        asmuo = new Freelancers("zzzzz", "sssss", "24566", 8);
        rezultatas.add(asmuo);
        asmuo = new Freelancers("hhhhh", "rrrrrr", "4563456", 12);
        rezultatas.add(asmuo);

        asmuo = new Praktikantai("UUUU", "OOOOOO", "123412134", new Date(), new Date());
        rezultatas.add(asmuo);
        asmuo = new Praktikantai("QQQQQ", "WWWWW", "1515155456", new Date(), new Date());
        rezultatas.add(asmuo);
        asmuo = new Praktikantai("QQasdQQQ", "WWWaWW", "15151554", new Date(), new Date());
        rezultatas.add(asmuo);
        return rezultatas;
    }

    public List<Asmuo> getFreelancersSortedByValandineAlga(List<Asmuo> asmenys) {
        List<Asmuo> rezultatas = new ArrayList<>();
        for (Asmuo asmuo : asmenys) {
            if (asmuo instanceof Freelancers) {
                rezultatas.add(asmuo);
            }
        }
        Collections.sort(rezultatas, new FreelancersComparatorByValandinisIkainis());
        return rezultatas;
    }

    public int getAllPraktikanai(List<Asmuo> asmenys) {
        List<Asmuo> result = new ArrayList<>();
        if (asmenys != null) {
            for (Asmuo asmuo : asmenys) {
                if (asmuo instanceof Praktikantai) {
                    result.add(asmuo);
                }
            }

        }
        return result.size();
    }

    public List<Asmuo> getSamdomiDarbuotojaiIsKaunoSortedByPavarde(List<Asmuo> asmenys){
        List<Asmuo> result = new ArrayList<>();
        for (Asmuo asmuo:asmenys){
            if((asmuo instanceof SamdomiDarbuotojai)&&((SamdomiDarbuotojai) asmuo).getPadalinys().equals(Padalinys.KAUNAS)){
                result.add(asmuo);
            }
        }
        Collections.sort(result,new SamdomiDarbuotojaiSortedByPavarde());
        return result;
    }

    public List<Asmuo> getSamdomiDarbuotojaiByPavarde(List<Asmuo> asmenys){
        List<Asmuo> result = new ArrayList<>();
        for(Asmuo asmuo: asmenys){
            if(asmuo instanceof SamdomiDarbuotojai){
                result.add(asmuo);
            }
        }
        Collections.sort(result,new SamdomiDarbuotojaiSortedByPavarde());
        return result;
    }


}
