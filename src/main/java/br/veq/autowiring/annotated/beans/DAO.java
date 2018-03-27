package br.veq.autowiring.annotated.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public abstract class DAO {

	private Datasource datasource;

	public Datasource getDatasource() {
		return datasource;
	}

	@Required @Autowired
	public void setDatasource(Datasource datasource) {
		this.datasource = datasource;
	}

}
