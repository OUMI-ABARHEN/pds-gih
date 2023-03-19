package ma.uiass.eia.pds.backend;

import jakarta.ws.rs.core.UriBuilder;
import ma.uiass.eia.pds.backend.Controleur.*;
import ma.uiass.eia.pds.backend.Entite.TypeChambre;
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
        /*MetierEmplacement metierEmplacement = new MetierEmplacement();
        metierEmplacement.create("batiment1","E01");
        metierEmplacement.create("batiment A","E01");
        metierEmplacement.create("batiment B","E01");
        metierEmplacement.create("batiment C","E01");
        metierEmplacement.create("batiment D","E01");
        metierEmplacement.delete(1);
        System.out.println(metierEmplacement.getAll());*/

        /*MetierJob metierJob = new MetierJob();
        metierJob.add("admin Local");
        metierJob.add("admin general");*/


        /*MetierIdentifiant metierIdentifiant = new MetierIdentifiant();
        metierIdentifiant.add("oumaima","abarhen","obarhen@gmail.com",666679767, Sexe.FEMELAE,"admin",1);
        metierIdentifiant.add("ahmed","elghassib","elghassibahmed@gmail.com",660079767, Sexe.MALE,"admin",1);
        metierIdentifiant.add("badr","elabbady","badrelabbady@gmail.com",666679700, Sexe.MALE,"admin",1);
        metierIdentifiant.add("jihad","hibatallah","jihadhibataalah@gmail.com",66098767, Sexe.FEMELAE,"admin",1);
        metierIdentifiant.add("marouan","aghbalo","marouanaghbalo@gmail.com",666679787, Sexe.MALE,"admin",1);
        System.out.println(metierIdentifiant.getPassword(1));
        System.out.println(metierIdentifiant.isCorrect(1,"admin"));*/

        MetierService sr =new MetierService ();
		/*sr.addService("S1", "cardiologie");
        sr.addService("S2", "cancer");

		sr.deleteService("S1", "cardiologie");
        System.out.println(sr.findServiceByName("cardiologie"));
        System.out.println(sr.showServiceById(1));
        System.out.println(sr.showServices());*/
        //System.out.println(sr.showServices());




        MetierChambre metierChambre = new MetierChambre();
        //metierChambre.addChambre(1,"cardiologie", TypeChambre.PEDIATRIE);
        //metierChambre.addChambre(2,"cardiologie", TypeChambre.PEDIATRIE);
        System.out.println(metierChambre.getAllChambre());



       /* MetierSalle metierSalle = new MetierSalle();
        metierSalle.addSalle(3,"cancer",TypeSalle.consultation);

        MetierLit mtl=new MetierLit();
        mtl.addLit(TypeLit.soin,"healthX",1, EtatLit.DISPONIBLE);
        MetierSejour metierSejour=new MetierSejour();
        metierSejour.addSejour(LocalDate.of(2022,12,13), LocalDate.now(),1);
        System.out.println(metierSejour.getSejours());

        System.out.println(mtl.getLits());*/

         //mtl.delete(1);


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
