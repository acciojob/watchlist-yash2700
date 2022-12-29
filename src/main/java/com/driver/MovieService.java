package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository mr;
    String addMovieService(Movie m){
        String res=mr.addMovie(m);
        return res;
    }

    String addDirectorService(Director d){
        return mr.addDirector(d);
    }

    Movie getMovieByNameService(String name){
        return mr.getMovieByName(name);
    }

    Director getDirectorByNameService(String name){
        return mr.getDirectorByName(name);
    }
    List<String> findAllMoviesService(){
        return mr.findAllMovies();
    }

    String addMovieDirectorPairService(String directorName,String movieName){
    return mr.addMovieDirectorPair(directorName,movieName);
    }
    List<String> getMoviesByDirectornameService(String name){
    return mr.getMoviesByDirectorName(name);
    }

    String deleteAllDirectorsService(){
        return mr.deleteAllDirectors();
    }
    String deleteDirectorByNameService(String name){
        return mr.deleteDirectorByName(name);
    }

}
