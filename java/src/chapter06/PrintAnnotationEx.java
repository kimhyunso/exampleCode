package chapter06;

import java.lang.reflect.Method;

public class PrintAnnotationEx {
    public static void main(String[] args) {
        Method[] declaredMethods = Service.class.getDeclaredMethods();

        for(Method method : declaredMethods){

            System.out.println(method.getName());
            PrintAnnotation a = method.getAnnotation(PrintAnnotation.class);
            System.out.println(a.value());

           /*if(method.isAnnotationPresent(PrintAnnotation.class)){
                PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

                System.out.println("["+method.getName()+"]");

                for(int i=0; i<printAnnotation.number(); i++)
                    System.out.print(printAnnotation.value());

                System.out.println();

                try{
                    method.invoke(new Service());
                }catch (Exception e){}
                System.out.println();
            }*/
        }
    }

}
