package org.example.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = {"classpath:src/test/resource/feature/bucket.feature"},
        glue = {"classpath:org.example.cucumber"})
public class CucumberRunnerTest {

}
