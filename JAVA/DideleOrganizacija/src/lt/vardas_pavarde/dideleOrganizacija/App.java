package lt.vardas_pavarde.dideleOrganizacija;

import lt.vardas_pavarde.dideleOrganizacija.beans.Asmuo;
import lt.vardas_pavarde.dideleOrganizacija.services.ImoneService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ImoneService imoneService = new ImoneService();
        List<Asmuo> personalas = imoneService.getPersonalas();

        List<Asmuo> freelanceriai = imoneService.getFreelancersSortedByValandineAlga(personalas);
        for (Asmuo asmuo : freelanceriai) {
            System.out.println(asmuo.getVardas());
        }

        int praktikantuSkaicius = imoneService.getAllPraktikanai(null);
        System.out.println(praktikantuSkaicius);

        List<Asmuo> darbuotojaiIsKaunoByPavarde = imoneService.getSamdomiDarbuotojaiIsKaunoSortedByPavarde(personalas);
        for(Asmuo asmuo:darbuotojaiIsKaunoByPavarde){
            System.out.println(asmuo.getVardas());
        }
        List<Asmuo> samdomiDarbuotojaiByPavarde = imoneService.getSamdomiDarbuotojaiByPavarde(personalas);
        for(Asmuo asmuo:samdomiDarbuotojaiByPavarde){
            System.out.println(asmuo.getPavarde());
        }
    }
}
