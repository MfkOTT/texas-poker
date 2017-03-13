package com.slt.base.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 * @Package: com.taikang.lottery.aop
 * @ClassName: SystemControllerLog
 * @Description:自定义controller注解标签 
 * @author lurui04
 * @date: 2016年7月26日
 * @version V1.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public  @interface SystemControllerLog {        
    
	String description()  default "";   
	
}    