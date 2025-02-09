package cucumber;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "frm.setpDefinitions", monochrome = true, plugin = {
		"html:target/cucumber.html" }, tags = "@Regression")
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)

	public Object[][] scenarios() {
		return super.scenarios();
	}
}