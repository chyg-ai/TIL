package self;

import java.util.Scanner;

public class P1427_소트인사이드 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();

        int[] A=new int[str.length()];
        for(int i=0; i<str.length(); i++){
            A[i]=Integer.parseInt(str.substring(i, i+1));
        }

        for(int i=0; i<(A.length-1); i++){
            int Max=i;
            for(int j=i+1; j<A.length; j++){
                if(A[Max] < A[j]) Max=j;
            }

            if(A[i] < A[Max]){
                int temp=A[i];
                A[i]=A[Max];
                A[Max]=temp;
            }
        }

        for(int i=0; i<str.length(); i++){
            System.out.print(A[i]);
        }
    }

}
