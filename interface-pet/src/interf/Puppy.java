package interf;

public class Puppy implements Pet{
    @Override
    public void sitDown() {
        System.out.println("앉는다.");
    }

    @Override
    public void stop() {
        System.out.println("기다린다.");
    }

    @Override
    public void poop() {
        System.out.println("맨날 싸는 곳에 싼다..");
    }

    @Override
    public void bang() {
        System.out.println("눕는다...");
    }
}
