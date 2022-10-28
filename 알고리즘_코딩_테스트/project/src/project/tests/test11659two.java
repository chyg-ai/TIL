package project.tests;

import java.util.Scanner;

//https://www.acmicpc.net/problem/11659
//정답

public class test11659two {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[] s=new int[N];
		
		for(int i=0; i<N; i++) {
			if(i!=0) {
				s[i]=sc.nextInt();
				s[i]+=s[i-1];
			}else {
				s[i]=sc.nextInt();
			}
		}
		
		for(int i=0; i<M; i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			if(start==1) {
				System.out.println(s[end-1]);
			}else {
				System.out.println(s[end-1]-s[start-2]);
			}
		}
	}

}
