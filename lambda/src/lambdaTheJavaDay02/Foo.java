package lambdaTheJavaDay02;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {


    public static void main(String[] args) {


        BinaryOperator<Integer> sum = (a,b)->a+b;

        Foo foo =new Foo();
        foo.run();

    }

    private void run(){
        final int baseNumber =10;


        // 로컬 클래스
        class LocalClass{
            void printBaseNumber(){
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        // 익명 클래
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 11;

                System.out.println(baseNumber);
            }
        };


        // 람다
        IntConsumer printInt = (i)-> {
//            int baseNumber = 11;컴파일 에러가 남. 스코프가 겉에 run과 같음.
            System.out.println(i+baseNumber);
        };
        // int를 넣고 반환값은 없는 function
        printInt.accept(10);
    }
}
