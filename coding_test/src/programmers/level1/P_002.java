package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/136798
// 기사단원의 무기
// 시간 초과

import java.util.Scanner;

public class P_002 {

    // 약수 리스트를 구한다.
    private static int getDivisorsCount(int num) {
        int count=0;
        for(int i=1; i<=num; i++){
            if(num%i==0){ count+=1; }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);

        int number=scanner.nextInt();
        int limit=scanner.nextInt();
        int power=scanner.nextInt();

        int result=0;
        // i번째 기사단을 조회한다.
        for(int i=0; i<number; i++){
            int divisorsCount=getDivisorsCount(i+1); // i번째 기사의 약수 개수

            if(divisorsCount > limit) { result += power; }
            else { result += divisorsCount; }
        }

        System.out.println(result);
    }
}
