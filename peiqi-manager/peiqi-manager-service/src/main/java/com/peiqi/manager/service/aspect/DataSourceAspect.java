package com.peiqi.manager.service.aspect;

import org.aspectj.lang.JoinPoint;

public class DataSourceAspect {
	
	private static String[] methods = new String[] {"query","find","get","search"};
	/**
	 * 在进入Service方法之前执行
	 * 
	 * @param point
	 *            切面对象
	 */
	public void before(JoinPoint point) {
		// 获取到当前执行的方法名
		String methodName = point.getSignature().getName();
		if (isSlave(methodName)) {
			// 标记为读库
			DynamicDataSourceHolder.markSlave();
		} else {
			// 标记为写库
			DynamicDataSourceHolder.markMaster();
		}
	}

	/**
	 * 判断是否为读库
	 * 
	 * @param methodName
	 * @return
	 */
	private Boolean isSlave(String methodName) {
		// 方法名以query、find、get开头的方法名走从库
		
		for(String method : methods) {
			
			if(methodName.contains(method)) {
				return true;
			}
		}
		
		return false;
	}
}
