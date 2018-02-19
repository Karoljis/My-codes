package lt.Vardas_pavarde.Autonuoma.beans;

public class AutomobilioTipas {
    public static final AutomobilioTipas MAZAS = new AutomobilioTipas("Mazas");
    public static final AutomobilioTipas VIDUTINIS = new AutomobilioTipas("Vidutinis");
    public static final AutomobilioTipas DIDELIS = new AutomobilioTipas("Didelis");
    public static final AutomobilioTipas SUPERCAR = new AutomobilioTipas("Supercar");

    String automobilioTipas;
   private AutomobilioTipas (String automobilioTipas){
        this.automobilioTipas = automobilioTipas;
    }
}
