package chapter10;

public class BalanceInsuffcientExcpetion extends Exception {
    public BalanceInsuffcientExcpetion(){}
    public BalanceInsuffcientExcpetion(String message){
        super(message);
    }
}
