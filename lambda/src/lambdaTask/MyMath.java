package lambdaTask;
@FunctionalInterface
public interface MyMath {
    // 두 정수 전달받은 후 뺄셈 또는 덧셈 결과를 int로 리턴
    public int calc(int num1,int num2);
}
