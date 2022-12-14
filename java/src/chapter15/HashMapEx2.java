package chapter15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx2 {
    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();
        map.put(new Student(1, "홍길동"),95);
        map.put(new Student(1,"홍길동"),70);

        System.out.println("총 Entry 수: "+map.size());

        Set<Map.Entry<Student, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Student, Integer>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry<Student, Integer> entry = iterator.next();
            Student key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+":"+value);
        }


    }
}
