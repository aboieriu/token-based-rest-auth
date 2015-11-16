package ws.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by root on 8/31/15.
 */
public class UserAuthService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<String> roles = new HashSet<String>();
        roles.add("ROLE_API_CONSUMER");
        // add user fetching logic here
        //fa86835ad104d7986d63354ddba3c97871e4ed2b7dcbf6a0effa84f48ea9c1db6f218c61d5543511 is encoded password for "fiska"
        return new UserDetailsImpl("alex", "fa86835ad104d7986d63354ddba3c97871e4ed2b7dcbf6a0effa84f48ea9c1db6f218c61d5543511", roles);
    }
}
