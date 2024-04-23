package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
                tags = "@ingles", monochrome = true, dryRun = false, //dryRun é apenas pra rodar a stack e ver quais steps não foram implementados
                plugin = {"pretty", "html:target/cucumber"})
public class MainRunnerCucumber extends AbstractTestNGCucumberTests {
}
