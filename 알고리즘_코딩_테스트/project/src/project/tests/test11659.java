package project.tests;

import java.util.Scanner;

//https://www.acmicpc.net/problem/11659
public class test11659 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=0, M=0;
		N=sc.nextInt();
		M=sc.nextInt();
		
		int[] arr=new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int a=0; a<M; a++) {
			int i=sc.nextInt();
			int j=sc.nextInt();
			int sum=0;
			for(int b=(i-1); b<j; b++) {
				sum+=arr[b];
			}
			System.out.println(sum);
		}
	}
}
