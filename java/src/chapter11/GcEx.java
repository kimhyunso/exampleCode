package chapter11;

public class GcEx {
    public static void main(String[] args) {
        Employee employee;
        employee = new Employee(1);
        employee = null;
        employee = new Employee(2);
        employee = new Employee(3);
        
        System.out.println("employee가 최종적으로 참조하는 사원 번호: "+employee.eno);
        System.gc();
    }
}

class Employee{
    public int eno;
    public Employee(int eno){
        this.eno =eno;
        System.out.println("Employee("+eno+") 가 메모리에 생성됨");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Employee("+eno+") 가 메모리에 제거됨");
    }
}
