package lambdaTest;

public class LambdaTest {
    public static void main(String[] args) {
        LambdaInter lambda1 = (number)-> number % 10 ==0;

        System.out.println(lambda1.checkMultipleOf10(10));

        LambdaInter lambda2 = (number)->
        {
            System.out.println("10의 배수 검사");
            return number% 10 == 0;
        };
        System.out.println(lambda2.checkMultipleOf10(99));


    }
}
