import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FindByID {
    public static Movie findMoviesByID(String title) throws SQLException {
        int id1 = 0,duration = 0,score = 0;
        String name=null;
        Date date = null;
        Connection connection = DBService.getConnection();
        System.out.println(title);
        String sql="select * from lab8.movies where title= ?";
       // Statement statement= (Statement) DBService.getConnection().createStatement();

        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,title);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next())
        {
             id1=resultSet.getInt("id");
             name=resultSet.getString("title");
             date=resultSet.getDate("release_date");
             duration=resultSet.getInt("duration");
             score=resultSet.getInt("score");
        }
        if(id1 == 0){
            System.out.println("It was not found");
        }
        return new Movie(id1,name,date,duration,score);

    }
    public static List<Actor> findActorsByID(int movieId) throws SQLException {
        int id1 = 0;
        String name=null;
        List<Actor> actors=new ArrayList<>();
        Connection connection = DBService.getConnection();
        String sql="select id_actor from lab8.actorstomovies where id_movie=?";
        // Statement statement= (Statement) DBService.getConnection().createStatement();

        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,movieId);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next())
        {
            int aux=resultSet.getInt("id_actor");
            preparedStatement=connection.prepareStatement("Select * from lab8.actors WHERE id=?;");
            preparedStatement.setInt(1,aux);
            ResultSet resultSet1=preparedStatement.executeQuery();
            while(resultSet1.next()) {
                id1 = resultSet1.getInt("id");
                name = resultSet1.getString("name");
                Actor actor=new Actor(id1,name);
                actors.add(actor);
            }

        }
        return actors;

    }
    public static List<Director> findDirectorsById(int movieId) throws SQLException {
        int id1 = 0;
        String name=null;
        List<Director> directors=new ArrayList<>();
        Connection connection = DBService.getConnection();
        String sql="select id_director from lab8.directorstomovies where id_movies=?";

        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,movieId);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next())
        {
            int aux=resultSet.getInt("id_director");
            preparedStatement=connection.prepareStatement("Select * from lab8.directors WHERE id=?;");
            preparedStatement.setInt(1,aux);
            ResultSet resultSet1=preparedStatement.executeQuery();
            while(resultSet1.next()) {
                id1 = resultSet1.getInt("id");
                name = resultSet1.getString("name");
                Director director=new Director(id1,name);
                directors.add(director);
            }

        }
        return directors;

    }


}
