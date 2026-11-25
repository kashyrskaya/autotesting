Feature: Admin Section and Authentication
      As an administrator
      I want to access the admin portal and log in
      So that I can manage hotel rooms and bookings

      Scenario: Successful admin login with valid credentials
        Given the user navigates directly to the admin login page
        When the user enters username "admin" and password "password"
        And clicks the login button
        Then the user should be redirected to the admin rooms dashboard
        And the rooms navigation button should be visible

      Scenario: Navigate to admin section from the public home page
        Given the user is on the hotel public home page
        When the user clicks the admin link in the navigation header
        Then the admin login form should be ready with all required elements