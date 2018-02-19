
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        PointAction pointAction = new PointAction();


        while (run) {
            print("1. Atspausdinti tasku sarasa");
            print("2. Pridėti taska");
            print("3. Istrinti taska");
            print("4. Apskaiciuoti atstuma tarp tasku");
            print("5. Kuriame ketvirtyje yra taskas");
            print("6. Ar taškai yra viename ketvirtyje");
            print("7. Issaugoti tasku koordinates byloje");
            print("0. Iseiti");
            int menuPick = scanner.nextInt();

            switch (menuPick) {
                case 0:
                    run = false;
                    break;
                case 1:
                    try {
                        pointAction.printTaskus();
                    } catch (Exception e) {
                        print(e.getMessage());
                    }

                    break;

                case 2:
                    print("Iveskite tasko pavadinima:");
                    String nameInput = scanner.next();
                    print("Iveskite tasko x koordinate:");
                    int xInput = scanner.nextInt();
                    print("Iveskite tasko y koordinate:");
                    int yInput = scanner.nextInt();
                    pointAction.pridetiTaska(nameInput, xInput, yInput);

                    break;
                case 3:
                    try {
                        pointAction.printTaskus();
                        print("Pasirinkite tasko indeksa, kuri norite istrinti:");
                        int pIndex = scanner.nextInt();
                        pointAction.istrintiTaska(pIndex);
                    } catch (Exception e) {
                        print(e.getMessage());
                    }

                    break;
                case 4:

                    try {
                        pointAction.printTaskus();
                        print("Pasirinkite pirmo tasko indeksa, kurio atzvilgiu skaiciuosite atstuma tarp tasku:");
                        int pIndex1 = scanner.nextInt();
                        pointAction.printTaskus();
                        print("Pasirinkite antro tasko indeksa, kurio atzvilgiu skaiciuosite atstuma tarp tasku:");
                        int pIndex2 = scanner.nextInt();
                        System.out.println("Atstumas tarp tasku yra: " + pointAction.skaiciuotiAtstumaTarpTasku(pIndex1, pIndex2));

                    } catch (Exception e) {
                        print(e.getMessage());
                    }

                    break;
                case 5:
                    try {
                        pointAction.printTaskus();
                        print("Pasirinkite tasko indeksa, kuriam norite suzinoti, kuriame ketvirtyje jis yra: ");
                        int pIndex = scanner.nextInt();
                        System.out.println("Taskas yra " + pointAction.kurisKetvirtis(pIndex));
                    } catch (Exception e) {
                        print(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        pointAction.printTaskus();
                        print("Pasirinkite pirmo tasko indeksa, kurio ketvirti lyginsime su kito tasko");
                        int pIndex1 = scanner.nextInt();
                        pointAction.printTaskus();
                        print("Pasirinkite antro tasko indeksa, kurio ketvirti lyginsime su kito tasko");
                        int pIndex2 = scanner.nextInt();
                        print(pointAction.ketvirciuLyginimas(pIndex1, pIndex2));
                    } catch (Exception e) {
                        print(e.getMessage());
                    }
                    break;
                case 7:
                    pointAction.saveTaskusFile();
                    break;


            }
        }

        scanner.close();
    }

    private static void print(String str) {
        System.out.println(str);
    }


}
