package br.veq;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.veq.annotated.NoXMLAnnotatedTests;
import br.veq.autowiring.AutowiringAnnotatedTests;
import br.veq.autowiring.AutowiringXMLTests;
import br.veq.core.CoreFeaturesTests;
import br.veq.core.SpELFeaturesTests;

@RunWith(Suite.class)
@SuiteClasses({ // ^_^
		CoreFeaturesTests.class, //
		SpELFeaturesTests.class, //
		AutowiringAnnotatedTests.class, //
		AutowiringXMLTests.class, //
		NoXMLAnnotatedTests.class //
		// ^_^
})
public class SpringFeaturesTestsSuite {

}
