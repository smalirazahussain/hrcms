package Tests;

public class Current_Date {

    public static String currentYear(){

        java.util.Date date = new java.util.Date();
        String year = String.valueOf(date);
        year = year.substring(year.length() - 4);


        return year;

    }

    public static String currentMonth(){

        java.util.Date date = new java.util.Date();
        String month = String.valueOf(date);
        month = month.substring(4,7);
        return month;
    }

    public static String currentDay(){

        java.util.Date date = new java.util.Date();
        String day = String.valueOf(date);
        day = day.substring(8,10);

        if(Integer.parseInt(day)<10) {
            day = day.substring(1,2);
        }

        return day;
    }

    public static void main(String[] args) {

        java.util.Date date = new java.util.Date();
        System.out.println(currentDay());

    }
}
