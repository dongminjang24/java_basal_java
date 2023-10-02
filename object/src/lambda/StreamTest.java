package lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {
        HashMap<String,Integer> chinaTown = new HashMap<String,Integer>();
        chinaTown.put("짜장면",4500);
        chinaTown.put("짬뽕",5000);
        chinaTown.put("탕수육",14500);
        //forEach()

//        chinaTown.values().stream().forEach(v -> System.out.println(v));
//        chinaTown.values().forEach(v -> System.out.println(v));
//        chinaTown.values().forEach(System.out::println);

        // IntStream.range(start,end);
        // IntStream.range(start,end);
//        IntStream.range(0,10).forEach(System.out::println);
//        IntStream.rangeClosed(0,9).forEach(System.out::println);
        //chars() :문자열을 문자 stream으로 변경
        String data = "ABC";
//        data.chars().forEach(System.out::print);
//        data.chars().forEach(c->System.out.println((char)(c)));
        data.chars().map(c->c+3).forEach(c->System.out.println((char)c));

        // filter():조건식을 작성하여 false일 경우 제외시킨다.
        IntStream.rangeClosed(1,10).filter(i -> i%2 == 0).forEach(System.out::println);
//        Integer [] arData = {1,2,3,4}
//        ArrayList<Integer> datas = new ArrayList<Integer>(Arrays.asList(arData));
        ArrayList<Integer> datas = new ArrayList<Integer>(Arrays.asList(10,40,20,30));
//        datas.stream().sorted().forEach(System.out::println);
        datas.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
        ArrayList<Integer> results =
                (ArrayList<Integer>) datas.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(results);

        //joining("구분점") : 문자열 요소들을 구분점으로 연겨하여 문자열로 리턴한다.
        System.out.println( datas.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
