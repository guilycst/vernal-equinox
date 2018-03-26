package br.veq.xml.beans.spel;

public class SpELLogicalOperators {
	private boolean greaterThan;
	private boolean equality;
	private boolean lesserThan;
	private boolean not;
	private boolean notEqual;
	private boolean greaterOrEqThan;
	private boolean lesserOrEqThan;
	private String ternary;

	public boolean isGreaterThan() {
		return greaterThan;
	}

	public void setGreaterThan(boolean greaterThan) {
		this.greaterThan = greaterThan;
	}

	public boolean isEquality() {
		return equality;
	}

	public void setEquality(boolean equality) {
		this.equality = equality;
	}

	public boolean isLesserThan() {
		return lesserThan;
	}

	public void setLesserThan(boolean lesserThan) {
		this.lesserThan = lesserThan;
	}

	public boolean isNot() {
		return not;
	}

	public void setNot(boolean not) {
		this.not = not;
	}

	public boolean isNotEqual() {
		return notEqual;
	}

	public void setNotEqual(boolean notEqual) {
		this.notEqual = notEqual;
	}

	public boolean isGreaterOrEqThan() {
		return greaterOrEqThan;
	}

	public void setGreaterOrEqThan(boolean greaterOrEqThan) {
		this.greaterOrEqThan = greaterOrEqThan;
	}

	public boolean isLesserOrEqThan() {
		return lesserOrEqThan;
	}

	public void setLesserOrEqThan(boolean lesserOrEqThan) {
		this.lesserOrEqThan = lesserOrEqThan;
	}

	public String getTernary() {
		return ternary;
	}

	public void setTernary(String ternary) {
		this.ternary = ternary;
	}

}
