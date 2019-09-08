package com.ddy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;


/*声明为组件，让spring 自动管理*/
@Component
/*声明该类为切面bean*/
@Aspect
public class RequestInterceptor {
    private final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    /* 拦截管理员访问的请求,(定义切点，该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点)*/
    @Pointcut("@annotation(com.ddy.aop.LogRecord)")
    public void recordLog() {
        LogUtils.printDebugLog(logger, "日志记录");
    }

    /*定义前置advice,同时接受JoinPoint切入点对象,可以没有该参数
      在环绕通知里面proceedingJoinPoint参数是必须的，其他情况JoinPoint 并不是必须的
    */
    @Before("recordLog()")
    public void recordLogBefore(JoinPoint point) {
        List<Object> list = new ArrayList<>();
        for (Object arg : point.getArgs()) {
            list.add(arg);
        }
        point.getSourceLocation().getWithinType().getName();//获取切点对应的类名
        point.getSourceLocation().getWithinType().getCanonicalName();
        Annotation[] annotations = point.getSourceLocation().getWithinType().getAnnotations();//获取切点的所有的注解
        point.getSourceLocation().getLine();
        LogUtils.printDebugLog(logger, "日志记录Before");
    }

    @After("recordLog()")
    public void recordLogAfter(JoinPoint point) {
        LogUtils.printDebugLog(logger, "日志记录After");
    }

}
