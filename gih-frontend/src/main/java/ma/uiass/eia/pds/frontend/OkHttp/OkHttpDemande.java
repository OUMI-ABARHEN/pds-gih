package ma.uiass.eia.pds.frontend.OkHttp;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import ma.uiass.eia.pds.backend.Entite.*;
import okhttp3.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class OkHttpDemande {
    OkHttpClient okHttpClient = new OkHttpClient();
    Gson gson = new Gson();


    public void addDemande( String codeD,String nomS,EtatDemande etat ){
        FormBody formBody = new FormBody.Builder()
                .add("codeD",codeD)
                .add("nomS",nomS)
                .add("etat",etat.toString())
                .build();


        Request request = new Request.Builder()
                .url("http://localhost:2002/pds/addDemande" )
                .post(formBody)
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

    public void updateDetail(String codeDD, String codeD){
        FormBody formBody = new FormBody.Builder()
                .add("codeDD",codeDD)
                .add("codeD",codeD)
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:2002/pds/updateDetail" )
                .post(formBody)
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


    public void addDetailDemande( String code, TypeLit typeLit ,  int q ){
        FormBody formBody = new FormBody.Builder()
                .add("code",code)
                .add("typeL",typeLit.toString())
                .add("quantite",Integer.toString(q))
                .build();


        Request request = new Request.Builder()
                .url("http://localhost:2002/pds/addDetail" )
                .post(formBody)
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
    public List<DemandeFormat> getDemandes() {
        Request request = new Request.Builder().url("http://localhost:2002/pds/Demandes").build();
        List<DemandeFormat> demandes = new ArrayList<>();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
            JsonElement jsonElement = gson.fromJson(response.body().charStream(), JsonElement.class);
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement j : jsonArray) {
                JsonObject jsonObject = j.getAsJsonObject();
                DemandeFormat d = gson.fromJson(jsonObject, DemandeFormat.class);
                demandes.add(d);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return demandes;
    }

    public DemandeFormat getDemande(String code) {
        Request request = new Request.Builder().url("http://localhost:2002/pds/uneDemande/" + code).build();
        DemandeFormat d = new DemandeFormat();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
            JsonElement jsonElement = gson.fromJson(response.body().charStream(), JsonElement.class);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            d = gson.fromJson(jsonObject, DemandeFormat.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return d;
    }
    public List<DemandeFormat> getByService(String nomS){
        Request request = new Request.Builder().url("http://localhost:2002/pds/getDemandeService/" + nomS).build();
        List<DemandeFormat> demandes = new ArrayList<>();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
            JsonElement jsonElement = gson.fromJson(response.body().charStream(), JsonElement.class);
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement j : jsonArray) {
                JsonObject jsonObject = j.getAsJsonObject();
                DemandeFormat d = gson.fromJson(jsonObject, DemandeFormat.class);
                demandes.add(d);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return demandes;

    }

    public void delete(String code){
        RequestBody formBody = new FormBody.Builder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:2002/pds/deleteDetail"+code )
                .delete(formBody)
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
    public void updateEtatDemande(String code,EtatDemande etat){
        FormBody formBody = new FormBody.Builder()
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:2002/pds/updateEtat/"+code+"/"+etat )
                .post(formBody)
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
    public void addLitStock(TypeLit type,String nomS){
        FormBody formBody = new FormBody.Builder()
                .add("typeLit",type.toString())
                .add("nomS",nomS)
                .build();


        Request request = new Request.Builder()
                .url("http://localhost:2002/pds/addLitStock" )
                .post(formBody)
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


    public static void main(String [] args ) throws ParseException {


        OkHttpDemande o = new OkHttpDemande();
        // o.addDetailDemande("D003","dd",TypeLit.hospitalisation,1);
        //    System.out.println(d.getCode() + " " + d.getDate() + " " + d.getEtat());
        //for(DemandeFormat d : o.getDemandes()){
        //    System.out.println(d.getLst());
        //}
        //o.updateEtatDemande("D579",EtatDemande.REJETEE);
        o.addLitStock(TypeLit.soin,"cancer");



    }





}
