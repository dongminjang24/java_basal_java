package first;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        System.out.println(plus(3, 10));
        System.out.println(minus(22, 18));
        System.out.println(f(22, 18));


    }

    public static int plus(int x, int y) {
        int result = x + y;
        return result;
    }

    public static int minus(int x, int y) {
        return x - y;
    }

    public static int f(int x, int y){
        return plus(x,y);
    }
}
