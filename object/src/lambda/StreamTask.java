package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {
    public static void main(String[] args) {
        //1~100까지 ArrayList에 담고 출력
//        ArrayList<Integer> datas = new ArrayList<>(); // 생략이 가능함.
//        IntStream.range(1,101).forEach(datas::add);

        // 1~10까지 중 홀수만 ArrayList에 담고 출력
//        IntStream.rangeClosed(1,10).filter(i -> i%2 == 1).forEach(datas::add);

        // A~F까지 ArrayList에 담고 출력
        String data = "ABCDEF";
//        data.chars().map(c->c+3).forEach(c->System.out.println((char)c));
        //        data.chars().forEach(c->System.out.println((char)(c)));
//        ArrayList<Character> datas = new ArrayList<>(); // 생략이 가능함.
//        data.chars().forEach(c -> datas.add((char) c));
        // A~F까지 중 C제외하고 ArrayList 담은 후 출력
//        data.chars().filter(c -> (char) c != 'F').forEach( a -> datas.add((char) a));
        // 문자열을 5개입력받고 모두 소문자로 변경
//        ArrayList<String> datas = new ArrayList<String>(Arrays.asList("BLAcK","white","language","Blue"));
//        try{        datas.stream().map(String::toLowerCase).forEach(System.out::println);
//        }catch (Exception e){;}
        // Apple,banana,Melon 중 첫번째 문자가 대문자인 문자열 출력
        ArrayList<String> datas = new ArrayList<String>(Arrays.asList("Apple","banana","Melon"));

        try{       System.out.println( datas.stream().filter(v -> v.charAt(0) <97 || v.charAt(0) >120).collect(Collectors.joining(",")));
       }catch (Exception e){;}
        // 한글을 정수로 변경

        // 정수를 한글로 변경


//        System.out.println(data.substring(0, 1).);
    }
}
