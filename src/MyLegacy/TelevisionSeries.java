package MyLegacy;

public class TelevisionSeries extends Film {
    private int numberOfSeasons;
    private String avgEpisodeLength;
    private String releasePlatform;

    public TelevisionSeries() {
    }

    public TelevisionSeries(int numberOfSeasons, String avgEpisodeLength, String releasePlatform) {
        this.numberOfSeasons = numberOfSeasons;
        this.avgEpisodeLength = avgEpisodeLength;
        this.releasePlatform = releasePlatform;
    }

    public TelevisionSeries(int id, String name, String filmGenre, String director, String mainStars, double imdbRate, int releaseYear, int numberOfSeasons, String avgEpisodeLength, String releasePlatform) {
        super(id, name, filmGenre, director, mainStars, imdbRate, releaseYear);
        this.numberOfSeasons = numberOfSeasons;
        this.avgEpisodeLength = avgEpisodeLength;
        this.releasePlatform = releasePlatform;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public String getAvgEpisodeLength() {
        return avgEpisodeLength;
    }

    public void setAvgEpisodeLength(String avgEpisodeLength) {
        this.avgEpisodeLength = avgEpisodeLength;
    }

    public String getReleasePlatform() {
        return releasePlatform;
    }

    public void setReleasePlatform(String releasePlatform) {
        this.releasePlatform = releasePlatform;
    }

    @Override
    public String toString() {
        return super.toString() +
                " seasons: " + numberOfSeasons +
                ", avgLength: " + avgEpisodeLength +
                ", platform: " + releasePlatform;
    }
}

