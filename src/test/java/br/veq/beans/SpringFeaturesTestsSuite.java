package br.veq.beans;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.veq.beans.core.CoreFeaturesTests;
import br.veq.beans.spel.SpELFeaturesTests;

@RunWith(Suite.class)
@SuiteClasses({ CoreFeaturesTests.class, SpELFeaturesTests.class })
public class SpringFeaturesTestsSuite {

}
