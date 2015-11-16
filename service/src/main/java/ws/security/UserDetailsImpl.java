package ws.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by root on 8/31/15.
 */
public class UserDetailsImpl implements UserDetails{
    private String username;
    private String password;
    private Set<String> roles;
    private Set<GrantedAuthority> grantedAuthorities;

    public UserDetailsImpl(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.grantedAuthorities = new LinkedHashSet<GrantedAuthority>();
        if (this.roles != null && this.roles.size() > 0) {
            Iterator it = this.roles.iterator();
            while(it.hasNext()) {
                String role = (String) it.next();
                UserGrantedAuthority userGrantedAuthority = new UserGrantedAuthority(role);
                this.grantedAuthorities.add(userGrantedAuthority);
            }
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
