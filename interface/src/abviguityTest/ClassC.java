package abviguityTest;

public class ClassC implements InterA,InterB{
    @Override
    public void printData() {
        InterA.super.printData();
        InterB.super.printData();
    }
}
