package com.driver;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ranges.DocumentRange;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {

    @Autowired
    MovieService movieService;
 // 1 POST MOVIE
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie Added Successfully" , HttpStatus.CREATED);
    }
  // 2 POST  DIRECTOR
    @PostMapping("/add-director")
    public ResponseEntity<String>  addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director Added Successfully" , HttpStatus.CREATED);
    }

    // 3 PUT  DIRECTOR MOVIE PAIR
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie , @RequestParam String director){
        movieService.addPair(movie, director);
        ResponseEntity<String > rs = new ResponseEntity<>("Director movie-Pair Added Successfully" ,HttpStatus.CREATED );
        return rs;
    }

    // 4 GET movie
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getByName(@PathVariable("name") String movie){
        Movie movies =  movieService.getMovie(movie);
        return new ResponseEntity<>(movies , HttpStatus.FOUND);
    }

    // 5 GET Director
    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity<Director>  getDirector (@PathVariable("name") String director){
        Director director1 = movieService.getDirector(director);
        return new ResponseEntity<>(director1 , HttpStatus.FOUND);
    }

    // 6 Get movieList by director name
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMovieByDirectorName(@PathVariable("director") String director){
        List<String> movies = movieService.getMovieByDirectorName(director);
        return new ResponseEntity<>(movies , HttpStatus.FOUND);
    }

    // 7 GET List of all movies
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> allMovies(){
        List<String>  movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies , HttpStatus.FOUND);
    }

    //8 DELETE a director and its movies
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>  deleteDirectorByName(@RequestParam String director){
        movieService.deleteDirectorByName(director);
        return new ResponseEntity<>("Director have removed Successfully" , HttpStatus.ACCEPTED);
    }

    // 9 DELETE all Directors
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors Have Removed Successfully" , HttpStatus.ACCEPTED);
    }
}
