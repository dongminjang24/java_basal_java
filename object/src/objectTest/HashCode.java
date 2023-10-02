package objectTest;

import java.util.Random;

public class HashCode {
    public static void main(String[] args) {
        String data1 = "ABC";
        String data2 = "ABC";

        Random r1 = new Random();
        Random r2 = new Random();

        System.out.println(r1.hashCode());
        System.out.println(r2.hashCode());
        System.out.println(r1);

        System.out.println(data1.hashCode());
        System.out.println(data2.hashCode());
    }
}
