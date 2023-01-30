package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private Map<String, Movie> movieMap; //movie name  , movie
    private Map<String, Director> directorMap; //director name , director
    private Map<String, List<String>> directorMovieMap; // director , List of movies

    public MovieRepository() {
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.directorMovieMap = new HashMap<>();
    }
   // 1 POST
    public void saveMovie(Movie movie) {  // just add into the movie map
        movieMap.put(movie.getName(), movie);
    }
    // 2  POST
    public void saveDirector(Director director) {  // just add into the directorMap
        directorMap.put(director.getName(), director);
    }
    // 3  PUT OR UPDATE
    public void saveMovieDirectorPair(String movie, String director) {
 // check whether the movies are present in maps , then add list into director movie map
        if (movieMap.containsKey(movie) && directorMap.containsKey(director)) {
            List<String> currMovies = new ArrayList<>();
            if (directorMovieMap.containsKey(director)) currMovies = directorMovieMap.get(director);
            currMovies.add(movie);
            directorMovieMap.put(director, currMovies);
        }
    }
   // 4  GET
    public Movie findMovie(String movie) { // get movie
        return movieMap.get(movie);
    }
    // 5 GET
    public Director findDirector(String director) { // get director
        return directorMap.get(director);
    }
  // 6 GET
    public List<String> findMoviesFromDirector(String director) { // get movie list
        List<String> movieList = new ArrayList<>();
        if (directorMovieMap.containsKey(director)) movieList = directorMovieMap.get(director);
        return movieList;
    }
   // 7 GET
    public List<String> findAllMovies() {  // add all movies names from the movie map into arraylist
        return new ArrayList<>(movieMap.keySet());
    }

    // 8 DELETE
    public void deleteDirector(String director) { // remove all movies from all maps

        List<String> movies = new ArrayList<>();

        if (directorMovieMap.containsKey(director)) { //  getting the  list of movies from directorMovieMap
            movies = directorMovieMap.get(director);
            for (String movie : movies) {
                if (movieMap.containsKey(movie)) {
                    movieMap.remove(movie);  // removing those movies from the movieMap
                }
            }
            directorMovieMap.remove(director); // remove director from the directorMovieMap
        }

        if (directorMap.containsKey(director)) directorMap.remove(director); // remove director from the directorMap
    }

    // 9 DELETE
    public void deleteAllDirector() {
        HashSet<String> moviesSet = new HashSet<String>();

        for (String director : directorMovieMap.keySet()) {
            for (String movie : directorMovieMap.get(director)) {
                moviesSet.add(movie);
            }
        }

        for (String movie : moviesSet) {
            if (movieMap.containsKey(movie)) {
                movieMap.remove(movie);
            }
        }

        directorMovieMap.clear();
        directorMap.clear();
    }
}
