package com.slt.base.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Package: com.taikang.lottery.aop
 * @ClassName: SystemServiceLog
 * @Description:自定义service注解标签  
 * @author lurui04
 * @date: 2016年7月26日
 * @version V2.3
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public  @interface SystemServiceLog {    
    
    String description()  default "";    
    
    
}    