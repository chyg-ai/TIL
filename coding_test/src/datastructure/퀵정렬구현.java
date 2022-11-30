package datastructure;

// Quick Sort

import java.util.Scanner;

public class 퀵정렬구현 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();

        int[] originalArr=new int[N];
        for(int i=0; i<N; i++){
            originalArr[i]=scanner.nextInt();
        }

        System.out.println("##### 원본 배열 #####");
        for(int i=0; i<N; i++){
            System.out.println(originalArr[i]);
        }

        System.out.println("##### 퀵 정렬 후 #####");
        quickSort(originalArr, 0, originalArr.length-1);
        for(int i=0; i<N; i++){
            System.out.println(originalArr[i]);
        }
    }

    private static void quickSort(int[] arr, int left, int right){
        if(left<right){
            int p=partition(arr, left, right); // 부분 정렬 처리
            quickSort(arr, left, p-1);
            quickSort(arr, p+1, right);
        }
    }

    private static int partition(int[] arr, int left, int right){
        int pivot=arr[left];
        int low=left+1;
        int high=right;

        while(low<high){
            while(arr[low] < pivot){ low++; } // 피벗보다 작은 경우 오른쪽으로 이동, 큰 경우는 멈춘다.
            while(arr[high] > pivot){ high--; } // 피벗보다 큰 경우 왼쪽으로 이동, 작은 경우는 멈춘다.

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
}
