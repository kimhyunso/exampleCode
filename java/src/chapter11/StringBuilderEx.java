package chapter11;

public class StringBuilderEx {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("Java");          //추가작업
        sb.append("Program Study"); //추가작업
        System.out.println(sb.toString());

        sb.insert(4,"2"); //index 4위치 뒤에 문자열2를 삽입
        System.out.println(sb.toString());

        sb.setCharAt(4,'6'); //index 4위치에 있는 문자를 문자 6으로 변경
        System.out.println(sb.toString());

        sb.replace(5,13,"Book"); //index 6부터 index 13까지 전체를 book 문자열로 대치
        System.out.println(sb.toString());

        sb.delete(4,5); //index4부터 index5전까지 전부삭제
        System.out.println(sb.toString());

        int length = sb.length(); //총문자의 길이
        System.out.println("총 문자 수: "+length);

        String result = sb.toString(); //버퍼안에 있는 문자열
        System.out.println(result);



    }
}
