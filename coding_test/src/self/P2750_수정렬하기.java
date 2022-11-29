package self;

// https://www.acmicpc.net/problem/2750

import java.util.Scanner;

public class P2750_수정렬하기 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();
        int[] arr=new int[N];
        for(int i=0; i<N; i++){
            arr[i]=scanner.nextInt();
        }

        for(int i=0; i<N-1; i++){ // N-1번 반복
            for(int j=0; j<(N-1-i); j++){
                if(arr[j] > arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
}
