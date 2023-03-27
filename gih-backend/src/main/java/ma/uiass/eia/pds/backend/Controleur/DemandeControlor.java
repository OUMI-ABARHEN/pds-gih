package ma.uiass.eia.pds.backend.Controleur;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.Demande;
import ma.uiass.eia.pds.backend.Entite.EtatDemande;
import ma.uiass.eia.pds.backend.Metier.MetierDemande;

import java.util.Date;
import java.util.List;

@Path("pds")
public class DemandeControlor {
    private MetierDemande metierDemande = new MetierDemande();
    @GET
    @Path("Demandes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Demande> getMyLists() {
        return metierDemande.getAll();
    }


    @PUT
    @Path("addDemande/{code}/{date}/{description}/{etat}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDemande(@PathParam("code") String code, @PathParam("date")Date date , @PathParam("description") String description, @PathParam("etat")EtatDemande etat){
        metierDemande.addDemande(code,date,description,etat);
    }
}
