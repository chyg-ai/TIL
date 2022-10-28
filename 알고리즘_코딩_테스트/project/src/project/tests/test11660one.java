package project.tests;

import java.util.Scanner;

public class test11660one {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int sum=0;
		
		int[][] matrix=new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				matrix[i][j]=sc.nextInt();					
				if(i!=0) {
					matrix[i][j]+=matrix[i-1][j];
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			int topLeftX=sc.nextInt();
			int topLeftY=sc.nextInt();
			int bottomRightX=sc.nextInt();
			int bottomRightY=sc.nextInt();
			
			for(int j=topLeftX; j<=bottomRightX; j++) {
				if(topLeftY==1) {
					sum+=matrix[j-1][bottomRightY-1];
				}else {
					sum+=matrix[j-1][bottomRightY-1];
					sum-=matrix[topLeftX-1][topLeftY-1];
				}
			}
			
			System.out.println(sum);
		}
	}

}
