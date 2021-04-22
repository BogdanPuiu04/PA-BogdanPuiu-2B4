import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class CreateTables {
    public static void create() throws SQLException {
        Connection connection=DBService.getConnection();
        Statement statement=DBService.getConnection().createStatement();
        String sqlDrop="drop table lab8.junction;";
        statement.execute(sqlDrop);
        sqlDrop="drop table lab8.actorstomovies;";
        statement.execute(sqlDrop);
        sqlDrop="drop table lab8.directorstomovies";
        statement.execute(sqlDrop);
        sqlDrop="drop table lab8.genres";
        statement.execute(sqlDrop);
        sqlDrop="drop table lab8.movies";
        statement.execute(sqlDrop);
        sqlDrop="drop table lab8.directors";
        statement.execute(sqlDrop);
        sqlDrop="drop table lab8.actors";
        statement.execute(sqlDrop);
        String sql1="create table movies ( id int PRIMARY KEY,   title VARCHAR(200), release_date DATE, duration int,score int);";
        String sql2="create table genres(id int AUTO_INCREMENT PRIMARY KEY, name VARCHAR(15));";
        String sql="create table junction(id_genres INT NOT NULL  , id_movies int NOT NULL,FOREIGN KEY(id_genres) REFERENCES lab8.genres(id),FOREIGN KEY(id_movies) REFERENCES lab8.movies(id));";
        String sql3="create table actors(id int AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200));";
        String sql4="create table directors(id int AUTO_INCREMENT PRIMARY KEY , name VARCHAR(200));";
        statement.execute(sql1);
        statement.execute(sql2);
        statement.execute(sql);
        statement.execute(sql3);
        statement.execute(sql4);
        sql="create table ActorsToMovies(id_actor int,id_movie int,FOREIGN KEY (id_actor) REFERENCES lab8.actors(id),FOREIGN KEY (id_movie) REFERENCES lab8.movies(id));";
        statement.execute(sql);
        sql="create table DirectorsToMovies(id_director int, id_movies int, FOREIGN KEY (id_director) REFERENCES lab8.directors(id),FOREIGN KEY (id_movies) REFERENCES lab8.movies(id));";
        statement.execute(sql);
      //  statement.execute(sqlAux);
     //   sqlAux="drop table lab8.genres";
      //  statement.execute(sqlAux);
     //   sqlAux="drop table lab8.junction";
      //  statement.execute(sqlAux);
    }
}
