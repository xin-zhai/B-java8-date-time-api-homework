package com.thoughtworks.capability.gtb;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 计算任意日期与下一个劳动节相差多少天
 *
 * @author itutry
 * @create 2020-05-15_16:33
 * @editer zhai xin
 * @edit time: 2020-06-11_12:30
 */
public class Practice1 {

    public final static int LABOR_DAY_MONTH = 5;
    public final static int LABOR_DAY_DAY = 1;
    public final static int ADD_ONE_YEAR = 1;

    public static long getDaysBetweenNextLaborDay(LocalDate date) {
        int getYear = date.getYear();
        int getMonth = date.getMonth().getValue();
        int getDay = date.getDayOfMonth();
        long dayDifference = 0;

        if (getMonth < LABOR_DAY_MONTH) {
            LocalDate dateLaborDay = LocalDate.of(getYear, LABOR_DAY_MONTH, LABOR_DAY_DAY);
            dayDifference = ChronoUnit.DAYS.between(date, dateLaborDay);
        } else if (getMonth > LABOR_DAY_MONTH) {
            LocalDate dateLaborDay = LocalDate.of(getYear + ADD_ONE_YEAR, LABOR_DAY_MONTH, LABOR_DAY_DAY);
            dayDifference = ChronoUnit.DAYS.between(date, dateLaborDay);
        } else {
            if (getDay > LABOR_DAY_DAY) {
                LocalDate dateLaborDay = LocalDate.of(getYear + ADD_ONE_YEAR, LABOR_DAY_MONTH, LABOR_DAY_DAY);
                dayDifference = ChronoUnit.DAYS.between(date, dateLaborDay);
            } else {
                return 0;
            }
        }

        return dayDifference;
    }
}