package com.aequilibrium.features;
import java.io.File;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/aequilibrium/features",
		glue = { "" }, 
		monochrome = true, 
		dryRun = false,
		tags = {"@AllTests"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/Testing Automation Report.html"}
		)

public class RunnerTest {
	
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("extent-config.xml"));
	Reporter.setSystemInfo("Application Name", "SwagLabs");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "QA");
	Reporter.setTestRunnerOutput("Test Execution Report");
	}
}