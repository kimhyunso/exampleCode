package chapter11;

import java.util.Arrays;

public class SearchEx{
    public static void main(String[] args) {
        //기본 타입값 검색
        int[] scores = {99,97,96};
        Arrays.sort(scores);
        int index = Arrays.binarySearch(scores,99);
        System.out.println("찾은 인덱스: "+index);

        System.out.println("-----------------------------");
        //문자열 검색
        String[] names = {"홍길동","박동수","김민수"};
        Arrays.sort(names);
        index = Arrays.binarySearch(names,"홍길동");
        System.out.println("찾은 인덱스: "+index);

        System.out.println("---------------------------");

        Member m1 = new Member("홍길동");
        Member m2 = new Member("박동수");
        Member m3 = new Member("김민수");
        Member[] members = {m1,m2,m3};
        Arrays.sort(members);
        index = Arrays.binarySearch(members,m1);
        System.out.println("찾은 인덱스: "+index);


    }
}
