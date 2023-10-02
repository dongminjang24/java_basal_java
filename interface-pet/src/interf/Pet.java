package interf;

public interface Pet {
    final static int eyes=2;
    // static 은 모든 것이 공유함.
    int nose =1;

    abstract void sitDown();
    // abstract가 생략되었음
    void stop();
    void poop();
    void bang();

}
