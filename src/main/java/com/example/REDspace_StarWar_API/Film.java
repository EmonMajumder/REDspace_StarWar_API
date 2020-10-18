package com.example.REDspace_StarWar_API;

import org.springframework.web.client.RestTemplate;

public class Film {

    private final String release_date;
    private final String director;
    private final String producer;
    private final String title;

    Film(final String filmLink, RestTemplate template){
        String filmInfo = "";
        try{
            filmInfo =  template.getForObject(filmLink, String.class);
        }catch (Exception e){
            System.out.print(e);
        }

        if(filmInfo == ""){
            title = "";
            director = "";
            producer = "";
            release_date = "";
        }else{
            int indexOftitle = filmInfo.indexOf("title");
            int indexOfdirector = filmInfo.indexOf("director");
            int indexOfproducer = filmInfo.indexOf("producer");
            int indexOfrelease_date= filmInfo.indexOf("release_date");

            title = filmInfo.substring(indexOftitle+"title".length()+3, filmInfo.indexOf("\"",indexOftitle+"title".length()+4));
            director = filmInfo.substring(indexOfdirector+"director".length()+3, filmInfo.indexOf("\"",indexOfdirector+"director".length()+4));
            producer = filmInfo.substring(indexOfproducer+"producer".length()+3, filmInfo.indexOf("\"",indexOfproducer+"producer".length()+4));
            release_date = filmInfo.substring(indexOfrelease_date+"release_date".length()+3, filmInfo.indexOf("\"",indexOfrelease_date+"release_date".length()+4));
        }
    }

    public String getRelease_date ()
    {
        return release_date;
    }

    public String getDirector ()
    {
        return director;
    }

    public String getProducer ()
    {
        return producer;
    }

    public String getTitle ()
    {
        return title;
    }

    @Override
    public String toString()
    {
        return "[title = "+title+", director = "+director+", producer = "+producer+", release_date = "+release_date+"]";
    }
}
