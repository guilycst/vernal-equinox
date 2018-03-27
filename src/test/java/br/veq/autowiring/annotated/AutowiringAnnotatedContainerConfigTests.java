package br.veq.autowiring.annotated;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AutowiringAnnotatedContainerConfigTests {

	protected static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext("autowire-annotated.xml");
	}

	@AfterClass
	public static void after() {
		if (context != null)
			context.close();
	}

}
