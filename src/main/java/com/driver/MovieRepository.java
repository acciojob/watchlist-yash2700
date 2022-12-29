package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDb=new HashMap<>();
    HashMap<String,Director> directorDb=new HashMap<>();

    String addMoveToDb(Movie m){
        String name=m.getName();
        movieDb.put(name,m);
        return "Successfully added";
    }

    String addDirectorToDb(Director d){
        String name=d.getName();
        directorDb.put(name,d);
        return "successfully added the director";
    }
    Movie getMovieByName(String name){
        return movieDb.get(name);
    }


}
