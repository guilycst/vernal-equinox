package br.veq.aop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import br.veq.aop.spring.BeforeAdvice;
import br.veq.aop.spring.Profiler;

public class AOPTests extends AOPTestsConfig {

	@Test
	public void testProxyObject() {
		LengthyOperation bean = context.getBean("lenghthyOperation", LengthyOperation.class);
		assertNotEquals(LengthyOperation.class, bean.getClass());

		bean.doIt("testProxyObject", 200);

		BeforeAdvice beforeAdvice = context.getBean(BeforeAdvice.class);
		assertEquals("BeforeAdvice ran before LengthyOperation.doIt(String, Long)",
				beforeAdvice.get(BeforeAdvice.class, "testProxyObject"));

		Profiler profiler = context.getBean(Profiler.class);
		assertEquals("Call to LengthyOperation.doIt(String, Long) intercepted by Profiler",
				profiler.get(Profiler.class, "testProxyObject"));

	}

}
