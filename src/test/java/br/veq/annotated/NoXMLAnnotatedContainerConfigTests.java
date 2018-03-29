package br.veq.annotated;

import br.veq.TestsConfig;
import br.veq.autowiring.annotated.AnnotedBeansConfig;

public abstract class NoXMLAnnotatedContainerConfigTests extends TestsConfig {

	public NoXMLAnnotatedContainerConfigTests() {
		super(AnnotedBeansConfig.class);
	}

}
