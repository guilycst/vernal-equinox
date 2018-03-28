package br.veq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContextFactory {

	private static List<AbstractApplicationContext> contexts = new ArrayList<>();

	public static AbstractApplicationContext getAppContext(String... configLocations) {
		AbstractApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(configLocations);
		contexts.add(classPathXmlApplicationContext);
		return classPathXmlApplicationContext;
	}

	public static void closeAll() {
		contexts.forEach(AbstractApplicationContext::close);
		contexts.clear();
	}

}
