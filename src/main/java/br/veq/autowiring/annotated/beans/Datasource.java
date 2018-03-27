package br.veq.autowiring.annotated.beans;

import org.springframework.stereotype.Component;

@Component
public class Datasource {

	private String connectionString;

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

}
