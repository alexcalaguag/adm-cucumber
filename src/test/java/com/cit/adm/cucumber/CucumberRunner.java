package com.cit.adm.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		glue = {"com.cit.adm.cucumber.stepdefs"},
		features = {"src/test/java/com/cit/adm/cucumber/features"})
public class CucumberRunner {}
