package chapter08.example;

public class DaoEx {
    public static void dbWork(DataAccessObject dao){
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();
    }

    public static void main(String[] args) {
        dbWork(new OracleDao());
        System.out.println("----------------------");
        dbWork(new MySqlDao());
    }

}
