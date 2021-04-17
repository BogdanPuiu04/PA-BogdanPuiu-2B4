import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            System.out.println("Do you want to drop the tables and create new ones?");
            String resp;
            Scanner scannerDrop=new Scanner(System.in);
            resp=scannerDrop.next();
            if(resp.equals("yes")) {
                CreateTables.create();
            }
            Statement statement = DBService.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from lab8.movies m JOIN lab8.junction j ON m.junctionID=j.id_movies JOIN lab8.genres g ON g.junctionID=j.id_genres;");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                Date date = resultSet.getDate("release_date");
                int duration = resultSet.getInt("duration");
                int score = resultSet.getInt("score");
                int junctinID = resultSet.getInt("junctionID");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + " " + " Title: " + title + " " + " Date: " + date + " " + " Duration: " + duration + " " + " Score: " + score + " " + " Genre: " + name + " " + " JunctionID: " + junctinID + " ");
            }
            Movie movie=new Movie();
            int id;
            Scanner scanner=new Scanner(System.in);
            System.out.println("Do you want to find a movie by id?");
            String response;
            response=scanner.next();
            if(response.equals("yes")) {
                System.out.println("Which id you want to find?");
                id=scanner.nextInt();
                movie = FindByID.findMoviesByID(id);
                if(movie.getId()==0){
                    System.out.println("It does not exist");
                }
                else {
                    System.out.print(movie.toString());
                    System.out.println();
                }
            }
            System.out.println("Do you want to insert a new entry for movies?");

            response=scanner.next();
            if(response.equals("yes")) {
                InsertDb.add();
            }
            System.out.println();
            System.out.println("Do you want to delete a new entry for movies?");
            response=scanner.next();
            if(response.equals("yes")){
                System.out.println("Which id should you delete?");
                 id=scanner.nextInt();
                DeleteEntry.delete(id);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

    }
}
