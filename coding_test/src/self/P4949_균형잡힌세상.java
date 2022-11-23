package self;

// https://www.acmicpc.net/problem/4949

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str=br.readLine();
            if(str.equals(".")) break;

            Stack<Character> stack=new Stack<>();
            char[] strArr=str.toCharArray();
            for(int i=0; i<strArr.length; i++){
                char ch=strArr[i];
                switch(ch){
                    case '(':
                    case '[':
                        stack.push(ch);
                        break;
                    case ')':
                        if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                        else stack.push(ch);
                        break;
                    case ']':
                        if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                        else stack.push(ch);
                        break;
                }
            }

            if(!stack.isEmpty()){
                System.out.println("no");
            }else{
                System.out.println("yes");
            }
        }
    }
}
