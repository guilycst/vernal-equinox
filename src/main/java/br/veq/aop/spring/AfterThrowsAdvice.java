package br.veq.aop.spring;

import org.springframework.aop.ThrowsAdvice;

public class AfterThrowsAdvice extends CallRec implements ThrowsAdvice {

	public void afterThrowing(Exception ex) {
		rec(AfterThrowsAdvice.class.getSimpleName(), ex.getMessage());
	}

}
