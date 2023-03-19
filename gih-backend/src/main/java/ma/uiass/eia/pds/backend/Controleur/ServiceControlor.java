package ma.uiass.eia.pds.backend.Controleur;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.backend.Entite.Service;
import ma.uiass.eia.pds.backend.Metier.MetierService;

import java.util.List;

@Path("pds")

public class ServiceControlor {
    MetierService metierService = new MetierService();
    @GET
    @Path("hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GET
    @Path("services")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Service> getMyServices() {
        return metierService.showServices();
    }

}
