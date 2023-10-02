package variable;

public class Variable {
    public  int data =10;
    public  static int data_s =10;
    public void increaseData(){
        System.out.println(++data);
    }
    public static void increaseData_s(){
        System.out.println(++data_s);
    }
}
