package october25.classwork;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Vasya", "pass1", new Role[] {new Role("roleName", "roleAuth")});
        System.out.println(user.toString());
    }
}
