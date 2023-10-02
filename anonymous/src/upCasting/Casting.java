package upCasting;
class Person{
    String name;
    Person(String name){
        this.name = name;
    }
}

class Student extends Person{
    String check;
    Student(String name){
        super(name);
    }
}


public class Casting {
    public static void main(String[] args){
        Student p = new Student("홍길동");

        p.name = "김유신";
        p.check = "check!";
    }
}
