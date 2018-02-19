package lt.Vardas_pavarde.Autonuoma;

import lt.Vardas_pavarde.Autonuoma.Services.NuomosService;
import lt.Vardas_pavarde.Autonuoma.beans.Automobilis;
import lt.Vardas_pavarde.Autonuoma.beans.KrovininisAutomobilis;
import lt.Vardas_pavarde.Autonuoma.beans.Motociklas;
import lt.Vardas_pavarde.Autonuoma.beans.TransportoPriemone;

import java.util.List;

public class App {
    public static void main(String[] args) {
        NuomosService nuomosService = new NuomosService();
        List<TransportoPriemone> transportoPriemones = nuomosService.getTransportoPriemones();

        Automobilis greiciausiasAutomobilis = nuomosService.spausdinaGreiciausiaAutomobili(transportoPriemones);
        System.out.println(greiciausiasAutomobilis.getMaxGreitis());

        TransportoPriemone pigiausiaTransportoPriemone = nuomosService.pigiausiaTPSuMaziausiaRida(transportoPriemones);
        System.out.println(pigiausiaTransportoPriemone.getValstNr());

        List<KrovininisAutomobilis> laisviKrovininiaiAutomobiliai = nuomosService.laisviKrovininiaiAutomobiliai(transportoPriemones);
        for(KrovininisAutomobilis krovininisAutomobilis:laisviKrovininiaiAutomobiliai){
            System.out.println(krovininisAutomobilis.getValstNr());
        }
        Motociklas greiciausiasMotociklasPaaugliams = nuomosService.greiciausiasMotociklasPaaugliams(transportoPriemones);
        System.out.println(greiciausiasMotociklasPaaugliams.getValstNr());

    }
}
