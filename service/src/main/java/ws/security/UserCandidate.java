package ws.security;

/**
 * Created by root on 9/4/15.
 */
public class UserCandidate {
    private String username;
    private String password;

    public UserCandidate() {

    }

    public UserCandidate(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
