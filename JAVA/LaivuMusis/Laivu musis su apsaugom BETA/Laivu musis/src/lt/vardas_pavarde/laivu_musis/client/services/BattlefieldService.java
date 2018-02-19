package lt.vardas_pavarde.laivu_musis.client.services;

import lt.vardas_pavarde.laivu_musis.client.beans.Battlefield;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattlefieldService {
//TODO sita i atskira klase pabandyti ir pakeisti mazesnia apimtimi
    private List<String> negalimosVietosLaivams = new ArrayList<>();

    public String[][] createBattlefield(String[] xAsis, String[] yAsis) {
        String[][] rezultatas = new String[10][10];
        for (int i = 0; i < rezultatas.length; i++) {
            for (int j = 0; j < rezultatas[0].length; j++) {
                rezultatas[i][j] = yAsis[j] + xAsis[i];
            }
        }
        return rezultatas;
    }

    public String createKeturvietiLaiva(String[][] str, String shipCoordinate) {
        if (negalimosVietosLaivams.size() > 0) {
            negalimosVietosLaivams.clear();
        }

        if (shipCoordinate.length() != 5 || !shipCoordinate.substring(2, 3).equals("-")) {
            printExceptionBlogosKoordinates();
        }
        String element1Letter = shipCoordinate.substring(0, 1);
        String element1Number = shipCoordinate.substring(1, 2);
        String element2Letter = shipCoordinate.substring(3, 4);
        String element2Number = shipCoordinate.substring(4, 5);

        List<String> xAsiesSkaiciai = Arrays.asList(Battlefield.getxAsis());
        List<String> yAsiesRaides = Arrays.asList(Battlefield.getyAsis());
        String[] keturviecioKoordinates = new String[4];
        StringBuilder sb = new StringBuilder();

        if (xAsiesSkaiciai.contains(element1Number) && xAsiesSkaiciai.contains(element2Number) &&
                yAsiesRaides.contains(element1Letter) && yAsiesRaides.contains(element2Letter)) {
            if (element1Letter.equals(element2Letter)) {
                if ((xAsiesSkaiciai.indexOf(element2Number) + 1 - xAsiesSkaiciai.indexOf(element1Number) != 4) || !element1Letter.equals(element2Letter)) {
                    printExceptionBlogosKoordinates();
                } else {
                    keturviecioKoordinates[0] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter)];
                    keturviecioKoordinates[1] = str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)];
                    keturviecioKoordinates[2] = str[xAsiesSkaiciai.indexOf(element1Number) + 2][yAsiesRaides.indexOf(element1Letter)];
                    keturviecioKoordinates[3] = str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter)];
                    switch (keturviecioKoordinates[0]) {
                        case "K0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 2][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            break;
                        case "I0":
                        case "L0":
                        case "O0":
                        case "M0":
                        case "E0":
                        case "T0":
                        case "R0":
                        case "A0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 2][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 2][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "K1":
                        case "K2":
                        case "K3":
                        case "K4":
                        case "K5":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 2][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            break;
                        case "K6":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 2][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            break;
                        case "I6":
                        case "L6":
                        case "O6":
                        case "M6":
                        case "E6":
                        case "T6":
                        case "R6":
                        case "A6":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 2][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 2][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "S0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 2][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "S1":
                        case "S2":
                        case "S3":
                        case "S4":
                        case "S5":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 2][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "S6":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 2][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        default:
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 2][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 2][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                    }
                }
            } else {
                if ((yAsiesRaides.indexOf(element2Letter) + 1 - yAsiesRaides.indexOf(element1Letter) != 4) || !element1Number.equals(element2Number)) {
                    printExceptionBlogosKoordinates();
                } else {
                    keturviecioKoordinates[0] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter)];
                    keturviecioKoordinates[1] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1];
                    keturviecioKoordinates[2] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 2];
                    keturviecioKoordinates[3] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element2Letter)];
                    switch (keturviecioKoordinates[0]) {
                        case "K0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "K1":
                        case "K2":
                        case "K3":
                        case "K4":
                        case "K5":
                        case "K6":
                        case "K7":
                        case "K8":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) - 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            break;
                        case "I0":
                        case "L0":
                        case "O0":
                        case "M0":
                        case "E0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "T0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            break;
                        case "T1":
                        case "T2":
                        case "T3":
                        case "T4":
                        case "T5":
                        case "T6":
                        case "T7":
                        case "T8":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) - 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "K9":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "I9":
                        case "L9":
                        case "O9":
                        case "M9":
                        case "E9":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "T9":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            break;
                        default:
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) - 2]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                    }
                }
            }
            for (String koordinate : keturviecioKoordinates) {
                sb.append(koordinate);
            }
            shipCoordinate = sb.toString();
        } else {
            printExceptionBlogosKoordinates();
        }
        return shipCoordinate;
    }

    public String createTrivietiLaiva(String[][] str, String shipCoordinate) {
        if (shipCoordinate.length() != 5 || !shipCoordinate.substring(2, 3).equals("-")) {
            printExceptionBlogosKoordinates();
        }
        String element1Letter = shipCoordinate.substring(0, 1);
        String element1Number = shipCoordinate.substring(1, 2);
        String element2Letter = shipCoordinate.substring(3, 4);
        String element2Number = shipCoordinate.substring(4, 5);

        List<String> xAsiesSkaiciai = Arrays.asList(Battlefield.getxAsis());
        List<String> yAsiesRaides = Arrays.asList(Battlefield.getyAsis());
        String[] triviecioKoordinates = new String[3];
        StringBuilder sb = new StringBuilder();

        if (xAsiesSkaiciai.contains(element1Number) && xAsiesSkaiciai.contains(element2Number) &&
                yAsiesRaides.contains(element1Letter) && yAsiesRaides.contains(element2Letter)) {
            if (element1Letter.equals(element2Letter)) {
                if ((xAsiesSkaiciai.indexOf(element2Number) + 1 - xAsiesSkaiciai.indexOf(element1Number) != 3) || !element1Letter.equals(element2Letter)) {
                    printExceptionBlogosKoordinates();
                } else {
                    triviecioKoordinates[0] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter)];
                    triviecioKoordinates[1] = str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)];
                    triviecioKoordinates[2] = str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter)];

                    for (String koordinate : triviecioKoordinates) {
                        if (koordinate.equals("--")) {
                            printExceptionNegalimasCiaLaivas();
                        } else if (negalimosVietosLaivams.contains(koordinate)) {
                            printExceptionNegalimasCiaLaivas();
                        }
                    }
                    switch (triviecioKoordinates[0]) {
                        case "K0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            break;
                        case "I0":
                        case "L0":
                        case "O0":
                        case "M0":
                        case "E0":
                        case "T0":
                        case "R0":
                        case "A0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "K1":
                        case "K2":
                        case "K3":
                        case "K4":
                        case "K5":
                        case "K6":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            break;
                        case "K7":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            break;
                        case "I7":
                        case "L7":
                        case "O7":
                        case "M7":
                        case "E7":
                        case "T7":
                        case "R7":
                        case "A7":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "S0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "S1":
                        case "S2":
                        case "S3":
                        case "S4":
                        case "S5":
                        case "S6":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "S7":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        default:
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                    }
                }
            } else {
                if ((yAsiesRaides.indexOf(element2Letter) + 1 - yAsiesRaides.indexOf(element1Letter) != 3) || !element1Number.equals(element2Number)) {
                    printExceptionBlogosKoordinates();
                } else {
                    triviecioKoordinates[0] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter)];
                    triviecioKoordinates[1] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1];
                    triviecioKoordinates[2] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element2Letter)];

                    for (String koordinate : triviecioKoordinates) {
                        if (koordinate.equals("--")) {
                            printExceptionNegalimasCiaLaivas();
                        } else if (negalimosVietosLaivams.contains(koordinate)) {
                            printExceptionNegalimasCiaLaivas();
                        }
                    }
                    switch (triviecioKoordinates[0]) {
                        case "K0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "K1":
                        case "K2":
                        case "K3":
                        case "K4":
                        case "K5":
                        case "K6":
                        case "K7":
                        case "K8":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            break;
                        case "I0":
                        case "L0":
                        case "O0":
                        case "M0":
                        case "E0":
                        case "T0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "R0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            break;
                        case "R1":
                        case "R2":
                        case "R3":
                        case "R4":
                        case "R5":
                        case "R6":
                        case "R7":
                        case "R8":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "K9":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "I9":
                        case "L9":
                        case "O9":
                        case "M9":
                        case "E9":
                        case "T9":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "R9":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            break;
                        default:
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                    }
                }
            }
            for (String koordinate : triviecioKoordinates) {
                sb.append(koordinate);
            }
            shipCoordinate = sb.toString();
        } else {
            printExceptionBlogosKoordinates();
        }
        return shipCoordinate;
    }

    public String createDvivietiLaiva(String[][] str, String shipCoordinate) {
        if (shipCoordinate.length() != 5 || !shipCoordinate.substring(2, 3).equals("-")) {
            printExceptionBlogosKoordinates();
        }
        String element1Letter = shipCoordinate.substring(0, 1);
        String element1Number = shipCoordinate.substring(1, 2);
        String element2Letter = shipCoordinate.substring(3, 4);
        String element2Number = shipCoordinate.substring(4, 5);

        List<String> xAsiesSkaiciai = Arrays.asList(Battlefield.getxAsis());
        List<String> yAsiesRaides = Arrays.asList(Battlefield.getyAsis());
        String[] dviviecioKoordinates = new String[2];
        StringBuilder sb = new StringBuilder();

        if (xAsiesSkaiciai.contains(element1Number) && xAsiesSkaiciai.contains(element2Number) &&
                yAsiesRaides.contains(element1Letter) && yAsiesRaides.contains(element2Letter)) {
            if (element1Letter.equals(element2Letter)) {
                if ((xAsiesSkaiciai.indexOf(element2Number) + 1 - xAsiesSkaiciai.indexOf(element1Number) != 2) || !element1Letter.equals(element2Letter)) {
                    printExceptionBlogosKoordinates();
                } else {
                    dviviecioKoordinates[0] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter)];
                    dviviecioKoordinates[1] = str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter)];

                    for (String koordinate : dviviecioKoordinates) {
                        if (koordinate.equals("--")) {
                            printExceptionNegalimasCiaLaivas();
                        } else if (negalimosVietosLaivams.contains(koordinate)) {
                            printExceptionNegalimasCiaLaivas();
                        }
                    }
                    switch (dviviecioKoordinates[0]) {

                        case "K0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            break;
                        case "I0":
                        case "L0":
                        case "O0":
                        case "M0":
                        case "E0":
                        case "T0":
                        case "R0":
                        case "A0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "K1":
                        case "K2":
                        case "K3":
                        case "K4":
                        case "K5":
                        case "K6":
                        case "K7":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            break;
                        case "K8":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "I8":
                        case "L8":
                        case "O8":
                        case "M8":
                        case "E8":
                        case "T8":
                        case "R8":
                        case "A8":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "S0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "S1":
                        case "S2":
                        case "S3":
                        case "S4":
                        case "S5":
                        case "S6":
                        case "S7":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "S8":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        default:
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                    }
                }
            } else {
                if ((yAsiesRaides.indexOf(element2Letter) + 1 - yAsiesRaides.indexOf(element1Letter) != 2) || !element1Number.equals(element2Number)) {
                    printExceptionBlogosKoordinates();
                } else {
                    dviviecioKoordinates[0] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter)];
                    dviviecioKoordinates[1] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element2Letter)];

                    for (String koordinate : dviviecioKoordinates) {
                        if (koordinate.equals("--")) {
                            printExceptionNegalimasCiaLaivas();
                        } else if (negalimosVietosLaivams.contains(koordinate)) {
                            printExceptionNegalimasCiaLaivas();
                        }
                    }
                    switch (dviviecioKoordinates[0]) {
                        case "K0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            break;
                        case "K1":
                        case "K2":
                        case "K3":
                        case "K4":
                        case "K5":
                        case "K6":
                        case "K7":
                        case "K8":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            break;
                        case "I0":
                        case "L0":
                        case "O0":
                        case "M0":
                        case "E0":
                        case "T0":
                        case "R0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "A0":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "A1":
                        case "A2":
                        case "A3":
                        case "A4":
                        case "A5":
                        case "A6":
                        case "A7":
                        case "A8":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            break;
                        case "K9":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "I9":
                        case "L9":
                        case "O9":
                        case "M9":
                        case "E9":
                        case "T9":
                        case "R9":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            break;
                        case "A9":
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            break;
                        default:
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) - 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter) + 1]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element2Number) + 1][yAsiesRaides.indexOf(element2Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                            negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                    }
                }
            }
            for (String koordinate : dviviecioKoordinates) {
                sb.append(koordinate);
            }
            shipCoordinate = sb.toString();

        } else {
            printExceptionBlogosKoordinates();
        }
        return shipCoordinate;

    }

    public String createVienvietiLaiva(String[][] str, String shipCoordinate) {
        if (shipCoordinate.length() != 5 || !shipCoordinate.substring(2, 3).equals("-")) {
            printExceptionBlogosKoordinates();
        }
        String element1Letter = shipCoordinate.substring(0, 1);
        String element1Number = shipCoordinate.substring(1, 2);
        String element2Letter = shipCoordinate.substring(3, 4);
        String element2Number = shipCoordinate.substring(4, 5);

        List<String> xAsiesSkaiciai = Arrays.asList(Battlefield.getxAsis());
        List<String> yAsiesRaides = Arrays.asList(Battlefield.getyAsis());
        String[] vienviecioKoordinates = new String[2];
        StringBuilder sb = new StringBuilder();

        if (xAsiesSkaiciai.contains(element1Number) && xAsiesSkaiciai.contains(element2Number) &&
                yAsiesRaides.contains(element1Letter) && yAsiesRaides.contains(element2Letter)) {
            if (element1Letter.equals(element2Letter) && element1Number.equals(element2Number)) {

                vienviecioKoordinates[0] = str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter)];
                vienviecioKoordinates[1] = str[xAsiesSkaiciai.indexOf(element2Number)][yAsiesRaides.indexOf(element1Letter)];
                for (String koordinate : vienviecioKoordinates) {
                    if (koordinate.equals("--")) {
                        printExceptionNegalimasCiaLaivas();
                    } else if (negalimosVietosLaivams.contains(koordinate)) {
                        printExceptionNegalimasCiaLaivas();
                    }
                }
                switch (vienviecioKoordinates[0]) {
                    case "K0":
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                        break;
                    case "K1":
                    case "K2":
                    case "K3":
                    case "K4":
                    case "K5":
                    case "K6":
                    case "K7":
                    case "K8":
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                        break;
                    case "I0":
                    case "L0":
                    case "O0":
                    case "M0":
                    case "E0":
                    case "T0":
                    case "R0":
                    case "A0":
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                        break;
                    case "S0":
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                        break;
                    case "S1":
                    case "S2":
                    case "S3":
                    case "S4":
                    case "S5":
                    case "S6":
                    case "S7":
                    case "S8":
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                        break;
                    case "K9":
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                        break;
                    case "I9":
                    case "L9":
                    case "O9":
                    case "M9":
                    case "E9":
                    case "T9":
                    case "R9":
                    case "A9":
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                        break;
                    case "S9":
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                        break;
                    default:
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter)]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) + 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter)]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) + 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number)][yAsiesRaides.indexOf(element1Letter) - 1]);
                        negalimosVietosLaivams.add(str[xAsiesSkaiciai.indexOf(element1Number) - 1][yAsiesRaides.indexOf(element1Letter) - 1]);
                }
            } else {
                printExceptionBlogosKoordinates();

            }
            for (String koordinate : vienviecioKoordinates) {
                sb.append(koordinate);
            }
            shipCoordinate = sb.toString();

        } else {
            printExceptionBlogosKoordinates();
        }
        return shipCoordinate;
    }

    public void createBattlefieldWithShips(String[][] str, String input) {
        int shipLong = input.length() / 2;
        String[] laivas = new String[shipLong];
        if (shipLong == 4) {
            laivas[0] = input.substring(0, 2);
            laivas[1] = input.substring(2, 4);
            laivas[2] = input.substring(4, 6);
            laivas[3] = input.substring(6, 8);
        }
        if (shipLong == 3) {
            laivas[0] = input.substring(0, 2);
            laivas[1] = input.substring(2, 4);
            laivas[2] = input.substring(4, 6);
        }
        if (shipLong == 2) {
            laivas[0] = input.substring(0, 2);
            laivas[1] = input.substring(2, 4);
        }
        if (shipLong == 1) {
            laivas[0] = input.substring(0, 2);
        }
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length; j++) {
                for (int k = 0; k < shipLong; k++)
                    if (str[i][j].equals(laivas[k])) {
                        str[i][j] = "--";
                    }
            }
        }

    }

    public void printBattleField(String[][] masyvas) {
        for (int i = 0; i < masyvas.length; i++) {
            System.out.print("  " + Battlefield.getyAsis()[i]);
        }
        System.out.println();
        for (int i = 0; i < masyvas.length; i++) {
            System.out.print(Battlefield.getxAsis()[i] + " ");
            for (int j = 0; j < masyvas[0].length; j++) {
                System.out.print(masyvas[i][j] + " ");

            }
            System.out.println();
        }
    }

    private static void printExceptionBlogosKoordinates() {
        throw new RuntimeException("Blogai įvestos koordinatės!");
    }

    private static void printExceptionNegalimasCiaLaivas() {
        throw new RuntimeException("Šioje vietoje laivas negalimas!");
    }
}
