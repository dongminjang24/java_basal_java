package input;

import java.util.Scanner;


public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name=null;
        String firstName  =null;
//        name =sc.next();
        name =sc.nextLine();

//        firstName =sc.next();
//        System.out.println("이름 :  " + name+firstName);
//        System.out.println(name+firstName+ "님 환영합니다.");
        System.out.println("이름 :  " + name);
        System.out.println(name+ "님 환영합니다.");
    }
}
