@AddUser
Feature: Add User

  Scenario: Can create new user
    And I filled all fields
      | Job title | Job description | Job notes |
      | CSX       | John Smith      | notes     |
    When I click on "Save" button