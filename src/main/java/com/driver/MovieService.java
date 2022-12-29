package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository mr;
    String addMovieService(Movie m){
        String res=mr.addMoveToDb(m);
        return res;
    }

    String addDirectorService(Director d){
        return mr.addDirectorToDb(d);
    }

    Movie getMovieByNameService(String name){
        return mr.getMovieByName(name);
    }

}
