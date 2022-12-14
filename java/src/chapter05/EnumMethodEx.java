package chapter05;

public class EnumMethodEx {
    public static void main(String[] args) {
        //name()
        Week today = Week.SUNDAY;
        String name = today.name();
        System.out.println(name);

        System.out.println("--------------------------");

        //ordinal()
        int ordinal = today.ordinal();
        System.out.println(ordinal);

        System.out.println("-----------------------------");

        //compareTo()
        Week day1 = Week.MONDAY;
        Week day2 = Week.WEDNESDAY;
        int result1 = day1.compareTo(day2); //0-2
        int result2 = day2.compareTo(day1); //2-0
        System.out.println(result1);
        System.out.println(result2);

        System.out.println("-------------------------------");

        //valueOf()
        if(args.length == 1){
            String strDay = args[0].toUpperCase();
            Week weekDay = Week.valueOf(strDay);
            if(weekDay == Week.SATURDAY || weekDay == Week.SUNDAY)
                System.out.println("주말이군요");
            else
                System.out.println("평일이군요");
        }

        System.out.println("-----------------------------");

        //values()
        Week[] days = Week.values();
        for(Week day : days)
            System.out.println(day);
    }
}
