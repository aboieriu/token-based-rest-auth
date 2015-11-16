package ws.security;

/**
 * Created by root on 8/31/15.
 */
public class AuthToken {
    private final String token;

    public AuthToken(String token) {
        this.token = token;
    }

    public String getToken(){
        return this.token;
    }
}
