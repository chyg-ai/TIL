package practice;

// https://www.acmicpc.net/problem/17298

import java.io.*;
import java.util.Stack;

public class P17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(bf.readLine());
        int[] A=new int[N];
        int[] ANS=new int[N];
        String[] str=bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(str[i]);
        }

        Stack<Integer> myStack=new Stack<>();
        myStack.push(0);
        for(int i=1; i<N; i++){
            while(!myStack.isEmpty() && A[myStack.peek()] < A[i]){
                ANS[myStack.pop()]=A[i];
            }
            myStack.push(i);
        }

        while(!myStack.empty()){
            ANS[myStack.pop()]=-1;
        }

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            bw.write(ANS[i]+" ");
        }

        bw.write("\n");
        bw.flush();
    }
}
