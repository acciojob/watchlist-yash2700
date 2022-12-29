package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

     @GetMapping("/movies/get-movie-by-name/{name}")
     public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){
        Movie res=ms.getMovieByNameService(name);
        if(res!=null){
            return new ResponseEntity<>(res,HttpStatus.FOUND);
        }
        else
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
     }
     @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name){
        Director d=ms.getDirectorByNameService(name);
        if(d!=null)
            return new ResponseEntity<>(d,HttpStatus.FOUND);
        else
            return new ResponseEntity<>(d,HttpStatus.BAD_REQUEST);
     }

     @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(ms.findAllMoviesService(),HttpStatus.OK);
     }

     @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("directorName") String directorName,@RequestParam("movieName")String movieName){
        return new ResponseEntity<>(ms.addMovieDirectorPairService(directorName,movieName),HttpStatus.OK);
     }

     @GetMapping("/movies/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name")String name){
        return new ResponseEntity<>(ms.getMoviesByDirectornameService(name),HttpStatus.OK);
     }

     @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String > deleteAllDirectors(){
        return new ResponseEntity<>(ms.deleteAllDirectorsService(),HttpStatus.GONE);
     }

     @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorbyName(@RequestParam("name")String name){
        return new ResponseEntity<>(ms.deleteDirectorByNameService(name));
     }

}
