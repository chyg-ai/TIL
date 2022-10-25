package project.tests;

import java.util.Scanner;

// Source : https://www.acmicpc.net/problem/11720

public class test11720 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long n=sc.nextLong();
		long[] arr=new long[100];
		long sum=0;
		for(long i=0; i<n; i++) {
			sum+=sc.nextLong();
		}
		System.out.println(sum);
	}

}
