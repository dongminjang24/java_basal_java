package methodLambda;

public interface Foo {
    void printName();
    default void   printNameUpperCase(){
        System.out.println(getName());
    };
    String getName();
}
