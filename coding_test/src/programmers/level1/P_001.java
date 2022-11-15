package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/134240

import java.util.Scanner;

public class P_001 {
    public static void main(String[] args) throws Exception{
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();
        int[] food=new int[N];
        for(int i=0; i<N; i++){
            food[i]=scanner.nextInt();
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0; i<food.length; i++){
            int elm=food[i];
            for(int j=0; j<(elm/2); j++){
                sb.append(i);
            }
        }

        String originalStr=sb.toString();
        String reverseStr=sb.reverse().toString();
        System.out.println(originalStr+"0"+reverseStr);
    }
}
