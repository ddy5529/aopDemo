package com.ddy.aop;

import org.slf4j.Logger;

/**
 * 为了解决打日志麻烦的问题，建立了该类
 * @author :yexingyuan
 * @date 2019年7月16日
 * */
public class LogUtils {

    private static String environmentValue= environment.DEV.getCode();

    public enum environment{
        DEV("dev","1"),TEST("test","2"),UAT("uat","3"),PRO("pro","4");
        private String code;
        private String name;

        environment(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    /**
     * 开发环境时的打印日志
     * @param logger
     * @param message
     * */
    public static void printDebugLog(Logger logger, String message) {
        if (environmentValue.equals(environment.DEV.getCode())){
            logger.info("项目名：impl ,类名:{} ,方法名:{} ,描述:{} ", getMethedClassName(3), getLevelMethedName(3),message);
        }
    }
    /**
     *打印日志
     * @param logger
     * @param message
     * */
    public static void printLog(Logger logger, String message){
        logger.info("项目名：impl ,类名:{} ,方法名:{} ,描述:{} ", getMethedClassName(3), getLevelMethedName(3),message);
    }

    /**
     *打印异常等级为ERROR的日志
     * @param logger
     * @param message
     * */
    public static void printErrorLog(Logger logger, String message){
        logger.error("项目名：impl ,类名:{} ,方法名:{} ,描述:{} ", getMethedClassName(3), getLevelMethedName(3),message);
    }

    /**
     * 获取当前线程对应的类名
     * */
    public static String getMethedClassName(int level){
        StackTraceElement[] temp=Thread.currentThread().getStackTrace();
        StackTraceElement a=temp[level];
        String fileName=a.getFileName();
        return fileName.substring(0,fileName.indexOf(".java"));
    }

    /**
     * 获取当前线程对应的方法
     * */
    public static String getLevelMethedName(int level){
        StackTraceElement[] temp=Thread.currentThread().getStackTrace();
        StackTraceElement a=temp[level];
        return a.getMethodName();
    }

}

