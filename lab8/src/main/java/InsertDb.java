import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InsertDb {
    public static void add() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id: ");
        int id = scanner.nextInt();
        System.out.print("Title: ");
        String title = scanner.next();
        System.out.print("Release date(yyyy/mm/dd): ");
        String date = scanner.next();
        Date d1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        java.sql.Date sDate= new java.sql.Date(d1.getTime());
        System.out.print("duration: ");
        int duration = scanner.nextInt();
        System.out.print("score: ");
        int score = scanner.nextInt();
        System.out.print("Genre: ");
        String genre=scanner.next();
        Connection connection = DBService.getConnection();
        String sql="insert into junction(id,id_movies,id_genres) values(?,?,?);";
        String sql1="insert into movies(id,title,release_date,duration,score,junctionID) values(?,?,?,?,?,?);";
        String sql2="insert into genres(id,name,junctionID) values (?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement1=connection.prepareStatement(sql1);
            PreparedStatement preparedStatement2=connection.prepareStatement(sql2);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2,id );
            preparedStatement.setInt(3,id );
            preparedStatement1.setInt(1, id);
            preparedStatement1.setString(2,title);
            preparedStatement1.setDate(3,  sDate);
            preparedStatement1.setInt(4, duration);
            preparedStatement1.setInt(5, score);
            preparedStatement1.setInt(6, id);
            preparedStatement2.setInt(1, id);
            preparedStatement2.setString(2, genre);
            preparedStatement2.setInt(3, id);
            int aux = preparedStatement.executeUpdate();
            int aux2=preparedStatement1.executeUpdate();
           int aux3=preparedStatement2.executeUpdate();
            System.out.println(aux+" "+aux2+" "+aux3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

