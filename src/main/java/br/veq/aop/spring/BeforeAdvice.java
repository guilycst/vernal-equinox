package br.veq.aop.spring;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice extends CallRec implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String methodSignature = getMethodSignature(method, args, target);
		Class<? extends BeforeAdvice> clazz = this.getClass();

		String log = String.format("%s ran before %s", clazz.getSimpleName(), methodSignature);
		rec(args[0], log);
	}

}
