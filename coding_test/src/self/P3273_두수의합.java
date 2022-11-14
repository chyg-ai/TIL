package self;

import java.util.Arrays;
import java.util.Scanner;

// 런타임 에러(ArrayIndexOutOfBounds)

public class P3273_두수의합 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();
        int[] A=new int[N];
        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
        }
        int X=scanner.nextInt();
        Arrays.sort(A);

        int i=0, j=N-1, count=0;
        while(i<j){
            if(A[i]+A[j] > X){
                j--;
            }else if(A[i]+A[j] < X){
                i++;
            }else{
                count++;
                j--;
                i++;
            }
        }

        System.out.println(count);
    }
}
