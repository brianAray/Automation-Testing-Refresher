package org.example.StepDefinition;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

// SelectClasspathResource: point to your features
// ConfigurationParameter: point to your step definitions

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/resources/Features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.example.StepDefinition")
public class CucumberTest {
}
