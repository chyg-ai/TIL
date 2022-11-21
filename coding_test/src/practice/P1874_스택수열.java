package practice;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        // 수열의 개수: N, N개의 수열 값 입력
        int N=scanner.nextInt();
        int[] A=new int[N];
        for(int i=0; i<N; i++){
            A[i]=scanner.nextInt();
        }

        Stack<Integer> stack=new Stack<>();
        StringBuffer bf=new StringBuffer();
        int num=1; // 오름차순 자연수
        boolean result=true;
        for(int i=0; i<A.length; i++){
            int su=A[i]; // 수열 값

            if(su >= num){
                while(su >= num){
                    stack.push(num++);
                    bf.append("+\n");
                }

                stack.pop();
                bf.append("-\n");
            }else{
                int n=stack.pop();

                if(n > su){
                    System.out.println("NO");
                    result=false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}
