package br.veq.aop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import br.veq.aop.spring.BeforeAdvice;
import br.veq.aop.spring.CallRec;
import br.veq.aop.spring.Profiler;

public class AOPTests extends AOPTestsConfig {

	@Test
	public void testProxyObject() {
		LengthyOperation bean = context.getBean("lenghthyOperation", LengthyOperation.class);
		assertNotEquals(LengthyOperation.class, bean.getClass());
		bean.doIt("testProxyObject", 200);
		assertEquals("BeforeAdvice ran before LengthyOperation.doIt(String, Long)",
				CallRec.get(BeforeAdvice.class, "testProxyObject"));
		assertEquals("Call to LengthyOperation.doIt(String, Long) intercepted by Profiler",
				CallRec.get(Profiler.class, "testProxyObject"));
	}

}
