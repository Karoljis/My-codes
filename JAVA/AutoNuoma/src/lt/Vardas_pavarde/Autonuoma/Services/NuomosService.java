package lt.Vardas_pavarde.Autonuoma.Services;

import lt.Vardas_pavarde.Autonuoma.beans.*;

import java.util.ArrayList;
import java.util.List;

public class NuomosService {
    public List<TransportoPriemone> getTransportoPriemones() {
        List<TransportoPriemone> transportoPriemones = new ArrayList<>();
        TransportoPriemone transportoPriemone = new Motociklas("MOT123", 101110, 50, false, MotocikloTipas.PATYRUSIEMS, 1800, 250);
        transportoPriemones.add(transportoPriemone);
        transportoPriemone = new Motociklas("MOT456", 17000, 50, false, MotocikloTipas.PAAUGLIAMS, 1200, 150);
        transportoPriemones.add(transportoPriemone);
        transportoPriemone = new Motociklas("MOT678", 100600, 120, true, MotocikloTipas.PAAUGLIAMS, 1000, 160);
        transportoPriemones.add(transportoPriemone);
        transportoPriemone = new KrovininisAutomobilis("AUT001", 16000, 50, false, 1900, 3000, "C", KrovininioAutobusoTipas.DIDELIS);
        transportoPriemones.add(transportoPriemone);
        transportoPriemone = new KrovininisAutomobilis("AUT100", 160000, 220, false, 2200, 3500, "B", KrovininioAutobusoTipas.DIDELIS);
        transportoPriemones.add(transportoPriemone);
        transportoPriemone = new KrovininisAutomobilis("AUT200", 60000, 250, false, 2200, 1000, "B", KrovininioAutobusoTipas.MAZAS);
        transportoPriemones.add(transportoPriemone);
        transportoPriemone = new Automobilis("MAS111", 200000, 50, false, 220, 5, "Automatine", AutomobilioTipas.VIDUTINIS);
        transportoPriemones.add(transportoPriemone);
        transportoPriemone = new Automobilis("MAS345", 100000, 350, false, 300, 4, "Mechanine", AutomobilioTipas.MAZAS);
        transportoPriemones.add(transportoPriemone);
        transportoPriemone = new Automobilis("MAS567", 80000, 600, false, 180, 2, "Automatine", AutomobilioTipas.SUPERCAR);
        transportoPriemones.add(transportoPriemone);

        return transportoPriemones;
    }

    public Automobilis spausdinaGreiciausiaAutomobili(List<TransportoPriemone> transportoPriemones) {
        Automobilis rezultatas = new Automobilis();
        int maxGreitis = Integer.MIN_VALUE;
        for (TransportoPriemone transportoPriemone : transportoPriemones) {
            if (transportoPriemone instanceof Automobilis) {
                Automobilis automobilis = (Automobilis) transportoPriemone;
                if (maxGreitis < automobilis.getMaxGreitis()) {
                    rezultatas = automobilis;
                    maxGreitis = automobilis.getMaxGreitis();
                }
            }
        }
        return rezultatas;
    }

    public TransportoPriemone pigiausiaTPSuMaziausiaRida(List<TransportoPriemone> transportoPriemones){
        if(transportoPriemones == null || transportoPriemones.size()==0){
            return null;

        }
        TransportoPriemone result = transportoPriemones.get(0);
        for(int i=0;i<transportoPriemones.size();i++){
            TransportoPriemone tp = transportoPriemones.get(i);
            if((tp.getParosKaina()<result.getParosKaina()) || (tp.getParosKaina()==result.getParosKaina() && tp.getRida()<result.getRida())){
                result = tp;
            }
        }
        return result;

    }

    public List<KrovininisAutomobilis> laisviKrovininiaiAutomobiliai(List<TransportoPriemone> transportoPriemones){
        List<KrovininisAutomobilis> result = new ArrayList<>();
        for(TransportoPriemone transportoPriemone:transportoPriemones){
            if(transportoPriemone instanceof KrovininisAutomobilis){
                KrovininisAutomobilis krovininisAutomobilis = (KrovininisAutomobilis)transportoPriemone;
                if(krovininisAutomobilis.getVairuotojoKategorija().equals("B") && !krovininisAutomobilis.isArSiuoMetuIsnuomotas()){
                    result.add(krovininisAutomobilis);
                }
            }
        }


        return result;
    }

    public Motociklas greiciausiasMotociklasPaaugliams(List<TransportoPriemone> transportoPriemones){
        Motociklas rezultatas = new Motociklas();
        int maxSpeed = Integer.MIN_VALUE;
        for(TransportoPriemone transportoPriemone:transportoPriemones){
            if(transportoPriemone instanceof Motociklas){
                Motociklas motociklas = (Motociklas)transportoPriemone;
                if(motociklas.getMotocikloTipas().equals(MotocikloTipas.PAAUGLIAMS)&& maxSpeed<motociklas.getMaxGreitis()){
                    rezultatas=motociklas;
                    maxSpeed=motociklas.getMaxGreitis();
                }
            }
        }
        return rezultatas;
    }
}
