package br.veq;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.veq.autowiring.xml.AutowiringXMLTests;
import br.veq.xml.beans.core.CoreFeaturesTests;
import br.veq.xml.beans.spel.SpELFeaturesTests;

@RunWith(Suite.class)
@SuiteClasses({ // ^_^
		CoreFeaturesTests.class, //
		SpELFeaturesTests.class, //
		AutowiringXMLTests.class //
		// ^_^
})
public class SpringFeaturesTestsSuite {

}
