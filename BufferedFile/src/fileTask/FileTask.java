package fileTask;

import java.io.*;

public class FileTask {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("./test.txt"));
        String array[] = {"족발", "보쌈", "짜장면", "탕수육"};
        for (int i = 0; i < array.length; i++) {
            bw.write(array[i] + "\n");
        }

        bw.close();
        BufferedReader br = new BufferedReader(new FileReader("./test.txt"));
        String pring = null;
        while ((pring = br.readLine()) != null) {
            System.out.println(pring);
        }

    }
}
