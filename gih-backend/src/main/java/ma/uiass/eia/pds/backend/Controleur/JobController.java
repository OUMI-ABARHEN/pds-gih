package ma.uiass.eia.pds.backend.Controleur;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Dao.IdentifiantDaoImp;
import ma.uiass.eia.pds.backend.Entite.Identifiant;

@Path("pds")
public class JobController {
    @GET
    @Path("job/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserJob(@PathParam("username") String username) {
        // Call a method to retrieve the user's job based on their username
        // Return the job as a string
        String job = retrieveUserJob(username);
        return job;
    }

    private String retrieveUserJob(String username) {
        IdentifiantDaoImp identifiantDaoImp = new IdentifiantDaoImp();
        Identifiant user = identifiantDaoImp.findByCode(username);
        if (user.getJob().equals("admin")) {
            return "admin";
        } else if (user.getJob().equals("chef service")) {
            return "chef service";
        } else {
            return "unknown";
        }
    }
}
