import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserAddressDao {

    private Connection connection;
    private final String databaseName = "people";
    private final String tableName = "address";
    private final String user = "root";
    private final String password = "admin";

    public UserAddressDao() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName +
                    "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<UserAddress> getAllAddresses() {
        List<UserAddress> userAddresses = new LinkedList<UserAddress>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String cityName = resultSet.getString("city_name");
                Integer zipCode = resultSet.getInt("zip_code");
                String streetName = resultSet.getString("street_name");
                Integer houseNumber = resultSet.getInt("house_number");

                userAddresses.add(new UserAddress(id, cityName, zipCode, streetName, houseNumber));
            }
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return userAddresses;
    }
    public void createAddress(UserAddress userAddress) {
        PreparedStatement statement;

        try {
            String query = "INSERT INTO " + tableName + " (city_name, zip_code, street_name, house_number) VALUES(?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, userAddress.getCityName());
            statement.setInt(2, userAddress.getZipCode());
            statement.setString(3, userAddress.getStreetName());
            statement.setInt(4, userAddress.getHouseNumber());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAddress(UserAddress userAddress) {
        PreparedStatement statement;

        try {
            String query = "UPDATE  " + tableName + " SET city_name = ?, zip_code = ?, street_name = ?, house_number = ? WHERE ID=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, userAddress.getCityName());
            statement.setInt(2, userAddress.getZipCode());
            statement.setString(3, userAddress.getStreetName());
            statement.setInt(4, userAddress.getHouseNumber());
            statement.setInt(5, userAddress.getId());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAddress(Integer id) {
        PreparedStatement statement;

        try {
            String query = "DELETE FROM " + tableName + " where id =?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserAddress getAddressById(Integer id) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName + " WHERE ID = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                String cityName = resultSet.getString("city_name");
                Integer zipCode = resultSet.getInt("zip_code");
                String streetName = resultSet.getString("street_name");
                Integer houseNumber = resultSet.getInt("house_number");

                return new UserAddress(id, cityName, zipCode, streetName, houseNumber);
            }
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
