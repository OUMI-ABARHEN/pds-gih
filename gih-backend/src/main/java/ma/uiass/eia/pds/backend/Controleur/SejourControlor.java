package ma.uiass.eia.pds.backend.Controleur;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.Sejour;
import ma.uiass.eia.pds.backend.Entite.SejourFormatted;
import ma.uiass.eia.pds.backend.Metier.MetierSejour;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Path("pds")
public class SejourControlor {
    MetierSejour metierSejour=new MetierSejour();
    @GET
    public String sayHello() {
        return "Hello world";
    }
    //    @GET
//    @Path("sejours")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Sejour> getMySejours() {
//        return metierSejour.getSejours();
//    }
    @GET
    @Path("sejours")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SejourFormatted> getMySejours() {
        List<SejourFormatted> sejoursFormatted = new ArrayList<>();
        List<Sejour> sejours = metierSejour.getSejours();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Sejour sejour : sejours) {
            String dateEntree = sdf.format(sejour.getDate_entre());
            String dateSortie = sdf.format(sejour.getDate_sortie());
            SejourFormatted sejourFormatted = new SejourFormatted(sejour.getSejour_id(), dateEntree, dateSortie, sejour.getLit());
            sejoursFormatted.add(sejourFormatted);
        }
        return sejoursFormatted;
    }
    @PUT
    @Path("addsejour/{date_entre}/{date_sortie}/{Code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addSejour(@PathParam("date_entre") String date_entre,
                          @PathParam("date_sortie") String date_sortie,
                          @PathParam("Code") String code) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date_entre_obj = formatter.parse(date_entre);
            Date date_sortie_obj = formatter.parse(date_sortie);
            metierSejour.addSejour(date_entre_obj, date_sortie_obj, code);
        } catch (ParseException e) {
            // Handle the exception
        }
    }

}

