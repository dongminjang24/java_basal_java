//package lambdaTask;
//
//import java.util.Scanner;
//
//public class Calc {
//    //외부에서 연산자를 전달받은 후 해당 연산에 맞도록 구현
//    public static MyMath calculator(String oper){
//        MyMath myMath = null;
//        switch (oper){
//            case "+":
//                // 덧셈을 리턴 받았을 때 더하기 연산 구현
//                myMath = (num1,num2)-> num1+num2;
//                break;
//            case "-":
//                // 뺄셈을 리턴 받았을 때 빼기 연산 구현
//                myMath = (num1,num2)-> num1- num2;
//                break;
//        }
//        // 필드가 구현된 MyMath 객체 리턴
//        return  myMath;
//    }
//
//    public static void main(String[] args) {
//        OperCheck operCheck = (e) -> {
//            String temp = "";
//            for(int i =0 ; i < e.length(); i++){
//                char c= e.charAt(i);
//                // 수식엣 +(43) ,-(45)를 따로 temp 연결해준다.
//                if(c==43 || c==45){
//                    temp += c;
//                }
//            }
//            // "ABC".split("") ---> [A][B][C]인 3칸 문자열 배열로 리턴
//            // 각 문자 모두 분리
//            return  temp.split("");
//        };
//        String msg ="정수의 덧셈,뺄셈에 대한 식을 입력하세요.";
//        String exMsg = "예)5+9-7";
//        String temp = null;
//        String[] opers =null;
//        String[] nums =null;
//        int num1 =0 ;
//        int num2 =0 ;
//        Scanner sc = new Scanner(System.in);
//        System.out.println(msg);
//        System.out.println(exMsg);
//        // \\+ : + 문자
//        // \\- : - 문자
//        // 여러개의 구분점을 사용할 때에는 각 구분점을 | 연산자로 작성해준다.
//        temp = sc.next();
//        // nums에는 정수들만 문자열 배열로 들어가 있다.
//        nums = temp.split("\\+|\\-");
//        // 사용자가 입력한 수식을 전달하면, 연산자만 문자열 배열로 리턴해준다.
//        opers = operCheck.getOpers(temp);
//
//        // 첫번째 정수가 음수일 경우 -n 이기 때문에
//        // opers에는 첫번째 연산자가 -로 들어간다.
//        //또한 Nums에서는 -n일 경우 [""]["n"]와 같은 식으로 분리되기 때문에
//        // 첫번째 방에 있는 값이 "" 라면 첫번째 정수가 음수라는 뜻이다.
//        // 첫번째 정수가 음수일 경우, 첫번째 연산자와 두번째 정수를 연결하여 -n을 만들어준다.
//        num1 = Integer.parseInt(num[0].equals("")? opers[0]+num[1] : nums[0]);
////        num1 = Integer.parseInt(nums[0]);
//        // 연산작 개수만큼 반복
//        for(int i=0; i < opers.length; i ++){
//            // 만약 첫번째 반복부터 첫번재 정수가 음수라면,
//            // 인덱스를 한개씩 건너뛰어야 한다.
//            //nums[0]: "",nums[1]:첫번째 정수
//            // opers[0]: -
//            if (num1 < 0 && i=0) {continue;}
//            // 두번째 정수는 현재 인덱스 다음 번째 값이다.
//            num2 = Integer.parseInt(nums[i+1]);
//            // 연산 결과가 다시 첫번째 정수로 된다.
//
//            num1 = calculator(opers[i]).calc(num1,num2);
//        }
//        System.out.println(num1);
//    }
//}
