package hashSetTest;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> foodSet = new HashSet<>();
        foodSet.add("햄버거");
        foodSet.add("순대");
        foodSet.add("치킨");
        foodSet.add("라면");
        foodSet.add("피자");
        foodSet.add("곱창");
        foodSet.add("짜장면");
        foodSet.add("돈까스");
        foodSet.add("돈까스");
        foodSet.add("돈까스");
        foodSet.add("돈까스");
        System.out.println(foodSet.toString());
        Iterator<String> iter = foodSet.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }

}
