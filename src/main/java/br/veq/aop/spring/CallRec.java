package br.veq.aop.spring;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CallRec {

	private static Map<String, String> calls = new HashMap<>();

	protected String getMethodSignature(Method method, Object[] args, Object target) {
		return Arrays.stream(args).map(m -> m.getClass().getSimpleName())
				.reduce((a, b) -> b == null ? a : (a == null || a.isEmpty() ? b : a.concat(", ").concat(b)))//
				.map(m -> m == null || m.isEmpty() ? "()" : "(".concat(m).concat(")"))//
				.map(m -> new Object[] { target.getClass().getSimpleName(), method.getName(), m })//
				.map(m -> String.format("%s.%s%s", m))//
				.get();
	}

	protected void rec(Class<?> clazz, Object uid, String msg) {
		calls.put(clazz.getSimpleName().concat(".").concat(uid.toString()), msg);
		System.out.println(msg);
	}

	public static String get(Class<?> clazz, String uid) {
		return calls.get(clazz.getSimpleName().concat(".").concat(uid));
	}

}