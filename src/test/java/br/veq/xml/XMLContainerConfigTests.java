package br.veq.xml;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class XMLContainerConfigTests {

	protected static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext("core.xml", "spel.xml");
	}

	@AfterClass
	public static void after() {
		if (context != null)
			context.close();
	}
	
}
