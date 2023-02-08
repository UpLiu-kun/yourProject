package com.example.yourproject.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@描述  深圳索信达数据技术有限公司
 *@功能  日期工具类
 *@创建人 LiuKun
 *@创建时间 2022-4-1
 */
public class DateUtil {

    /** yyyy-MM-dd */
    public static String YYYYMMDD = "yyyy-MM-dd";
    /** yyyyMMdd */
    public static String yyyyMMdd = "yyyyMMdd";
    /** yyyyMMddHHmmss */
    public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    /** yyyy-MM-dd HH:mm:ss **/
    public static String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static String DDMMMYYYY = "ddMMMyyyy";
    public static String yyyyMMddHHmm = "yyyy-MM-dd HH:mm";

    /**
     * 格式化输出日期
     *
     * @param date
     *            日期
     * @param format
     *            格式
     * @return 返回字符型日期
     */
    public static String format(Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                java.text.DateFormat df = new SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
        }
        return result;
    }

}
