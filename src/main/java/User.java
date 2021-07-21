public class User {
    private String name;
    private String lastName;
    private Integer age;

    public User(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return  "name: " + name +
                "\n" + "lastName: " + lastName+
                "\n" + "age: " + age;
    }
}
