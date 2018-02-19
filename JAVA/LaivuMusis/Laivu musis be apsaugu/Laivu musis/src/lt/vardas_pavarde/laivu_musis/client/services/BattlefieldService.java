package lt.vardas_pavarde.laivu_musis.client.services;

import lt.vardas_pavarde.laivu_musis.client.beans.Battlefield;

public class BattlefieldService {

    public String[][] createBattlefield(String[] xAsis, String[] yAsis) {
        String[][] rezultatas = new String[10][10];
        for (int i = 0; i < rezultatas.length; i++) {
            for (int j = 0; j < rezultatas[0].length; j++) {
                rezultatas[i][j] = yAsis[j] + xAsis[i];
            }
        }

        return rezultatas;
    }

    public String createShip(String[][] str, String strg) {
        StringBuilder sb = new StringBuilder();
        String element1 = strg.substring(0, 2);
        String element2 = strg.substring(3, 5);
        Integer[] element1Index = new Integer[2];
        Integer[] element2Index = new Integer[2];

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length; j++) {
                if (str[i][j].equals(element1)) {
                    element1Index[0] = i;
                    element1Index[1] = j;
                }
                if (str[i][j].equals(element2)) {
                    element2Index[0] = i;
                    element2Index[1] = j;
                }
            }
        }

        if (element1Index[0].equals(element2Index[0])) {
            String[] vienodiSkaiciai = new String[element2Index[1] + 1 - element1Index[1]];
            if (vienodiSkaiciai.length == 4) {
                vienodiSkaiciai[0] = str[element1Index[0]][element1Index[1]];
                vienodiSkaiciai[1] = str[element1Index[0]][element1Index[1] + 1];
                vienodiSkaiciai[2] = str[element1Index[0]][element1Index[1] + 2];
                vienodiSkaiciai[3] = str[element1Index[0]][element2Index[1]];
            }
            if (vienodiSkaiciai.length == 3) {
                vienodiSkaiciai[0] = str[element1Index[0]][element1Index[1]];
                vienodiSkaiciai[1] = str[element1Index[0]][element1Index[1] + 1];
                vienodiSkaiciai[2] = str[element1Index[0]][element2Index[1]];
            }
            if (vienodiSkaiciai.length == 2) {
                vienodiSkaiciai[0] = str[element1Index[0]][element1Index[1]];
                vienodiSkaiciai[1] = str[element1Index[0]][element2Index[1]];

            }
            if (vienodiSkaiciai.length == 1) {
                vienodiSkaiciai[0] = str[element1Index[0]][element1Index[1]];
            }

            for (int i = 0; i < vienodiSkaiciai.length; i++) {
                sb.append(vienodiSkaiciai[i]);
            }
            strg = sb.toString();

        }
        if (element1Index[1].equals(element2Index[1])) {
            for (int i = element1Index[0]; i <= element2Index[0]; i++) {
                sb.append(strg.substring(0, 1)).append(i);
            }
            strg = sb.toString();
        }

        return strg;
    }

    public String[][] createBattlefieldWithShips(String[][] str, String input) {
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
                        str[i][j] = "# ";
                    }
            }
        }
        return str;
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
}
