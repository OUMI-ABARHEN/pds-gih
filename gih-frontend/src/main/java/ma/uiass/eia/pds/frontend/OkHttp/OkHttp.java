package ma.uiass.eia.pds.frontend.OkHttp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import ma.uiass.eia.pds.backend.Entite.*;
import ma.uiass.eia.pds.backend.Metier.MetierJob;
import okhttp3.*;
import org.codehaus.jettison.json.JSONException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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




    public List<Identifiant> getIdentifiants() {
        Request request = new Request.Builder().url("http://localhost:2002/pds/identifiants").build();
        List<Identifiant> identifiants = new ArrayList<>();
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
                Identifiant identifiant = gson.fromJson(jsonObject, Identifiant.class);
                identifiants.add(identifiant);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return identifiants;
    }



    public void addIdentifiant(Identifiant identifiant) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(identifiant);
        System.out.println(json);
        RequestBody requestBody = RequestBody.create(json, JSON);
        System.out.println(requestBody);
        Request request = new Request.Builder()
                .url("http://localhost:2002/pds/addIdentifiant")
                .post(requestBody)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response);
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Service> getServices() {
        Request request = new Request.Builder().url("http://localhost:2002/pds/services").build();
        List<Service> services = new ArrayList<>();
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
                Service service = gson.fromJson(jsonObject, Service.class);
                services.add(service);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return services;
    }

    public List<Emplacement> getEmplacements() {
        Request request = new Request.Builder().url("http://localhost:2002/pds/emplacement").build();
        List<Emplacement> emplacements = new ArrayList<>();
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
                Emplacement emplacement = gson.fromJson(jsonObject, Emplacement.class);
                emplacements.add(emplacement);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return emplacements;
    }

    public void deleteIdentifient(String codeIdentifiant) {
        String url = "http://localhost:2002/pds/DeleteIdentifient" + codeIdentifiant;
        Request request = new Request.Builder().url(url).delete().build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addService(String code,String nomS,String codeE ){
        FormBody formBody = new FormBody.Builder()
                .add("code", code)
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:2002/pds/addService/" + code + "/" + nomS + "/" + codeE )
                .put(formBody)
                .build();
        System.out.println(request);
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SejourFormatted> getSejours() {
        Request request = new Request.Builder().url("http://localhost:2002/pds/sejours").build();
        List<SejourFormatted> sejours = new ArrayList<>();
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
                SejourFormatted sejour = gson.fromJson(jsonObject, SejourFormatted.class);
                sejours.add(sejour);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sejours;
    }

    public void addSejourok(Date date_entre, Date date_sortie, String code) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String date_entre_str = formatter.format(date_entre);
        String date_sortie_str = formatter.format(date_sortie);

        RequestBody formBody = new FormBody.Builder()
                .add("date_entre", date_entre_str)
                .add("date_sortie", date_sortie_str)
                .add("Code", code)
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:2002/pds/addsejour/" + date_entre_str + "/" + date_sortie_str + "/" + code)
                .put(formBody)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } //add okhttp

    public void updateEtatLit(String codeLit, EtatLit etatLit) {
        String url = "http://localhost:2002/pds/UpdateLit/" + codeLit + "/" + etatLit.toString();
        Request request = new Request.Builder().url(url).post(RequestBody.create("", MediaType.parse("application/json"))).build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Lit getLitByCode(String code) {
        Request request = new Request.Builder().url("http://localhost:2002/pds/LitByCode" + code).build();
        Lit lit = null;
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
            JsonElement jsonElement = gson.fromJson(response.body().charStream(), JsonElement.class);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            System.out.println(jsonObject);
            lit = gson.fromJson(jsonObject, Lit.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lit;
    }


    public static void main(String[] args) {
        MetierJob mj = new MetierJob();
        OkHttp o = new OkHttp();
        //o.getIdentifiants();
        o.getLits();
        // o.addService("S102","Urgence","EM005");
        //o.addIdentifiant(new Identifiant("ID0000","kldj","dasf","fs@gmail.com",666679767, Sexe.FEMELAE,"admin",mj.finfByid(1)));

    }

}
