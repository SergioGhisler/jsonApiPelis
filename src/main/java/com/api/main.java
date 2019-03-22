package com.api;
import java.awt.*;
import java.net.URL;
import java.net.URLEncoder;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;



public class main {
    public static final String apiUrl = "https://api.themoviedb.org/3/";
    public static final String APPID = "580c3fdf7b076afec166b45304891b55";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        System.out.println( buscar1PeliID("Capitana Marvel"));


    }
    public static String getPeliculasPopulares()throws Exception {
        String url = apiUrl + "discover/movie?" + "api_key=" + APPID + "&language=es-ES&sort_by=popularity.desc";
        System.out.println(url);
        final HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();

        String resu = "";
        for (int i = 0;i<json.getJSONArray("results").length();i++) {
            String resultado = ("" + json.getJSONArray("results").getJSONObject(i).get("title"));
            resu += resultado+"\n";

        }
        return resu;
    }




    public static String getDescripcionPelicula(String nombre) throws Exception{

        int id = buscar1PeliID(nombre);
        String url = apiUrl + "movie/"+id + "?api_key=" + APPID + "&language=es-ES";
        System.out.println(url);
        final HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();
        try {

            return (String) json.get("overview");
        }catch(Exception e){
            return "No se dispone de descripcion";
        }
    }
    public static String getNombrePelicula(String nombre)throws Exception{
        int id = buscar1PeliID(nombre);
        String url = apiUrl + "movie/"+id + "?api_key=" + APPID + "&language=es-ES";
        System.out.println(url);
        final HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();
        try{
        return (String) json.get("title");
    }catch (Exception e){
            return "La pelicula no existe";
        }
    }

    public static ImageIcon getFoto( String nombre)throws Exception{
        int id = buscar1PeliID(nombre);
        String url =apiUrl + "movie/"+id + "?api_key=" + APPID + "&language=es-ES";

        final HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();
        try{
            String peli = (String) json.get("poster_path");
            URL url2 = new URL("http://image.tmdb.org/t/p/w154"+ peli);
            System.out.println(url2);
            Image image = ImageIO.read(url2);
            ImageIcon icon = new ImageIcon(image);

            return icon;
        }catch ( Exception e) {
            URL url2 = new URL("https://www.themoviedb.org/assets/2/v4/logos/208x226-stacked-green-9484383bd9853615c113f020def5cbe27f6d08a84ff834f41371f223ebad4a3c.png");
            Image image = ImageIO.read(url2);
            ImageIcon icon = new ImageIcon(image);
            return icon;
        }

    }

    public static String buscarPeli(String query)throws Exception{
        String url = apiUrl + "search/movie?" + "api_key=" + APPID + "&language=es-ES&query="+ query;
        System.out.println(url);
        final HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();

        String resu = "";
        for (int i = 0;i<json.getJSONArray("results").length();i++) {
            String resultado = ("" + json.getJSONArray("results").getJSONObject(i).get("title"));
            resu += resultado+"\n";

        }
        return resu;
    }
    public static int buscar1PeliID(String query)throws Exception{
        query = URLEncoder.encode(query,"UTF-8");
        String url = apiUrl + "search/movie?" + "api_key=" + APPID + "&language=es-ES&query="+ query;
        System.out.println(url);
        final HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();



            int id = Integer.parseInt(""+json.getJSONArray("results").getJSONObject(0).get("id"));



        return id;
    }
}
