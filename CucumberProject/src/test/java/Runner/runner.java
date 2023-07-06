package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src/test/java/Feature/hooks.feature"},
		glue= {"StepDefinitions","hooks"})

public class runner extends AbstractTestNGCucumberTests{
	
}
