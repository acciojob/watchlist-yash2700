package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDb=new HashMap<>();
    HashMap<String,Director> directorDb=new HashMap<>();

    HashMap<String,List<String >> movieDirectorpair=new HashMap<String,List<String>>();
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
    Movie getMovieByNameFromDb(String name){
        return movieDb.get(name);
    }

    Director getDirectorByNameFromDb(String name){
        return directorDb.get(name);
    }
    List<String> findAllMoviesFromDb(){
        List<String> res=new ArrayList<String>();
        for(String name:movieDb.keySet()){
            res.add(name);
        }
        return res;
    }

    String addMovieDirectorPairToDb(String directorName,String movieName){
    if(movieDirectorpair.containsKey(directorName))
        movieDirectorpair.get(directorName).add(movieName);

    else {
        List<String> res=new ArrayList<String>();
        res.add(movieName);
        movieDirectorpair.put(directorName,res);
    }
    return "Successfully added";

    }

    List<String> getMoviesByDirectorNameFromDb(String name){
        return movieDirectorpair.get(name);
    }

}
