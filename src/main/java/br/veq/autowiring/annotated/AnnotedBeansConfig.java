package br.veq.autowiring.annotated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.veq.autowiring.annotated.beans.Datasource;
import br.veq.autowiring.annotated.beans.ProductDAO;
import br.veq.autowiring.annotated.beans.ProductDatasource;
import br.veq.autowiring.annotated.beans.UserDAO;

@Configuration // Just another stereotype for component
public class AnnotedBeansConfig {

	@Bean // same as a <bean/> tag on the XML config
	public UserDAO userDAO() {
		return new UserDAO();
	}

	@Bean(name = { "productDAOAlias1", "productDAOAlias2" })
	public ProductDAO productDAO() {
		return new ProductDAO();
	}

	@Bean
	public Datasource datasource() {
		return new Datasource();
	}
	

	@Bean(name = "productDatasource")
	public Datasource productDatasource() {
		return new ProductDatasource();
	}

}
