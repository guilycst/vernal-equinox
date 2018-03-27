package br.veq.autowiring.xml;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AutowiringXMLContainerConfigTests {

	protected static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext("autowire-xml.xml");
	}

	@AfterClass
	public static void after() {
		if (context != null)
			context.close();
	}

}
