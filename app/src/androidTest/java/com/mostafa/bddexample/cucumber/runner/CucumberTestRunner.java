package com.mostafa.bddexample.cucumber.runner;

import android.os.Bundle;


import androidx.test.runner.AndroidJUnitRunner;

import com.mostafa.bddexample.test.BuildConfig;

import cucumber.api.android.CucumberInstrumentationCore;

public class CucumberTestRunner extends AndroidJUnitRunner {
    private static final String CUCUMBER_TAGS_KEY = "tags";
    private static final String CUCUMBER_SCENARIO_KEY = "name";
    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(Bundle arguments) {
        String tags = BuildConfig.TEST_TAGS;
        if (!tags.isEmpty()){
            arguments.putString(CUCUMBER_TAGS_KEY,tags.replaceAll("\\s",""));
        }
        String scenario = BuildConfig.TEST_SCENARIO;
        if (!scenario.isEmpty()){
            scenario = scenario.replaceAll("","\\\\s");
            arguments.putString(CUCUMBER_SCENARIO_KEY,scenario);
        }
        instrumentationCore.create(arguments);
        super.onCreate(arguments);
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
