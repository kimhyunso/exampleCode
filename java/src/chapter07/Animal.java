package chapter07;

public abstract class Animal {
    private String kind;

    public void breathe(){
        System.out.println("숨을 쉽니다.");
    }

    public abstract void sound();

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
