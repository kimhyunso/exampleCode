package chapter06.example;

public class MemberService {

    public boolean login(String id,String password){
        if(id.equals("hong") && password.equals("12345"))
            return true;
        else
            return false;
    }

    public void logout(String id){
        System.out.println("["+id+"]님 "+"로그아웃 되었습니다.");

    }
}
