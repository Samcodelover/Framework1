package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "src/test/resources/features/",
        glue = "APISteps",
        //when you set dryRun to true, it stops actual execution
        //it will quickly scan all the gherkin steps whether they are implemented or not
        //when we dryRun = false, it starts execute again
        dryRun = false,
        tags = "@apidynamic",
        //to remove irrelevant info from console, you need to monochrome to true
        monochrome = true,
        //pretty keyword prints the steps in the console to increase readability
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json", "rerun:target/failed.txt"}

)

public class APIRunner {

}
