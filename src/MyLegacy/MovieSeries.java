package MyLegacy;

public class MovieSeries extends Film {
    private String distributedBy;
    private String runningTime;
    private double worldWideBoxOffice;

    public MovieSeries() {
    }

    public MovieSeries(String distributedBy, String runningTime, double worldWideBoxOffice) {
        this.distributedBy = distributedBy;
        this.runningTime = runningTime;
        this.worldWideBoxOffice = worldWideBoxOffice;
    }

    public MovieSeries(int id, String name, String filmGenre, String director, String mainStars, double imdbRate, int releaseYear, String distributedBy, String runningTime, double worldWideBoxOffice) {
        super(id, name, filmGenre, director, mainStars, imdbRate, releaseYear);
        this.distributedBy = distributedBy;
        this.runningTime = runningTime;
        this.worldWideBoxOffice = worldWideBoxOffice;
    }

    public String getDistributedBy() {
        return distributedBy;
    }

    public void setDistributedBy(String distributedBy) {
        this.distributedBy = distributedBy;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public double getWorldWideBoxOffice() {
        return worldWideBoxOffice;
    }

    public void setWorldWideBoxOffice(double worldWideBoxOffice) {
        this.worldWideBoxOffice = worldWideBoxOffice;
    }

    @Override
    public String toString() {
        return super.toString() +
                " prod: " + distributedBy +
                ", time: " + runningTime +
                ", boxOffice: " + worldWideBoxOffice;
    }
}