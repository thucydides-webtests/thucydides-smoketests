package com.bddinaction.flyinghigh.jbehave.pages;

import com.bddinaction.flyinghigh.jbehave.model.DestinationDeal;
import com.google.common.collect.Lists;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends PageObject {

    @FindBy(id = "welcome-message")
    private WebElementFacade welcomeMessage;

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public List<DestinationDeal> getFeaturedDestinations() {
        List<DestinationDeal> deals = Lists.newArrayList();
        List<WebElementFacade> featuredDestinations = findAll(".featured .featured-destination");
        for (WebElement destinationEntry : featuredDestinations) {
            deals.add(destinationDealFrom(destinationEntry));
        }
        return deals;
    }

    private DestinationDeal destinationDealFrom(WebElement destinationEntry) {
        String destinationCity = $(destinationEntry).findBy(".destination-title").getText();
        String priceValue = $(destinationEntry).findBy(".destination-price").getText();

        int price = Integer.parseInt(priceValue.substring(1));
        return new DestinationDeal(destinationCity, price);
    }
}
