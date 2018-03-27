package br.veq.autowiring.xml.beans;

public class Processor {

	private ProductDAO productDAO;
	private SaleDAO saleDAO;
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
