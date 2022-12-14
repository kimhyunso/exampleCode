package chapter06.example;

public class Account {
    /*private int balance;
    private final static int MIN_BALANCE = 0;
    private final static int MAX_BALANCE = 1000000;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(balance <= MIN_BALANCE || balance >= MAX_BALANCE)
            return;
        this.balance = balance;
    }*/
    private String ano;
    private String owner;
    private int balance;

    public Account(String ano, String owner, int balance){
        this.ano = ano;
        this.owner = owner;
        this.setBalance(balance);
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(balance < 0 || this.balance < 0) {
            System.out.println("금액을 확인하여 주십시오.");
            return;
        }
        this.balance = balance;
    }
}
