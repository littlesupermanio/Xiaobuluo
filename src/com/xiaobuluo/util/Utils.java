package com.xiaobuluo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Utils {
    public static String diffTimeFromNow(Date d1)
    {
        Date currDate = new Date(System.currentTimeMillis());
        long diff = currDate.getTime() - d1.getTime(); // 得到的差值是微秒级别，可以忽略
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60) - minutes * (1000 * 60)) / (1000);
        String interval = "";
        if(days!=0)
        {
            interval += days + "天";
        }
        if(hours!=0)
        {
            interval += hours + "小时";
        }
        if(minutes!=0)
        {
            interval += minutes + "分";
        }
        if(seconds!=0)
        {
            interval += seconds + "秒";
        }
        return interval;
    }


    public static String toMD5(String data) {
        if (data == null)
            return null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 加密转换
            md.update(data.getBytes());
            String result = new BigInteger(1, md.digest()).toString(16);

            return result;

        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
