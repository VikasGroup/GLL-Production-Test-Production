package net.gll.test.gll.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(format = { "pretty", "json:target/cucumber.json" },features="src/test/resources/features/",glue="net.gll.test.gll.test.steps",tags="@RegPre")


public class TestRunner {

}
