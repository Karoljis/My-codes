package lt.vardas_pavarde.kavos_aparatas;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            print("1. Išsirinkite kavą");
            print("2. Papildyti produktų");
            print("3. Atlikti plovimą");
            print("4. Pateikti produktų kiekių informaciją");
            print("0 . Išeiti");

            int menu = scanner.nextInt();
            KavosAparatas kavosAparatas = new KavosAparatas();

            switch (menu) {
                case 0:
                    run = false;
                    break;
                case 1:
                    for(int i=0;i<kavosAparatas.gautiReceptus().length;i++){
                        System.out.println(i+ ") "+kavosAparatas.gautiReceptus()[i].getName());
                    }
                    int kavaPicked = scanner.nextInt();
                    try{
                        kavosAparatas.padarykGerima(kavaPicked);
                    }catch(Exception e){
                        print(e.getMessage());
                }


                    break;
                case 2:
                    kavosAparatas.papildytiProduktus();
                    break;
                case 3:
                    kavosAparatas.plovimas();
                    break;
                case 4:
                    kavosAparatas.produktuKiekiai();
                    break;

            }

        }


        scanner.close();
    }

    public static void print(String str) {
        System.out.println(str);
    }
}
