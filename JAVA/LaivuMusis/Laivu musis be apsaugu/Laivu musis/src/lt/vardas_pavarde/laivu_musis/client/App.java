package lt.vardas_pavarde.laivu_musis.client;

import lt.vardas_pavarde.laivu_musis.client.beans.Battlefield;
import lt.vardas_pavarde.laivu_musis.client.beans.Game;
import lt.vardas_pavarde.laivu_musis.client.beans.GameData;
import lt.vardas_pavarde.laivu_musis.client.beans.User;
import lt.vardas_pavarde.laivu_musis.client.services.BattlefieldService;
import lt.vardas_pavarde.laivu_musis.client.services.GameServiceImpl;
import lt.vardas_pavarde.laivu_musis.client.services.GameServiceInterface;

import java.util.Scanner;

public class App {
    private static final String READY_FOR_SECOND_PLAYER = "READY_FOR_SECOND_PLAYER";
    private static final String READY_FOR_SHIPS = "READY_FOR_SHIPS";
    private static final String READY_TO_PLAY = "READY_TO_PLAY";
    private static final String FINISHED = "FINISHED";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        BattlefieldService battlefieldService = new BattlefieldService();
        GameServiceImpl gameService2 = new GameServiceImpl();
        String[][] createdBattlefield = battlefieldService.createBattlefield(Battlefield.getxAsis(), Battlefield.getyAsis());
        String[][] createdBattlefieldForShooting = battlefieldService.createBattlefield(Battlefield.getxAsis(), Battlefield.getyAsis());
        StringBuilder shipsPosition = new StringBuilder();

