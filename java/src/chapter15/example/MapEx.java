package chapter15.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx {
    public static void main(String[] args) {
        Map<String ,Integer> map = new HashMap<>();
        map.put("blue",96);
        map.put("hong",86);
        map.put("white",92);

        String name = null;
        int maxScore = 0;
        int totalScore = 0;

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry<String ,Integer> entry = iterator.next();
            String key = entry.getKey();
            int value = entry.getValue();
            if(maxScore < value){
                maxScore = value;
                name = key;
            }
            totalScore += value;
        }
        totalScore = totalScore/map.size();

        System.out.println("평균점수: "+totalScore);
        System.out.println("최고점수: "+maxScore);
        System.out.println("최고점수를 받은 아이디: "+name);
    }
}
