package interf;

public class Cat implements Pet {

    @Override
    public void sitDown() {
        System.out.println("아무런 반응이 없다.");
    }

    @Override
    public void stop() {
        System.out.println("아무런 반응이 없다.");
    }

    @Override
    public void poop() {
        System.out.println("알아서 잘싼다.");
    }

    @Override
    public void bang() {
        System.out.println("아무런 반응이 없다.");
    }
}
