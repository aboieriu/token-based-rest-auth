package ws.endpoint;

import ws.security.AuthToken;
import ws.security.TokenUtils;
import ws.security.UserAuthService;
import ws.security.UserCandidate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by root on 8/31/15.
 */
@Path("/authenticate/")
public class AuthenticationResource {
    private AuthenticationManager authManager;
    private UserAuthService userAuthService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public AuthToken getUsers(UserCandidate userCandidate){
        UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(userCandidate.getUsername(), userCandidate.getPassword());
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = this.userAuthService.loadUserByUsername(userCandidate.getUsername());

        return new AuthToken(TokenUtils.createToken(userDetails));
    }

    public void setAuthManager(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    public void setUserAuthService(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }
}

