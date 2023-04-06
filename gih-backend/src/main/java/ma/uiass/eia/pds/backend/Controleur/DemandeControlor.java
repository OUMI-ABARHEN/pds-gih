package ma.uiass.eia.pds.backend.Controleur;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.Demande;
import ma.uiass.eia.pds.backend.Entite.DemandeFormat;
import ma.uiass.eia.pds.backend.Entite.EtatDemande;
import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.Metier.MetierDemande;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("pds")
public class DemandeControlor {
    private MetierDemande metierDemande = new MetierDemande();
    @GET
    @Path("Demandes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DemandeFormat> getDemandes() {
        List<Demande> lst = metierDemande.getAll();
        List<DemandeFormat> newlst = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Demande d : lst) {
            String date = sdf.format(d.getDate());
            newlst.add(new DemandeFormat(d.getDemande_id(), d.getCode(), date,d.getEtat(), d.getService(), d.getDetailDemande()));
        }
        return newlst;
    }


    @POST
    @Path("/addDemande")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDemande( @FormParam("codeD") String codeD,@FormParam("nomS") String nomS, @FormParam("etat")EtatDemande etat){
        metierDemande.addDemande(codeD,nomS,etat);
    }
    @GET
    @Path("uneDemande/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public DemandeFormat getDemande(@PathParam("code") String codeD){
        Demande d = metierDemande.findByCode(codeD);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d.getDate());
        return new DemandeFormat(d.getDemande_id(),d.getCode(),date,d.getEtat(),d.getService(),d.getDetailDemande());
    }

    @GET
    @Path("getDemandeService/{nomS}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DemandeFormat> getDemandeSer(@PathParam("nomS") String nomS){
        List<Demande> demandes = metierDemande.getByService(nomS);
        List<DemandeFormat> newlst = new ArrayList<>();
        for(Demande d : demandes) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(d.getDate());
            newlst.add(new DemandeFormat(d.getDemande_id(),d.getCode(),date,d.getEtat(),d.getService(),d.getDetailDemande()));
        }
        return newlst;
    }
    @POST
    @Path("/updateEtat/{codeD}/{etat}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update(@PathParam("codeD") String code,@PathParam("etat") EtatDemande etat){
        metierDemande.updateEtat(code,etat);
    }

}
