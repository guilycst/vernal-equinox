package br.veq.annotated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import br.veq.autowiring.annotated.beans.Datasource;
import br.veq.autowiring.annotated.beans.ProductDAO;
import br.veq.autowiring.annotated.beans.ProductDatasource;
import br.veq.autowiring.annotated.beans.UserDAO;

public class NoXMLAnnotatedTests extends NoXMLAnnotatedContainerConfigTests {

	@Test
	public void testFetchUserDAO() {
		UserDAO userDao = context.getBean(UserDAO.class);
		assertNotNull(userDao);
		assertNotNull(userDao.getDatasource());
	}

	@Test
	public void testFetchProductDAOUserDAO() {
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAOAlias1");
		assertSame(productDAO, context.getBean("productDAOAlias2"));
		assertNotNull(productDAO);
		Datasource datasource = productDAO.getDatasource();
		assertNotNull(productDAO.getDatasource());
		assertEquals(ProductDatasource.class, datasource.getClass());
	}

}
