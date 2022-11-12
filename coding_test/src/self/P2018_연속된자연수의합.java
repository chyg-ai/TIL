package self;

import java.util.Scanner;

// 시간 초과

public class P2018_연속된자연수의합 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();
        int cnt=0;
        for(int i=1; i<=N; i++){
            int sum=0;
            for(int j=i; j<=N; j++){
                sum+=j;
                if(sum==N){
                    cnt+=1;
                }
            }
        }
        System.out.println(cnt);
    }
}
