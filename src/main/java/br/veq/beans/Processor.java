package br.veq.beans;

public class Processor {

	private Datasource datasource;
	private Printer printer;

	public Processor(Datasource datasource, Printer printer) {
		this.datasource = datasource;
		this.printer = printer;
	}

	public Datasource getDatasource() {
		return datasource;
	}

	public void setDatasource(Datasource datasource) {
		this.datasource = datasource;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
		
}
