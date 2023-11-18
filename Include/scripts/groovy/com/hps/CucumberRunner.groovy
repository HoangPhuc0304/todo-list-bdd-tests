package com.hps

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import internal.GlobalVariable

@RunWith(Cucumber.class)
@CucumberOptions(features = "Include/features", glue = "", plugin = ["pretty",
	"junit:Reports/cucumber.xml",
	"html:Reports",
	"json:Reports/cucumber.json"])
public class CucumberRunner {
}
