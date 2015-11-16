package ws.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by root on 9/4/15.
 */
public class UserGrantedAuthority implements GrantedAuthority {

    private String authority;

    public UserGrantedAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public int hashCode() {
        return this.authority.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof UserGrantedAuthority)) return false;
        return ((UserGrantedAuthority) obj).getAuthority().equals(this.authority);
    }
}
