package practice;

import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int count=1, start_index=1, end_index=1, sum=1;

        while(end_index != N){
            if(sum == N){
                count++;
                end_index++;
                sum += end_index;
            }else if(sum < N){
                end_index++;
                sum += end_index;
            }else {
                sum -= start_index;
                start_index++;
            }
        }

        System.out.println(count);
    }
}
