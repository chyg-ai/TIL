package project.tests;

import java.util.Scanner;

public class test1546 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[] arr=new int[N];
		int max=0;
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		
		int sum=0;
		for(int i=0; i<N; i++) {
			sum+=arr[i]/max*100;
		}
		System.out.println(sum/3);
	}

}
