package lamdaTheJava;
@FunctionalInterface
public interface RunSomething {
    void doIt();

    static void printName(){
        System.out.println("Kessun");
    }

    default  void printAge(){
        System.out.println("40");
    }
}
