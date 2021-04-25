import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        SingletonClass singletonClass=SingletonClass.getInstance();
        EntityManager entityManager=SingletonClass.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
         Movie movie=    MovieRepository.findById(5120);
        System.out.println(movie.toString());
        List<Movie> movieList=MovieRepository.findByName("Shadowhunter");
        for(Movie aux : movieList){
            System.out.println(aux.toString());
        }
        Movie movie1=new Movie(2,"Test90",5);
        movieList.add(MovieRepository.create(movie1));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
