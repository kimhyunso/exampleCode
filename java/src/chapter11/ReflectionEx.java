package chapter11;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("chapter11.Car");
        System.out.println("[클래스 이름]");
        System.out.println(clazz.getName());
        System.out.println();

        System.out.println("[생성자 정보]");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for(Constructor con : constructors){
            System.out.print(con.getName()+"(");
            Class[] parameters = con.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }

        System.out.println();
        
        System.out.println("[필드 정보]");
        Field[] fields = clazz.getFields();
        for(Field field : fields)
            System.out.println(field.getType().getSimpleName()+" "+field.getName());
        System.out.println();

        System.out.println("[메소드 정보]");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.print(method.getName()+"(");
            Class[] parameters = method.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }
    }

    private static void printParameters(Class[] parameters){
        for(int i=0; i<parameters.length; i++){
            System.out.print(parameters[i].getName());
            if(i<parameters.length-1)
                System.out.print(",");
        }
    }
}
