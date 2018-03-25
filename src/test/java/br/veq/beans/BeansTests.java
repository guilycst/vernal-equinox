package br.veq.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansTests {

	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}

	@AfterClass
	public static void after() {
		if (context != null)
			context.close();
	}

	@Test
	public void testFetchProcessorBeanByName() {
		Processor processor = (Processor) context.getBean("processor");
		assertNotNull(processor);
	}

	@Test
	public void testFetchProcessorTypedBeanByName() {
		Processor processor = context.getBean("processor", Processor.class);
		assertNotNull(processor);
	}

	@Test
	public void testFetchProcessorBeanByClass() {
		Processor processor = context.getBean(Processor.class);
		assertNotNull(processor);
	}

	@Test
	public void testFetchBeansOfProcessorTyppe() {
		Map<String, Processor> beansOfType = context.getBeansOfType(Processor.class);
		assertNotNull(beansOfType);
		assertEquals(1, beansOfType.size());
	}

	@Test
	public void testSingletonScope() {
		// Singleton is the default scope, btw
		Datasource ds1 = (Datasource) context.getBean("datasource");
		Datasource ds2 = context.getBean(Datasource.class);
		assertSame(ds1, ds2);
	}

	@Test
	public void testPrototypeScope() {
		Processor processor1 = (Processor) context.getBean("processor");
		Processor processor2 = context.getBean(Processor.class);
		assertNotSame(processor1, processor2);
	}

	@Test(expected = BeansException.class)
	public void testFetchUnavaibleBean() {
		context.getBean("non-existe");
	}

	@Test
	public void testLazyInitBean() throws InterruptedException {
		// Singleton lazy-init bean test
		assertTrue(FileDatasource.hasBeenInit());
		assertFalse(LazyBean.hasBeenInit());

		LazyBean bean1 = context.getBean(LazyBean.class);
		assertTrue(LazyBean.hasBeenInit());

		LazyBean bean2 = context.getBean(LazyBean.class);
		assertSame(bean1, bean2);
	}

	@Test
	public void testInitMethod() {
		assertFalse(InitMethod.hasInitMethodRun());
		context.getBean(InitMethod.class);
		assertTrue(InitMethod.hasInitMethodRun());
	}

}
