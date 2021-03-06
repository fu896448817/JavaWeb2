package com.javaweb.config.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

	//切入点execution
	//@Pointcut("execution(* com.javaweb.web..*(..))")  
	//public void methodCall() {}
	
	//@Before(value="methodCall()")
	//@Before(value="execution(* com.javaweb.web..*(..))")
	@Before(value="execution(* com.javaweb.web.dao..*.*(..))")
	//这里写具体的数据源切换逻辑
	public void beforeMethod(JoinPoint joinPoint) throws Throwable {
		String packagePathDao = joinPoint.getStaticPart().getSignature().getDeclaringTypeName();
		if(packagePathDao.contains("ds1")){//数据源1的位置
			MultipleDataSourceManage.setDataSourceKey("mysql_d1");
		}else if(packagePathDao.contains("ds2")){//数据源2的位置
			MultipleDataSourceManage.setDataSourceKey("mysql_d2");
		}else{//默认数据源
			MultipleDataSourceManage.setDataSourceKey("mysql_d1");
		}
	}

}
