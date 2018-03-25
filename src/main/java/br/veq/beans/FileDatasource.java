package br.veq.beans;

import java.util.concurrent.atomic.AtomicBoolean;

public class FileDatasource implements Datasource {

	private final static AtomicBoolean beenInit = new AtomicBoolean(false);

	private String file;

	public FileDatasource() {
		beenInit.set(true);
	}

	public void getData() {
		throw new UnsupportedOperationException("well...");
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public static boolean hasBeenInit() {
		return beenInit.get();
	}

}
