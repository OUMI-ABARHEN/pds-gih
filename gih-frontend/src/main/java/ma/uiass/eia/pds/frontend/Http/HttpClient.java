package ma.uiass.eia.pds.frontend.Http;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import ma.uiass.eia.pds.backend.Entite.Chambre;
import ma.uiass.eia.pds.backend.Entite.Emplacement;
import ma.uiass.eia.pds.backend.Entite.Service;


import javax.ws.rs.core.MediaType;
import java.util.List;

public class HttpClient {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:2002/pds";
    Gson gson = new Gson();
    public HttpClient(){
        client = Client.create(new DefaultClientConfig());
        webResource = client.resource(BASE_URI);

    }
    public List<Service> getServices(){
        WebResource wr = webResource;
        String json = wr.path("services").accept(MediaType.APPLICATION_JSON).get(String.class);
        List<Service> services = gson.fromJson(json, new TypeToken<List<Service>>(){}.getType());
        return services;
    }
    public List<Emplacement> getEmplacements(){
        WebResource wr = webResource;
        String json = wr.path("emplacement").accept(MediaType.APPLICATION_JSON).get(String.class);
        List<Emplacement> emplacements = gson.fromJson(json, new TypeToken<List<Emplacement>>(){}.getType());
        return emplacements;
    }

    public List<Chambre> getChambres(){
        WebResource wr = webResource;
        String json = wr.path("emplacement").accept(MediaType.APPLICATION_JSON).get(String.class);
        List<Chambre> chambres = gson.fromJson(json, new TypeToken<List<Chambre>>(){}.getType());
        return chambres;
    }



}
