import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static UserDao userDao = new UserDao();

    public static void createUser() {
        String name, lastName;
        Integer age, id = 0;

        System.out.println("Type a name: ");
        name = scanner.next();

        System.out.println("Type a last name: ");
        lastName = scanner.next();

        System.out.println("Type an age: ");
        age = scanner.nextInt();

        User user = new User(id, name, lastName, age);
        userDao.createUser(user);
        System.out.println("New user: \n" + user);
    }

    public static void deleteUser() {
        String lastName;

        System.out.println("Write last name of user to delete: ");
        lastName = scanner.next();

        userDao.deleteUser(lastName);
        System.out.println("Deleted user: " + lastName);
    }

    public static void updateUser() {
        String name, lastName;
        Integer age, id;

        System.out.println("Write user ID to update: ");
        id = scanner.nextInt();

        System.out.println("Write new name: ");
        name = scanner.next();

        System.out.println("Write new name: ");
        lastName = scanner.next();

        System.out.println("Write new name: ");
        age = scanner.nextInt();

        User user = new User(id, name, lastName, age);
        userDao.updateUser(user);
        System.out.println("Updated user: " + user);
    }

    public static void calculate() {
        Integer x, y;

        System.out.println("Type first number: ");
        x = scanner.nextInt();
        System.out.println("Type second number: ");
        y = scanner.nextInt();

        System.out.println("Sum: " + Calculator.add(x, y));
        System.out.println("Subtract: " + Calculator.subtract(x, y));
        System.out.println("Multiple: " + Calculator.multiple(x, y));
        System.out.println("Divide: " + Calculator.divide(x, y));
    }

    public static void main(String[] args) {
        //calculate();
        createUser();
        createUser();
        System.out.println(userDao.getAllUsers());
        updateUser();
        System.out.println(userDao.getAllUsers());
        deleteUser();
        System.out.println(userDao.getAllUsers());
    }
}
