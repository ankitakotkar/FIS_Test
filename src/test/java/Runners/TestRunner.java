package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
//Author:Ankit Akotkar
@CucumberOptions(
	    features = "src/test/resources/Features",
	    glue = {"stepDef", "Utils"},
	    plugin = {"pretty", "html:target/cucumber-reports.html"},
	    monochrome = true
	)
	
	public class TestRunner extends AbstractTestNGCucumberTests{


}
