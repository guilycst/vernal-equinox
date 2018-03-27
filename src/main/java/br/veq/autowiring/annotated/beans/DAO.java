package br.veq.autowiring.annotated.beans;

public abstract class DAO {

	private Datasource datasource;

	public Datasource getDatasource() {
		return datasource;
	}

	public void setDatasource(Datasource datasource) {
		this.datasource = datasource;
	}

}
