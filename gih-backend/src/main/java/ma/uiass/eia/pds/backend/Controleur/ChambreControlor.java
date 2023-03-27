package ma.uiass.eia.pds.backend.Controleur;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.Chambre;
import ma.uiass.eia.pds.backend.Metier.MetierChambre;

import java.util.List;

@Path("pds")
public class ChambreControlor {
    MetierChambre metierChambre = new MetierChambre();
    @GET
    @Path("chambre")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chambre> getMyList() {
        return metierChambre.getAllChambre();
    }

    public static void main(String[] args) {
        ChambreControlor c = new ChambreControlor();
        List<Chambre> list = c.getMyList();
        System.out.println(list);
    }
}
