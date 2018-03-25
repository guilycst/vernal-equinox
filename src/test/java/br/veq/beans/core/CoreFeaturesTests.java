package br.veq.beans.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.BeansException;

import br.veq.beans.SpringTests;

public class CoreFeaturesTests extends SpringTests {

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
		Processor processor = context.getBean(ChildProcessor.class);
		assertNotNull(processor);
	}

	@Test
	public void testFetchBeansOfProcessorTyppe() {
		Map<String, Processor> beansOfType = context.getBeansOfType(Processor.class);
		assertNotNull(beansOfType);
		assertEquals(2, beansOfType.size());
	}

	@Test
	public void testSingletonScope() {
		// Singleton is the default scope, btw
		FileDatasource ds1 = (FileDatasource) context.getBean("datasource");
		FileDatasource ds2 = context.getBean(FileDatasource.class);
		assertSame(ds1, ds2);
	}

	@Test
	public void testPrototypeScope() {
		Processor processor1 = (Processor) context.getBean("processor");
		Processor processor2 = context.getBean("processor", Processor.class);
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

	@Test
	public void testBeanInheritance() {
		ChildProcessor processor = context.getBean(ChildProcessor.class);
		Datasource datasource = processor.getDatasource();
		assertNotNull(processor.getDatasource());
		assertEquals(datasource.getClass(), RandomDatasource.class);
	}

}
