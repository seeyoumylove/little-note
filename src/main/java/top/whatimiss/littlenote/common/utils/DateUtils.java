package top.whatimiss.littlenote.common.utils;

import java.time.*;
import java.util.Date;

/**
 * @author wcj
 * @create 2020/4/26  下午2:08
 * @description 日期的工具类
 */
public class DateUtils {

    public static void main(String[] args) {
        System.out.println(LocalDate.now().getDayOfWeek().getValue());
    }


    /**
     * 通过数字1，2，3，4，5，6，7获取本周几
     *
     * @param goalNumber 1
     * @return
     */
    public static LocalDate getDayOfWeek(int goalNumber) {
        switch (goalNumber) {
            case 1:
                return LocalDate.now().with(DayOfWeek.MONDAY);
            case 2:
                return LocalDate.now().with(DayOfWeek.TUESDAY);
            case 3:
                return LocalDate.now().with(DayOfWeek.WEDNESDAY);
            case 4:
                return LocalDate.now().with(DayOfWeek.THURSDAY);
            case 5:
                return LocalDate.now().with(DayOfWeek.FRIDAY);
            case 6:
                return LocalDate.now().with(DayOfWeek.SATURDAY);
            case 7:
                return LocalDate.now().with(DayOfWeek.SUNDAY);
            default:
                break;
        }
        return LocalDate.now();
    }

    /**
     * 将date转换成LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * 将date转换成LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * 将毫秒转换成x天x小时
     *
     * @param second
     * @return String
     */
    public static String secondToHour(long second) {
        long day = second / (1000 * 60 * 60 * 24);
        long hour = (second % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        if (day > 0) {
            return day + "天" + hour + "小时";
        } else {
            return hour + "小时";
        }
    }



}