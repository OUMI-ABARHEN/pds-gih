package ma.uiass.eia.pds.backend.Controleur;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.DetailDemande;
import ma.uiass.eia.pds.backend.Entite.TypeLit;
import ma.uiass.eia.pds.backend.Metier.MetierDetailDemande;
import ma.uiass.eia.pds.backend.Metier.MetierLit;
import ma.uiass.eia.pds.backend.Metier.MetierService;

import java.util.List;

@Path("pds")
public class DetailDemandeControlor {
    private MetierDetailDemande metierDetailDemande = new MetierDetailDemande();
    private MetierLit metierLit = new MetierLit();
    private MetierService metierService = new MetierService();

    @GET
    @Path("DetailDemandes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetailDemande> getMyLists() {
        return metierDetailDemande.getAll();
    }

    @PUT
    @Path("addDetail/{code}/{codeL}/{typeL}/{nameS}/{quantite}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDetail(@PathParam("code") String code, @PathParam("codeL") String codeL, @PathParam("typeL")TypeLit typeLit ,@PathParam("nameS") String nameS,@PathParam("quantite") int q){
        metierDetailDemande.add(code,codeL,typeLit,nameS,q);
    }

}
