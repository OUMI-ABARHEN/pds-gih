package ma.uiass.eia.pds.frontend.OkHttp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import ma.uiass.eia.pds.backend.Entite.Chambre;
import ma.uiass.eia.pds.backend.Entite.Lit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.codehaus.jettison.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OkHttp {
    OkHttpClient okHttpClient = new OkHttpClient();
    Gson gson = new Gson();

    public List<Chambre> chambreList() {
        Request request = new Request.Builder().url("http://localhost:2002/pds/chambre").build();
        List<Chambre> chambres = new ArrayList<>();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
            JsonElement jsonElement = gson.fromJson(response.body().charStream(), JsonElement.class);
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement j : jsonArray) {
                JsonObject jsonObject = j.getAsJsonObject();
                Chambre chambre = gson.fromJson(jsonObject, Chambre.class);
                chambres.add(chambre);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return chambres;

    }

    public List<Lit> getLits() {
        Request request = new Request.Builder().url("http://localhost:2002/pds/lits").build();
        List<Lit> lits = new ArrayList<>();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
            JsonElement jsonElement = gson.fromJson(response.body().charStream(), JsonElement.class);
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement j : jsonArray) {
                JsonObject jsonObject = j.getAsJsonObject();
                System.out.println(jsonObject);
                Lit lit = gson.fromJson(jsonObject, Lit.class);
                lits.add(lit);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lits;

    }

    public static void main(String[] args) {
        OkHttp o = new OkHttp();
        System.out.println(o.chambreList());

    }
}
