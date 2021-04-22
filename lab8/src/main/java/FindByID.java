import java.beans.Statement;
import java.sql.*;

public class FindByID {
    public static Movie findMoviesByID(String title) throws SQLException {
        int id1 = 0,duration = 0,score = 0;
        String name=null;
        Date date = null;
        Connection connection = DBService.getConnection();
        String sql="select * from lab8.movies where title=?";
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
        return new Movie(id1,name,date,duration,score);

    }


}
