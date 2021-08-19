public class User {
    private String name;
    private String lastName;
    private Integer age, id;
    private UserRole userRole;

    public User(String name, String lastName, Integer age, UserRole userRole) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.userRole = userRole;
    }
    public User(Integer id, String name, String lastName, Integer age, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return  "User [Id: " + id +
                "" + ", name: " + name +
                "" + ", lastName: " + lastName +
                "" + ", age: " + age +
                "" + ", user role: " + userRole + "]\n";
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
