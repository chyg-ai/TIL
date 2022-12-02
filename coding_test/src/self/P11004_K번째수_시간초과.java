package self;

// https://www.acmicpc.net/problem/11004

// N의 크기 최대 5,000,000 이하이므로 시간 복잡도 O(n^2)인 알고리즘을 사용하면 안된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수_시간초과 {

    private static void quickSort(int[] arr, int left, int right){
        if(left<right){
            int p=partition(arr, left, right);
            quickSort(arr, left, p-1);
            quickSort(arr, p+1, right);
        }
    }

    private static int partition(int[] arr, int left, int right){
        int pivot=arr[left]; // 가장 왼쪽의 요소를 피벗(기준)으로 잡는다.
        int low=left+1;
        int high=right;

        while(low<high){
            while(arr[low] < pivot) low++;
            while(arr[high] > pivot) high--;

            if(low<high){
                int temp=arr[low];
                arr[low]=arr[high];
                arr[high]=temp;
            }
        }

        if(pivot > arr[high]){
            arr[left]=arr[high];
            arr[high]=pivot;
        }

        return high;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int[] arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N-1);

        System.out.println(arr[K-1]);
    }

}
