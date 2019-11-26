package lab5;


import lab1.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Lab5Repository {


    public Connection getDBconnection(){
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

    public void saveDB(Customer customer){
        String str;
        Statement statement = null;
        try {
            String sql = "insert into company_client values (ROW('" + customer.getFirstName() + "','"
                    + customer.getLastName()+ "','" +customer.getPhoneNumber()
                    + "','" +customer.getEmail() +"'));";
            Connection c =getDBconnection();
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<Customer> fromDB(){
        List<Customer> list = new ArrayList<>();
        String str;
        PreparedStatement statement = null;
        try {
            statement = getDBconnection().prepareStatement("select (client) from company_client;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String string = resultSet.getString("client").split("\\(")[1].split("\\)")[0];
                list.add(new Customer(
                        string.split(",")[0],
                        string.split(",")[1],
                        string.split(",")[2],
                        string.split(",")[3]));
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }





}
