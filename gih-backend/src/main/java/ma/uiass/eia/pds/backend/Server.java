package ma.uiass.eia.pds.backend;

import jakarta.ws.rs.core.UriBuilder;
import ma.uiass.eia.pds.backend.Controleur.*;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Server {
    public static void main(String[] args) {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(2002).build();
        ResourceConfig config = new ResourceConfig();
        config.register(ServiceControlor.class);
        config.register(EmplacementControlor.class);
        config.register(IdentifiantControlor.class);
        config.register(LitControlor.class);
        config.register(SejourControlor.class);
        config.register(ChambreControlor.class);
        config.register(DemandeControlor.class);
        config.register(DetailDemandeControlor.class);
        config.register(LoginControlor.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);

    }
}
