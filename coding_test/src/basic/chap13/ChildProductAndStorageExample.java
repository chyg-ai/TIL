package basic.chap13;

public class ChildProductAndStorageExample {
    public static void main(String[] args){
        ChildProduct<Tv, String, String> product=new ChildProduct<>();
        product.setModel(new Tv());
        product.setModel("SmartTV");
        product.setCompany("Samsung");

        Storage<Tv> storage=new StorageImpl<>(100);
        storage.add(new Tv(), 0);
        Tv tv=storage.get(0);
    }
}
