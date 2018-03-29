package br.veq.aspects.spring;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Profiler implements MethodInterceptor {

	private List<Long> times = new ArrayList<>();

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long beforeCall = System.currentTimeMillis();
		Object result = invocation.proceed();
		long time = System.currentTimeMillis() - beforeCall;
		System.out.println(String.format("'%s' took: %s ms", invocation, time));
		getTimes().add(time);
		return result;
	}

	public List<Long> getTimes() {
		return times;
	}

}
