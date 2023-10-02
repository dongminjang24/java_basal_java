package objectTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListTest{
    public static void main(String[] args) {
        // 꺽세 제네릭, 포괄적인,이름이 없는
        // 임시로 타입을 선언하여 임시 타입으로 설계한다.
        // 제네릭을 쓰면 따로 다운 캐스팅을 할 필요가 없다.
        // 오브젝트를 하면 모든 애들이 다 들어가기 때문에 제약을 둘 수가 없다.
        //제네릭은 타입에 제한을 둘 수가 있음. 타입 가드
        ArrayList<Integer> datas = new ArrayList<Integer>();
        ArrayList<Integer> datas2 = new ArrayList<>(); // 생략이 가능함.
        datas2.add(10);
        datas2.add(20);
        datas2.add(30);
        datas2.add(40);
        datas2.add(50);
        datas2.add(60);
        datas2.add(70);
        datas2.add(80);
        datas2.add(90);
        datas2.add(100);

        System.out.println(datas2.size());
        for(int i =0; i < datas2.size() ; i++){
//            System.out.println(datas2);
            if (datas2.get(i) == 50){
                datas2.set(i+1,500);
            }
            if (datas2.get(i) == 90){
                datas2.set(i,9);
            }
            if (datas2.get(i) == 80){
                datas2.remove(datas2.get(i) );
        };
        }
        // 빠른 for문 향상된 for문, forEach
//        for(int data1 : datas2){
//            System.out.println(data1);
//            if (data1 == 50){
//                data1
//            }
//        };
//        Collections.sort(datas2);
//        Collections.reverse(datas2);
//        System.out.println(datas2);
//        datas2.remove(1);


        System.out.println(datas2);

    };
}
