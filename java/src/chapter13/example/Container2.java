package chapter13.example;

public class Container2 <T,M>{
    private T key;
    private M value;

    public void set(T key, M value){
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }
    public M getValue() {
        return value;
    }
}
