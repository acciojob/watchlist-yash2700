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
        return "success";
    }

    String addDirectorToDb(Director d){
        String name=d.getName();
        directorDb.put(name,d);
        return "success";
    }
    Movie getMovieByNameFromDb(String name){
        if(movieDb.containsKey(name))
            return movieDb.get(name);
        else
            return null;
    }

    Director getDirectorByNameFromDb(String name){
        if(directorDb.containsKey(name))
            return directorDb.get(name);
        else return null;
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
    return "success";

    }

    List<String> getMoviesByDirectorNameFromDb(String name){
        return movieDirectorpair.getOrDefault(name,null);
    }

    String deleteAllDirectorsFromDb(){
        for(String director : directorDb.keySet()){
            if(movieDirectorpair.containsKey(director)){
                List<String> list = movieDirectorpair.get(director);

                for(String m : list){
                    movieDb.remove(m);
                }
                movieDirectorpair.remove(director);
            }
            directorDb.remove(director);
        }
        return "success";
    }

    String deleteDirectorByNameFromDb(String name){
        if(directorDb.containsKey(name)){
            if(movieDirectorpair.containsKey(name)){
                List<String> res=movieDirectorpair.get(name);
                for(String s:res){
                    movieDb.remove(s);
                }
                movieDirectorpair.remove(name);
            }
            directorDb.remove(name);
        }
        return "success";
    }

}
