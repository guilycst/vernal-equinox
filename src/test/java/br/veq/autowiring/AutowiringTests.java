package br.veq.autowiring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.veq.autowiring.beans.Processor;

public class AutowiringTests extends AutowiringContainerConfigTests {

	@Test
	public void testBasicAutowiring() {
		Processor processor = context.getBean(Processor.class);
		assertNotNull(processor.getProductDAO());
		assertNotNull(processor.getSaleDAO());
		assertNotNull(processor.getUserDAO());
		assertNotNull(processor.getProductDAO().getDatasource());
		assertNotNull(processor.getSaleDAO().getDatasource());
		assertNotNull(processor.getUserDAO().getDatasource());
		assertEquals("jdbc:mysql://localhost/db", processor.getUserDAO().getDatasource().getConnectionString());
	}

}
