package com.dutu.admin.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author dutu
 * @date 2021-03-28 12:07
 */
public class MyTimeUtil {

    public static String getTime(){
        Date date = new Date();
        //获取当前的日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置日期格式
        String str = df.format(date);
        //获取String类型的时间
        return str;
    }

    public static   String[] getTimeDate(String str){
        String[] split = str.split("-");
        String[] split1 = split[2].split(" ");
        split[2] = split1[0];
        return split;
    }


    public static void main(String[] args) {
        System.out.println(getTime().substring(0, 4));
        System.out.println(getTime().substring(5, 7));
        System.out.println(getTime().substring(8, 10));
    }
}
