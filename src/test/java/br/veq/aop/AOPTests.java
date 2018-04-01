package br.veq.aop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import br.veq.aop.spring.AfterThrowsAdvice;
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
				beforeAdvice.get("testProxyObject"));

		Profiler profiler = context.getBean(Profiler.class);
		assertEquals("Call to LengthyOperation.doIt(String, Long) intercepted by Profiler",
				profiler.get("testProxyObject"));

	}

	@Test
	public void testAfterThrows() {
		ThrowExceptionOperation bean = context.getBean("afterThrowsOperation", ThrowExceptionOperation.class);
		assertNotEquals(ThrowExceptionOperation.class, bean.getClass());
		try {
			bean.doIt();
		} catch (Exception e) {
		}
		AfterThrowsAdvice afterThrowsAdvice = context.getBean(AfterThrowsAdvice.class);
		assertEquals("meh", afterThrowsAdvice.get(AfterThrowsAdvice.class.getSimpleName()));
	}

}
