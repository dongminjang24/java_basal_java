package lambdaTask;
@FunctionalInterface
public interface OperCheck {
    // 수식을 입력받은 후 각 수식을 분리하여 문자열 배열로 리턴
    public String[] getOpers(String expression);
}
