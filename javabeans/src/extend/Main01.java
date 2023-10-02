package extend;

public class Main01 {
    public static void main(String[] args) {
        CalcParent parent = new CalcParent();
        CalcChild child = new CalcChild();

        System.out.println(parent.plus(10,20));
        System.out.println(parent.minus(10,20));

        System.out.println(child.plus(10,20));
        System.out.println(child.minus(10,20));
        System.out.println(child.times(10,20));
        System.out.println(child.divide(10,20));

    }
}
