package br.veq.autowiring.beans;

public abstract class DAO {

	private Datasource datasource;

	public Datasource getDatasource() {
		return datasource;
	}

	public void setDatasource(Datasource datasource) {
		this.datasource = datasource;
	}

}
