package object_array;

// Data class

class Person_data{
    //Field
    String name;
    int age;

    //Constructor
    Person_data(String name, int age){
        this.name =name;
        this.age =age;

        System.out.println("Person(String name, int age) 생성자가 호출");

    }
    void printPerson(){System.out.println("이름 : " + name+", 나이 : "+age+"살");}
}
public class Person {
    public static void main(String[] args) {
        //Person 객체 3개를 저장할 수 있는 people 배열 선언
        Person_data[] people = new Person_data[3];// 생성자가 호출된 것이 아님
        // 3개의 person_data가 생성된 것이 아닙니다.
        // 아래와 같은 작업을 통해서 3개 Person_data를 생성한다.
        // people[0] = new Person_data("name",age)
        // people[1] = new Person_data("name",age)
        // people[2] = new Person_data("name",age)
        String[] name  = {"James","Alice","David"};
        int[] age ={20,30,25};
        //1.3개의 Person_data 객체 생성 후 배열에 저장
        for(int i =0; i< people.length;i++){
            people[i]= new Person_data(name[i],age[i]);
        }
        //2.출력
        for(int i =0; i< people.length;i++){
            people[i].printPerson();
        }
    }
    //Method

}


