package com.example.REDspace_StarWar_API;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:5500")
public class PeopleController {

    @GetMapping("/{id}")
    public String getPeople(@PathVariable int id){
        final String URL = "https://swapi.dev/api/people/"+id+"/";

        RestTemplate template = new RestTemplate();
        String s = "";
        try{
            s =  template.getForObject(URL, String.class).replaceAll("http","https");
        }catch (Exception e){
            String errorMessage = "";
            return "Emon";
        }

        int indexOfname = s.indexOf("name");
        int indexOfheight = s.indexOf("height");
        int indexOfmass = s.indexOf("mass");
        int indexOfhair_color = s.indexOf("hair_color");
        int indexOfskin_color = s.indexOf("skin_color");
        int indexOfeye_color = s.indexOf("eye_color");
        int indexOfbirth_year = s.indexOf("birth_year");
        int indexOfgender = s.indexOf("gender");
        int indexOfhomeworld = s.indexOf("homeworld");
        int indexOffilms = s.indexOf("films");
        int indexOfspecies = s.indexOf("species");
        int indexOfvehicles = s.indexOf("vehicles");
//        int indexOfstarships = s.indexOf("starships");
//        int indexOfcreated = s.indexOf("created");
//        int indexOfedited = s.indexOf("edited");
//        int indexOfurl = s.indexOf("url");

        String name = s.substring(indexOfname+"name".length()+3,indexOfheight-3);
        String height = s.substring(indexOfheight+"height".length()+3,indexOfmass-3);
        String mass = s.substring(indexOfmass+"mass".length()+3,indexOfhair_color-3);
        String hair_color = s.substring(indexOfhair_color+"hair_color".length()+3,indexOfskin_color-3);
        String skin_color = s.substring(indexOfskin_color+"skin_color".length()+3,indexOfeye_color-3);
        //String eye_color = s.substring(indexOfeye_color+"eye_color".length()+3,indexOfbirth_year-3);
        String birth_year = s.substring(indexOfbirth_year+"birth_year".length()+3,indexOfgender-3);
        String gender = s.substring(indexOfgender+"gender".length()+3,indexOfhomeworld-3);
        String homeworld = s.substring(indexOfhomeworld+"homeworld".length()+3,indexOffilms-3);

        HomePlanet hp = new HomePlanet(homeworld,template);
        System.out.print(hp);

        String films = s.substring(indexOffilms+"films".length()+3,indexOfspecies-3);
        String[] filmsArray = new String[]{""};
        filmsArray = films.split(",");
        films = makeArray(filmsArray);
        AllFilms af = new AllFilms(filmsArray,template);

        String species = s.substring(indexOfspecies+"species".length()+3,indexOfvehicles-3);
        String[] speciesArray = new String[]{""};
        speciesArray = species.split(",");
        species = makeArray(speciesArray);
        AllSpecies as = new AllSpecies(speciesArray,template);


//        String vehicles = s.substring(indexOfvehicles+"vehicles".length()+3,indexOfstarships-3);
//        String[] vehiclesArray = new String[]{""};
//        vehiclesArray = vehicles.split(",");
//        vehicles = makeArray(vehiclesArray);
//
//
//        String starships = s.substring(indexOfstarships+"starships".length()+3,indexOfcreated-3);
//        String[] starshipsArray = new String[]{""};
//        starshipsArray = starships.split(",");
//        starships = makeArray(starshipsArray);
//
//
//        String created = s.substring(indexOfcreated+"created".length()+3,indexOfedited-3);
//        String edited = s.substring(indexOfedited+"edited".length()+3,indexOfurl-3);
//        String url = s.substring(indexOfurl+"url".length()+3,s.lastIndexOf("\""));

        try{
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(new People(id,name,height,mass,hair_color,skin_color,birth_year,gender,hp,af.getFilms(),as.getSpecies()));
            return json;
        }catch (Exception e){
            return e.toString();
        }
    }

    private String makeArray(String[] s){

        String newS = "";
        for(int i =0;i<s.length;i++){
            if(s[i].length()>1){
                s[i] = s[i].substring(1,s[i].length()-1);
            }
            newS += s[i]+0;
        }
        return newS;
    }
}
