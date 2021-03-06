import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRoleDao {

    private Connection connection;
    private final String databaseName = "people";
    private final String tableName = "roles";
    private final String user = "root";
    private final String password = "admin";

    public UserRoleDao() {
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

    public List<UserRole> getAllUserRoles() {
        List<UserRole> userRoles = new LinkedList<UserRole>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("role");

                userRoles.add(new UserRole(id, Role.valueOf(name))); //rzutowanie bo name to String a konstruktor potrzebuje ENUM Role!!!
            }
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return userRoles;
    }

    public UserRole getRoleById(Integer id) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName + " WHERE ID = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                String name = resultSet.getString("role");
                Role userRole = Role.valueOf(name);

                return new UserRole(id, userRole);
            }
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getRoleIdByName(String roleName) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName + " WHERE ROLE = '" + roleName + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");

                return id;
            }
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
