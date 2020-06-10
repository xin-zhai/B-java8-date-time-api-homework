package com.thoughtworks.capability.gtb;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * 脑洞会议系统v3.0
 * 1.当前会议时间"2020-04-01 14:30:00"表示伦敦的本地时间，而输出的新会议时间是芝加哥的本地时间
 * 2.用Period来实现下个会议时间的计算
 *
 * @author itutry
 * @create 2020-05-19_18:43
 * @editer zhai xin
 * @edit time: 2020-06-11_12:30
 */
public class MeetingSystemV3 {

    public static void main(String[] args) {
        String timeStr = "2020-04-01 14:30:00";

        // 根据格式创建格式化类
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 从字符串解析得到会议时间
        LocalDateTime londonMeetingTime = LocalDateTime.parse(timeStr, formatter);
        ZoneId londonZoneId = ZoneId.of("Europe/London");
        ZonedDateTime londonZonedDateTime = ZonedDateTime.of(londonMeetingTime, londonZoneId);
        long londonAndGMTDifference = londonZonedDateTime.getOffset().getTotalSeconds();

        ZoneId beiJingZoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime beijingZoneDateTime = ZonedDateTime.of(londonMeetingTime, beiJingZoneId);
        long beijingAndGMTDifference = beijingZoneDateTime.getOffset().getTotalSeconds();
        LocalDateTime beijingTime = londonMeetingTime.plusSeconds(beijingAndGMTDifference - londonAndGMTDifference);

        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(beijingTime)) {
            Period addOneDay = Period.ofDays(1);
            LocalDateTime tomorrow = now.plus(addOneDay);
            int newDayOfYear = tomorrow.getDayOfYear();
            beijingTime = beijingTime.withDayOfYear(newDayOfYear);
            ZoneId chicagoZoneId = ZoneId.of("America/Chicago");
            ZonedDateTime chicagoZoneDateTime = ZonedDateTime.of(beijingTime, chicagoZoneId);
            long chicagoAndGMTDifference = chicagoZoneDateTime.getOffset().getTotalSeconds();
            LocalDateTime chicagoTime = beijingTime.plusSeconds(chicagoAndGMTDifference - beijingAndGMTDifference);

            // 格式化新会议时间
            String showBeijingTime = formatter.format(beijingTime);
            String showChicagoTime = formatter.format(chicagoTime);
            System.out.println("北京时间：" + showBeijingTime);
            System.out.println("芝加哥时间：" + showChicagoTime);
        } else {
            System.out.println("会议还没开始呢");
        }
    }
}
