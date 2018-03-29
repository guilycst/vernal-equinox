package br.veq.annotated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.veq.autowiring.annotated.beans.Datasource;
import br.veq.autowiring.annotated.beans.ProductDAO;
import br.veq.autowiring.annotated.beans.ProductDatasource;
import br.veq.autowiring.annotated.beans.UserDAO;
import br.veq.autowiring.annotated.morebeans.AnotherBean;

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

	@Test
	@Ignore(value = "context.refresh() will throw \"GenericApplicationContext does not support multiple refresh attempts: just call 'refresh' once\"")
	public void testContextRegister() {
		AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) this.context;
		boolean thrown = false;
		try {
			context.getBean(AnotherBean.class);
		} catch (NoSuchBeanDefinitionException e) {
			e.printStackTrace();
			thrown = true;
		}
		assertTrue("Expected NoSuchBeanDefinitionException to be thrown", thrown);
		context.register(AnotherBean.class);
		context.refresh(); /*
							 * By design, programmatic refreshing of an ApplicationContext is not explicitly
							 * supported by the Spring TestContext Framework :(
							 */
		assertNotNull(context.getBean(AnotherBean.class));
	}

}
