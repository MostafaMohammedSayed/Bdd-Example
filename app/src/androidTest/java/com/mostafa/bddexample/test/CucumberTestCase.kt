package com.mostafa.bddexample.test

import cucumber.api.CucumberOptions
@CucumberOptions(features = ["features"],
    glue = ["com.mostafa.bddexample.cucumber.steps"],
    tags = ["@e2e", "@smoke"])
@SuppressWarnings("unused")
class CucumberTestCase