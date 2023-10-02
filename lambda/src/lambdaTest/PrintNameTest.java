package lambdaTest;

public class PrintNameTest {
    public static void printFullName(PrintName printName){
        System.out.println(printName.printName("장","동민"));
    };

    public static void main(String[] args) {
            printFullName((l,f)->l+f);
    }
}
