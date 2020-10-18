package com.example.REDspace_StarWar_API;

import org.springframework.web.client.RestTemplate;

public class Species {

    private final String name;
    private final String average_lifespan;
    private final String classification;
    private final String language;

    Species(final String speciesLink, RestTemplate template){
        String speciesInfo = "";
        try{
            speciesInfo =  template.getForObject(speciesLink, String.class);
        }catch (Exception e){
            System.out.print(e);
        }

        if(speciesInfo == ""){
            name = "";
            average_lifespan = "";
            classification = "";
            language = "";
        }else{
            int indexOfname = speciesInfo.indexOf("name");
            int indexOfaverage_lifespan = speciesInfo.indexOf("average_lifespan");
            int indexOfclassification = speciesInfo.indexOf("classification");
            int indexOflanguage= speciesInfo.indexOf("language");

            name = speciesInfo.substring(indexOfname+"name".length()+3, speciesInfo.indexOf("\"",indexOfname+"name".length()+4));
            average_lifespan = speciesInfo.substring(indexOfaverage_lifespan+"average_lifespan".length()+3, speciesInfo.indexOf("\"",indexOfaverage_lifespan+"average_lifespan".length()+4));
            classification = speciesInfo.substring(indexOfclassification+"classification".length()+3, speciesInfo.indexOf("\"",indexOfclassification+"classification".length()+4));
            language = speciesInfo.substring(indexOflanguage+"language".length()+3, speciesInfo.indexOf("\"",indexOflanguage+"language".length()+4));
        }
    }

    public String getName ()
    {
        return name;
    }

    public String getAverage_lifespan ()
    {
        return average_lifespan;
    }

    public String getClassification ()
    {
        return classification;
    }

    public String getLanguage ()
    {
        return language;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", average_lifespan = "+average_lifespan+", classification = "+classification+", language = "+language+"]";
    }
}
