package lt.vardas_pavarde.laivu_musis.client.services;


import lt.vardas_pavarde.laivu_musis.client.beans.Game;
import lt.vardas_pavarde.laivu_musis.client.beans.GameData;
import lt.vardas_pavarde.laivu_musis.client.beans.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

public class GameServiceImpl implements GameServiceInterface {
    private static final String SERVER_URL = "http://192.168.1.38:8080";
    private static final String CREATE_USER_METHOD_NAME = "/create_user";
    private static final String JOIN_USER_METHOD_NAME = "/join";
    private static final String GAME_STATUS_METHOD_NAME = "/status";
    private static final String SETUP_SHIP_METHOD_NAME = "/setup";
    private static final String SENDING_SHOOT_METHOD_NAME = "/turn";


    @Override
    public User createUser(String name, String email) {
        String url = SERVER_URL + CREATE_USER_METHOD_NAME + "?name=" + name + "&email=" + email;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            String resp = getResponceAsString(response.getEntity().getContent());
            return convertUser(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private User convertUser(String body) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(body);
        if (obj instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) obj;
            String name = (String) jsonObject.get("name");
            String email = (String) jsonObject.get("email");
            String id = (String) jsonObject.get("id");
            User user = new User();
            user.setId(id);
            user.setEmail(email);
            user.setName(name);
            return user;
        }
        return null;
    }

    private String getResponceAsString(InputStream inputStream) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    @Override
    public Game joinGame(String id) {
        String url = SERVER_URL + JOIN_USER_METHOD_NAME + "?user_id=" + id;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            String resp = getResponceAsString(response.getEntity().getContent());
            return this.checkStatus(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Game setupShips(String gameId, String id, String ships) {
        String url = SERVER_URL + SETUP_SHIP_METHOD_NAME + "?game_id=" + gameId + "&user_id=" + id + "&data=" + ships;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            String resp = getResponceAsString(response.getEntity().getContent());
            return this.checkStatus(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Game takeShoot(String gameId, String id, String shoot) {
        String url = SERVER_URL + SENDING_SHOOT_METHOD_NAME + "?game_id=" + gameId + "&user_id=" + id + "&data=" + shoot;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            String resp = getResponceAsString(response.getEntity().getContent());
            return this.checkStatus(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Game checkGameStatus(String gameId) {
        String url = SERVER_URL + GAME_STATUS_METHOD_NAME + "?game_id=" + gameId;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            String resp = getResponceAsString(response.getEntity().getContent());
            return this.checkStatus(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Game checkStatus(String body) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(body);
        if (obj instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) obj;
            String nextTurnForUserid = (String) jsonObject.get("nextTurnForUserId");
            String gameId = (String) jsonObject.get("id");
            String status = (String) jsonObject.get("status");
            String winnerUserId = (String) jsonObject.get("winnerUserId");
            Game game = new Game();
            JSONArray jarray = (JSONArray) jsonObject.get("events");
            for (int i = 0; i < jarray.size(); i++) {
                Date date = new Date((Long) ((JSONObject) jarray.get(i)).get("date"));
                String userId = (String) ((JSONObject) jarray.get(i)).get("userId");
                Boolean hitResult = (Boolean) ((JSONObject) jarray.get(i)).get("hit");
                String coordinate = (String) ((JSONObject) ((JSONObject) jarray.get(i)).get("coordinate")).get("column") +
                        ((Long) ((JSONObject) ((JSONObject) jarray.get(i)).get("coordinate")).get("row")).toString();

                GameData gameData = new GameData(date, coordinate, userId, hitResult);
                game.getEvents().add(gameData);
            }
            game.setNextTurnForUserId(nextTurnForUserid);
            game.setGameId(gameId);
            game.setStatus(status);
            game.setWinnerUserId(winnerUserId);

            return game;
        }
        return null;
    }

}


