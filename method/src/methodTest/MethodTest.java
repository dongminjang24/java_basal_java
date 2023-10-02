package methodTest;

public class MethodTest {


    int getCount(String str, char c) {
        int count = 0;

        for (int i =0 ; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드

    }

}
