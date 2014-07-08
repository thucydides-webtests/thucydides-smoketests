package com.bddinaction.flyinghigh.junit.steps;

import com.bddinaction.flyinghigh.Application;
import com.bddinaction.flyinghigh.jbehave.flowsteps.TravellerFlowSteps;
import com.bddinaction.flyinghigh.jbehave.model.FrequentFlyerMember;
import com.bddinaction.flyinghigh.jbehave.pages.BookingPage;
import com.google.common.collect.ImmutableList;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(ThucydidesRunner.class)
@Story(Application.ViewingFlights.displaying_flight_details.class)
public class WhenDisplayingMoreFlightDetails {

    @Managed
    WebDriver driver;

    @ManagedPages(defaultUrl = "http://localhost:8080/#/welcome")
    public Pages pages;

    @Steps
    private TravellerFlowSteps registeredMember;

    @Test
    public void display_flight_details_to_featured_destinations() {
        registeredMember.enterEmailAndPasswordFor(FrequentFlyerMember.Jane);
        registeredMember.shouldSeeFeaturedDestinations(3);
    }

    @BeforeClass
    public static void setup() {
        assertThat(false).isFalse();
    }


    @Test
    public void display_flight_durations() {
        //Assume.assumeTrue("Favorite destinations service is ready", false);
    }

    @Test
    public void display_flight_for_all_available_flights() {
        registeredMember.navigateToFlightBookings();
        registeredMember.searchForFlights("return", "Sydney", "London", "Business");
    }

    BookingPage bookingPage;

    @Test
    public void display_flight_details_with_lookahead() {
        registeredMember.navigateToFlightBookings();
        bookingPage.setFrom("Se");
        assertThat(bookingPage.getFromTypeaheads()).containsAll(ImmutableList.of("Seattle","Seoul"))
                .hasSize(2);
    }

}
