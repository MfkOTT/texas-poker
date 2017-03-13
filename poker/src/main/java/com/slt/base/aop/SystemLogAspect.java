package com.slt.base.aop;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.slt.base.exception.SysException;



/**
 * @Package: com.taikang.lottery.aop
 * @ClassName: SystemLogAspect
 * @Description: aop日志处理
 * @author lurui04
 * @date: 2016年8月16日
 * @version V1.0
 */
@Aspect
@Component
public class SystemLogAspect {
	private static final Logger log = LoggerFactory
			.getLogger(SystemLogAspect.class);

	// Service层切点
	@Pointcut("@annotation(com.slt.base.aop.SystemServiceLog)")
	public void serviceAspect() {
	}

	// Controller层切点
	@Pointcut("@annotation(com.slt.base.aop.SystemControllerLog)")
	public void controllerAspect() {
	}

	/**
	 * @Title: aroundController
	 * @Description: 针对controller的日志环绕处理方法
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	@Around(value = "controllerAspect()")
	public Object aroundController(ProceedingJoinPoint joinPoint) throws Exception{
		Object result = null;
		StringBuilder builder = new StringBuilder();
		try {
			builder.append("\n==Controller start==");
			builder.append("\n");
			builder.append("Starttime:【"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date()) + "】\n");
			builder.append("Description:【"
					+ getControllerMethodDescription(joinPoint) + "】\n");
			builder.append("Detail:【"
					+ (joinPoint.getTarget().getClass().getName() + "."
							+ joinPoint.getSignature().getName() + "()") + "】\n");
			String param = "";
			if (joinPoint == null || 0 == joinPoint.getArgs().length) {
				param = "null";
			} else {
				for (int i = 0; i < joinPoint.getArgs().length; i++) {
					if (i == joinPoint.getArgs().length - 1) {
						param = param + joinPoint.getArgs()[i];
					} else {
						param = param + joinPoint.getArgs()[i] + ";";
					}
				}
			}
			builder.append("ParamIn:【" + param + "】\n");
			result = joinPoint.proceed();
			builder.append("ParamOut:【" + result + "】\n");
			builder.append("Endtime:【"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date())+"】\n");
			builder.append("==Controller end==");
		} catch (Throwable e) {
			e.printStackTrace();
			throw new SysException(new Date(), e.getMessage());
		}finally{
			log.info(builder.toString());
		}
		return result;
	}

	/**
	 * @Title: aroundService
	 * @Description: 针对service的日志环绕处理方法
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	@Around(value = "serviceAspect()")
	public Object aroundService(ProceedingJoinPoint joinPoint) {
		Object result = null;
		StringBuilder builder = new StringBuilder();
		try {
			builder.append("\n==Service start==");
			builder.append("\n");
			builder.append("Starttime:【"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date()) + "】\n");
			builder.append("Description:【"
					+ getControllerMethodDescription(joinPoint) + "】\n");
			builder.append("Detail:【"
					+ (joinPoint.getTarget().getClass().getName() + "."
							+ joinPoint.getSignature().getName() + "()") + "】\n");
			String param = "";
			if (joinPoint == null || 0 == joinPoint.getArgs().length) {
				param = "null";
			} else {
				for (int i = 0; i < joinPoint.getArgs().length; i++) {
					if (i == joinPoint.getArgs().length - 1) {
						param = param + joinPoint.getArgs()[i];
					} else {
						param = param + joinPoint.getArgs()[i] + ";";
					}
				}
			}
			builder.append("ParamIn:【" + param + "】\n");
			result = joinPoint.proceed();
			builder.append("ParamOut:【" + result + "】\n");
			builder.append("Endtime:【"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date())+"】\n");
			builder.append("==Service end==");
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			log.info(builder.toString());
		}
		return result;
	}
	
	
	
	

	/**
	 * @Title: getServiceMthodDescription
	 * @Description: 获取注解中对方法的描述信息 用于service层注解
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	public static String getServiceMthodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class<?> targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				@SuppressWarnings("rawtypes")
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SystemServiceLog.class)
							.description();
					break;
				}
			}
		}
		return description;
	}

	/**
	 * @Title: getControllerMethodDescription
	 * @Description: 获取注解中对方法的描述信息 用于Controller层注解
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	public static String getControllerMethodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class<?> targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				@SuppressWarnings("rawtypes")
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(
							SystemControllerLog.class).description();
					break;
				}
			}
		}
		return description;
	}

	/**
	 * @Title: getHostName
	 * @Description: 获取服务器主机名
	 * @return
	 */
	public static String getHostName() {
		try {
			return (InetAddress.getLocalHost()).getHostName();
		} catch (UnknownHostException uhe) {
			String host = uhe.getMessage(); // host = "hostname: hostname"
			if (host != null) {
				int colon = host.indexOf(':');
				if (colon > 0) {
					return host.substring(0, colon);
				}
			}
			return "UnknownHost";
		}
	}
}