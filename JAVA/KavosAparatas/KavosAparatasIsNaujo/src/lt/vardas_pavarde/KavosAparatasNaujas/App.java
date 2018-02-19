package lt.vardas_pavarde.KavosAparatasNaujas;

import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        KavosAparatas kavosAparatas = new KavosAparatas();
        kavosAparatas.kavuPasirinkimas.setPradinesKavosRusys();
        while (run) {
            print("1. Pasirinkti kava ");
            print("2. Prideti kavos recepta");
            print("3. Istrinti kavos recepta");
            print("4. Papildyti produktu");
            print("5. Atlikti plovima");
            print("6. Pateikti produktu kiekiu informacija");
            print("0. Iseiti ");
            int menu = scanner.nextInt();
            switch (menu) {
                case 0:
                    run = false;
                    break;
                case 1:
                    try {
                        System.out.println("Pasirinkite kava is saraso:");
                        kavosAparatas.kavuPasirinkimas.printKavuPavadinimai();
                        menu = scanner.nextInt();
                        kavosAparatas.padarytiKava(menu);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }

                    break;
                case 2:
                    print("Iveskite kavos pavadinima:");
                    String name = scanner.next();
                    print("Iveskite kiek kavai reikia cukraus:");
                    int cukrus = scanner.nextInt();
                    print("Iveskite kiek kavai reikia kavos pupeliu:");
                    int kavosPupeles = scanner.nextInt();
                    print("Iveskite kiek kavai reikia vandens:");
                    int vanduo = scanner.nextInt();
                    kavosAparatas.kavuPasirinkimas.pridetiKavosRecepta(name, cukrus, kavosPupeles, vanduo);
                    break;
                case 3:
                    try {
                        kavosAparatas.kavuPasirinkimas.printKavuPavadinimai();
                        print("Pasirinkite kavos indeksa, kuria norite istrinti:");
                        int index = scanner.nextInt();
                        kavosAparatas.kavuPasirinkimas.istrintiKavosRecepta(index);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case 4:
                    kavosAparatas.papildytiProduktus();

                    break;
                case 5:
                    kavosAparatas.atliktiPlovima();
                    break;
                case 6:
                    kavosAparatas.printProduktuInfo();
                    break;

            }

        }

    }

    private static void print(String str) {
        System.out.println(str);
    }
}
