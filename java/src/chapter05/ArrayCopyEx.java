package chapter05;

import java.util.Arrays;

public class ArrayCopyEx {
    public static void main(String[] args) {
        int[] oldArray = {1,2,3};
        int[] newArray = new int[oldArray.length];

        /*for(int i=0; i<oldArray.length; i++){
            newArray[i] = oldArray[i];
            System.out.println(newArray[i]);
        }*/

        System.arraycopy(oldArray,0,newArray,0,oldArray.length);
        Arrays.stream(newArray).forEach(x->System.out.print(x+" "));

        System.out.println();
        System.out.println("-------------------------------------------");

        String[] oldStringArray = {"java","array","copy"};
        String[] newStringArray = new String[oldStringArray.length];

        System.arraycopy(oldStringArray,0,newStringArray,0,oldStringArray.length);
        Arrays.stream(newStringArray).forEach(x->System.out.print(x+" "));

    }


}
