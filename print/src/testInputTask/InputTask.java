package testInputTask;

import java.util.Scanner;

public class InputTask {
    public static void main(String[] args) {
        //세 정수를 한번에 입력받고, 곱의 결과를 출력;
        Scanner sc = new Scanner(System.in);
        int firstInt = 0;
        int secondInt = 0;
        int thirdtInt = 0;
        firstInt = sc.nextInt();
        secondInt = sc.nextInt();
        thirdtInt = sc.nextInt();

        System.out.println(firstInt*secondInt*thirdtInt);
    }
}
