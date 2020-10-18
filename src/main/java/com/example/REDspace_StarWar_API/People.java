package com.example.REDspace_StarWar_API;

import java.net.URL;

public class People {
    private final int id;
    private final String name;
    private final String height;
    private final String mass;
    private final String hair_color;
    private final String skin_color;
//    private final String eye_color;
    private final String birth_year;
    private final String gender;
    private final HomePlanet homeworld;
    private final Film[] films;
    private final Species[] species;
//    private final String[] vehicles;
//    private final String[] starships;
//    private final String created;
//    private final String edited;
//    private final String url;

    public People(){
        this.id = 0;
        this.name = "";
        this.height = "";
        this.mass = "";
        this.hair_color = "";
        this.skin_color = "";
//        this.eye_color = "";
        this.birth_year = "";
        this.gender = "";
        this.homeworld = null;
        this.films = null;
        this.species = null;
//        this.vehicles = null;
//        this.starships = null;
//        this.created = "";
//        this.edited = "";
//        this.url = "";
    }

    public People(int id, String name, String height, String mass, String hair_color, String skin_color, String birth_year, String gender, HomePlanet homeworld, Film[] films, Species[] species) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        //this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.films = films;
        this.species = species;
//        this.vehicles = vehicles;
//        this.starships = starships;
//        this.created = created;
//        this.edited = edited;
//        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

//    public String getEye_color() {
//        return eye_color;
//    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public HomePlanet getHomeworld() {
        return homeworld;
    }

    public Film[] getFilms() {
        return films;
    }

    public Species[] getSpecies() {
        return species;
    }

//    public String[] getVehicles() {
//        return vehicles;
//    }
//
//    public String[] getStarships() {
//        return starships;
//    }
//
//    public String getCreated() {
//        return created;
//    }
//
//    public String getEdited() {
//        return edited;
//    }
//
//    public String getUrl() {
//        return url;
//    }

    @Override
    public String toString()
    {
        return "ClassPeople [id ="+id+", name ="+name+ ", height=" +height+", mass = "+mass+", hair_color = "+hair_color+", skin_color = "+skin_color+", birth_year = "+birth_year+", gender = "+gender+", homeworld = "+homeworld+", films = "+films+", species = "+species+"]";
    }
}
