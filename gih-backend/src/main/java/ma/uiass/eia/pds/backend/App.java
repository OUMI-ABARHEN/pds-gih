package ma.uiass.eia.pds.backend;

import jakarta.ws.rs.core.UriBuilder;
import ma.uiass.eia.pds.backend.Controleur.*;
import ma.uiass.eia.pds.backend.Dao.EmplacementDaoImp;
import ma.uiass.eia.pds.backend.Entite.*;
import ma.uiass.eia.pds.backend.Metier.*;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


public class App 
{
    public static void main( String[] args ) {
        MetierEmplacement metierEmplacement = new MetierEmplacement();
        /*metierEmplacement.create("EM001","batiment1","E01");
        metierEmplacement.create("EM002","batiment A","E01");
        metierEmplacement.create("EM003","batiment B","E01");
        metierEmplacement.create("EM004","batiment C","E01");
        metierEmplacement.create("EM005","batiment D","E01");*/
        //metierEmplacement.delete(1);
        //System.out.println(metierEmplacement.getAll());

        MetierJob metierJob = new MetierJob();
        /*metierJob.add("JB001","admin ");
        metierJob.add("JB002","Agent Logistic");
        metierJob.add("JB003","Chef Service");*/


        MetierIdentifiant metierIdentifiant = new MetierIdentifiant();
       /* metierIdentifiant.add("ID001","oumaima","abarhen","obarhen@gmail.com",666679767, Sexe.FEMELAE,"admin",1);
        metierIdentifiant.add("ID002","ahmed","elghassib","ahmedelghassib@gmail.com",660079767, Sexe.MALE,"admin",1);
        metierIdentifiant.add("ID003","badr","elabbady","badrelghassib@gmail.com",666679700, Sexe.MALE,"admin",1);
        metierIdentifiant.add("ID004","jihad","hibatallah","jihadhibataalah@gmail.com",66098767, Sexe.FEMELAE,"admin",1);
        metierIdentifiant.add("ID005","marouan","aghbalo","marouanaghbalo@gmail.com",666679787, Sexe.MALE,"admin",1);*/

        //System.out.println(metierIdentifiant.getPassword(1));
        //System.out.println(metierIdentifiant.isCorrect(1,"admin"));



        MetierService sr=new MetierService ();
        /*sr.addService("SR001", "cardiologie",1);
        sr.addService("SR002", "cancer",2);
        sr.addService("SR003", "chirurgi3",3);*/

       // sr.deleteService("chirurgi3");
        //System.out.println(sr.findServiceByName("chirurgi3"));
        //System.out.println(sr.showServiceById(1));
         //System.out.println(sr.showServices());




        MetierChambre metierChambre = new MetierChambre();
       /* metierChambre.addChambre("CH001",1,"chirurgi3", TypeChambre.PEDIATRIE);
        metierChambre.addChambre("CH002",2,"cardiologie", TypeChambre.DOUBLE);
        metierChambre.addChambre("CH003",3,"cardiologie", TypeChambre.TRIPLE);
        metierChambre.addChambre("CH004",1,"cardiologie", TypeChambre.INDIVIDUELLE);*/

        // System.out.println(metierChambre.getAllChambre());

        MetierSalle metierSalle = new MetierSalle();
       /* metierSalle.addSalle("SL001",3,"cardiologie", TypeSalle.consultation);
        metierSalle.addSalle("SL002",2,"cardiologie", TypeSalle.radiologie);
        metierSalle.addSalle("SL003",1,"cardiologie", TypeSalle.operation);*/
        // System.out.println(metierSalle.getAllSalle());
        //metierSalle.delete(3);
//
        MetierLit mtl=new MetierLit();
        /*mtl.addLit("LI001",TypeLit.soin,"healthX",1, EtatLit.DISPONIBLE);
        mtl.addLit("LI002",TypeLit.soin,"healthX",1, EtatLit.DISPONIBLE);
        mtl.addLit("LI003",TypeLit.soin,"healthX",1, EtatLit.DISPONIBLE);
        mtl.addLit("LI004",TypeLit.hospitalisation,"healthX",1, EtatLit.OCCUPE);
        mtl.addLit("LI005",TypeLit.hospitalisation,"healthX",1, EtatLit.EN_STOCK);*/
        //System.out.println(mtl.searchById(1));
        // mtl.updateEtat(1,EtatLit.OCCUPE);
        //mtl.deleteLit(1);
        //System.out.println(mtl.getLits());


       /* LocalDate localDate = LocalDate.of(2022, 12, 13);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());*/


        MetierSejour metierSejour=new MetierSejour();
       // metierSejour.addSejour(date, Calendar.getInstance().getTime(),2);
        //System.out.println(metierSejour.getSejours());
        //metierSejour.deleteSejour(1);

       // System.out.println(metierChambre.getAll().get(0));
        //System.out.println(new java.util.Date().getTime());





    }
}
