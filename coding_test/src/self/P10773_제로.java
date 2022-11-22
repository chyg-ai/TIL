package self;

// https://www.acmicpc.net/problem/10773

import java.util.Scanner;
import java.util.Stack;

public class P10773_제로 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int K=scanner.nextInt();
        int result=0;
        Stack<Integer> stack=new Stack<>();

        for(int i=0; i<K; i++){
            int num=scanner.nextInt();
            if(num==0 && !stack.empty()) { result-=stack.pop(); }
            else {
                stack.push(num);
                result+=num;
            }
        }

        System.out.println(result);
    }
}
