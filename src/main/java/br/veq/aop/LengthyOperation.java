package br.veq.aop;

public class LengthyOperation {

	public void doIt(String uniqueId, long timeMillis) {
		try {
			Thread.sleep(timeMillis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
