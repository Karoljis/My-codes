package lt.vardas_pavarde.laivu_musis.client.beans;

import java.util.Date;

public class GameData {
    private Date date;
    private String coordinate;
    private String userId;
    private Boolean hit;

    public GameData(Date date, String coordinate, String userId, Boolean hit) {
        this.date = date;
        this.coordinate = coordinate;
        this.userId = userId;
        this.hit = hit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getHit() {
        return hit;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }
}
