package br.veq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.support.AbstractApplicationContext;

public abstract class TestsConfig {

	protected static AbstractApplicationContext context;

	public TestsConfig(String... configLocations) {
		context = AppContextFactory.getAppContext(configLocations);
	}

	@BeforeClass
	public static void before() {

	}

	@AfterClass
	public static void after() {
		AppContextFactory.closeAll();
	}

}
