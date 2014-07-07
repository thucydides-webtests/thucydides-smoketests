package com.bddinaction.flyinghigh.jbehave.flowsteps;

import com.bddinaction.flyinghigh.jbehave.model.FrequentFlyerMember;
import com.bddinaction.flyinghigh.jbehave.pages.HomePage;
import com.bddinaction.flyinghigh.jbehave.pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.fest.assertions.api.Assertions.assertThat;

public class AuthenticationFlowSteps {

    protected LoginPage loginPage;
    protected HomePage homePage;

    @Step
    public void enterEmailAndPasswordFor(FrequentFlyerMember user) {
        loginPage.open();
        loginPage.signinAs(user.getEmail(), user.getPassword());
    }

    @Step
    public void verifyWelcomeMessageFor(FrequentFlyerMember user) {
        String welcomeMessage = homePage.getWelcomeMessage();
        assertThat(welcomeMessage).isEqualTo("Welcome " + user.getFirstName());
    }
}
