import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "movies", schema="lab8")
@NamedQuery(name="Movies.findByName" , query = "Select m from Movie m WHERE m.title=:title")
public class Movie implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", score=" + score +
                '}';
    }

    public Movie(int id, String name, int score) {
        this.id=id;
        this.title=name;
        this.score=score;
    }

    public Movie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "title")
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    @Column(name = "score")
    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
