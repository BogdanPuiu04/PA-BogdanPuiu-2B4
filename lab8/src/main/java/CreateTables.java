import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class CreateTables {
    public static void create() throws SQLException {
        Connection connection=DBService.getConnection();
        String sqlAux="Drop table lab8.movies";
        String sql="create table junction( id int AUTO_INCREMENT PRIMARY KEY,id_genres INT NOT NULL UNIQUE , id_movies int NOT NULL UNIQUE );";
        String sql1="create table movies (   id int AUTO_INCREMENT PRIMARY KEY,   title VARCHAR(20), release_date DATE, duration int,score int,junctionID int, FOREIGN KEY(junctionID) REFERENCES lab8.junction(id_movies));";
        String sql2="create table genres(id int AUTO_INCREMENT PRIMARY KEY, name VARCHAR(15), junctionID int,FOREIGN KEY(junctionID) REFERENCES lab8.junction(id_genres) );";
        Statement statement=DBService.getConnection().createStatement();
        statement.execute(sqlAux);
        sqlAux="drop table lab8.genres";
        statement.execute(sqlAux);
        sqlAux="drop table lab8.junction";
        statement.execute(sqlAux);
        statement.execute(sql);
        statement.execute(sql1);
        statement.execute(sql2);
    }
}
