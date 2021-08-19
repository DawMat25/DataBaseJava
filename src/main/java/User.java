public class User {
    private String name;
    private String lastName;
    private Integer age, id;
    private UserRole userRole;
    private UserAddress userAddress;

    public User(String name, String lastName, Integer age, UserRole userRole, UserAddress userAddress) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.userRole = userRole;
        this.userAddress = userAddress;
    }
    public User(Integer id, String name, String lastName, Integer age, UserRole userRole, UserAddress userAddress) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.userRole = userRole;
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return  "User [Id: " + id +
                "" + ", name: " + name +
                "" + ", lastName: " + lastName +
                "" + ", age: " + age +
                "" + ", user role: " + userRole +
                "" + ", user address: " + userAddress +"]\n";
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

    public UserAddress getUserAddress() {
        return userAddress;
    }
}