        boolean run = true;
        while (run) {
            print("1. Suveskite laivus: ");
            print("2. Prisijungti i zaidima: ");
            print("0. Išeiti");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    battlefieldService.printBattleField(createdBattlefield);
//                    System.out.println("Sukurkite keturvietį laivą: pvz(I0-M0 arba K0-K4)");
//                    String laivas = scanner.next().toUpperCase();
                    String laivas = "K0-O0";
                    shipsPosition.append(laivas).append("!");
                    String keturvietis = battlefieldService.createShip(createdBattlefield, laivas);
                    battlefieldService.createBattlefieldWithShips(createdBattlefield, keturvietis);
                    battlefieldService.printBattleField(createdBattlefield);
//                   String laivas1 = scanner.next().toUpperCase();
                    String laivas1 = "K3-L3";
                    shipsPosition.append(laivas1).append("!");
                    String trivietis1 = battlefieldService.createShip(createdBattlefield, laivas1);
                    battlefieldService.createBattlefieldWithShips(createdBattlefield, trivietis1);
                    battlefieldService.printBattleField(createdBattlefield);
//                   String laivas2 = scanner.next().toUpperCase();
                    String laivas2 = "K5-L5";
                    shipsPosition.append(laivas2).append("!");
                    String trivietis2 = battlefieldService.createShip(createdBattlefield, laivas2);
                    battlefieldService.createBattlefieldWithShips(createdBattlefield, trivietis2);
                    battlefieldService.printBattleField(createdBattlefield);
//                    System.out.println("Sukurkite pirma dvivieti laiva: pvz (M0-E0 arba K1-K2)");
//                    String laivas3 = scanner.next().toUpperCase();
                    String laivas3 = "K7-I7";
                    shipsPosition.append(laivas3).append("!");
                    String dvivietis1 = battlefieldService.createShip(createdBattlefield, laivas3);
                    battlefieldService.createBattlefieldWithShips(createdBattlefield, dvivietis1);
                    battlefieldService.printBattleField(createdBattlefield);
//                    System.out.println("Sukurkite antra dvivieti laiva: pvz (M0-E0 arba K1-K2)");
//                    String laivas4 = scanner.next().toUpperCase();
                    String laivas4 = "K9-I9";
                    shipsPosition.append(laivas4).append("!");
                    String dvivietis2 = battlefieldService.createShip(createdBattlefield, laivas4);
                    battlefieldService.createBattlefieldWithShips(createdBattlefield, dvivietis2);
                    battlefieldService.printBattleField(createdBattlefield);
//                    System.out.println("Sukurkite trecia dvivieti laiva: pvz (M0-E0 arba K1-K2)");
//                    String laivas5 = scanner.next().toUpperCase();
                    String laivas5 = "E0-T0";
                    shipsPosition.append(laivas5).append("!");
                    String dvivietis3 = battlefieldService.createShip(createdBattlefield, laivas5);
                    battlefieldService.createBattlefieldWithShips(createdBattlefield, dvivietis3);
                    battlefieldService.printBattleField(createdBattlefield);
//                    System.out.println("Sukurkite pirma vienvieti laiva: pvz (M0-M0)");
//                    String laivas6 = scanner.next().toUpperCase();
                    String laivas6 = "E2-E2";
                    shipsPosition.append(laivas6).append("!");
                    String vienvietis1 = battlefieldService.createShip(createdBattlefield, laivas6);
                    battlefieldService.createBattlefieldWithShips(createdBattlefield, vienvietis1);
                    battlefieldService.printBattleField(createdBattlefield);
//                    System.out.println("Sukurkite antra vienvieti laiva: pvz (M0-M0)");
//                    String laivas7 = scanner.next().toUpperCase();
                    String laivas7 = "E4-E4";
                    shipsPosition.append(laivas7).append("!");
                    String vienvietis2 = battlefieldService.createShip(createdBattlefield, laivas7);
                    battlefieldService.createBattlefieldWithShips(createdBattlefield, vienvietis2);
                    battlefieldService.printBattleField(createdBattlefield);
//                    System.out.println("Sukurkite trecia vienvieti laiva: pvz (M0-M0)");
//                    String laivas8 = scanner.next().toUpperCase();
                    String laivas8 = "E6-E6";
                    shipsPosition.append(laivas8).append("!");
                    String vienvietis3 = battlefieldService.createShip(createdBattlefield, laivas8);
                    battlefieldService.createBattlefieldWithShips(createdBattlefield, vienvietis3);
                    battlefieldService.printBattleField(createdBattlefield);
//                    System.out.println("Sukurkite ketvirta vienvieti laiva: pvz (M0-M0)");
//                    String laivas9 = scanner.next().toUpperCase();
                    String laivas9 = "E8-E8";
                    shipsPosition.append(laivas9).append("!");
                    shipsPosition.delete(shipsPosition.length() - 1, shipsPosition.length());
                    String vienvietis4 = battlefieldService.createShip(createdBattlefield, laivas9);
                    battlefieldService.createBattlefieldWithShips(createdBattlefield, vienvietis4);
                    battlefieldService.printBattleField(createdBattlefield);
                    break;

                case 2:
                    if (shipsPosition.toString().length() > 0) {
                        if (shipsPosition.length() > 0) {
                            GameServiceInterface gameService = new GameServiceImpl();
                            User user = gameService.createUser("Vardas", "vardas@gmail.com");
                            Game game = gameService.joinGame(user.getId());
                            while (game.getStatus().equals(READY_FOR_SECOND_PLAYER)) {
                                game = gameService.checkGameStatus(game.getGameId());
                                Thread.sleep(2000);
                            }
                            while (game.getStatus().equals(READY_FOR_SHIPS)) {
                                gameService.setupShips(game.getGameId(), user.getId(), shipsPosition.toString());
                                print("");
                                print("Jusu isdestyti laivai: ");
                                battlefieldService.printBattleField(createdBattlefield);
                                print("");
                                print("Tavo spejimai prieso laivu nuskandinimui:");
                                battlefieldService.printBattleField(createdBattlefieldForShooting);
                                game = gameService.checkGameStatus(game.getGameId());
                                Thread.sleep(2000);
                            }
                            while (game.getStatus().equals(READY_TO_PLAY)) {
                                if (!game.getNextTurnForUserId().equals(user.getId())) {
                                    print("palaukite kol varzovas atliks ejima:");
                                    Thread.sleep(3000);
                                    game = gameService.checkGameStatus(game.getGameId());
                                } else if (game.getNextTurnForUserId().equals(user.getId())) {
                                    print("Iveskite savo spejima, kur yra varzovo laivas:");
                                    String spejimas = scanner.next().toUpperCase();
                                    try {
                                        game = gameService.takeShoot(game.getGameId(), user.getId(), spejimas);
                                    } catch (Exception e) {
                                        print(e.getMessage());
                                        Thread.sleep(2000);
                                    }
                                }
                                for (GameData gameData : game.getEvents()) {
                                    if (!gameData.getUserId().equals(user.getId())) {
                                        if (!gameData.getHit()) {
                                            createdBattlefield[gameService2.takeShootNumber(gameData.getCoordinate())]
                                                    [gameService2.takeShootLetter(gameData.getCoordinate())] = ". ";
                                        }
                                        if (gameData.getHit()) {
                                            createdBattlefield[gameService2.takeShootNumber(gameData.getCoordinate())]
                                                    [gameService2.takeShootLetter(gameData.getCoordinate())] = "@ ";
                                        }
                                    } else if (gameData.getUserId().equals(user.getId())) {
                                        if (!gameData.getHit()) {
                                            createdBattlefieldForShooting[gameService2.takeShootNumber(gameData.getCoordinate())]
                                                    [gameService2.takeShootLetter(gameData.getCoordinate())] = ". ";
                                        }
                                        if (gameData.getHit()) {
                                            createdBattlefieldForShooting[gameService2.takeShootNumber(gameData.getCoordinate())]
                                                    [gameService2.takeShootLetter(gameData.getCoordinate())] = "@ ";
                                        }
                                    }
                                }
                                print("");
                                print("Laivu issidestymas ir prieso spejimas: ");
                                battlefieldService.printBattleField(createdBattlefield);
                                print("");
                                print("Spejimas ir prieso laivu isdestymas: ");
                                battlefieldService.printBattleField(createdBattlefieldForShooting);
                            }
                            if (game.getStatus().equals(FINISHED)) {
                                if (game.getWinnerUserId().equals(user.getId())) {
                                    System.out.println("Sveikiname laimėjus !");
                                } else {
                                    System.out.println("Sveikiname užėmus antrą vietą!");
                                }
                            }
                        }
                    } else {
                        System.out.println("Is pradziu turite suvesti laivus!");
                        Thread.sleep(2000);
                        continue;
                    }
                case 0:
                    run = false;
                    break;
            }
        }
    }

    private static void print(String str) {
        System.out.println(str);
    }
}
