package methodLambda;

public class DefaultFoo implements Foo {
    String name;

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

}
