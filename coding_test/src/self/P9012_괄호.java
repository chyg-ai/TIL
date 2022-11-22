package self;

// https://www.acmicpc.net/problem/9012

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int T=Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            Stack<Character> stack=new Stack<>();
            String ps=br.readLine(); // ps 입력
            char[] psArr=ps.toCharArray();
            for(int j=0; j<psArr.length; j++){
                char psCh=psArr[j];
                switch(psCh){
                    case '(':
                        stack.push(psCh);
                        break;
                    case ')':
                        if(!stack.isEmpty() && stack.peek() == '(' ) stack.pop();
                        else stack.push(psCh);
                        break;
                }
            }

            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
