import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static UserDao userDao = new UserDao();
    static UserRoleDao userRoleDao = new UserRoleDao();
    static UserAddressDao userAddressDao = new UserAddressDao();

    public static void createUser() {
        String name, lastName, role;
        Integer age, addressId;

        System.out.println("Type a name: ");
        name = scanner.next();

        System.out.println("Type a last name: ");
        lastName = scanner.next();

        System.out.println("Type an age: ");
        age = scanner.nextInt();

        System.out.println("Type user role: [ADMIN, USER] ");
        role = scanner.next();

        System.out.println(userAddressDao.getAllAddresses());
        System.out.println("Type address id which will be assign to user: ");
        addressId = scanner.nextInt();

        User user = new User(name, lastName, age, new UserRole(Role.valueOf(role)), userAddressDao.getAddressById(addressId));
        userDao.createUser(user);
        System.out.println("New user: \n" + user);
    }

    public static void deleteUser() {
        String lastName;

        System.out.println(userDao.getAllUsers());

        System.out.println("Write last name of user to delete: ");
        lastName = scanner.next();

        userDao.deleteUser(lastName);
        System.out.println("Deleted user: " + lastName);
    }

    public static void updateUser() {
        String name, lastName, role;
        Integer age, id, addressId;

        System.out.println(userDao.getAllUsers());

        System.out.println("Write user ID to update: ");
        id = scanner.nextInt();

        System.out.println("Write new name: ");
        name = scanner.next();

        System.out.println("Write new last name: ");
        lastName = scanner.next();

        System.out.println("Write new age: ");
        age = scanner.nextInt();

        System.out.println("Write new user role: [ADMIN, USER] ");
        role = scanner.next();

        System.out.println(userAddressDao.getAllAddresses());
        System.out.println("Type address id which will be assign to user: ");
        addressId = scanner.nextInt();

        User user = new User(id, name, lastName, age, new UserRole(Role.valueOf(role)),
                userAddressDao.getAddressById(addressId));
        userDao.updateUser(user);
        System.out.println("Updated user: " + user);
    }

    public static void createAddress() {
        String city_name, street_name;
        Integer zip_code, house_number;

        System.out.println("Type city name: ");
        city_name = scanner.next();

        System.out.println("Type zip code: ");
        zip_code = scanner.nextInt();

        System.out.println("Type street name: ");
        street_name = scanner.next();

        System.out.println("Type house number: ");
        house_number = scanner.nextInt();

        UserAddress userAddress = new UserAddress(city_name, zip_code, street_name, house_number);
        userAddressDao.createAddress(userAddress);
        System.out.println(userAddress);
    }

    public static void deleteAddress() {
        Integer id;

        System.out.println(userAddressDao.getAllAddresses());

        System.out.println("Type address id to delete: ");
        id = scanner.nextInt();

        userAddressDao.deleteAddress(id);
    }

    public static void updateAddress() {
        String city_name, street_name;
        Integer zip_code, house_number, id;

        System.out.println(userAddressDao.getAllAddresses());

        System.out.println("Type address id to update: ");
        id = scanner.nextInt();

        System.out.println("Type new city name: ");
        city_name = scanner.next();

        System.out.println("Type new zip code: ");
        zip_code = scanner.nextInt();

        System.out.println("Type new street name: ");
        street_name = scanner.next();

        System.out.println("Type new house number: ");
        house_number = scanner.nextInt();

        UserAddress userAddress = new UserAddress(id, city_name, zip_code, street_name, house_number);
        userAddressDao.updateAddress(userAddress);
        System.out.println(userAddress);
    }

    public static void main(String[] args) {
        System.out.println(userRoleDao.getAllUserRoles());
        createUser();
        updateUser();
        deleteUser();
        //createAddress();
        //updateAddress();
        //deleteAddress();
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
}
