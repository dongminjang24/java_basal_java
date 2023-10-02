package codingTest;

import java.util.*;

public class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = {};
        answer = new int[num_list.length/n][n]; // answer에서 크게 만들기

        int[] before=new int[n];

        //n개씩 뽑아서 넣은 것 순서대로 answer2차배열에 하나씩 넣기
        //before에는 []요소넣기  num_list.length/n , n  4,2     3,3
        //0,1 2,3 2*n,2*n+1


        for (int i = 0; i < num_list.length / n; i++) {
            for (int j = 0; j < n; j++) {
                before[j]=
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
