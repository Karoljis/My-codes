package lt.vardas_pavarde.laivu_musis.client.beans;


import java.util.ArrayList;
import java.util.List;

public class Game {

    private String gameId;
    private String nextTurnForUserId;
    private String status;
    private String winnerUserId;
    private List<GameData> events = new ArrayList<>();


    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getNextTurnForUserId() {
        return nextTurnForUserId;
    }

    public void setNextTurnForUserId(String nextTurnForUserId) {
        this.nextTurnForUserId = nextTurnForUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWinnerUserId() {
        return winnerUserId;
    }

    public void setWinnerUserId(String winnerUserId) {
        this.winnerUserId = winnerUserId;
    }

    public List<GameData> getEvents() {
        return events;
    }

    public void setEvents(List<GameData> events) {
        this.events = events;
    }
}
