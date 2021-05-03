import java.sql.*;
import java.util.ArrayList;

public class Commands {


    public static int register(String username) throws SQLException {
        Connection connection=DBService.getConnection();
        String query="SELECT MAX(id) from lab10.user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        int id=resultSet.getInt("max(id)");
        id++;
        String sql="insert into lab10.user(id,username) values (?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
        return id;
    }


    public static int login(String s) throws SQLException {
        Connection connection=DBService.getConnection();
        String sql="select id from lab10.user WHERE username=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,s);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        int id=resultSet.getInt("id");
        return id;
    }

    public static void friend(String s,int id) throws SQLException {
        Connection connection=DBService.getConnection();
        String sql="select id from lab10.user WHERE username=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,s);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        int id1=resultSet.getInt("id");
         String s1="insert into lab10.friendship(friend1, friend2) values(?,?)";
       PreparedStatement preparedStatement1= connection.prepareStatement(s1);
       preparedStatement1.setInt(1,id);
        preparedStatement1.setInt(2,id1);
        preparedStatement1.executeUpdate();
        preparedStatement1.setInt(1,id1);
        preparedStatement1.setInt(2,id);
        preparedStatement1.executeUpdate();
    }

    public static void sendMessage(String s, int id) throws SQLException {
        Connection connection=DBService.getConnection();
        String sql="select friend2 from lab10.friendship where friend1=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            int id1=resultSet.getInt("friend2");
            String q="insert into lab10.inbox(id_sender,id_receiver,message) values (?,?,?);";
            PreparedStatement preparedStatement1=connection.prepareStatement(q);
            preparedStatement1.setInt(1,id);
            preparedStatement1.setInt(2,id1);
            preparedStatement1.setString(3,s);
            preparedStatement1.executeUpdate();
        }
    }

    public static ArrayList<String> readMessages(int id) throws SQLException {
        ArrayList<String> aux=new ArrayList<>();
        Connection connection=DBService.getConnection();
        String sql="select message from lab10.inbox where id_receiver=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            String str=resultSet.getString("message");
            aux.add(str);
        }
        return aux;
    }
}
