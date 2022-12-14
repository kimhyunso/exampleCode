package chapter07;

public class HankooTire extends Tire{

    public HankooTire(String location, int maxRotation){
        super(location,maxRotation);
    }

    @Override
    public boolean roll() {
        ++accumulatedRotation;
        if(accumulatedRotation < maxRotation){
            System.out.println(location + " HankooTire 수명: "+(maxRotation-accumulatedRotation)+" 회");
            return true;
        }else{
            System.out.println("*** "+location+" HankooTire 펑크 ***");
            return false;
        }
    }
}
