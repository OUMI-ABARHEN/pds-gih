package ma.uiass.eia.pds.backend.Controleur;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import ma.uiass.eia.pds.backend.Dao.IdentifiantDaoImp;
import ma.uiass.eia.pds.backend.Entite.Identifiant;

import javax.json.Json;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

//@Path("pds")
//public class LoginControlor {
//    @POST
//    @Path("login")
//    public Response login(@HeaderParam("Authorization") String authHeader) {
//        if (authHeader != null && authHeader.startsWith("Basic")) {
//            String authToken = authHeader.substring("Basic ".length()).trim();
//            String[] credentials = new String(Base64.getDecoder().decode(authToken)).split(":");
//            String username = credentials[0];
//            String password = credentials[1];
//
//
//            // Verify the credentials against a database or other authentication mechanism
//            if (isValid(username, password)) {
//                return Response.ok("Authentication successful").build();
//            }
//        }
//
//        return Response.status(Response.Status.UNAUTHORIZED)
//                .header("WWW-Authenticate", "Basic realm=\"example\"")
//                .entity("Authentication failed").build();
//    }
//
//    private boolean isValid(String username, String password) {
//        IdentifiantDaoImp identifiantDaoImp = new IdentifiantDaoImp();
//        Identifiant user = identifiantDaoImp.findByCode(username);
//        if (user != null && user.getPassword().equals(password)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        LoginControlor l = new LoginControlor();
//        //System.out.println(l.isValid("ID001","admin"));
//    }
//
//
//}



//@Path("pds")
//public class LoginControlor {
//    @POST
//    @Path("login")
//    public Response login(@HeaderParam("Authorization") String authHeader) {
//        if (authHeader != null && authHeader.startsWith("Basic")) {
//            String authToken = authHeader.substring("Basic ".length()).trim();
//            String[] credentials = new String(Base64.getDecoder().decode(authToken)).split(":");
//            String username = credentials[0];
//            String password = credentials[1];
//
//            // Verify the credentials against a database or other authentication mechanism
//            if (isValid(username, password)) {
//                // Get the user's roles from the database or other data source
//                String job = getUserJob(username);
//
//                // Return a response that includes the user's roles
//                return Response.ok()
//                        .header("X-User-Roles", String.join(",", job))
//                        .entity("Authentication successful").build();
//            }
//        }
//
//        return Response.status(Response.Status.UNAUTHORIZED)
//                .header("WWW-Authenticate", "Basic realm=\"example\"")
//                .entity("Authentication failed").build();
//    }
//
//    private boolean isValid(String username, String password) {
//        IdentifiantDaoImp identifiantDaoImp = new IdentifiantDaoImp();
//        Identifiant user = identifiantDaoImp.findByCode(username);
//        if (user != null && user.getPassword().equals(password)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    private String getUserJob(String username) {
//        // Get the user's job from the database or other data source
//        IdentifiantDaoImp identifiantDaoImp = new IdentifiantDaoImp();
//        Identifiant user = identifiantDaoImp.findByCode(username);
//        if (user != null && user.getJob() != null && !user.getJob().getNomJob().isEmpty()) {
//            return user.getJob().getNomJob();
//        } else {
//            return "unknown";
//        }
//    }
//
//
//    public static void main(String[] args) {
//        LoginControlor l = new LoginControlor();
//        // System.out.println(l.isValid("ID001","admin"));
//        System.out.println(l.getUserJob("ID001"));
//    }
//}



@Path("pds")
public class LoginControlor {
    @POST
    @Path("login")
    public Response login(@HeaderParam("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Basic")) {
            String authToken = authHeader.substring("Basic ".length()).trim();
            String[] credentials = new String(Base64.getDecoder().decode(authToken)).split(":");
            String username = credentials[0];
            String password = credentials[1];

            // Verify the credentials against a database or other authentication mechanism
            Identifiant user = authenticateAndGetUser(username, password);
            if (user != null) {
                // Get the job of the user
                String job = user.getJob().getNomJob();

                // Create a response containing the user's job
                JsonObject responseJson = new JsonObject();
                responseJson.add("job", new JsonPrimitive(job));
                return Response.ok(responseJson.toString()).build();
            }
        }

        return Response.status(Response.Status.UNAUTHORIZED)
                .header("WWW-Authenticate", "Basic realm=\"example\"")
                .entity("Authentication failed").build();
    }

    private Identifiant authenticateAndGetUser(String username, String password) {
        IdentifiantDaoImp identifiantDaoImp = new IdentifiantDaoImp();
        Identifiant user = identifiantDaoImp.findByCode(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        LoginControlor l = new LoginControlor();
        System.out.println(l.authenticateAndGetUser("ID001","admin").getJob().getNomJob());
        //System.out.println(l.authenticateAndGetUser("ID001","admin").getJob().getNomJob());
    }
}





