package ws.endpoint;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 8/19/15.
 */
@Path("/user/")
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String response = "You are logged in as: " + auth.getName();
        return response;
    }
}
