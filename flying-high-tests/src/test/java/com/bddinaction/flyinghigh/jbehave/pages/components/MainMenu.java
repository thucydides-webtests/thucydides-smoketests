package com.bddinaction.flyinghigh.jbehave.pages.components;

import com.bddinaction.flyinghigh.jbehave.pages.BookingPage;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class MainMenu extends PageObject {

    public void selectMenuOption(String menuOption) {
        find(By.partialLinkText(menuOption)).click();
    }

    public BookingPage selectBookFlight() {
        selectMenuOption("Book");
        return switchToPage(BookingPage.class);
    }

}
