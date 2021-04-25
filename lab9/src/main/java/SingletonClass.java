import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonClass {
    private static SingletonClass single_instance=null;
    public static EntityManagerFactory entityManagerFactory;

    private SingletonClass(){
    entityManagerFactory= Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }
    public static SingletonClass getInstance(){
        if(single_instance==null) {
            single_instance = new SingletonClass();
        }
        return single_instance;
    }
}
