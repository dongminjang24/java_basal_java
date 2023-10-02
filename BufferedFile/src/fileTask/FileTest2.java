package fileTask;

import java.io.*;

public class FileTest2 {
    public static void main(String[] args) throws IOException {
//        갈치,대구,돔,고등어,연어,광어.참치,숭어,멸치
//        String[] fishs = {"갈치", "대구", "돔", "고등어"};
//        BufferedWriter bf = new BufferedWriter(new FileWriter("fish.txt"));
//        for (String fish : fishs) {
//            bf.write(fish + "\n");
//        }
//        bf.close();
//
//        //수정
//        try{
//        BufferedReader  br = new BufferedReader(new FileReader("fish.txt"));
//        String line = null;
//        String temp="";
//        while ((line=br.readLine()) != null){
//            if (line.equals("대구")){
//                temp += "개복치 \n";
//                continue;
//            }
//            temp+=line +"\n";
//
//            System.out.println(line);
//        }
//        br.close();
//
//        BufferedWriter bw = new BufferedWriter(new FileWriter("fish.txt"));
//        bw.write(temp);
//        bw.close();}catch (FileNotFoundException e){;}

        BufferedReader br = new BufferedReader(new FileReader("fish.txt"));
        String line = null;
        String temp = "";
        while ((line = br.readLine()) != null) {
            if (line.equals("개복치")) {
                continue;
            }
            temp += line + "\n";
        }
        System.out.println(temp);
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("fish.txt"));
        bw.write(temp);
        bw.close();
    }
}
