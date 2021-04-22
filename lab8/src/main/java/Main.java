import java.io.FileNotFoundException;
import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            System.out.println("Do you want to drop the tables and create new ones?");
            String resp;
            Scanner scannerDrop = new Scanner(System.in);
            resp = scannerDrop.next();
            if (resp.equals("yes")) {
                CreateTables.create();
                InsertDb.readFile();
            }
            System.out.println("Do you want to find a movie?");
            resp=scannerDrop.next();
            if(resp.equals("yes")){
                System.out.println("The name of the movie: ");
                Scanner scanner=new Scanner(System.in);
                String aux=scanner.next();
                Movie movie=FindByID.findMoviesByID(aux);
                System.out.println(movie);
            }
            System.out.println("Do you want to add another entry?");
            resp=scannerDrop.next();
            if(resp.equals("yes")){
                InsertDb.add();
            }
            System.out.println("Do you want to delete an entry?");
            resp=scannerDrop.next();
            if(resp.equals("yes")){
                Scanner scanner=new Scanner(System.in);
                System.out.println("The title of the movie you want to delete: ");
                resp=scanner.next();
                DeleteEntry.deleteMovie(resp);
            }

        } catch (SQLException | FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }

    }
}
