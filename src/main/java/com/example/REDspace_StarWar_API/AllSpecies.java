package com.example.REDspace_StarWar_API;

import org.springframework.web.client.RestTemplate;

public class AllSpecies {
    private final Species[] species;

    AllSpecies(final String[] speciesLink, RestTemplate template){
        int numberOfFilms = speciesLink.length;
        species = new Species[numberOfFilms];
        for(int i=0; i< numberOfFilms; i++){
            species[i] = new Species(speciesLink[i], template);
        }
    }

    public Species[] getSpecies() {
        return species;
    }

    @Override
    public String toString(){
        String s = "ClassAllSpecies[";
        for(Species species:species){
            s+=species;
        }
        s+="]";
        return s;
    }
}
