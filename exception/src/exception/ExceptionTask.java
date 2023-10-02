package exception;

import java.util.Scanner;

public class ExceptionTask {
    public static void main(String[] args) {
        //5개의 정수만 입력받기
        //- 무한 입력 상태로 구현
        // q 입력시 나가기
        // 5개의 정수는 배열에 담기
        // if문은 딱한번만 사용하기
        int[] arData = new int[5];
        Scanner sc = new Scanner(System.in);
        String msg = "번째 정수 :", temp =null;
        int index =0;
        while (true){

            System.out.println(++index  + msg);
                temp=sc.next();
                if (temp.equals("q")){break;}
            try{
                arData[index-1]= Integer.parseInt(temp);
            }catch (NumberFormatException e){
                e.printStackTrace();
                System.out.println("제대로된 숫자를 입력하셨나요?");
                --index;
            }
            catch (ArrayIndexOutOfBoundsException e){
//                e.printStackTrace();
                System.out.println("배열의 인덱스를 넘기셨습니다.");
                for (int i=0;i<arData.length;i++){
                    System.out.println(arData[i]);
                }
                break;
            }catch (Exception e){
                System.out.println("도대체 뭐를 입력했길래 이게 출력되니?");
            }

        }
    }
}
