package hiding;

class User{
    public String name = "사용자";
    private int age = 20;


}

public class Main01 {
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.name);
    }
}
