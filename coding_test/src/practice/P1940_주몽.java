package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        int[] A=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int count=0, i=0, j=N-1;
        while(i < j){
            if(A[i]+A[j] < M){
                i++;
            }else if(A[i]+A[j] > M) {
                j--;
            }else{
                i++;
                j--;
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}
