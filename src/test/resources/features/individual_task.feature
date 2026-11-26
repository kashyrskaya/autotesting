Feature: Hotel Website End-to-End User Journeys and Contact Validation

  Scenario: End-to-end room exploration, booking navigation, and empty contact form validation
    Given the user navigates to the hotel main page
    And the user proceeds to the Book Now section and verifies it is displayed
    When the user scrolls down until the Book Now button is not in view
    And verifies the Book Now button is out of view
    And scrolls back up to the Book Now section
    And randomly selects a room and clicks its Book Now button
    Then the user should be redirected to the reservation page with a spinner displayed
    When the user navigates back using the browser back button
    Then the main page and Our Rooms section should be displayed as before
    When the user clicks the main hotel logo
    Then the main page should still be displayed
    When the user clicks Contact in the top navigation
    Then the contact section should be displayed
    When the user submits the empty contact form
    Then 8 validation messages should be displayed
    And the text of the last validation message should be "Message may not be blank"

  Scenario Outline: Contact form phone number field validation
    Given the user is in the contact section
    When the user fills the contact form with name "John Doe", email "john@example.com", phone "<phone>", subject "Booking Enquiry", message "Hello, I would like to book a
    And submits the contact form
    Then a validation error containing "<expected_error>" should be displayed

    Examples:
      | phone | expected_error                             |
      |   123 | Phone must be between 11 and 21 characters |
      |       | Phone may not be blank                     |
