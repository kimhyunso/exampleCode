package chapter14;

public class Fruit {
    private int price;
    private String name;

    public Fruit(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
