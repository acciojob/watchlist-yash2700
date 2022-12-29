package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    MovieService ms;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie m){
    String res=ms.addMovieService(m);
    return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director d){
        String res=ms.addDirectorService(d);
        return new ResponseEntity<>(res,HttpStatus.OK);
        }

     @GetMapping("/get-movie-by-name")
     public ResponseEntity<Movie> getMovieByName(@RequestParam("name")String name){
        Movie res=ms.getMovieByNameService(name);
        if(res!=null){
            return new ResponseEntity<>(res,HttpStatus.FOUND);
        }
        else
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
     }


}
