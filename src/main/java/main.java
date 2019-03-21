
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import entity.City;
import entity.MyCity;
import com.fasterxml.jackson.databind.ObjectMapper;
import error.ApiError;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
    public static final String apiUrl = "https://api.themoviedb.org/3/";
    public static final String APPID = "580c3fdf7b076afec166b45304891b55";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        System.out.println(peliculasPopulares());


    }
    public static String peliculasPopulares()throws Exception {
        String url = apiUrl + "discover/movie?" + "api_key=" + APPID + "&language=es-ES&sort_by=popularity.desc";
        System.out.println(url);
        final HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();

        String resu = "";
        for (int i = 0;i<json.getJSONArray("results").length();i++) {
            String resultado = ("peliculas:" + json.getJSONArray("results").getJSONObject(i).get("title"));
            resu += resultado+"\n";

        }
        return resu;
    }
}
