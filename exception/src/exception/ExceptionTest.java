package exception;

public class ExceptionTest {
    public static void main(String[] args) {
        try{
            System.out.println(10/0);
        } catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        } catch(Exception e){
            System.out.println("알수 없는 오류");
        }finally {
            System.out.println("반드시 실행되어야 하는 문장");
        }
    }
}
