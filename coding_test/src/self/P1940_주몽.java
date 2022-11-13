package self;

import java.util.Scanner;

// 틀렸습니다. 문제를 제대로 이해할 것

public class P1940_주몽 {
    public static void main(String[] args) throws Exception{
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int count=0, startIdx=0, endIdx=1;

        int A[]=new int[N];
        for(int i=0; i<N; i++){
            A[i]=scanner.nextInt();
        }

        while(startIdx != N-1){
            if(A[startIdx] + A[endIdx] == M){
                startIdx++;
                endIdx++;
                count++;
            }else if(A[startIdx] + A[endIdx] != M){
                endIdx++;
            }

            // endIdx 마지막 요소인 경우
            if(endIdx == N){
                startIdx++;
                endIdx=startIdx+1;
            }
        }

        System.out.println(count);
    }
}
