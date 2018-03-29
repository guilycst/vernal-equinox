package br.veq;

import org.junit.AfterClass;
import org.springframework.context.support.AbstractApplicationContext;

public abstract class TestsConfig {

	protected AbstractApplicationContext context;

	public TestsConfig(String... configLocations) {
		context = AppContextFactory.getXMLAppContext(configLocations);
	}

	public TestsConfig(Class<?>... configLocations) {
		context = AppContextFactory.getAnnotationAppContext(configLocations);
	}

	@AfterClass
	public static void after() {
		AppContextFactory.closeAll();
	}

}
