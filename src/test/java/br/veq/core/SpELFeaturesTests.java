package br.veq.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.veq.xml.beans.spel.SpELBasicSintax;
import br.veq.xml.beans.spel.SpELLogicalOperators;
import br.veq.xml.beans.spel.SpELMathOperators;
import br.veq.xml.beans.spel.SpELReferences;

public class SpELFeaturesTests extends StaticXMLContainerTestsConfig {

	@Test
	public void testBasicSintax() {
		SpELBasicSintax bean = context.getBean(SpELBasicSintax.class);
		assertEquals(5, bean.getIntNumber());
		assertEquals(5.5, bean.getFloatNumber(), Double.NaN);
		assertEquals("Hello", bean.getaString());
		assertTrue(bean.isaBoolean());
	}

	@Test
	public void testMathOperators() {
		SpELMathOperators bean = context.getBean(SpELMathOperators.class);
		assertEquals(10, bean.getSum());
		assertEquals(1, bean.getSubs());
		assertEquals(25, bean.getMult());
		assertEquals(1, bean.getDiv());
		assertEquals(1, bean.getMod());
		assertEquals(9, bean.getPow());
	}

	@Test
	public void testLogicalOperators() {
		SpELLogicalOperators bean = context.getBean(SpELLogicalOperators.class);
		assertTrue(bean.isGreaterThan());
		assertTrue(bean.isEquality());
		assertTrue(bean.isLesserThan());
		assertTrue(bean.isNot());
		assertTrue(bean.isNotEqual());
		assertTrue(bean.isGreaterOrEqThan());
		assertTrue(bean.isLesserOrEqThan());
		assertEquals("one is equals to one", bean.getTernary());
	}

	@Test
	public void testReferences() {
		System.setProperty("xpto.foo", "Hola");
		SpELReferences bean = context.getBean(SpELReferences.class);
		assertNotNull(bean.getLogicalOperatorsRef());
		assertEquals(10, bean.getReferencedValue());
		assertEquals(10, bean.getReferencedMethodCallValue());
		assertEquals("Hola", bean.getSysProp());
	}

}
