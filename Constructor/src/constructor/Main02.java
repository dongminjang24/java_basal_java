package constructor;

class User{
    String name;
    int age;

    User(String name, int age){
        this.name = name;
        this.age= age;
    }
    void print(){
        System.out.println(this.name);
        System.out.println(this.age);

    }
}



public class Main02 {
    public static void main(String[] args) {

        User user = new User("jangdm",27);
        user.print();

    }
}
