package model;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class RetailFilmStore {
    List<Film> films = new LinkedList<Film>();

    public List<Film> findByPartialTitle(final String partialTitle) {

        List<Film> results = new LinkedList<Film>();
        return findBy(film -> film.getTitle().toUpperCase().contains(partialTitle.toUpperCase()), results);
    }


    public void add(Film movie) {
    	films.add(movie);
    }


    public List<Film> findByDirector(final String director) {

        List<Film> results = new LinkedList<Film>();
        return findBy(film -> film.getDirector().equals(director), results);
    }





    public List<Film> findByReleaseYear(final int from, final int to) {

        List<Film> results = new LinkedList<Film>();
        return findBy(film -> film.getYearOfRelease() > from && film.getYearOfRelease()<to, results);
    }

    interface Predicate{
        boolean matches(Film film);
    }
    public List<Film> findBy(Predicate predicate, List<Film> results) {

        for (Film film : films){
            if(predicate.matches(film)){
                results.add(film);
            }
        }
        return results;
    }
}