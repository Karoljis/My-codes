package lt.vardas_pavarde.kavos_aparatas;

public class KavuPasirinkimas {


    public Receptas[] getKavuRusys() {
        return new Receptas[]{
                new Receptas("Juoda kava", 20, 50, 100),
                new Receptas("Balta kava", 20, 20, 100),
                new Receptas("Kapucino", 30, 10, 100)

        };


    }
}
