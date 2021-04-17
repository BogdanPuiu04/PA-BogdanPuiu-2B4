import java.beans.Statement;
import java.sql.*;

public class FindByID {
    public static Movie findMoviesByID(int id) throws SQLException {
        int id1 = 0,duration = 0,score = 0;
        String name=null;
        Date date = null;
        Connection connection = DBService.getConnection();
        String sql="select * from lab8.movies where id=?";
       // Statement statement= (Statement) DBService.getConnection().createStatement();

        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next())
        {
             id1=resultSet.getInt("id");
             name=resultSet.getString("title");
             date=resultSet.getDate("release_date");
             duration=resultSet.getInt("duration");
             score=resultSet.getInt("score");
        }
        return new Movie(id1,name,date,duration,score);

    }


}
