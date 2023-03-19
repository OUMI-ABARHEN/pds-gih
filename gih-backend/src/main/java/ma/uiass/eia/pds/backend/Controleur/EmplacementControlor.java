package ma.uiass.eia.pds.backend.Controleur;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.Emplacement;
import ma.uiass.eia.pds.backend.Metier.MetierEmplacement;

import java.util.List;

@Path("pds")
public class EmplacementControlor {
    MetierEmplacement metierEmplacement = new MetierEmplacement();
    @GET
    @Path("emplacement")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Emplacement> getMyList() {
        return metierEmplacement.getAll();
    }
}
