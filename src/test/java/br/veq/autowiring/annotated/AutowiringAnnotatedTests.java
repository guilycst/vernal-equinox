package br.veq.autowiring.annotated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.veq.autowiring.annotated.beans.Datasource;
import br.veq.autowiring.annotated.beans.Processor;
import br.veq.autowiring.annotated.beans.ProductDAO;
import br.veq.autowiring.annotated.beans.ProductDatasource;
import br.veq.autowiring.annotated.beans.SaleDAO;
import br.veq.autowiring.annotated.beans.SaleDatasource;

public class AutowiringAnnotatedTests extends AutowiringAnnotatedContainerConfigTests {

	@Test
	public void testBasicAutowiring() {
		Processor processor = context.getBean(Processor.class);
		assertNotNull(processor.getProductDAO());
		assertNotNull(processor.getSaleDAO());
		assertNotNull(processor.getUserDAO());
		assertNotNull(processor.getProductDAO().getDatasource());
		assertNotNull(processor.getSaleDAO().getDatasource());
		assertNotNull(processor.getUserDAO().getDatasource());
		// assertEquals("jdbc:mysql://localhost/db",
		// processor.getUserDAO().getDatasource().getConnectionString());
	}

	@Test
	public void testQualifier() {
		SaleDAO saleDao = context.getBean(SaleDAO.class);
		Datasource datasource = saleDao.getDatasource();
		assertNotNull(datasource);
		assertEquals(SaleDatasource.class, datasource.getClass());
	}

	@Test
	public void testCustomQualifierAnnotation() {
		ProductDAO productDAO = context.getBean(ProductDAO.class);
		Datasource datasource = productDAO.getDatasource();
		assertNotNull(datasource);
		assertEquals(ProductDatasource.class, datasource.getClass());
	}

	@Test
	public void testBeanLifeCicle() {
		try (ClassPathXmlApplicationContext lcContext = new ClassPathXmlApplicationContext("autowire-annotated.xml")) {
			ProductDAO productDAO = lcContext.getBean(ProductDAO.class);
			assertTrue(productDAO.hasBeenPostConstruct());
			assertFalse(ProductDAO.hasBeenPreDestroy());
		} // closeable
		assertTrue(ProductDAO.hasBeenPreDestroy());
	}

}
