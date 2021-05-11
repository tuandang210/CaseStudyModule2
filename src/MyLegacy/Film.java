package MyLegacy;

import java.io.Serializable;

public class Film implements Serializable {
    private int id;
    private String name;
    private String filmGenre;
    private String director;
    private String mainStars;
    private double imdbRate;
    private int releaseYear;

    public Film() {
    }

    public Film(int id, String name, String filmGenre, String director,
                String mainStars, double imdbRate, int releaseYear) {
        this.id = id;
        this.name = name;
        this.filmGenre = filmGenre;
        this.director = director;
        this.mainStars = mainStars;
        this.imdbRate = imdbRate;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMainStars() {
        return mainStars;
    }

    public void setMainStars(String mainStars) {
        this.mainStars = mainStars;
    }

    public double getImdbRate() {
        return imdbRate;
    }

    public void setImdbRate(double imdbRate) {
        this.imdbRate = imdbRate;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Film " +
                "id: " + id +
                ", name: " + name +
                ", genre: " + filmGenre +
                ", dir: " + director +
                ", main: " + mainStars +
                ", imdb: " + imdbRate +
                ", year: " + releaseYear +
                ',';
    }
}
