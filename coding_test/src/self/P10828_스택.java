package self;

// https://www.acmicpc.net/problem/10828

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());

        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());

            String cmd=st.nextToken();
            switch(cmd.toLowerCase()){
                case "push":
                    int num=Integer.parseInt(st.nextToken());
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
