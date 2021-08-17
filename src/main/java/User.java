public class User {
    private String name;
    private String lastName;
    private Integer age, id;

    public User(Integer id, String name, String lastName, Integer age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return  "User [Id: " + id +
                "" + ", name: " + name +
                "" + ", lastName: " + lastName+
                "" + ", age: " + age + "]\n";
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
}
