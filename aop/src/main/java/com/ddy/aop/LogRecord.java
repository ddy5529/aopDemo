package com.ddy.aop;

public @interface LogRecord {
    String values() default "";

    String descript() default "自定义管理员注解";
}
