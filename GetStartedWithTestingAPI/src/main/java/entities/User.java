package entities;

public class User {

    //For tests using JsonObject
    public static final String LOGIN = "login";
    public static final String ID = "id";

    private String login;
    private int id;
    private String location;

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }
}
