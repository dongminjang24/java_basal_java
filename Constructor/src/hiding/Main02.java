package hiding;

class Student{
    // 은닉된 멤버 변수 -> 현재 class 블록 안에서만 접근가능
    private String name;
    private int age;

    String getName(){
        return this.name;
    };
    void setName(String name){
        this.name = name;
    };
    int getAge(){
        return this.age;
    };
    void setAge(int age){
        this.age = age;
    };

    /*
    * getter : String getUserName(){};
    * setter :void setUserName(String userName){}
    * */


}

public class Main02 {
    public static void main(String[] args) {
        Student std = new Student();
        std.setAge(20);
        std.setName("adf");
        System.out.println(std.getName());

        System.out.println(std.getAge());
    }
}
