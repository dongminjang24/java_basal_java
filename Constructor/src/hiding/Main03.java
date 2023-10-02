package hiding;

public class Main03 {
    public static void main(String[] args) {
        Member s = new Member(27,"namddsdse");
        String name =  s.getName();
        int age =  s.getAge();
        System.out.println(name);
        System.out.println(age);
    }
}
