package fileTask;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
//        try{
//            BufferedWriter bw = new BufferedWriter(new FileWriter("./text.txt"));
////            BufferedWriter bw = new BufferedWriter(new FileWriter("./text.txt",true));
//            // 이어쓰기
//
//            bw.write("한동석");
////            bw.newLine(); 운영체제에 맞는 줄바꿈
////            bw.write("한동석\n"); 줄바꿈
//            bw.close();
//        } catch (IOException e){
//            e.printStackTrace();}
        BufferedReader br = new BufferedReader(new FileReader("./text.txt"));
//        br.readLine();
        // null뜰때까지 while문을 사용한다.
        String line =null;
        // 줄바꿈 문자는 가져오지 않는다.
        while ((line = br.readLine())!= null){
            System.out.print(line);
        }
    }
}
