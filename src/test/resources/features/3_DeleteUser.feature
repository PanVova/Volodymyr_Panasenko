@DeleteUser
Feature: Delete user by username

  Scenario: Admin can delete user by username
    And I want to delete user with "JohnSmithUser" username
    And Deleted successfully