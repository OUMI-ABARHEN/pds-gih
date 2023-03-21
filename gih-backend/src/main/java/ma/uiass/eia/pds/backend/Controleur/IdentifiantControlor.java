package ma.uiass.eia.pds.backend.Controleur;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.Identifiant;
import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.Metier.MetierIdentifiant;

import java.util.List;

@Path("pds")
public class IdentifiantControlor {
    MetierIdentifiant metierIdentifiant = new MetierIdentifiant();
    @GET
    @Path("identi/{id}/{pass}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean isCorrect (@PathParam("id") int id,@PathParam("pass") String pass) {
       return  metierIdentifiant.isCorrect(id,pass);

    }
    @GET
    @Path("identifiant{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Identifiant get(@PathParam("id") int id) {
        return  metierIdentifiant.finfByid(id);

    }

    @GET
    @Path("identifiants")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Identifiant> getMyLits() {
        return metierIdentifiant.getAll();
    }

    public static void main(String[] args) {
        IdentifiantControlor i = new IdentifiantControlor();
        System.out.println(i.getMyLits());
    }

}
