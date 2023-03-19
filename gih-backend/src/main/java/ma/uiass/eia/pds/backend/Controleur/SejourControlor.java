package ma.uiass.eia.pds.backend.Controleur;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.Sejour;
import ma.uiass.eia.pds.backend.Metier.MetierSejour;






import java.util.List;
@Path("pds")
public class SejourControlor {
    MetierSejour metierSejour=new MetierSejour();
    @GET
    public String sayHello() {
        return "Hello world";
    }
    @GET
    @Path("sejours")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sejour> getMySejours() {
        return metierSejour.getSejours();
    }
}
