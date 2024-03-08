package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue={"stepDefinition","helper"},tags="@Reg", 
plugin="json:target/jsonReports/test.json")
public class TestRunner {

	//dryRun- run to check test run mapping
	//monochrome- proper formatting. makes the output in console more readable and easily understandable.
 


	
}
//html:target/reports/test.html
//test automation for git status




