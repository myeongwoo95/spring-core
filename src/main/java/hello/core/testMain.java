package hello.core;

import java.time.LocalDate;

public class testMain {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.parse("2020-12-31");
        System.out.println(date1); //2022-04-14
        System.out.println(date1.getYear()); //2022

        System.out.println(date1.getMonthValue()); //4
        System.out.println(date1.getMonth()); //APRIL

        System.out.println(date1.getDayOfYear()); //104 (2020년 1월 1일부터 몇일 지났는가? [1일~ 365일])
        System.out.println(date1.getDayOfMonth()); // 14
        System.out.println(date1.getDayOfWeek()); // THURSDAY
    }
}
