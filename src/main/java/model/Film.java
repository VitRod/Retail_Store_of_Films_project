package model;

public class Film {
    private final  String director;
    private final  String title;
    private final  int  yearOfRelease;


    public Film (String title, String director, int yearOfRelease) {
        this.director = director;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }
}
