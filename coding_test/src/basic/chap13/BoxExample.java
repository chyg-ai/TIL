package basic.chap13;

public class BoxExample {
    public static void main(String[] args){
//        제네릭 사용 전
//        Box box=new Box();
//        box.set("홍길동"); // String → Object
//        String name=(String)box.get(); // Object → String
//
//        box.set(new Apple()); // Apple → Object;
//        Apple apple=(Apple)box.get(); // Object → Apple

        Box<String> box1=new Box<String>();
        box1.set("hello");
        String str=box1.get();

        Box<Integer> box2=new Box<Integer>();
        box2.set(6);
        int value=box2.get();
    }
}
