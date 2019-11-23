package lab4;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lab1.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceWithDB {

    public static void savePersonList(List<Person> persons) throws SQLException {

        Connection connection = getDBconnection();
        if (persons != null && persons.size() > 0) {
            Gson gson = new Gson();

            String personsAsJson = gson.toJson(persons);

            PreparedStatement statement = connection.
                    prepareStatement("insert into jtest (content, contentb) values ( cast( ? as json) , cast( ? as json) )");
            statement.setString(1, personsAsJson);
            statement.setString(2, personsAsJson);

            int count = statement.executeUpdate();

            System.out.println(count + " records added!");

            statement.close();

        }
    }

    public static List<Person> loadPersonList(String sql) throws JsonSyntaxException, SQLException {
//        String pStr = "";
//
        Connection con = getDBconnection();
//        PreparedStatement statement =
//                con.prepareStatement("select contentb from jtest ");
//
//        ResultSet resultSet = statement.executeQuery();
//
//        while (resultSet.next()) {
//            pStr = resultSet.getString("contentb");
//            System.out.println(pStr);
//        }
//
//        statement.close();
//
//        Gson gson = new Gson();
//
//        Person[] plst = gson.fromJson(pStr, Person[].class);
//
//        statement =
//                con.prepareStatement("select contentb->0 as c from jtest ");
//
//        resultSet = statement.executeQuery();
//
//        while (resultSet.next()) {
//            pStr = resultSet.getString("c");
//            System.out.println(pStr);
//        }
//
//        return Arrays.asList(plst);
        PreparedStatement statement = con.prepareStatement(sql);

        long start = System.nanoTime();
        ResultSet rs = statement.executeQuery();
        long finish = System.nanoTime();

        System.out.printf(sql.contains("contentb") ? "Jsonb: %d\n" : "Json: %d\n", (finish - start));

        List<Person> persons = new ArrayList<>();
        while (rs.next()) {
            Person person = new Gson().fromJson(rs.getString(1), Person.class);
            persons.add(person);
        }

        return persons;
    }

    public static List<Person> loadJson() throws SQLException {
        return loadPersonList("select content from jtest");
    }

    public static List<Person> loadJsonb() throws SQLException {
        return loadPersonList("select contentb from jtest");
    }

    public static Connection getDBconnection(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/oodb";
            connection =
                    DriverManager.getConnection( dbURL, "postgres", "1");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
