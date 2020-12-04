package com.util;

/**
 * @author admin
 * @version 1.0
 * @desc 系统字符串工具类
 */
public final class SystemStringUtils {
    /**
     * 判断字符串是否为空，为空返回null，否则返回去除空格的字符串
     * @param string
     * @return
     */
    public static String strNotNullTrim(String string){
        String result = string == null ? null : string.trim();
        return result;
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        String string = " user";
        System.out.println(strNotNullTrim(string));
        string = null;
        System.out.println(strNotNullTrim(string));
    }
}
