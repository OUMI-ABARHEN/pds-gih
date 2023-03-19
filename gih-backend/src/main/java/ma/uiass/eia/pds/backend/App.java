package ma.uiass.eia.pds.backend;

import jakarta.ws.rs.core.UriBuilder;
import ma.uiass.eia.pds.backend.Controleur.*;
import ma.uiass.eia.pds.backend.Entite.*;
import ma.uiass.eia.pds.backend.Metier.*;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        MetierEmplacement metierEmplacement = new MetierEmplacement();
       /*metierEmplacement.create("batiment1","E01");
       metierEmplacement.create("batiment A","E01");
        metierEmplacement.create("batiment B","E01");
        metierEmplacement.create("batiment C","E01");
        metierEmplacement.create("batiment D","E01");*/
        //metierEmplacement.delete(1);
         //System.out.println(metierEmplacement.getAll());

        MetierJob metierJob = new MetierJob();
         //metierJob.add("admin ");
        // metierJob.add("Agent Logistic");
        //metierJob.add("Chef Service");


        MetierIdentifiant metierIdentifiant = new MetierIdentifiant();
     /* metierIdentifiant.add("oumaima","abarhen","obarhen@gmail.com",666679767, Sexe.FEMELAE,"admin",1);
        metierIdentifiant.add("ahmed","elghassib","ahmedelghassib@gmail.com",660079767, Sexe.MALE,"admin",1);
        metierIdentifiant.add("badr","elabbady","badrelghassib@gmail.com",666679700, Sexe.MALE,"admin",1);
        metierIdentifiant.add("jihad","hibatallah","jihadhibataalah@gmail.com",66098767, Sexe.FEMELAE,"admin",1);
        metierIdentifiant.add("marouan","aghbalo","marouanaghbalo@gmail.com",666679787, Sexe.MALE,"admin",1);*/

        //System.out.println(metierIdentifiant.getPassword(1));
        //System.out.println(metierIdentifiant.isCorrect(1,"admin"));


        MetierService sr=new MetierService ();
        //sr.addService("S1", "cardiologie",1);
        //sr.addService("S2", "cancer",2);
        //sr.addService("S2", "chirurgi3",3);

       // sr.deleteService("chirurgi3");
        //System.out.println(sr.findServiceByName("chirurgi3"));
        //System.out.println(sr.showServiceById(1));
         //System.out.println(sr.showServices());




        MetierChambre metierChambre = new MetierChambre();
        //metierChambre.addChambre(1,"chirurgi3", TypeChambre.PEDIATRIE);

        // System.out.println(metierChambre.getAllChambre());

        MetierSalle metierSalle = new MetierSalle();
        // metierSalle.addSalle(3,"cardiologie", TypeSalle.consultation);
        // System.out.println(metierSalle.getAllSalle());
        //metierSalle.delete(3);
//
        MetierLit mtl=new MetierLit();
       // mtl.addLit(TypeLit.soin,"healthX",1, EtatLit.DISPONIBLE);
        //System.out.println(mtl.searchById(1));
        // mtl.updateEtat(1,EtatLit.OCCUPE);
        //mtl.deleteLit(1);
       // System.out.println(mtl.getLits());

        MetierSejour metierSejour=new MetierSejour();
       // metierSejour.addSejour(LocalDate.of(2022,12,13), LocalDate.now(),2);
        //System.out.println(metierSejour.getSejours());
        //metierSejour.deleteSejour(1);

        URI baseUri = UriBuilder.fromUri("http://localhost/").port(2002).build();
        ResourceConfig config = new ResourceConfig();
        config.register(ServiceControlor.class);
        config.register(EmplacementControlor.class);
        config.register(IdentifiantControlor.class);
        config.register(LitControlor.class);
        config.register(SejourControlor.class);
        config.register(ChambreControlor.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);



    }
}
