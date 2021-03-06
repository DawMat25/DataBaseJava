import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDao {
    private Connection connection;
    private final String dataBaseName = "people";
    private final String tableName = "user";
    private final String user = "root";
    private final String password = "admin";
    private UserRoleDao userRoleDao = new UserRoleDao();
    private UserAddressDao userAddressDao = new UserAddressDao();

    public UserDao() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dataBaseName +
                    "?useSSL=false", user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                Integer age = resultSet.getInt("age");
                Integer userRoleId = resultSet.getInt("user_role_id");
                Integer userAddressId = resultSet.getInt("user_address_id");
                UserRole userRole = userRoleDao.getRoleById(userRoleId);
                UserAddress userAddress = userAddressDao.getAddressById(userAddressId);

                User user = new User(id, name, lastName, age, userRole, userAddress);
                users.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void createUser(User user) {
        PreparedStatement statement;

        try {
            Integer roleId = userRoleDao.getRoleIdByName(user.getUserRole().getRole().name());
            Integer addressId = user.getUserAddress().getId();
            String query = "INSERT INTO " + tableName + " (name, lastname, age, user_role_id, user_address_id) VALUES(?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setInt(4, roleId);
            statement.setInt(5, addressId);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String lastName) {
        PreparedStatement statement;

        try {
            String query = "DELETE FROM " + tableName + " where lastname =?";
            statement = connection.prepareStatement(query);
            statement.setString(1, lastName);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        PreparedStatement statement;

        try {
            Integer roleId = userRoleDao.getRoleIdByName(user.getUserRole().getRole().name());
            Integer addressId = user.getUserAddress().getId();
            String query = "UPDATE " + tableName + " SET name = ?, lastname = ?, age = ?, user_role_id = ?, user_address_id = ? WHERE ID=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setInt(4, roleId);
            statement.setInt(5, addressId);
            statement.setInt(6, user.getId());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
