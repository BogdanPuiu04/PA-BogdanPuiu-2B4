import javax.persistence.*;
import java.util.List;


public interface MovieRepository  {
   static EntityManager entityManager=SingletonClass.entityManagerFactory.createEntityManager();
    static Movie findById(int id){
        return entityManager.find(Movie.class,id);
    }
    static List<Movie> findByName(String name){
     Query  query=  entityManager.createNamedQuery("Movies.findByName",Movie.class).setParameter(name,"Movie");
        return (List<Movie>) query.getResultList();
    }


    static Movie create(Movie movie){
        List<Movie> movieList=findByName(movie.getTitle());
        if(movieList.isEmpty())
            entityManager.persist(movie);
        else entityManager.merge(movie);
        return movie;
    }
}

