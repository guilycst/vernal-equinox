package br.veq;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.veq.xml.beans.core.CoreFeaturesTests;
import br.veq.xml.beans.spel.SpELFeaturesTests;

@RunWith(Suite.class)
@SuiteClasses({ CoreFeaturesTests.class, SpELFeaturesTests.class })
public class SpringFeaturesTestsSuite {

}
