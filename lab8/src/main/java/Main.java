import java.io.FileNotFoundException;
import java.sql.*;
import java.text.ParseException;
import java.util.List;
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
                String aux=scanner.nextLine();
                Movie movie=FindByID.findMoviesByID(aux);
                if(movie.id!=0) {
                    System.out.println(movie);
                }
                List <Actor> actors=FindByID.findActorsByID(movie.id);
                for(Actor actor : actors){
                    System.out.println(actor.toString());
                }
                List <Director> directors=FindByID.findDirectorsById(movie.id);
                for(Director director : directors){
                    System.out.println(director.toString());
                }
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
                resp=scanner.nextLine();
                DeleteEntry.deleteMovie(resp);
            }

        } catch (SQLException | FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }

    }
}
