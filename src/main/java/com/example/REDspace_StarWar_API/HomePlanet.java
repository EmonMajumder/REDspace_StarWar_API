package com.example.REDspace_StarWar_API;

import org.springframework.web.client.RestTemplate;

public class HomePlanet {
    private final String title;
    private final String terrain;
    private final String population;

    HomePlanet(final String homePlanetLink, RestTemplate template){
        String planetInfo = "";
        try{
            planetInfo =  template.getForObject(homePlanetLink, String.class);
        }catch (Exception e){
            System.out.print(e);
        }

        if(planetInfo == ""){
            title = "";
            terrain = "";
            population = "";
        }else{
            int indexOfname = planetInfo.indexOf("name");
            int indexOfterrain = planetInfo.indexOf("terrain");
            int indexOfpopulation = planetInfo.indexOf("population");

            title = planetInfo.substring(indexOfname+"name".length()+3, planetInfo.indexOf("\"",indexOfname+"name".length()+4));
            terrain = planetInfo.substring(indexOfterrain+"terrain".length()+3, planetInfo.indexOf("\"",indexOfterrain+"terrain".length()+4));
            population = planetInfo.substring(indexOfpopulation+"population".length()+3, planetInfo.indexOf("\"",indexOfpopulation+"population".length()+4));
        }
    }

    public String getTitle() {
        return title;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getPopulation() {
        return population;
    }

    public String toString(){
        return "".join("-",title,terrain,population);
    }
}
