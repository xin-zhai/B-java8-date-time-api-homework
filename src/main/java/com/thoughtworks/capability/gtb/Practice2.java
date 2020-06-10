package com.thoughtworks.capability.gtb;

import java.time.LocalDate;

/**
 * 对任意日期获取下一个工作日, 不考虑节假日
 *
 * @author itutry
 * @create 2020-05-15_17:20
 * @editer zhai xin
 * @edit time: 2020-06-11_12:30
 */
public class Practice2 {

    public final static int FRIDAY = 5;
    public final static int SATURDAY = 6;
    public final static int FRIDAY_MONDAY_DIFFERENCE = 3;
    public final static int SATURDAY_MONDAY_DIFFERENCE = 2;
    public final static int OTHER_DAY_WORK_DAY_DIFFERENCE = 1;

    public static LocalDate getNextWorkDate(LocalDate date) {
        int getWeekOfDay = date.getDayOfWeek().getValue();
        LocalDate resultDate = null;
        if (getWeekOfDay == FRIDAY) {
            resultDate = date.plusDays(FRIDAY_MONDAY_DIFFERENCE);
        } else if (getWeekOfDay == SATURDAY) {
            resultDate = date.plusDays(SATURDAY_MONDAY_DIFFERENCE);
        } else {
            resultDate = date.plusDays(OTHER_DAY_WORK_DAY_DIFFERENCE);
        }
        return resultDate;
    }
}
