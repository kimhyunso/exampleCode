package chapter13.example;

public class OtherPair<K,V> {
    private K key;
    private V value;

    public OtherPair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }
}
