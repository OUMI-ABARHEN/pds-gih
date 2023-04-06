package ma.uiass.eia.pds.backend.Controleur;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.DetailDemande;
import ma.uiass.eia.pds.backend.Entite.TypeLit;
import ma.uiass.eia.pds.backend.Metier.MetierDetailDemande;
import ma.uiass.eia.pds.backend.Metier.MetierLit;
import ma.uiass.eia.pds.backend.Metier.MetierService;

import java.util.List;

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

    @POST
    @Path("/addDetail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDetail( @FormParam("code") String code,@FormParam("typeL")TypeLit typeLit ,@FormParam("quantite") int q){
        metierDetailDemande.add(code,typeLit,q);
    }
    @POST
    @Path("/updateDetail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update(@FormParam("codeDD") String codeDD,@FormParam("codeD") String codeD){
        metierDetailDemande.update(codeDD,codeD);

    }

    @DELETE
    @Path("/deleteDetail{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("code") String code){
        metierDetailDemande.delete(code);
    }


}
