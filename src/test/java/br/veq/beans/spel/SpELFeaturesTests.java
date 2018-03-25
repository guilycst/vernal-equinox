package br.veq.beans.spel;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import br.veq.beans.SpringTests;

public class SpELFeaturesTests extends SpringTests {

	@Test
	public void testBasicSintax() {
		SpELBasicSintax bean = context.getBean(SpELBasicSintax.class);
		assertEquals(5, bean.getIntNumber());
		assertEquals(5.5, bean.getFloatNumber());
		assertEquals("Hello", bean.getaString());
		assertTrue(bean.isaBoolean());
	}

}
