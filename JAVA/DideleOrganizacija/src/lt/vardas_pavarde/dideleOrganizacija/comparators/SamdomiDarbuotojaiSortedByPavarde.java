package lt.vardas_pavarde.dideleOrganizacija.comparators;

import lt.vardas_pavarde.dideleOrganizacija.beans.Asmuo;
import lt.vardas_pavarde.dideleOrganizacija.beans.SamdomiDarbuotojai;

import java.util.Comparator;

public class SamdomiDarbuotojaiSortedByPavarde implements Comparator<Asmuo>{
    public int compare(Asmuo o1,Asmuo o2){
        if(!(o1 instanceof SamdomiDarbuotojai)){
            throw new IllegalArgumentException();
        }
        if(!(o2 instanceof SamdomiDarbuotojai)){
            throw new IllegalArgumentException();
        }
        SamdomiDarbuotojai s1 = (SamdomiDarbuotojai) o1;
        SamdomiDarbuotojai s2 = (SamdomiDarbuotojai) o2;

        return s1.getPavarde().compareTo(s2.getPavarde());
    }
}
