package methodLambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        Function<Integer,String> intToString = (i)-> "number";

//        UnaryOperator<String> hi = (s)-> "hi"+s;
        UnaryOperator<String> hi = Greeting::hi;
        // 콜론 두개 메소드 레퍼런스- static method



        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("keesun"));

        Function<String,Greeting> keesunGreeting
                = Greeting::new;
        Greeting keesun = keesunGreeting.apply("keesun");
        System.out.println(keesun.getName());
        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();








        // 불특정 다수 인스턴스
        String[] names = {"abc","ghi","def"};
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });

         Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
