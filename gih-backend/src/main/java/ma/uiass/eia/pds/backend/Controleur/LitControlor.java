package ma.uiass.eia.pds.backend.Controleur;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.uiass.eia.pds.backend.Entite.*;
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

   /* @POST
    @Path("AddLit")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLit(@QueryParam("typeLit") TypeLit typeLit,
                           @QueryParam("marque") String marque,
                           @QueryParam("code") String code ,
                           @QueryParam("nom") String nom ,
                           @QueryParam("qte") Integer qte ,
                           @QueryParam("etat") EtatLit etat) {
        Service s=new Service(code,nom);
        Espace e=new Espace(qte,s);
        metierlit.addLit(typeLit, marque, e, etat);
        return Response.status(Response.Status.CREATED).build();
    }*/






}






