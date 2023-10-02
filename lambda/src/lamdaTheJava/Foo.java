package lamdaTheJava;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        //익명 내부 클래스
//        RunSomething runSomething = () -> {
//            System.out.println("Hdello");
//            System.out.println("Lambda");
//        };
//        runSomething.doIt();
        Function<Integer,Integer> plus10 = (number)->{
            return number+10;
        };
        Function<Integer,Integer> multiply2 = (i)-> i*2;
        System.out.println(multiply2.apply(1));


        Function<Integer,Integer>multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(1));


        System.out.println(plus10.andThen(multiply2).apply(20));

        Consumer<Integer> printT = System.out::println;
        printT.accept(10);// return 값이 없는 함수

        Supplier<Integer> get10 = ()-> 20;
        System.out.println(get10.get()); // 입력은 없고 리턴만 하는 함수


        Predicate<String> startWithKeesun = (s)-> s.startsWith("keesutn");
        System.out.println(startWithKeesun.test("keesutn12"));

        Predicate<Integer> isOdd = (i)-> i%2 ==1;
        System.out.println(isOdd.test(11));


        UnaryOperator<Integer> plus11 = (i)-> i+11;
        UnaryOperator<Integer> multiply3 = (i)-> 3*i;
        //입력값과 리턴값에서 타입이 같다면 UnaryOperator 를 사용하면 됨.
    }
}
