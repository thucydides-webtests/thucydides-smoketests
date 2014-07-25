package com.bddinaction.flyinghigh.jbehave.steps;

import org.jbehave.core.annotations.AfterScenario;

/**
 * Created by john on 20/07/2014.
 */
public class FixtureSteps {

    @AfterScenario
    public void cleanup() {
        System.out.println("AFTER SCENARIO");
    }
}
