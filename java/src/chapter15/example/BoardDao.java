package chapter15.example;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    private List<Board> list = new ArrayList<>();

    public BoardDao(){
        for(int i=1; i<=3; i++)
            list.add(new Board("제목"+i,"내용"+i));
    }

    public List<Board> getBoardList() {
        return list;
    }
}
