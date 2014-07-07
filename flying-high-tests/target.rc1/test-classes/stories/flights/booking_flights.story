Narrative:
In order to travel to my destination
As a traveller
I want to be able to book a flight online

Meta:
@tag component:ui
@issue FH-15

Scenario: View all available flights before booking
Given I want to book a flight
When I search for return flights from Sydney to London in Business
Then I should see the list of all available flights

Scenario: Filter flights by city before booking
Given I want to book a flight
When I enter 'Se' into the 'from' city field
Then I should see the following cities: Seattle, Seoul
