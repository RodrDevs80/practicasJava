package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        //Download webs
        List<String> linkList=new ArrayList<>();
        linkList.add("https://www.nuevodiarioweb.com.ar/");
        linkList.add("https://www.elliberal.com.ar/");
        linkList.add("https://diariopanorama.com/");
        linkList.add("https://www.elhistoriador.com.ar/");
        linkList.add("https://www.cronista.com/");



        linkList.stream().parallel().forEach(link->getWebContent(link));




        String link= "https://www.nuevodiarioweb.com.ar/";

        String result = Main.getWebContent(link);



    }

    private static String getWebContent(String link) {
        System.out.println(link);
        String result = null;
        try {
            URL url = new URL(link);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String encoding = connection.getContentEncoding();

            InputStream inputStream = connection.getInputStream();

            result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

         return result;
    }
}