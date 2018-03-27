package br.veq.autowiring.annotated.beans;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("processor")
public class Processor {

	@Resource
	private ProductDAO productDAO;
	@Autowired
	private SaleDAO saleDAO;
	@Inject
	private UserDAO userDAO;

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public SaleDAO getSaleDAO() {
		return saleDAO;
	}

	public void setSaleDAO(SaleDAO saleDAO) {
		this.saleDAO = saleDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
