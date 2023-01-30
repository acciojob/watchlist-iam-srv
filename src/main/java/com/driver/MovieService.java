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
   public void addMovie(Movie movie){
       movieRepository.saveMovie(movie);
   }

    // 2
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }

    //3
    public void createMovieDirectorPair( String movie ,String director){
        movieRepository.saveMovieDirectorPair(movie, director);
    }

    // 4
    public Movie findMovie(String movieName){
        return movieRepository.findMovie(movieName);
    }

    public Director findDirector(String directorName){
        return movieRepository.findDirector(directorName);
    }

    public List<String> findMoviesFromDirector(String director){
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }
}
