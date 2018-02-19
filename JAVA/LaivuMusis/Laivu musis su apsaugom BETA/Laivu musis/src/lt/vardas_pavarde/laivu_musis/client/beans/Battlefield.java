package lt.vardas_pavarde.laivu_musis.client.beans;


public class Battlefield {

    private static String[] yAsis = {"K", "I", "L", "O", "M", "E", "T", "R", "A", "S"};
    private static String[] xAsis = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static String[] getyAsis() {
        return yAsis;
    }

    public static void setyAsis(String[] yAsis) {
        Battlefield.yAsis = yAsis;
    }

    public static String[] getxAsis() {
        return xAsis;
    }

    public static void setxAsis(String[] xAsis) {
        Battlefield.xAsis = xAsis;
    }


}

