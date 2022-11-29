import java.util.Scanner;

public class 삽입정렬구현 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();

        // 정수 데이터 삽입
        int[] numbers=new int[N];
        for(int i=0; i<N; i++){
            numbers[i]=scanner.nextInt();
        }

        System.out.println("##### 삽입 정렬 전 #####");
        for(int i=0; i<N; i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();

        System.out.println("##### 오름차순 삽입 정렬 후 #####");
        AscendingSort(numbers);
        System.out.println();

        System.out.println("##### 내림차순 삽입 정렬 후 #####");
        DescendingSort(numbers);
        System.out.println();
    }

    // 오름차순 정렬
    private static void AscendingSort(int[] numbers){
        for(int i=1; i<numbers.length; i++){
            for(int j=i; j>0; j--){
                if(numbers[j] < numbers[j-1]){
                    int temp=numbers[j];
                    numbers[j]=numbers[j-1];
                    numbers[j-1]=temp;
                }
            }
        }

        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i]+" ");
        }
    }

    // 내림차순 정렬
    private static void DescendingSort(int[] numbers){
        for(int i=1; i<numbers.length; i++){
            for(int j=i; j>0; j--){
                if(numbers[j] > numbers[j-1]){
                    int temp=numbers[j];
                    numbers[j]=numbers[j-1];
                    numbers[j-1]=temp;
                }
            }
        }

        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i]+" ");
        }
    }
}
