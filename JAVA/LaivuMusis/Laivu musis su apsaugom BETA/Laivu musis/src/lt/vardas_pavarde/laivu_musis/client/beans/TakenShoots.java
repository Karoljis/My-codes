package lt.vardas_pavarde.laivu_musis.client.beans;

import java.util.ArrayList;
import java.util.List;

public class TakenShoots {
    private List<String> shoots = new ArrayList<>();

    public List<String> getTakenShoots(){
        return shoots;
    }

    public void setTakenShoots(String shoot){
        shoots.add(shoot);
    }
}

