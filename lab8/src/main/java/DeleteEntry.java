import java.sql.*;

public class DeleteEntry {


    public static void deleteMovie(String title) throws SQLException {
        Connection connection=DBService.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("Select id from lab8.movies WHERE title=?;");
        preparedStatement.setString(1,title);
        ResultSet resultSet= preparedStatement.executeQuery();
        while(resultSet.next()){
            int id=resultSet.getInt("id");
            delete(id);
        }
    }
    public static void delete(int id) throws SQLException {
        int aux;
        ResultSet resultSet;
        Connection connection=DBService.getConnection();
        PreparedStatement prAux = null;
        prAux=connection.prepareStatement("DELETE from lab8.junction WHERE id_movies=?;");
        prAux.setInt(1,id);
        prAux.executeUpdate();
        PreparedStatement prAux1=connection.prepareStatement("Select id_actor from lab8.actorstomovies WHERE id_movie=?");
        prAux1.setInt(1,id);
        resultSet=prAux1.executeQuery();
        prAux=connection.prepareStatement("DELETE from lab8.actorstomovies WHERE id_movie=?; ");
        prAux.setInt(1,id);
        prAux.executeUpdate();

        while(resultSet.next()){
          //  System.out.println(resultSet.getInt("id_actor"));
            aux=resultSet.getInt("id_actor");
            System.out.println(aux);
            prAux=connection.prepareStatement("DELETE from lab8.actors WHERE id=?");
            prAux.setInt(1,aux);
            prAux.executeUpdate();
        }
      //756
        prAux1=connection.prepareStatement("Select id_director from lab8.directorstomovies WHERE id_movies=?");
        prAux1.setInt(1,id);
        resultSet=prAux1.executeQuery();
        prAux=connection.prepareStatement("DELETE from lab8.directorstomovies WHERE id_movies=?; ");
        prAux.setInt(1,id);
        prAux.executeUpdate();
        while(resultSet.next()){
        //    System.out.println(resultSet.getInt("id_director"));
            aux=resultSet.getInt("id_director");
            prAux=connection.prepareStatement("DELETE from lab8.directors WHERE id=?");
            prAux.setInt(1,aux);
            prAux.executeUpdate();
        }

        prAux=connection.prepareStatement("DELETE from lab8.movies WHERE id=?;");
        prAux.setInt(1,id);
        prAux.executeUpdate();
        System.out.println("You have succesfully deleted the entry.");
    }
}
