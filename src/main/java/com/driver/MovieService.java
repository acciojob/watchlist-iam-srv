package com.driver;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository ;

   // 1
    public String addMovie(Movie movie){
        movieRepository.saveMovie(movie);
        return "Movie Add Successfully";
    }

    // 2
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }

    //3
    public void addPair( String movie ,String director){
        movieRepository.saveMovieDirectorPair(movie, director);
    }

    // 4
    public Movie getMovie(String movie){
         return movieRepository.findMovie(movie);
    }

    // 5
    public Director getDirector(String director){
        return movieRepository.findDirector(director);
    }

    // 6
    public List<String> getMovieByDirectorName(String director){
        return movieRepository.findMoviesFromDirector(director);
    }

    // 7
    public List<String> getAllMovies() {
        return movieRepository.findAllMovies();
    }

    // 8
    public void deleteDirectorByName(String director) {
        movieRepository.deleteDirector(director);
    }

    // 9
    public void deleteAllDirectors() {
        movieRepository.deleteAllDirector();
    }
}
