package ma.uiass.eia.pds.frontend.Http;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;


import ma.uiass.eia.pds.backend.Entite.Chambre;
import ma.uiass.eia.pds.backend.Entite.Emplacement;
import ma.uiass.eia.pds.backend.Entite.Lit;
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
    public List<Service> getServices() {
        WebResource wr = webResource;
        String json = wr.path("services").accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        //List<Service> services = objectMapper.readValue(json, new TypeReference<List<Service>>(){});
        List<Service> services = gson.fromJson(json, new TypeToken<List<Service>>(){}.getType());
        return services;
    }
    public List<Emplacement> getEmplacements(){
        WebResource wr = webResource;
        String json = wr.path("emplacement").accept(MediaType.APPLICATION_JSON).get(String.class);
        List<Emplacement> emplacements = gson.fromJson(json, new TypeToken<List<Emplacement>>(){}.getType());
        return emplacements;
    }

    public List<Chambre> getChambres() throws JsonProcessingException {
        WebResource wr = webResource;
        String json = wr.path("chambre").accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        //List<Chambre> chambres = objectMapper.readValue(json, new TypeReference<List<Chambre>>(){});
        List<Chambre> chambres = gson.fromJson(json, new TypeToken<List<Chambre>>(){}.getType());
        return chambres;
    }
    public List<Lit> getLits(){
        WebResource wr = webResource;
        String json = wr.path("lits").accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(json);
        List<Lit> Lits = gson.fromJson(json, new TypeToken<List<Lit>>(){}.getType());
        return Lits;
    }


    public static void main(String[] args) throws JsonProcessingException {
        HttpClient h = new HttpClient();
        List<Chambre> L = h.getChambres();
        List<Lit> S = h.getLits();
        List<Service> k = h.getServices();
        List<Chambre> chambres = h.getChambre();
        System.out.println(S);
    }
    public List<Chambre> getChambre() {
        WebResource wr = webResource;
        String json = wr.path("chambre").accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(json);
        ObjectMapper objectMapper = new ObjectMapper();
        //List<Service> services = objectMapper.readValue(json, new TypeReference<List<Service>>(){});
        List<Chambre> c = gson.fromJson(json, new TypeToken<List<Chambre>>(){}.getType());
        return c;

    }

}
