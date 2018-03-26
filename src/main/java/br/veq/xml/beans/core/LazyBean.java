package br.veq.xml.beans.core;

import java.util.concurrent.atomic.AtomicBoolean;

public class LazyBean {

	private final static AtomicBoolean beenInit = new AtomicBoolean(false);

	public LazyBean() {
		beenInit.set(true);
	}

	public static boolean hasBeenInit() {
		return beenInit.get();
	}
}
