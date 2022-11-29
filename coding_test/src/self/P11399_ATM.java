package self;

// https://www.acmicpc.net/problem/11399

import java.util.Scanner;

public class P11399_ATM {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();

        int[] arr=new int[N];
        for(int i=0; i<N; i++){
            arr[i]=scanner.nextInt();
        }

        // 오름차순 정렬
        // 버블 정렬
        // 시간 복잡도 O(n^2)
        for(int i=0; i<N-1; i++){
            for(int j=0; j<(N-1-i); j++){
                if(arr[j] > arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        int result=0;
        for(int i=1; i<=N; i++){
            int sum=0;
            for(int j=0; j<i; j++){
                sum+=arr[j];
            }

            result+=sum;
        }

        System.out.println(result);
    }
}
