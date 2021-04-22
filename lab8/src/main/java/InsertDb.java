import com.opencsv.CSVReader;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InsertDb {
    private static final String pa = "D:\\PA\\lab8\\imdb.csv";
    static int id_movie = 0, id_actor = 0, id_genre = 0, id_director = 0;
    static List<String> genres = new ArrayList<>(), actors = new ArrayList<>(), directors = new ArrayList<>();

    public static void add() throws ParseException, SQLException {

        try {
            Connection connection = DBService.getConnection();
            String query="SELECT MAX(id) from movies";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            id_movie=resultSet.getInt("max(id)");
            resultSet=statement.executeQuery("SELECT name from genres");
            while(resultSet.next()){
                String genr=resultSet.getString("name");
                genres.add(genr);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Title: ");
            String title = scanner.next();
            System.out.print("Release date(dd/mm/yyyy): ");
            String date = scanner.next();
            Date d1 = new SimpleDateFormat("dd-MM-yy").parse(date);
            java.sql.Date sDate = new java.sql.Date(d1.getTime());
            System.out.print("duration: ");
            int duration = scanner.nextInt();
            System.out.print("score: ");
            int score = scanner.nextInt();
            System.out.print("Genre: ");
            String genre = scanner.next();
            System.out.print("Actors (delimited by ; ) : ");
            String acts = scanner.next();
            System.out.print("Directors (delimited by ; ) : ");
            String directs = scanner.next();
            insertToMovies(title, date, duration, score);
            insertToGenres(genre);

            String[] act = acts.split(";");
            for (String actorName : act) {
                insertToActors(actorName);
            }
            String[] direct = directs.split(";");
            for (String directName : direct) {
                insertToDirectory(directName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertToMovies(String title, String date, Integer duration, Integer score) throws SQLException, ParseException {
        Connection connection = DBService.getConnection();
        String sql = "insert into movies(id,title,release_date,duration,score) values (?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        id_movie++;
        preparedStatement.setInt(1, id_movie);
        preparedStatement.setString(2, title);
        Date d1 = new SimpleDateFormat("dd-MM-yy").parse(date);
        java.sql.Date sDate = new java.sql.Date(d1.getTime());
        preparedStatement.setDate(3, sDate);
        preparedStatement.setInt(4, duration);
        preparedStatement.setInt(5, score);
        preparedStatement.executeUpdate();
    }

    public static void insertToGenres(String name) throws SQLException {
        Connection connection = DBService.getConnection();
        if (!genres.contains(name)) {
            id_genre++;
            genres.add(name);
            String sql = "insert into genres(id,name) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_genre);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            insertToJunction(id_genre, id_movie);
        } else {
            int id1 = 0;
            String sql = "select id from lab8.genres WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id1 = resultSet.getInt("id");
            }
            insertToJunction(id1, id_movie);
        }
    }

    public static void insertToActors(String name) throws SQLException {
        Connection connection = DBService.getConnection();
        if (!actors.contains(name)) {
            if(id_actor<10)
            {
                String query="SELECT MAX(id) from actors";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                resultSet.next();
                id_actor=resultSet.getInt("max(id)");
            }
            id_actor++;
            actors.add(name);
            String sql = "insert into actors(id,name) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_actor);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            insertToActorsToMovies(id_actor, id_movie);
        } else {
            int id1 = 0;
            String sql = "select id from actors WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id1 = resultSet.getInt("id");
            }
            insertToActorsToMovies(id1, id_movie);
        }
    }

    public static void insertToDirectory(String name) throws SQLException {
        Connection connection = DBService.getConnection();
        if (!directors.contains(name)) {
            if(id_director<10){
                String query="SELECT MAX(id) from directors";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                resultSet.next();
                id_director=resultSet.getInt("max(id)");
            }
            id_director++;
            directors.add(name);
            String sql = "insert into directors(id,name) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_director);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            insertToActorsToMovies(id_director, id_movie);
        } else {
            int id1 = 0;
            String sql = "select id from directors WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id1 = resultSet.getInt("id");
            }
            insertToDirectorsToMovies(id1, id_movie);
        }
    }

    public static void insertToDirectorsToMovies(int idDirector, int idMovie) throws SQLException {
        Connection connection = DBService.getConnection();
        String sql = "insert into directorsToMovies(id_director,id_movies) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idDirector);
        preparedStatement.setInt(2, idMovie);
        preparedStatement.executeUpdate();
    }

    public static void insertToActorsToMovies(int idActor, int idMovie) throws SQLException {
        Connection connection = DBService.getConnection();
        String sql = "insert into ActorsToMovies(id_actor,id_movie) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idActor);
        preparedStatement.setInt(2, idMovie);
        preparedStatement.executeUpdate();
    }

    public static void insertToJunction(int idGenre, int idMovie) throws SQLException {
        Connection connection = DBService.getConnection();
        String sql = "insert into junction(id_genres,id_movies) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idGenre);
        preparedStatement.setInt(2, idMovie);
        preparedStatement.executeUpdate();
    }

    public static void readFile() throws FileNotFoundException {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(pa));
            Path p1 = Paths.get(pa);
            System.out.println(p1);
            String[] record;
            while ((record = csvReader.readNext()) != null) {
                //     System.out.println(record[1]);
                int rating = (int) Float.parseFloat(record[4]);
                insertToMovies(record[1], record[2], Integer.parseInt(record[3]), rating);
                String[] gen = record[5].split(";");
                for (String g : gen) {
                    insertToGenres(g);
                }
                String[] act = record[7].split(";");
                for (String actorName : act) {
                    insertToActors(actorName);
                }
                String[] direct = record[6].split(";");
                for (String directName : direct) {
                    insertToDirectory(directName);
                }
                // record[0] = id, record[1]= title, record[2]= data, record[3]=duration,record[4]=rating
                // record[5]= array de genres (split)
                //record[6]= array de directory (split)
                //record[7]=array de actori (split)

            }


        } catch (IOException | SQLException | ParseException e) {
            e.printStackTrace();
        }

    }

}

