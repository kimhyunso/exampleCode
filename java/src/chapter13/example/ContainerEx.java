package chapter13.example;

public class ContainerEx {
    public static void main(String[] args) {
        /*Container<String> container1 = new Container<>();
        container1.set("홍길동");
        String str = container1.get();

        Container<Integer> container2 = new Container<>();
        container2.set(6);
        int value = container2.get();*/

        Container2<String , String> container1 = new Container2<>();
        container1.set("홍길동","도적");
        String name1 = container1.getKey();
        String job = container1.getValue();

        Container2<String, Integer> container2 = new Container2<>();
        container2.set("홍길동",35);
        String name2 = container2.getKey();
        int age = container2.getValue();
    }
}
