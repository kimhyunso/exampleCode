package chapter11;

public class NewInstanceEx {
    public static void main(String[] args) {
        try{
            Class clazz = Class.forName("chapter11.SendAction");
            //Class clazz = Class.forName("chapter11.ReceiveAction");
            Action action = (Action) clazz.newInstance();
            action.execute();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }

}
