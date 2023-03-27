package ma.uiass.eia.pds.backend.Controleur;


import jakarta.ws.rs.*;
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

    @PUT
    @Path("addService/{code}/{nomS}/{codeE}")
    @Produces(MediaType.APPLICATION_JSON)
    public void addService(@PathParam("code") String code,@PathParam("nomS") String nomS,@PathParam("codeE") String codeE ){
        metierService.addService(code,nomS,codeE);
    }


}
