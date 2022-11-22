package self;

// https://www.acmicpc.net/problem/10828

import java.util.Scanner;
import java.util.Stack;

public class P10828_스택_시간초과 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<N; i++){
            String cmd=scanner.next();
            switch(cmd.toLowerCase()){
                case "push":
                    int num=scanner.nextInt();
                    stack.push(num);
                    break;
                case "pop":
                    if(stack.isEmpty()) System.out.println("-1");
                    else System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "top":
                    if(stack.isEmpty()) System.out.println("-1");
                    else System.out.println(stack.peek());
                    break;
            }
        }
    }
}
