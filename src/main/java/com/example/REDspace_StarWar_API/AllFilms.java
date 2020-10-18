package com.example.REDspace_StarWar_API;

import org.springframework.web.client.RestTemplate;

public class AllFilms {
    private final Film[] films;

    AllFilms(final String[] filmsLink, RestTemplate template){
        int numberOfFilms = filmsLink.length;
        films = new Film[numberOfFilms];
        for(int i=0; i< numberOfFilms; i++){
            films[i] = new Film(filmsLink[i], template);
        }
    }

    public Film[] getFilms() {
        return films;
    }

    @Override
    public String toString(){
        String s = "ClassAllFilms [";
        for(Film film:films){
            s+=film;
        }
        s+="]";
        return s;
    }
}
