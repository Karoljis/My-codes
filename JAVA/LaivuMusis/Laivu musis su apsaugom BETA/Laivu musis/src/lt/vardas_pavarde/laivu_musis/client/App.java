package lt.vardas_pavarde.laivu_musis.client;

import lt.vardas_pavarde.laivu_musis.client.beans.*;
import lt.vardas_pavarde.laivu_musis.client.services.BattlefieldService;
import lt.vardas_pavarde.laivu_musis.client.services.GameServiceImpl;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String READY_FOR_SECOND_PLAYER = "READY_FOR_SECOND_PLAYER";
    private static final String READY_FOR_SHIPS = "READY_FOR_SHIPS";
    private static final String READY_TO_PLAY = "READY_TO_PLAY";
    private static final String FINISHED = "FINISHED";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        BattlefieldService battlefieldService = new BattlefieldService();
        GameServiceImpl gameService = new GameServiceImpl();
        String[][] createdBattlefield = new String[10][10];
        String[][] createdBattlefieldForShooting = battlefieldService.createBattlefield(Battlefield.getxAsis(), Battlefield.getyAsis());
        StringBuilder shipsPosition = new StringBuilder();
        TakenShoots takenShoots = new TakenShoots();
        List<String> xAsiesSkaiciai = Arrays.asList(Battlefield.getxAsis());
        List<String> yAsiesRaides = Arrays.asList(Battlefield.getyAsis());

        boolean run = true;
        while (run) {
            print("1. Sukurkite laivus");
            print("2. Prisijungti į žaidimą ");
            print("0. Išeiti");
            String menu = scanner.next();
            switch (menu) {
                case "1":
                    createdBattlefield = battlefieldService.createBattlefield(Battlefield.getxAsis(), Battlefield.getyAsis());
                    if (shipsPosition.length() > 0) {
                        shipsPosition.delete(0, shipsPosition.length());
                    }
                    int countKeturvietis = 0;
                    while (countKeturvietis < 1) {
                        try {
                            System.out.println();
                            battlefieldService.printBattleField(createdBattlefield);
                            System.out.println("Sukurkite vieną keturvietį laivą. Įveskite jo pradžios ir pabaigos koordinates, pvz: (K1-K4), (I1-M1) ir pan.");
                            String laivas = scanner.next().toUpperCase();
                            String ship = battlefieldService.createKeturvietiLaiva(createdBattlefield, laivas);
                            battlefieldService.createBattlefieldWithShips(createdBattlefield, ship);
                            shipsPosition.append(laivas).append("!");
                            countKeturvietis++;
                        } catch (Exception e) {
                            print(e.getMessage());
                            Thread.sleep(1500);
                        }
                    }
                    int countTrivietis = 0;
                    while (countTrivietis < 2) {
                        try {
                            System.out.println();
                            battlefieldService.printBattleField(createdBattlefield);
                            System.out.printf("Sukurkite %d trivietį laivą iš dviejų. Įveskite jo pradžios ir pabaigos koordinates, pvz: (K1-K3), (K1-L1) ir pan\n", countTrivietis + 1);
                            String laivas = scanner.next().toUpperCase();
                            String ship = battlefieldService.createTrivietiLaiva(createdBattlefield, laivas);
                            battlefieldService.createBattlefieldWithShips(createdBattlefield, ship);
                            shipsPosition.append(laivas).append("!");
                            countTrivietis++;
                        } catch (Exception e) {
                            print(e.getMessage());
                            Thread.sleep(2000);
                        }
                    }
                    int countDvivietis = 0;
                    while (countDvivietis < 3) {
                        try {
                            System.out.println();
                            battlefieldService.printBattleField(createdBattlefield);
                            System.out.printf("Sukurkite %d dvivietį laivą iš trijų. Įveskite jo pradžios ir pabaigos koordinates, pvz: (K1-K2), (K1-I1) ir pan\n", countDvivietis + 1);
                            String laivas = scanner.next().toUpperCase();
                            String ship = battlefieldService.createDvivietiLaiva(createdBattlefield, laivas);
                            battlefieldService.createBattlefieldWithShips(createdBattlefield, ship);
                            shipsPosition.append(laivas).append("!");
                            countDvivietis++;
                        } catch (Exception e) {
                            print(e.getMessage());
                            Thread.sleep(2000);
                        }
                    }
                    int countVienvietis = 0;
                    while (countVienvietis < 4) {
                        try {
                            System.out.println();
                            battlefieldService.printBattleField(createdBattlefield);
                            System.out.printf("Sukurkite %d vienvietį laivą iš keturių. Įveskite jo pradžios ir pabaigos koordinates, pvz: (K1-K1), (I2-I2) ir pan\n", countVienvietis + 1);
                            String laivas = scanner.next().toUpperCase();
                            String ship = battlefieldService.createVienvietiLaiva(createdBattlefield, laivas);
                            battlefieldService.createBattlefieldWithShips(createdBattlefield, ship);
                            shipsPosition.append(laivas).append("!");
                            countVienvietis++;
                        } catch (Exception e) {
                            print(e.getMessage());
                            Thread.sleep(2000);
                        }
                    }
                    shipsPosition.deleteCharAt(shipsPosition.length() - 1);
                    break;

                case "2":
                    if (shipsPosition.toString().length() > 0) {
                        if (shipsPosition.length() > 0) {

                            User user = gameService.createUser("Vardas", "vardas@gmail.com");
                            Game game = gameService.joinGame(user.getId());
                            while (game.getStatus().equals(READY_FOR_SECOND_PLAYER)) {
                                game = gameService.checkGameStatus(game.getGameId());
                                Thread.sleep(2000);
                            }
                            while (game.getStatus().equals(READY_FOR_SHIPS)) {
                                gameService.setupShips(game.getGameId(), user.getId(), shipsPosition.toString());
                                print("");
                                print("Jūsų išdėstyti laivai: ");
                                battlefieldService.printBattleField(createdBattlefield);
                                print("");
                                print("Tavo spėjimai varžovo laivams nuskandinti:");
                                battlefieldService.printBattleField(createdBattlefieldForShooting);
                                game = gameService.checkGameStatus(game.getGameId());
                                Thread.sleep(2000);
                            }

                            while (game.getStatus().equals(READY_TO_PLAY)) {
                                if (!game.getNextTurnForUserId().equals(user.getId())) {
                                    print("Palaukite, kol varžovas atliks ėjimą:");
                                    Thread.sleep(2000);
                                    game = gameService.checkGameStatus(game.getGameId());
                                } else if (game.getNextTurnForUserId().equals(user.getId())) {
                                    print("Įveskite spėjimą, kur yra varžovo laivas:");
                                    String spejimas = scanner.next().toUpperCase();
                                    String shootLetter = spejimas.substring(0, 1);
                                    String shootNumber = spejimas.substring(1);

                                    try {
                                        if (xAsiesSkaiciai.contains(shootNumber) && yAsiesRaides.contains(shootLetter)) {
                                            if (takenShoots.getTakenShoots().contains(spejimas)) {
                                                throw new RuntimeException("Toks spėjimas jau buvo!");
                                            }
                                        } else {
                                            throw new RuntimeException("Blogai įvesta koordinatė!");
                                        }
                                        game = gameService.takeShoot(game.getGameId(), user.getId(), spejimas);
                                        takenShoots.setTakenShoots(spejimas);
                                    } catch (Exception e) {
                                        print(e.getMessage());
                                        Thread.sleep(2000);
                                    }
                                }
                                for (GameData gameData : game.getEvents()) {
                                    if (!gameData.getUserId().equals(user.getId())) {
                                        if (!gameData.getHit()) {
                                            createdBattlefield[xAsiesSkaiciai.indexOf(gameData.getCoordinate().substring(1,2))]
                                                [yAsiesRaides.indexOf(gameData.getCoordinate().substring(0,1))]= "  ";
                                        }
                                        if (gameData.getHit()) {
                                            createdBattlefield[xAsiesSkaiciai.indexOf(gameData.getCoordinate().substring(1,2))]
                                                    [yAsiesRaides.indexOf(gameData.getCoordinate().substring(0,1))]= "@@";
                                        }
                                    } else if (gameData.getUserId().equals(user.getId())) {
                                        if (!gameData.getHit()) {
                                            createdBattlefieldForShooting[xAsiesSkaiciai.indexOf(gameData.getCoordinate().substring(1,2))]
                                                    [yAsiesRaides.indexOf(gameData.getCoordinate().substring(0,1))]= "  ";
                                        }
                                        if (gameData.getHit()) {
                                            createdBattlefieldForShooting[xAsiesSkaiciai.indexOf(gameData.getCoordinate().substring(1,2))]
                                                    [yAsiesRaides.indexOf(gameData.getCoordinate().substring(0,1))]= "@@";
                                        }
                                    }
                                }
                                print("");
                                print("Tavo laivų išdėstymas ir varžovo spėjimai: ");
                                battlefieldService.printBattleField(createdBattlefield);
                                print("");
                                print("Tavo spėjimai ir varžovo laivų išdėstymas: ");
                                battlefieldService.printBattleField(createdBattlefieldForShooting);
                            }
                            if (game.getStatus().equals(FINISHED)) {
                                if (game.getWinnerUserId().equals(user.getId())) {
                                    System.out.println("Sveikiname laimėjus !");
                                } else {
                                    System.out.println("Sveikiname užėmus antrą vietą!");
                                }
                                Thread.sleep(3000);
                                continue;
                            }
                        }
                    } else {
                        System.out.println("Iš pradžių turite sukurti laivus!");
                        Thread.sleep(1000);
                        continue;
                    }
                case "0":
                    run = false;
                    break;
            }
        }
    }

    private static void print(String str) {
        System.out.println(str);
    }
}
