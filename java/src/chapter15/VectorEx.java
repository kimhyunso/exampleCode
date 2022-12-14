package chapter15;

import java.util.List;
import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        List<Board> list = new Vector<>();

        for(int i=1; i<=5; i++)
            list.add(new Board("제목"+i,"내용"+i,"글쓴이"+i));

        list.remove(2);
        list.remove(3);

        for(Board board : list)
            System.out.println(board.subject+" "+board.content+" "+board.writer);

    }
}
