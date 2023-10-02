package casting;


class Person {
    public void eat(String food) {
        System.out.println(food + "먹는다.");
    }

    public void sleep() {
        System.out.println("잔다..");
    }

    public void goToToilet(String food) {
        System.out.println(food + "싼다..");
    }


}

class Student extends Person {
    public void study() {
        System.out.println("공부한다.");
    }
}

class Worker extends Person {
    public void work() {
        System.out.println("일한다.");
    }
}

public class Ex01_downcasting_person {
    public static void main(String[] args) {
        Person p1 = new Student();
        p1.eat("밥");
        p1.sleep();
        p1.goToToilet("똥");

        ((Student)p1).study();

        Person p2 = new Worker();
        p2.eat("밥");
        p2.sleep();
        p2.goToToilet("똥");
        ((Worker)p2).work();

        Person p3 = new Student();
        ((Worker)p3).work();
//        if (p3 instanceof Worker){
//            ((Worker)p3).work();
//        }
    }
}
