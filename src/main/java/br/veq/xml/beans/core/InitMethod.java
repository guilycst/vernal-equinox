package br.veq.xml.beans.core;

import java.util.concurrent.atomic.AtomicBoolean;

public class InitMethod {

	private final static AtomicBoolean initMethodRun = new AtomicBoolean(false);

	public static boolean hasInitMethodRun() {
		return initMethodRun.get();
	}

	public void init() {
		initMethodRun.set(true);
	}
}
