package lt.vardas_pavarde.laivu_musis.client.services;

import lt.vardas_pavarde.laivu_musis.client.beans.Game;
import lt.vardas_pavarde.laivu_musis.client.beans.User;
import org.json.simple.parser.ParseException;

public interface GameServiceInterface {

    User createUser(String name, String email);

    Game joinGame(String id);

    Game checkStatus(String gameId) throws ParseException;

    Game setupShips(String gameId, String userId, String shipsPosition);

    Game takeShoot(String gameId, String userId, String shoot);

    Game checkGameStatus(String gameId);

}
