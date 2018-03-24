package br.veq.beans;

public class FileDatasource implements Datasource {

	private String file;

	public void getData() {
		throw new UnsupportedOperationException("well...");
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
