package chapter11;

import java.util.Arrays;
import java.util.Objects;

public class Member implements Cloneable, Comparable<Member> {
    /*public String id;
    public String name;
    public String password;
    public int age;
    public boolean adult;
    public int[] scores;
    public Car car;

    public Member(String name,int age,int[] scores,Car car){
        this.name = name;
        this.age = age;
        this.scores =scores;
        this.car =car;
    }

    public Member(String id,String name,String password,int age,boolean adult){
        this.id = id;
        this.name = name;
        this.password = password;
        this.age =age;
        this.adult =adult;
    }

    public Member getMember(){
        Member cloned = null;
        try{
            cloned = (Member) clone();
        }catch (Exception e){}
        return cloned;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Member cloned = (Member)super.clone();

        cloned.scores = Arrays.copyOf(this.scores,this.scores.length);
        cloned.car = new Car(this.car.model);
        return cloned;
    }*/

    public String name;
    public Member(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        return name.compareTo(o.name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /*public String id;

    public Member(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member){
            Member member = (Member) obj;
            if(id.equals(member.id))
                return true;
        }

        return false;
    }*/
}
