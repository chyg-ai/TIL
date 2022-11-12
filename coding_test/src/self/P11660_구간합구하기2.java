package self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 결과 : 시간 초과

public class P11660_구간합구하기2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int A[][]=new int[N+1][N+1];

        // N * N 배열 생성
        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                A[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        // 무식하게 (x1, y1) → (x2, y2) 까지의 합 구하기
        for(int i=1; i<=M; i++){
            int sum=0;
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for(int j=x1; j<=x2; j++){
                for(int z=y1; z<=y2; z++){
                    sum+=A[j][z];
                }
            }
            System.out.println(sum);
        }
    }
}
