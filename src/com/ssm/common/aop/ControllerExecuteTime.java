package com.ssm.common.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author liguoping
 * @since 2016/1/21
 */
@Component
@Aspect
public class ControllerExecuteTime {
	private static final Logger logger = LoggerFactory
			.getLogger(ControllerExecuteTime.class);

	@Pointcut("execution(* com.itonghui.web..controller..*(..))")
	public void aspect() {
	}

	/**
	 * 用于检测service方法执行时间
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("aspect()")
	static Object around(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = new Date().getTime();
		Signature signature = pjp.getSignature();
		try {
			Object result = pjp.proceed();
			long endTime = new Date().getTime();
			long times = (endTime - startTime);
			long time = times / 1000;
			if (times >= 900) {
				logger.warn(
						"controller响应时间:{}",
						signature.getDeclaringTypeName() + "#"
								+ signature.getName() + " 运行时间为: " + times
								+ "毫秒  " + time + "s");
				/*
				 * logger.error("执行时间的模块:{} Service:{} 运行时间为:{} ", "controller",
				 * signature.getDeclaringTypeName() + "." + signature.getName(),
				 * + times + "毫秒  " + time + "秒");
				 */
			} else {
				// logger.info(signature.getDeclaringTypeName() + "#" +
				// signature.getName() + " 运行时间为: " + time + "s");
			}
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
}
