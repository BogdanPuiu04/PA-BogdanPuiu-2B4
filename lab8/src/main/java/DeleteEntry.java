import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEntry {

    public static void delete(int id) throws SQLException {

        Connection connection=DBService.getConnection();
        String sql="delete from lab8.movies WHERE id=?";
        String sql2="delete from lab8.junction WHERE id=?";
        String sql3="delete from lab8.genres WHERE id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        PreparedStatement preparedStatement1=connection.prepareStatement(sql2);
        PreparedStatement preparedStatement2=connection.prepareStatement(sql3);
        preparedStatement.setInt(1,id);
        preparedStatement2.setInt(1,id);
        preparedStatement1.setInt(1,id);
        preparedStatement.executeUpdate();
        preparedStatement1.executeUpdate();
        preparedStatement2.executeUpdate();
        System.out.println("You successfully deleted the entry with the id: "+ id);
    }
}
