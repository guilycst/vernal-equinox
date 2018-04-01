package br.veq.xml.beans.spel;

public class SpELReferences {

	private SpELLogicalOperators logicalOperatorsRef;
	private int referencedValue;
	private int referencedMethodCallValue;
	private String sysProp;

	public SpELLogicalOperators getLogicalOperatorsRef() {
		return logicalOperatorsRef;
	}

	public void setLogicalOperatorsRef(SpELLogicalOperators logicalOperatorsRef) {
		this.logicalOperatorsRef = logicalOperatorsRef;
	}

	public int getReferencedValue() {
		return referencedValue;
	}

	public void setReferencedValue(int referencedValue) {
		this.referencedValue = referencedValue;
	}

	public int getReferencedMethodCallValue() {
		return referencedMethodCallValue;
	}

	public void setReferencedMethodCallValue(int referencedMethodCallValue) {
		this.referencedMethodCallValue = referencedMethodCallValue;
	}

	public String getSysProp() {
		return sysProp;
	}

	public void setSysProp(String sysProp) {
		this.sysProp = sysProp;
	}

}
