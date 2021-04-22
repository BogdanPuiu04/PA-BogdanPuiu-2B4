import java.sql.Date;

public class Movie {
    int id;
    String title;
    Date releaseDate;
    int duration;
    int score;

    public Movie(int id, String title, Date releaseDate, int duration, int score) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    public Movie() {

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Movie " +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", score=" + score;
    }
}
