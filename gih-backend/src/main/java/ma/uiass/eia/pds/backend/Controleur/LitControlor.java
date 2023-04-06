package ma.uiass.eia.pds.backend.Controleur;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.Entite.TypeLit;
import ma.uiass.eia.pds.backend.Metier.MetierLit;

import java.util.List;

@Path("pds")
public class LitControlor {
    MetierLit metierlit = new MetierLit();

    @GET
    @Path("lits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lit> getMyLits() {
        return metierlit.getLits();
    }
    @DELETE
    @Path("/DeleteLit{id}")
    public String deleteLit(@PathParam("id") int id){
        metierlit.deleteLit(id);
        return "done";
    }

    @GET
    @Path ("LitByid{idlit}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lit findLitbyname(@PathParam("idlit") int id) {
        return metierlit.searchById(id);

    }

    @POST
    @Path("/addLitStock")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addLit(@FormParam("typeLit") TypeLit typeLit, @FormParam("nomS") String nomS) {
        metierlit.addLitStock(typeLit,nomS);
    }






}






