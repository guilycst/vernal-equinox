package br.veq.aop.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Profiler extends CallRec implements MethodInterceptor {

	private List<Long> times = new ArrayList<>();
	private static Map<String, String> calls = new HashMap<>();

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long beforeCall = System.currentTimeMillis();
		Object result = invocation.proceed();
		long time = System.currentTimeMillis() - beforeCall;

		Class<? extends Profiler> clazz = this.getClass();
		Object[] arguments = invocation.getArguments();
		String methodSignature = getMethodSignature(invocation.getMethod(), invocation.getArguments(),
				invocation.getThis());
		System.out.printf("%s took: %s ms\n", methodSignature, time);
		rec(clazz, arguments[0], String.format("Call to %s intercepted by %s", methodSignature, clazz.getSimpleName()));

		getTimes().add(time);
		return result;
	}

	public String get(String id) {
		return calls.get(id);
	}

	public List<Long> getTimes() {
		return times;
	}

}
