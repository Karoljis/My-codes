package lt.vardas_pavarde.dideleOrganizacija.comparators;

import lt.vardas_pavarde.dideleOrganizacija.beans.Asmuo;
import lt.vardas_pavarde.dideleOrganizacija.beans.Freelancers;

import java.util.Comparator;

public class FreelancersComparatorByValandinisIkainis implements Comparator<Asmuo> {
    public int compare(Asmuo o1, Asmuo o2) {
        if (!(o1 instanceof Freelancers)) {
            throw new IllegalArgumentException();
        }
        if (!(o2 instanceof Freelancers)) {
            throw new IllegalArgumentException();
        }
        Freelancers f1 = (Freelancers) o1;
        Freelancers f2 = (Freelancers) o2;

        if (f1.getValandosKaina() > f2.getValandosKaina()) {
            return 1;
        }
        if (f1.getValandosKaina() < f2.getValandosKaina()) {
            return -1;
        }
        return 0;
    }
}
