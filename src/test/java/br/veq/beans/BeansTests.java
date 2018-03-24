package br.veq.beans;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.function.Consumer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansTests {

	private Optional<ClassPathXmlApplicationContext> context = Optional.empty();

	@Before
	public void before() {
		this.context = Optional.of(new ClassPathXmlApplicationContext("spring.xml"));
	}

	@After
	public void after() {
		context.ifPresent(c -> c.close());
	}

	@Test
	public void testContainer() {
		assertContextIsPresentThen(c -> {
			Processor processor = c.getBean("processor", Processor.class);
			assertNotNull(processor);
		});
	}

	private void assertContextIsPresentThen(Consumer<? super ClassPathXmlApplicationContext> consumer) {
		assertTrue(context.isPresent());
		context.ifPresent(consumer);
	}

}
